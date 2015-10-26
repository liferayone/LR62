<%@page import="com.twelve.capital.service.adminalertLocalServiceUtil"%>
<%@page import="com.liferay.portlet.announcements.service.AnnouncementsEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.announcements.model.AnnouncementsEntry"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />
<theme:defineObjects />
<portlet:renderURL var="adminViewURL"><portlet:param name="jspPage" value="/html/alert-admin/viewAllAlerts.jsp"/></portlet:renderURL>
<portlet:actionURL var="alertAdminActionURL"><portlet:param name="cmd" value="createAlert"/></portlet:actionURL>
<aui:form action="<%=alertAdminActionURL.toString() %>">
<%
	String alertId = renderRequest.getParameter("alertId");
	if(Validator.isNull(alertId)){
%>
<div class="form_elements">

<ul style="list-style-type: none;">

<li><aui:input name="title" type="text" label="Title"/></li>
<li><aui:field-wrapper label="Description">
<liferay-ui:input-editor name="description" toolbarSet="liferay-article" initMethod="initEditor"  width="200" /></aui:field-wrapper></li>
<li>
	<aui:select name="location" id="location">
		<aui:option value="Global">Global</aui:option>
		<aui:option value="London">London</aui:option>
		<aui:option value="Zurich">Zurich</aui:option>
	</aui:select>
 </li>
<li>
<aui:select name="alertType" label="Type"> 
    <aui:option value="Info">Info</aui:option>
 	<aui:option value="Warning">Warning</aui:option>
 	<aui:option value="Business Interruption">Business Interruption</aui:option>
</aui:select></li>
<%-- <li><aui:input name="resolution" type="text" label="Resolution"/></li> --%>
<li><aui:input name="expectedResolutionTime" id="expectedResolutionTime" type="text" label="Expected Resolution Time"/></li>
<li>
	<aui:select name="resolutionStatus" id="resolutionStatus" label="Resolution Status">
		<aui:option value="Open">Open</aui:option>
	</aui:select>
</li>
</ul>
<p align="right" style="padding-right:5px;"><aui:button type="submit" value="Create"/> <a href="<%= adminViewURL.toString() %>"><aui:button type="cancel" value="cancel"/></a></p>

</div>
 <script type="text/javascript">
    function <portlet:namespace/>initEditor(){
    return "<%=UnicodeFormatter.toString("") %>";
    }

    </script>
<% }
	if(Validator.isNotNull(alertId)){
		SimpleDateFormat sdf= new SimpleDateFormat("mm/dd/yyyy");
		AnnouncementsEntry alert= AnnouncementsEntryLocalServiceUtil.getEntry(Long.parseLong(alertId));
%>
<div class="form_elements">

<ul style="list-style-type: none;">
<aui:input name="alertId" type="hidden" value="<%= String.valueOf(alert.getEntryId()) %>"></aui:input>
<li><aui:input name="title" type="text" label="Title" value="<%= alert.getTitle() %>"/></li>
<li><aui:field-wrapper label="Description">
<liferay-ui:input-editor name="description" toolbarSet="liferay-article" initMethod="initEditor"  width="200" /></aui:field-wrapper></li>

<li>
<aui:select name="location" id="location">
		<aui:option value="Global" selected='<%= adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getLocation().equalsIgnoreCase("global") %>'>Global</aui:option>
		<aui:option value="London" selected='<%= adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getLocation().equalsIgnoreCase("london") %>'>London</aui:option>
		<aui:option value="Zurich" selected='<%= adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getLocation().equalsIgnoreCase("zurich") %>'>Zurich</aui:option>
	</aui:select>
</li>
<li>
<aui:select name="alertType" label="Type"> 
    <aui:option value="Info" selected='<%= alert.getType().equalsIgnoreCase("info") %>'>Info</aui:option>
 	<aui:option value="Warning" selected='<%= alert.getType().equalsIgnoreCase("warning") %>'>Warning</aui:option>
 	<aui:option value="Business Interruption" selected='<%= alert.getType().equalsIgnoreCase("Business Interruption") %>'>Business Interruption</aui:option>
 	
 	
</aui:select></li>
<%-- <li><aui:input name="resolution" type="text" label="Resolution" value="<%= adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getResolution() %>"/></li> --%>
<li><aui:input name="expectedResolutionTime" id="expectedResolutionTime" type="text" label="Expected Resolution Time" value="<%= adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getExpectedResolutionTime() %>" /></li>
<li>
	<aui:select name="resolutionStatus" id="resolutionStatus" label="Resolution Status">
		<aui:option value="Open" selected='<%= adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getResolutionStatus().equalsIgnoreCase("open") %>'>Open</aui:option>
		<aui:option value="Resolved" selected='<%= adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getResolutionStatus().equalsIgnoreCase("resolved") %>'>Resolved</aui:option>
	</aui:select>
</li>
</ul>
<p align="right" style="padding-right:5px;"><aui:button type="submit" value="Update"/> <a href="<%= adminViewURL.toString() %>"><aui:button type="cancel" value="cancel"/></a></p>

</div>


 <script type="text/javascript">
    function <portlet:namespace/>initEditor(){
    return "<%=UnicodeFormatter.toString(alert.getContent()) %>";
    }

    </script>
 <% } %>
 
</aui:form>
<%-- <script type="text/javascript">
 AUI().use('aui-datepicker', function(A) {
     new A.DatePicker({
    trigger: '#<%= renderResponse.getNamespace()%>expectedResolutionTime',
    popover: { zIndex: 99999 },
    mask: '%m/%d/%y',
    calendar: {
        minimumDate: new Date(2000,01,01),
        maximumDate: new Date(2020,01,01),
        selectionMode: 'single'
    }
    })
     .render();
});
</script> --%>