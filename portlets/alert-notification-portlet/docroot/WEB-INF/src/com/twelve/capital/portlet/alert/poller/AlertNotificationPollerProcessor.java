package com.twelve.capital.portlet.alert.poller;

import java.util.LinkedHashMap;

import com.liferay.portal.kernel.poller.BasePollerProcessor;
import com.liferay.portal.kernel.poller.PollerRequest;
import com.liferay.portal.kernel.poller.PollerResponse;
import com.liferay.portlet.announcements.model.AnnouncementsFlagConstants;
import com.liferay.portlet.announcements.service.AnnouncementsEntryLocalServiceUtil;
import com.liferay.portlet.announcements.util.AnnouncementsUtil;


public class AlertNotificationPollerProcessor extends BasePollerProcessor{

	
	protected void doReceive(PollerRequest request, PollerResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		setAlertNotificationCount( request,  response);
	}


	protected void doSend(PollerRequest request) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	protected void setAlertNotificationCount(PollerRequest request, PollerResponse response) throws Exception{
		
		int userAlertNotificationCount=0;
		int readUserAlertNotificationCount=0;
		
		
		int flagValue = AnnouncementsFlagConstants.NOT_HIDDEN;
		
		LinkedHashMap<Long, long[]> scopes = AnnouncementsUtil.getAnnouncementScopes(request.getUserId());
		
		userAlertNotificationCount=  AnnouncementsEntryLocalServiceUtil.getEntriesCount(request.getUserId(), scopes, true, flagValue);
		
		readUserAlertNotificationCount= AnnouncementsEntryLocalServiceUtil.getEntriesCount(request.getUserId(), scopes, true, AnnouncementsFlagConstants.HIDDEN);
		
		//System.out.println("userAlertNotificationCount-------"+userAlertNotificationCount+"------readUserAlertNotificationCount+"+readUserAlertNotificationCount);
		
		response.setParameter("userAlertNotificationCount", String.valueOf(userAlertNotificationCount));
		response.setParameter("unreadUserAlertNotificationCount", String.valueOf(readUserAlertNotificationCount));
		
		
		
	}

}
