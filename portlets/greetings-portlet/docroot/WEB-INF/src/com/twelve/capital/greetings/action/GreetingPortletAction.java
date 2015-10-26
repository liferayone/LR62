package com.twelve.capital.greetings.action;





import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.twelve.capital.greetings.service.model.GreetingsMessage;
import com.twelve.capital.greetings.service.model.User_Status;
import com.twelve.capital.greetings.service.service.GreetingsMessageLocalServiceUtil;
import com.twelve.capital.greetings.service.service.User_StatusLocalServiceUtil;



public class GreetingPortletAction extends MVCPortlet{
	
public void processAction(ActionRequest actionRequest,ActionResponse actionResponse){}

public void render(RenderRequest request,RenderResponse response) throws IOException, PortletException{
	/*String statusMessage="Set your status here";
	ThemeDisplay themeDisplay = (ThemeDisplay) request
			.getAttribute(WebKeys.THEME_DISPLAY);
	User_Status user_status=null;
	GreetingsMessage message=null;
	try {
		 user_status=User_StatusLocalServiceUtil.getUser_Status(themeDisplay.getUserId());
		 message=GreetingsMessageLocalServiceUtil.getGreetingsMessage(user_status.getStatusId());
	} catch (PortalException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SystemException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(Validator.isNotNull(user_status)){
	request.setAttribute("button_color", message.getButton_color());
	request.setAttribute("status", message.getMessage());
	}
	else
	{
		request.setAttribute("button_color", "");
		request.setAttribute("status", statusMessage);
		}*/
	include("/view.jsp", request, response);
}




      

public void serveResource(ResourceRequest resourceRequest,
  			ResourceResponse resourceResponse) throws IOException, PortletException {
	
	/*//JSONObject jsonFeed= JSONFactoryUtil.createJSONObject();
	String statusMessage="Set your status here";
	 String statusId= resourceRequest.getParameter("statusIds");
	 String userId= resourceRequest.getParameter("UserId");
	 System.out.println("User Id--->>>"+userId);
	 System.out.println("Status Id from Ajax Request--->>>"+statusId);
	 
	 User_StatusLocalServiceUtil.updateUserStatus( Long.parseLong(userId), Long.parseLong(statusId));
	 
	 GreetingsMessage message=null;
	 try {
		 message=GreetingsMessageLocalServiceUtil.getGreetingsMessage(Long.parseLong(statusId));
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
	 
	 
	 JSONObject jsonObj= JSONFactoryUtil.createJSONObject();
	 if(Validator.isNotNull(message)){
		 jsonObj.put("status", message.getMessage());
			jsonObj.put("button_color", message.getButton_color());
	 }
	 else {
		jsonObj.put("status", statusMessage);
		jsonObj.put("button_color", "");
	 }
	
	resourceResponse.setContentType("application/json");
	resourceResponse.setCharacterEncoding("UTF-8");
	resourceResponse.getWriter().write(jsonObj.toString());*/
}
}
 
 
