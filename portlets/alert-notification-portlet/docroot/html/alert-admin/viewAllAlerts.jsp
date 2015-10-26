<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.twelve.capital.portlet.alert.admin.AlertAdminPortletAction"%>
<%@page import="com.twelve.capital.service.adminalertLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.service.ClassNameLocalServiceUtil"%>
<%@page import="com.liferay.portlet.announcements.service.AnnouncementsEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.announcements.model.AnnouncementsEntry"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<theme:defineObjects/>
<script type="text/javascript" src="<%= themeDisplay.getPathThemeJavaScript() %>/datatables/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%= themeDisplay.getPathThemeCss() %>/datatables/jquery.dataTables.css"/>

<portlet:defineObjects/>
<portlet:renderURL var="alertAdminRenderURL"><portlet:param name="jspPage" value="/html/alert-admin/view.jsp"/></portlet:renderURL>
<style type="text/css">
<!--
.taglib-page-iterator .lfr-pagination-config .lfr-pagination-delta-selector, .taglib-page-iterator .lfr-pagination-config .lfr-pagination-page-selector {
    display: none !important;
}

table.dataTable{
background-color: #ededed;
text-align: left;
}
 table.dataTable tbody th, table.dataTable tbody td{
padding:4px;
}

table.dataTable thead th, table.dataTable thead td{
padding: 6px 4px;
}
-->
</style>
<%
    PortletURL actionURL = renderResponse.createRenderURL();
	List<AnnouncementsEntry> alertList = AnnouncementsEntryLocalServiceUtil.getEntries(ClassNameLocalServiceUtil.getClassNameId(Group.class), themeDisplay.getScopeGroupId(), true, -1, -1);
	SimpleDateFormat dateFormat= new SimpleDateFormat("MM/dd/yyyy");
	
	PortletURL alertEditURL= renderResponse.createRenderURL();
	alertEditURL.setParameter("jspPage", "/html/alert-admin/view.jsp");
	
	PortletURL deleteAlertURL= renderResponse.createActionURL();
	deleteAlertURL.setParameter("cmd", "deleteAlert");
%>

<div id="alertLists">
<a href="<%= alertAdminRenderURL.toString() %>"><aui:button value="Create Alert"/></a>

    <table id="alert_list" class="display row-border cell-border" width="100%" style="margin-top: 1%;">
    	<thead>
    	
    		<tr>
    			<th>Title</th>
    			<th>Type</th>
    			<th>Location</th>
    			<th>Resolution Time</th>
    			<th>Resolution Status</th>
    			<th>Modified Date</th>
    			<th>Actions</th>
    		</tr>
    	</thead>
    	<tbody>
    	<%
    		for (AnnouncementsEntry alert: alertList ){
    			alertEditURL.setParameter("alertId", String.valueOf(alert.getEntryId()));
    			deleteAlertURL.setParameter("alertId", String.valueOf(alert.getEntryId()));
    	%>
    		<tr>
    			<td><%= alert.getTitle() %></td>
    			<td><%= alert.getType() %></td>
    			<td><%= adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getLocation() %></td>
    			<td><%= adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getExpectedResolutionTime()  %></td>
    			<td><%= adminalertLocalServiceUtil.getadminalert(alert.getEntryId()).getResolutionStatus() %></td>
    			<td><%= dateFormat.format(alert.getModifiedDate()) %></td>
    			<td>
    				<a href="<%= alertEditURL.toString() %>"><liferay-ui:icon image="edit" /></a>
					&nbsp;&nbsp;
					<a href="<%= deleteAlertURL.toString() %>"><liferay-ui:icon image="delete" /></a>
    			</td>
    		</tr>
    	<%
    		}
    	%>
    	</tbody>
    </table>
</div>    
<script type="text/javascript">

    jQuery('#alert_list').DataTable({
    "searching": false,
    "lengthChange": false,
    "pageLength": 5,
    "bSort": false
    });
    
    
</script>
