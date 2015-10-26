package com.liferay.calendar.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.NullComparator;
import org.apache.commons.lang.time.DateUtils;

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.recurrence.Recurrence;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.calendar.util.JCalendarUtil;
import com.liferay.calendar.util.RecurrenceUtil;
import com.liferay.compat.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class CorporateCalendarPortlet extends MVCPortlet{

	
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		List<Calendar> calendarList= null;
		
		List<CalendarBooking> calendarListfromFinder=new ArrayList<CalendarBooking>();
		String siteName = null;
		try {
		PortletPreferences portletPreferences = (PortletPreferences) request.getPreferences();
		long configuredSiteId = GetterUtil.getLong(portletPreferences.getValue("siteid", "0"));	
			
			if(configuredSiteId != 0){
				siteName = GroupLocalServiceUtil.getGroup(configuredSiteId).getName();		
			}
			
			calendarList = CalendarLocalServiceUtil.getCalendars(-1, -1);
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		for(Calendar calendar : calendarList){
			if(siteName != null){
			if(calendar.getName(LocaleUtil.US).equalsIgnoreCase(siteName)){
				try {
					calendarListfromFinder= CalendarBookingLocalServiceUtil.getCorporateCalendarListView(calendar.getCalendarId());
					
				} catch (SystemException e) {
				
					e.printStackTrace();
				}
			}
		}	
		}
		
		request.setAttribute("futureCalendarEvents", generateCorporateViewList(calendarListfromFinder));
		//System.out.println("Approved Calendar Booking List Size From Finder---"+calendarListfromFinder.size());
		include(viewTemplate, request, response);
	}
	
	private List<CalendarBooking> generateCorporateViewList(List<CalendarBooking> calendarList){
		Date now = new Date();
		//System.out.println("Current Date  : "+now);
		List<CalendarBooking> futureCalendarEvents= new ArrayList<CalendarBooking>();
		TimeZone timeZone = TimeZone.getTimeZone("UTC");
			
		for (CalendarBooking booking : calendarList){
			
			java.util.Calendar startTimeJCalendar = JCalendarUtil.getJCalendar(booking.getStartTime());
			java.util.Calendar endTimeJCalendar = JCalendarUtil.getJCalendar(booking.getEndTime());
			java.util.Calendar nowTimeJCalendar = JCalendarUtil.getJCalendar(now.getTime());
			nowTimeJCalendar.setTimeZone(timeZone);
			
						
			if(booking.isRecurring()){
				try{
				java.util.Calendar untilJCalendar = null;
				List<CalendarBooking> recurrenceCalendarEvents =  new ArrayList<CalendarBooking>();
				Recurrence recurrence = null;
				
				recurrence =  booking.getRecurrenceObj();
					if(recurrence!=null){
						untilJCalendar = recurrence.getUntilJCalendar();
						recurrenceCalendarEvents = RecurrenceUtil.expandCalendarBooking(booking, (startTimeJCalendar.getTime()).getTime(), (untilJCalendar.getTime()).getTime(), 0);
							 	
						for(CalendarBooking recBooking : recurrenceCalendarEvents){
							java.util.Calendar recstartTimeJCalendar = JCalendarUtil.getJCalendar(recBooking.getStartTime());
							java.util.Calendar recendTimeJCalendar = JCalendarUtil.getJCalendar(recBooking.getEndTime());
							//System.out.println("Booking is recurrence Event :and Time is   "+recstartTimeJCalendar.getTime());		
							if((DateUtils.isSameDay(recstartTimeJCalendar.getTime(), nowTimeJCalendar.getTime()))||(DateUtils.isSameDay(recendTimeJCalendar.getTime(), nowTimeJCalendar.getTime()))||((recendTimeJCalendar.getTime()).after(now))||recstartTimeJCalendar.getTime().after(now) || recstartTimeJCalendar.getTime().equals(now) || (recBooking.isAllDay() && recendTimeJCalendar.getTime().after(now))){
							 			futureCalendarEvents.add(recBooking);
							 			//System.out.println("Calendar Events Recursive Booking Event  :"+recstartTimeJCalendar.getTime());
						 			}
								}
						}
				}catch(NullPointerException e){
					e.printStackTrace();
				}
				 	}else if((DateUtils.isSameDay(startTimeJCalendar.getTime(), nowTimeJCalendar.getTime()))||(DateUtils.isSameDay(endTimeJCalendar.getTime(), nowTimeJCalendar.getTime()))||((endTimeJCalendar.getTime()).after(now))||startTimeJCalendar.getTime().after(now) || startTimeJCalendar.getTime().equals(now) || (booking.isAllDay() && endTimeJCalendar.getTime().after(now))){
				 		//System.out.println("Booking is Normal Event :and Time is   "+startTimeJCalendar.getTime());
				 				futureCalendarEvents.add(booking);
								//System.out.println("Calendar Events Sorted"+startTimeJCalendar.getTime());
							}
					}
		
		//System.out.println("Future Events---"+futureCalendarEvents.size());
		
		Comparator<CalendarBooking> startTimeComparator = new BeanComparator("startTime", new NullComparator(true));
	    Collections.sort(futureCalendarEvents, startTimeComparator );
		return futureCalendarEvents;
	}
	
	
	public void serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws PortletException {

		try {
		     long selectedGroupId =  GetterUtil.getLong(ParamUtil.getString(resourceRequest, "site"));
		     		     	
		     List<Layout> layoutList  = LayoutLocalServiceUtil.getLayouts(selectedGroupId, true);
		     
		     String siteTitlesPlIds = "";
		     
		     for(Layout layout:layoutList)
		     {
		    	 if(siteTitlesPlIds.length() < 1){
		    		 siteTitlesPlIds =  layout.getName(Locale.US)+":"+layout.getPlid();
		    	 }else{
		    		 siteTitlesPlIds =  siteTitlesPlIds +"#"+ layout.getName(Locale.US)+":"+layout.getPlid();
		    	 }
		     }		     
		    
		     resourceResponse.getWriter().println(siteTitlesPlIds);
		}
		catch (Exception e) {
			throw new PortletException(e);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(CorporateCalendarPortlet.class);
}
