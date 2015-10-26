<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sun.org.apache.xerces.internal.impl.dv.xs.MonthDV"%>
<%@page import="com.sun.org.apache.xerces.internal.impl.dv.xs.MonthDayDV"%>
<%@page import="com.twelve.capital.service.adminalertLocalServiceUtil"%>
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
	List<AnnouncementsEntry> alertList= (List<AnnouncementsEntry>)renderRequest.getAttribute("alertList");
	
//System.out.println("Alert List from Render Method"+alertList.size());
%>

<div class="alerts" id="page_alerts">
<% if(Validator.isNotNull(alertList)){ 
	for(AnnouncementsEntry alert : alertList){
		SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd");
		SimpleDateFormat openTimeFormat= new SimpleDateFormat("HH:mm");
		Date alertCreateDate= alert.getCreateDate();
		String alertType=alert.getType().toLowerCase();
		if(alert.getType().toLowerCase().equalsIgnoreCase("Business Interruption")){
			alertType="error";
		}
		if(adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getResolutionStatus().equalsIgnoreCase("resolved")){
			alertType="success";
		}
%>
  <div class='alert-message <%= alertType %>'>
  
    <a class="alertclose" href="#" onclick="<%= renderResponse.getNamespace() %>markAlertAsRead('<%= alert.getEntryId() %>');">x</a>
   <% if(!(alertType.equalsIgnoreCase("warning"))){ %>
    <table>
    <tr>
    <td>
    <div style="float:left;clear:both;background-color: none; border: 1px solid #f4f4f4;border-radius: 1px; box-shadow: 0 0 10px #fff inset; height: 25px; padding-left: 4px; padding-top: 6px;widh: 72px; z-index: 9999;margin-top: 6px;">
   <div style="float:left;transform: rotate(-90deg);transfom-origin: right top 0;font-size: 11px; color: #fff;"><%= monthFormat.format(alertCreateDate) %></div>
   <div style="float:left;border-left: 1px solid #fff;color: #fff; font-size: 19px; margin-left: 5px; padding-left: 5px;padding-right: 6px;"><%= dateFormat.format(alertCreateDate) %></div>
   </div>
   </td>
   </tr>
   <tr>
   <td>
    <div style="margin-top: -39px;">
			<div class="asset-title" style="font-size:12px;font-weight: bolder; font-family:helvetica;color:#fff;margin-left: 75px;width: 100%;"><%= adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getLocation() %>: <%= alert.getTitle() %>        </div>
			<div style="margin-left:75px;font-size: 12px;color:#fff;">by: <%= alert.getUserName() %></div>
			<div style="margin-left:75px;font-size: 12px;color:#fff;"><%= alert.getContent() %></div>
			<!-- Modified By Sachin Jagtap: PRT-739 -->
 			<div style="margin-left:75px;font-size: 12px;color:#fff;">Created at: <%= openTimeFormat.format(adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getAlertOpenTime())+" UTC"%><% if(!((adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getExpectedResolutionTime()).toString()).isEmpty()){ %>,      Resolution: <%= adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getExpectedResolutionTime() %><%} %></div>
		    
    		</div>
    </td>
    </tr>
    </table>
    <% 
	}
    	if(alertType.equalsIgnoreCase("warning")){
    %>
     <table>
    <tr>
    <td>
    <div style="float:left;clear:both;background-color: none; border: 1px solid #f4f4f4;border-radius: 1px; box-shadow: 0 0 10px #555 inset; height: 25px; padding-left: 4px; padding-top: 6px;widh: 72px; z-index: 9999;margin-top: 6px;">
   <div style="float:left;transform: rotate(-90deg);transfom-origin: right top 0;font-size: 11px; color: #555;"><%= monthFormat.format(alertCreateDate) %></div>
   <div style="float:left;border-left: 1px solid #555;color: #555; font-size: 19px; margin-left: 5px; padding-left: 5px;padding-right: 6px;"><%= dateFormat.format(alertCreateDate) %></div>
   </div>
   </td>
   </tr>
   <tr>
   <td>
    <div style="margin-top: -39px;">
			<div class="asset-title" style="font-size:12px;font-weight: bolder; font-family:helvetica;color:#555;margin-left: 75px;width: 100%;"><%= adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getLocation() %>: <%= alert.getTitle() %>        </div>
			<div style="margin-left:75px;font-size: 12px;color:#555;">by: <%= alert.getUserName() %></div>
			<div style="margin-left:75px;font-size: 12px;color:#555;"><%= alert.getContent() %></div>
			<!-- Modified by Sachin Jagtap ,PRT-739 -->
			<div style="margin-left:75px;font-size: 12px;color:#555;">Created at: <%= openTimeFormat.format(adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getAlertOpenTime()) +"  UTC"%> <% if (!((adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getExpectedResolutionTime()).toString()).isEmpty()){ %>,     Resolution: <%= adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getExpectedResolutionTime() %><% }%></div>
		    
    		</div>
    </td>
    </tr>
    </table>
    <% } %>
  </div>
<%
	}
	} %>
 <!--  <div class="alert-message error">
    <a class="alertclose" href="#">x</a>
    <p><strong>Oh snap!</strong> Change this and that and <a href="#">try again</a>.</p>
  </div>

  <div class="alert-message success">
    <a class="alertclose" href="#">x</a>
    <p><strong>Well done!</strong> You successfully <a href="#">read this</a> alert message.</p>
  </div>

  <div class="alert-message info">
    <a class="alertclose" href="#">x</a>
    <p><strong>Heads up!</strong> This is an alert that needs your attention, but it?s not <a href="#">a huge priority</a> just yet.</p>
  </div> -->

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
		data=jQuery(data).html();
     	jQuery("#page_alerts").html(data);
		 })
  		}
  		
  			}
  	
  		}
  	});//End of IO
  });//End of provide
  	 

</aui:script>

