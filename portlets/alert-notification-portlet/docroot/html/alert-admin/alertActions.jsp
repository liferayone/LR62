<%@page import="com.liferay.portlet.announcements.model.AnnouncementsEntry"%>
<%@page import="com.liferay.portlet.journal.ArticleContentException"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<portlet:defineObjects />
<%
ResultRow resultRow = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

AnnouncementsEntry alert = (AnnouncementsEntry)resultRow.getObject();


%>
<portlet:renderURL var="editAlertURL" >
	<portlet:param name="alertId" value="<%=  String.valueOf(alert.getEntryId()) %>"/>
	<portlet:param name="jspPage" value="/html/alert-admin/view.jsp"/>
</portlet:renderURL>

<portlet:actionURL var="deleteAlertURL">
	<portlet:param name="alertId" value="<%= String.valueOf(alert.getEntryId()) %>"/>
	<portlet:param name="cmd" value="deleteAlert"/>
</portlet:actionURL>

<liferay-ui:icon-menu>
	<liferay-ui:icon message="Edit" url="${editAlertURL}" />
	 <liferay-ui:icon message="Delete" url="${deleteAlertURL}" />
</liferay-ui:icon-menu>