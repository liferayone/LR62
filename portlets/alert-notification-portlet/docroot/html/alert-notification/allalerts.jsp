<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.twelve.capital.service.adminalertLocalServiceUtil"%>
<%@page import="com.liferay.portlet.announcements.service.AnnouncementsEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.liferay.portlet.announcements.util.AnnouncementsUtil"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="com.liferay.portlet.announcements.model.AnnouncementsFlagConstants"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.announcements.model.AnnouncementsEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />
<theme:defineObjects/>
<%
	List<AnnouncementsEntry> allAlertList= null;

int readFlagValue= AnnouncementsFlagConstants.READ;
LinkedHashMap<Long, long[]> scopes;

try{
	scopes = AnnouncementsUtil.getAnnouncementScopes(themeDisplay.getUserId());
	allAlertList= AnnouncementsEntryLocalServiceUtil.getEntries(themeDisplay.getUser().getUserId(), scopes, true, readFlagValue, -1,-1);
}
catch (PortalException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SystemException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	

%>

<div class="dockbaralerts" id="dockbar_alerts">
<% if(Validator.isNotNull(allAlertList)){ 
	//System.out.println(allAlertList.size());
	for(AnnouncementsEntry alert : allAlertList){
		SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd");
		SimpleDateFormat openTimeFormat= new SimpleDateFormat("HH:mm");
		Date alertCreateDate= alert.getCreateDate();
		String alertType=alert.getType().toLowerCase();
		if(alert.getType().toLowerCase().equalsIgnoreCase("businessInterruption")){
			alertType="error";
		}
		if(adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getResolutionStatus().equalsIgnoreCase("resolved")){
			alertType="success";
		}
%>
  <%-- <div class='dockbaralert-message <%=alertType %>'>
    <a class="alertclose" href="#" onclick="<%= renderResponse.getNamespace() %>markAlertAsRead('<%= alert.getEntryId() %>');">x</a>
    <p><%= alert.getTitle() %></p>
  </div> --%>
  
  <table>
  	 <tr>
  	 	<td>
  	 		<div id="alert_title_date_wrapper" style="clear:both;">
  	 		<% if (alertType.equalsIgnoreCase("info")){
  	 			
  	 		 %>
    		<div id="alert_date_wrapper" style="float:left;clear:both;background-color: #339bb9; border: 1px solid #f4f4f4;border-radius: 1px; box-shadow: 0 0 10px #fff inset; height: 25px; padding-left: 4px; padding-top: 6px;widh: 72px; z-index: 9999;margin-top: 6px;">
    		<% } %>
    		<% if (alertType.equalsIgnoreCase("warning")){
  	 			
  	 		 %>
    		<div id="alert_date_wrapper" style="float:left;clear:both;background-color: #eecc38; border: 1px solid #f4f4f4;border-radius: 1px; box-shadow: 0 0 10px #fff inset; height: 25px; padding-left: 4px; padding-top: 6px;widh: 72px; z-index: 9999;margin-top: 6px;">
    		<% } %>
    		<% if (alertType.equalsIgnoreCase("business interruption")){
  	 			
  	 		 %>
    		<div id="alert_date_wrapper" style="float:left;clear:both;background-color: #c43c35; border: 1px solid #f4f4f4;border-radius: 1px; box-shadow: 0 0 10px #fff inset; height: 25px; padding-left: 4px; padding-top: 6px;widh: 72px; z-index: 9999;margin-top: 6px;">
    		<% } %>
    		<% if (alertType.equalsIgnoreCase("success")){
  	 			
  	 		 %>
    		<div id="alert_date_wrapper" style="float:left;clear:both;background-color: #57a957; border: 1px solid #f4f4f4;border-radius: 1px; box-shadow: 0 0 10px #fff inset; height: 25px; padding-left: 4px; padding-top: 6px;widh: 72px; z-index: 9999;margin-top: 6px;">
    		<% } %>
       		<div id="alert_month" style="float:left;transform: rotate(-90deg);transfom-origin: right top 0;font-size: 11px; color: #fff;"><%= monthFormat.format(alertCreateDate) %></div>
       		<div id="alert_date" style="float:left;border-left: 1px solid #fff;color: #fff; font-size: 19px; margin-left: 5px; padding-left: 5px;padding-right: 6px;"><%= dateFormat.format(alertCreateDate) %></div>
       		</div>
    		</div>
    	</td>
  	 </tr>
  	 <tr>
  	 	<td>
  	 		<div style="margin-top: -39px;">
			<div class="asset-title" style="font-size:12px;font-weight: bolder; font-family:helvetica;color:#555;margin-left: 73px;width: 100%;"><%= adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getLocation() %>: <%= alert.getTitle() %>     </div>
			<div style="font-size: 12px;margin-left: 73px;"> by: <%= alert.getUserName() %></div>
			<div style="margin-left: 73px;font-size: 12px;"><%= alert.getContent() %></div>
			<!-- Modified By Sachin Jagtap: PRT-739 -->
			<div style="margin-left: 73px;font-size: 12px;">Created at: <%= openTimeFormat.format(adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getAlertOpenTime())+" UTC"%>,     Resolution: <%= adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getExpectedResolutionTime() %></div>
		    
    		</div>
  	 	</td>
  	 </tr>
  	 <tr>
  	 	<td>
  	 		<div style="border-bottom: 1px dotted #ccc;"></div>
  	 	</td>
  	 </tr>
  </table>
<%
	}
	}
if(allAlertList.size()==0){
%>
	<div style="margin-top:-1%;text-align:center;"> No Alerts! for now </div>
	<% } %>
 
</div>


<%-- <script type="text/javaScript">

 function timedRefresh(timeoutPeriod) {

 jQuery.post('<portlet:renderURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>"></portlet:renderURL>', function(data){
     $("#page_alerts").html(data);
 })
}
timedRefresh(50000);
//   

</script>  --%>

<portlet:resourceURL var="alertResourceURL"/>
<aui:script use="aui-io-request,aui-node">

Liferay.provide(
  	window,
  	'<portlet:namespace />markAlertAsRead',
  	function(alertId){
  	
  	var A= AUI();
  	//alert(alertId);
  	
  	var url='<%= alertResourceURL.toString()%>';
  	
  	A.io.request(
  	url,
  	 //data to be sent to server
  	 {
  	 data:{
  	   <portlet:namespace/>alertIds:alertId,
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
  		//alert("response from server"+message.updateSuccess)
  		jQuery.post('<portlet:renderURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>"></portlet:renderURL>', function(data){
     	jQuery("#page_alerts").html(data);
		 })
  		}
  		
  			}
  	
  		}
  	});//End of IO
  });//End of provide
  	 

</aui:script>

