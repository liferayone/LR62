<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<theme:defineObjects/>
<script type="text/javascript" src="<%= themeDisplay.getPathThemeJavaScript() %>/datatables/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%= themeDisplay.getPathThemeCss() %>/datatables/jquery.dataTables.css"/>
<portlet:defineObjects/>

<portlet:renderURL var="createNewsRenderURL"><portlet:param name="cmd" value="createNews"/><portlet:param name="jspPage" value="/html/admin/createNews.jsp"/></portlet:renderURL>
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
	List<JournalArticle> newsList=(List<JournalArticle>)renderRequest.getAttribute("internalNewsList");
	//System.out.println("News List Size---"+newsList.size());
	SimpleDateFormat dateFormat= new SimpleDateFormat("MM/dd/yyyy");
	
	PortletURL editNewsArticle = renderResponse.createRenderURL();
	editNewsArticle.setParameter("jspPage", "/html/admin/createNews.jsp");
	editNewsArticle.setParameter("cmd", "editNews");
	
	PortletURL deleteNewsArticle= renderResponse.createActionURL();
	deleteNewsArticle.setParameter("cmd", "deleteArticle");
	
%>
<a href="<%= createNewsRenderURL.toString() %>"><aui:button value="Create Internal News"/></a>
<div id="internalnewslist">
	
    <table id="news_list" class="display row-border cell-border" width="100%" style="margin-top: 1%;">
    	<thead>
    		<tr>
    			<th>Title</th>
    			<th>Description</th>
    			<th>Location</th>
    			<th>Published Date</th>
    			<th>Actions</th>
    		</tr>
    		
    	</thead>
    	<tbody>
    	<% for(JournalArticle newsArticle: newsList){ 
    		 String[] expandoVal=(String[]) newsArticle.getExpandoBridge().getAttribute("Location");
    		editNewsArticle.setParameter("articleId", String.valueOf(newsArticle.getId()));
    		deleteNewsArticle.setParameter("articleId", String.valueOf(newsArticle.getResourcePrimKey()));
    	%>
    		<tr>
    			<td><%= newsArticle.getTitle(LocaleUtil.US) %></td>
    			<td><%= StringUtil.shorten(newsArticle.getDescription(LocaleUtil.US), 50) %></td>
    			<td><%= expandoVal[0] %></td>
    			<td><%= dateFormat.format(newsArticle.getModifiedDate()) %></td>
    			<td>
    				<a href="<%= editNewsArticle.toString() %>"><liferay-ui:icon image="edit" /></a>
    				&nbsp;&nbsp;<a href="<%= deleteNewsArticle.toString() %>"><liferay-ui:icon image="delete" /></a>
    				<%-- <liferay-ui:icon-menu>
						<liferay-ui:icon message="Edit" url="<%= editNewsArticle.toString() %>" />
	 					<liferay-ui:icon message="Delete" url="<%= deleteNewsArticle.toString() %>" />
					</liferay-ui:icon-menu> --%>
    			</td>
    		</tr>
    	<%}%>
    	</tbody>
    		
    </table>
</div>

<script type="text/javascript">

    jQuery('#news_list').DataTable({
    "searching": false,
    "lengthChange": false,
    "pageLength": 5,
    "bSort" : false
    });
    
    

</script>
  