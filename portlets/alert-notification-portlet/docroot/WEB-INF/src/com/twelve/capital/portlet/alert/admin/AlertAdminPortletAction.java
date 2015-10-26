package com.twelve.capital.portlet.alert.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;



















import javax.portlet.PortletException;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.announcements.model.AnnouncementsEntry;
import com.liferay.portlet.announcements.service.AnnouncementsEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.twelve.capital.model.adminalert;
import com.twelve.capital.service.adminalertLocalServiceUtil;

/**
 * Portlet implementation class AlertAdminPortletAction
 */
public class AlertAdminPortletAction extends MVCPortlet {
 
private Object actionRequest;
public  void processAction(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException, PortletException{
	//System.out.println("control came inside action class");
	String cmd=actionRequest.getParameter("cmd");
	 ThemeDisplay themeDisplay=(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	  String alertId= actionRequest.getParameter("alertId");
	  String title = actionRequest.getParameter("title");
	  String description = actionRequest.getParameter("description");
	 /* String displayDate = actionRequest.getParameter("displayDate");
	  String expirationDate = actionRequest.getParameter("expirationDate");
	 */ String alertType = actionRequest.getParameter("alertType");
	  String location = actionRequest.getParameter("location");
	  String resolution = "";//actionRequest.getParameter("resolution");
	  String expectedResolutionTime = actionRequest.getParameter("expectedResolutionTime");
	  String resolutionStatus = actionRequest.getParameter("resolutionStatus");
	  //System.out.println("Title---"+title+"----description---"+description+"----displayDate---"+displayDate+"----expirationDate---"+expirationDate+"---alertType---"+alertType+"----location---"+location+"---resolution---"+resolution+"----expectedResolutionTime---"+expectedResolutionTime+"----resolutionStatus----"+resolutionStatus+"");
	  AnnouncementsEntry alertEntry =null;
	  Date date = new Date();
	  Calendar cal = Calendar.getInstance();
	  cal.setTime(date);
	  cal.add(Calendar.DATE, 7);
	  SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/mm/yyyy");
	 if(cmd.equalsIgnoreCase("createAlert")){
		 try {
			 if(Validator.isNull(alertId)){
			 alertEntry = AnnouncementsEntryLocalServiceUtil.createAnnouncementsEntry(CounterLocalServiceUtil.increment(AnnouncementsEntry.class.getName()));
			 alertEntry.setAlert(true);
			 alertEntry.setUuid(PortalUUIDUtil.generate());
			 alertEntry.setCompanyId(themeDisplay.getCompanyId());
			 alertEntry.setUserId(themeDisplay.getUserId());
			 alertEntry.setUserName(themeDisplay.getUser().getFullName());
			 alertEntry.setCreateDate(date);
			 alertEntry.setModifiedDate(date);
			 alertEntry.setClassNameId(ClassNameLocalServiceUtil.getClassNameId(Group.class));
			 alertEntry.setClassPK(themeDisplay.getScopeGroupId());
			 alertEntry.setTitle(title);
			 alertEntry.setContent(description);
			 alertEntry.setType(alertType);
			 alertEntry.setDisplayDate(date);
			 alertEntry.setExpirationDate(cal.getTime());
			 alertEntry.setNew(true);
			 AnnouncementsEntryLocalServiceUtil.updateAnnouncementsEntry(alertEntry);
			 }
			 
			 if(Validator.isNotNull(alertId)){
			 alertEntry = AnnouncementsEntryLocalServiceUtil.getAnnouncementsEntry(Long.parseLong(alertId));
			 alertEntry.setAlert(true);
			 alertEntry.setUserId(themeDisplay.getUserId());
			 alertEntry.setUserName(themeDisplay.getUser().getFullName());
			 alertEntry.setModifiedDate(date);
			 alertEntry.setTitle(title);
			 alertEntry.setContent(description);
			 alertEntry.setType(alertType);
			 alertEntry.setDisplayDate(date);
			 alertEntry.setExpirationDate(cal.getTime());
			 AnnouncementsEntryLocalServiceUtil.updateAnnouncementsEntry(alertEntry);
			 }
			 
		//creating alertadmin entry
			 if (Validator.isNull(alertId)) {
				 	adminalert adminAlerts = adminalertLocalServiceUtil.createadminalert(alertEntry.getEntryId());
					adminAlerts.setGroupId(themeDisplay.getScopeGroupId());
					adminAlerts.setCreateDate(date);
					adminAlerts.setModifiedDate(date);
					adminAlerts.setLocation(location);
					adminAlerts.setResolution(resolution);
					adminAlerts.setExpectedResolutionTime(expectedResolutionTime);
					adminAlerts.setResolutionStatus(resolutionStatus);
					adminAlerts.setAlertOpenTime(date);
					adminalertLocalServiceUtil.updateadminalert(adminAlerts);
			}
			 if (Validator.isNotNull(alertId)) {
				 	adminalert adminAlerts = adminalertLocalServiceUtil.getadminalert(Long.parseLong(alertId));
					adminAlerts.setModifiedDate(date);
					adminAlerts.setLocation(location);
					adminAlerts.setResolution(resolution);
					adminAlerts.setExpectedResolutionTime(expectedResolutionTime);
					adminAlerts.setResolutionStatus(resolutionStatus);
					if(adminAlerts.getResolutionStatus().equalsIgnoreCase("resolved")){
					adminAlerts.setAlertResolvedtime(date);
					}
					adminalertLocalServiceUtil.updateadminalert(adminAlerts);
			}
			 
			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
	 }
	 if(cmd.equalsIgnoreCase("deleteAlert")){
		 try {
			adminalertLocalServiceUtil.deleteadminalert(Long.parseLong(alertId));
			AnnouncementsEntryLocalServiceUtil.deleteAnnouncementsEntry(Long.parseLong(alertId));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 actionResponse.setRenderParameter("jspPage", "/html/alert-admin/viewAllAlerts.jsp");
}


}
