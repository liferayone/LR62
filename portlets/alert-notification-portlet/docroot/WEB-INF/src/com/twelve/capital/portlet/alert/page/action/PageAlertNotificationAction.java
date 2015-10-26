package com.twelve.capital.portlet.alert.page.action;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.announcements.model.AnnouncementsEntry;
import com.liferay.portlet.announcements.model.AnnouncementsFlag;
import com.liferay.portlet.announcements.model.AnnouncementsFlagConstants;
import com.liferay.portlet.announcements.service.AnnouncementsEntryLocalServiceUtil;
import com.liferay.portlet.announcements.service.AnnouncementsFlagLocalServiceUtil;
import com.liferay.portlet.announcements.util.AnnouncementsUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class PageAlertNotificationAction extends MVCPortlet {
	
	
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		// TODO Auto-generated method stub
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		List<AnnouncementsEntry> alertList= null;
		List<AnnouncementsEntry> allAlertList=null;
		//System.out.println("Control inside Render Method");
		int flagValue = AnnouncementsFlagConstants.NOT_HIDDEN;
		int readFlagValue= AnnouncementsFlagConstants.READ;
		LinkedHashMap<Long, long[]> scopes;
		try {
			scopes = AnnouncementsUtil.getAnnouncementScopes(themeDisplay.getUserId());
			alertList= AnnouncementsEntryLocalServiceUtil.getEntries(themeDisplay.getUserId(), scopes, true, flagValue, -1 ,-1);
			allAlertList= AnnouncementsEntryLocalServiceUtil.getEntries(themeDisplay.getUser().getUserId(), scopes, true, readFlagValue, -1,-1);
			//System.out.println("All Alert List Count"+allAlertList.size());
			//System.out.println("Count for Alert---"+alertList.size());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(Validator.isNotNull(alertList)){
			
			request.setAttribute("alertList", alertList);
			request.setAttribute("allAlertList", allAlertList);
			//request.setAttribute("jspPage", "/html/alert-notification/view.jsp");
		}
		include("/html/alert-notification/view.jsp", request, response);
		
	}
	
	
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String alertId= resourceRequest.getParameter("alertIds");
		ThemeDisplay themeDisplay=(ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Date now = new Date();
		AnnouncementsFlag flagEntryRead;
		AnnouncementsFlag flagEntryHidden;
		
		
		try {
			
			flagEntryRead= AnnouncementsFlagLocalServiceUtil.createAnnouncementsFlag(CounterLocalServiceUtil.increment(AnnouncementsFlag.class.getName()));
			flagEntryRead.setUserId(themeDisplay.getUser().getUserId());
			flagEntryRead.setCreateDate(now);
			flagEntryRead.setEntryId(Long.parseLong(alertId));
			flagEntryRead.setValue(AnnouncementsFlagConstants.READ);
			AnnouncementsFlagLocalServiceUtil.updateAnnouncementsFlag(flagEntryRead);
			
			flagEntryHidden= AnnouncementsFlagLocalServiceUtil.createAnnouncementsFlag(CounterLocalServiceUtil.increment(AnnouncementsFlag.class.getName()));
			flagEntryHidden.setUserId(themeDisplay.getUser().getUserId());
			flagEntryHidden.setCreateDate(now);
			flagEntryHidden.setEntryId(Long.parseLong(alertId));
			flagEntryHidden.setValue(AnnouncementsFlagConstants.HIDDEN);
			AnnouncementsFlagLocalServiceUtil.updateAnnouncementsFlag(flagEntryHidden);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 JSONObject jsonObj= JSONFactoryUtil.createJSONObject();
		 jsonObj.put("updateSuccess", "alerts updated");
		 resourceResponse.setContentType("application/json");
		 resourceResponse.setCharacterEncoding("UTF-8");
		 resourceResponse.getWriter().write(jsonObj.toString());
		
	}

}
