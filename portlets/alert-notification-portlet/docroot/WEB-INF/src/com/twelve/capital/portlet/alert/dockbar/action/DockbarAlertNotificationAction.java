package com.twelve.capital.portlet.alert.dockbar.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class DockbarAlertNotificationAction extends MVCPortlet {

	
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		 try {
			 //System.out.println("====serveResource========");
			 JSONObject jsonUser=null;
			 JSONArray alertJsonArray=JSONFactoryUtil.createJSONArray();
			
			 PrintWriter out=resourceResponse.getWriter();
			 out.print(alertJsonArray.toString());
			 }
			 catch (Exception e) {
			 e.printStackTrace();
			 }
	}
}
