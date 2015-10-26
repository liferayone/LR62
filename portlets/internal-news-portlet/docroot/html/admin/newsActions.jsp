
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
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

JournalArticle article = (JournalArticle)resultRow.getObject();


%>
<portlet:renderURL var="editArticleURL" >
	<portlet:param name="articleId" value="<%=  String.valueOf(article.getId()) %>"/>
	<portlet:param name="cmd" value="editNews"/>
	<portlet:param name="jspPage" value="/html/admin/createNews.jsp"/>
</portlet:renderURL>

<portlet:actionURL var="deleteArticleURL">
	<portlet:param name="articleId" value="<%= String.valueOf(article.getResourcePrimKey()) %>"/>
	<portlet:param name="cmd" value="deleteArticle"/>
</portlet:actionURL>

<liferay-ui:icon-menu>
	<liferay-ui:icon message="Edit" url="${editArticleURL}" />
	 <liferay-ui:icon message="Delete" url="${deleteArticleURL}" />
</liferay-ui:icon-menu>