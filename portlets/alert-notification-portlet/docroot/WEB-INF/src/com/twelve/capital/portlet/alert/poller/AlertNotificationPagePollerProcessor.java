package com.twelve.capital.portlet.alert.poller;

import java.util.LinkedHashMap;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.poller.BasePollerProcessor;
import com.liferay.portal.kernel.poller.PollerRequest;
import com.liferay.portal.kernel.poller.PollerResponse;
import com.liferay.portlet.announcements.model.AnnouncementsEntry;
import com.liferay.portlet.announcements.model.AnnouncementsFlagConstants;
import com.liferay.portlet.announcements.service.AnnouncementsEntryLocalServiceUtil;
import com.liferay.portlet.announcements.util.AnnouncementsUtil;

public class AlertNotificationPagePollerProcessor extends BasePollerProcessor{


	protected void doReceive(PollerRequest request, PollerResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		setPageAlertNotificationCount( request,  response);
	}

	


	protected void doSend(PollerRequest arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	private void setPageAlertNotificationCount(PollerRequest request,
			PollerResponse response) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		
		List<AnnouncementsEntry> alertList= null;
		
		int flagValue = AnnouncementsFlagConstants.NOT_HIDDEN;
		
		LinkedHashMap<Long, long[]> scopes = AnnouncementsUtil.getAnnouncementScopes(request.getUserId());
		
		alertList= AnnouncementsEntryLocalServiceUtil.getEntries(request.getUserId(), scopes, true, flagValue, -1 ,-1);
		
		
		
		 
	}
}
