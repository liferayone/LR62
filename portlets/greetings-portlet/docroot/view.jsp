<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.util.PortletCategoryKeys"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>   
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%
	/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects />
<theme:defineObjects />
<%
				String myAccountURL = themeDisplay.getURLMyAccount().toString();

				myAccountURL = HttpUtil.setParameter(myAccountURL, "controlPanelCategory", PortletCategoryKeys.MY);
				boolean showInPopUp=true;
				%>

<%-- <liferay-ui:user-display userId="<%= themeDisplay.getUser().getUserId() %>"></liferay-ui:user-display> --%>

<div class="avatar">
<img  id="profile_image" alt="user-image" style="border-radius: 14px;height:28px;width:26px;"src="<%= themeDisplay.getUser().getPortraitURL(themeDisplay) %>"/>
</div>



<div class="sign-out-menu" style="text-align: left;">
	 <ul>
    	<li id="account-menu"><aui:nav-item href="<%= myAccountURL %>" iconCssClass="icon-user" title="My Account"  label="My Account" useDialog="<%= showInPopUp %>" /></li>
    	<li  id="sign"><aui:nav-item cssClass="sign-out" href="<%= themeDisplay.getURLSignOut() %>" iconCssClass="icon-off" label="sign-out" /></li>
    </ul>
  </div>


<script type="text/javascript">
jQuery(".sign-out-menu").hide();
jQuery(document).ready(function() {
	jQuery(".sign-out-menu").hide();

	jQuery(".avatar").click(function() {
		if (jQuery(".sign-out-menu").is(":hidden")) {
			jQuery(".sign-out-menu").show();
		} 
		else { jQuery(".sign-out-menu").hide();
		
		}
		
	});
	
		 jQuery(".sign-out-menu").mouseleave(function(){
			 jQuery(".sign-out-menu").hide();
			 
			
	
});
	    
	});
	
	
	</script>
<%-- <%
	String button_color=(String)renderRequest.getAttribute("button_color");
	String statusMessage=(String)renderRequest.getAttribute("status");
%>
<portlet:resourceURL var="StatusResourceURL"><portlet:param name='UserId' value='<%= Long.toString(themeDisplay.getUserId()) %>'/></portlet:resourceURL>

<script type="text/javascript">
jQuery(".custom-hidden-menu").hide();
jQuery(document).ready(function() {
jQuery(".custom-hidden-menu").hide();

jQuery("#status-menu").click(function() {
	if (jQuery(".custom-hidden-menu").is(":hidden")) {
		jQuery(".custom-hidden-menu").show();
	} 
	else { jQuery(".custom-hidden-menu").hide();
	
	}
	
});

	jQuery(".custom-hidden-menu").mouseleave(function(){
			jQuery(".custom-hidden-menu").hide();
			 jQuery(".custom-hiddden-menu").fadeToggle(); 

});
	
		
	
	});
	jQuery(".sign-out-menu").hide();
	jQuery(document).ready(function() {
	jQuery(".sign-out-menu").hide();

	jQuery(".arrow-down").click(function() {
		if (jQuery(".sign-out-menu").is(":hidden")) {
			jQuery(".sign-out-menu").show();
		} 
		else { jQuery(".sign-out-menu").hide();
		
		}
		
	});
	
		 jQuery(".sign-out-menu").mouseleave(function(){
			 jQuery(".sign-out-menu").hide();
			 
			
	
});
	    
	});
	

	 

</script>
<%
				String myAccountURL = themeDisplay.getURLMyAccount().toString();

				myAccountURL = HttpUtil.setParameter(myAccountURL, "controlPanelCategory", PortletCategoryKeys.MY);
				boolean showInPopUp=true;
				%>

<div class="custom-user-display">
	<ul>
		<li style="margin-left: 5px;margin-right:-37px;">Hello <%=themeDisplay.getUser().getFirstName()%>&nbsp;|</li>
		
		<li class="arrow-down"> </li>
		<% if(button_color.equalsIgnoreCase("")){ %>
		<li id="status-menu"><%= statusMessage %></li>
  		<% } %>
  		<% if(!(button_color.equalsIgnoreCase(""))){ %>
		<li id="status-menu"><img alt="green" align="middle" id="status-img" src='<%= "/greetings-portlet/images/bullet-"+button_color+".png" %>' style="height: 16px; width: 16px;margin-top:0px;">&nbsp;<h7 id="status-text">&nbsp;<%= statusMessage %></h7></li>
  		<% } %>
  		
		
  		
	</ul>
</div>



<div class="sign-out-menu" style="text-align: left;">
	 <ul>
    	<li id="account-menu"><aui:nav-item href="<%= myAccountURL %>" iconCssClass="icon-user" title="My Account"  label="My Account" useDialog="<%= showInPopUp %>" /></li>
    	<li id="sign"><aui:nav-item cssClass="sign-out" href="<%= themeDisplay.getURLSignOut() %>" iconCssClass="icon-off" label="sign-out" /></li>
    </ul>
  </div>
  
  <div class="custom-hidden-menu">
	<ul>
		<li  style="color:#003366;"><a href="#" onclick='<%= renderResponse.getNamespace()+"setStatus(0);" %>'><img alt="green" align="left" src="/greetings-portlet/images/bullet-green.png" style="height: 16px; width:16px;margin-top:4px;margin-left:-16px; "/>&nbsp;In Zurich Office</a></li>
		<li  style="color:#003366;"><a href="#" onclick='<%= renderResponse.getNamespace()+"setStatus(1);" %>'><img alt="red" align="left" src="/greetings-portlet/images/bullet-red.png" style="height: 16px; width:16px;margin-top:4px;margin-left:-16px; "/>&nbsp;In Zurich Office </a></li>
		<li style="color:#003366;"><a href="#" onclick='<%= renderResponse.getNamespace()+"setStatus(2);" %>'><img alt="yellow" align="left" src="/greetings-portlet/images/bullet-green.png" style="height: 16px; width:16px;margin-top:4px;margin-left:-16px; "/>&nbsp;In London Office</a></li>
		<li  style="color:#003366;"><a href="#" onclick='<%= renderResponse.getNamespace()+"setStatus(3);" %>'><img alt="red" align="left" src="/greetings-portlet/images/bullet-red.png" style="height: 16px; width:16px;margin-top:4px;margin-left:-16px; "/>&nbsp;In London Office</a></li>
		<li style="color:#003366;"><a href="#" onclick='<%= renderResponse.getNamespace()+"setStatus(4);" %>'><img alt="green" align="left" src="/greetings-portlet/images/bullet-green.png" style="height: 16px; width:16px;margin-top:4px;margin-left:-16px; "/>&nbsp;Travelling,Reachable</a></li>
		<li style="color:#003366;"><a href="#" onclick='<%= renderResponse.getNamespace()+"setStatus(5);" %>'><img alt="red" align="left" src="/greetings-portlet/images/bullet-red.png" style="height: 16px; width:16px;margin-top:4px;margin-left:-16px; "/>&nbsp;Travelling,Not Reachable</a></li>
	</ul>
  </div>
  
  <aui:script use="aui-io-request,aui-node">
  	Liferay.provide(
  	window,
  	'<portlet:namespace />setStatus',
  	function(statusId){
  	
  	var A= AUI();
  	//alert (statusId);
  	
  	var url='<%= StatusResourceURL.toString()%>';
  	
  	A.io.request(
  	url,
  	 //data to be sent to server
  	 {
  	 data:{
  	   <portlet:namespace/>statusIds:statusId,
  	 },
  	 
  	 dataType : 'json',
  	 
  	 on: {
  	 	failure:function(){
  		 },
  		 
  		success:function(event,id,obj){
  		var instance=this;
  		//JSON data coming back from server
  		
  		var message=instance.get('responseData');
  	
  		if(message){
  		var status=message.status;
  		var button_color1=message.button_color;
  	//alert(message.button_color);
  		
  		var statusPlaceHolder= document.getElementById('status-menu');
  		//alert(statusPlaceHolder);
  		
  		if(button_color1==""){
  		//alert("button color null");
  		//alert(status);
  		statusPlaceHolder.innerHTML=status;
  		}
  		if((button_color1!="")){
  		//alert("button color not null");
  		document.getElementById('status-img').src="/greetings-portlet/images/bullet-"+button_color1+".png";
  		//alert(document.getElementById('status-img').src);
  		document.getElementById('status-text').innerHTML=status;
  		}
  		
  		}
  		
  			}
  	
  		}
  	});//End of IO
  });//End of provide
  	 
  </aui:script>




 --%>