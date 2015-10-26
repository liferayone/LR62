<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<portlet:defineObjects/>
<theme:defineObjects/>
<portlet:actionURL var="createNews"><portlet:param name="cmd" value="createnews"/></portlet:actionURL>
<portlet:actionURL var="updateNews"><portlet:param name="cmd" value="updatenews"/></portlet:actionURL>
<portlet:renderURL var="viewAllInternalNews"><portlet:param name="jspPage" value="/html/admin/allNews.jsp"/></portlet:renderURL>
<portlet:renderURL var="editArticleRenderURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
		<portlet:param name="struts_action" value="/journal/edit_article" />
	</portlet:renderURL>
<%
	String articleId=renderRequest.getParameter("articleId");
	
%>
<aui:form action="<%= createNews.toString() %>">

<aui:input name="articleURL" type="hidden" value="<%= editArticleRenderURL %>" />
<%
if(Validator.isNull(articleId)){
%>
	<div id="internal_news_form">
		<ul style="list-style-type: none;">
			<li>
				<aui:input name="newsTitle" type="text" showRequiredLabel="<%=false %>" label="Title">
					<aui:validator  name="required"/>
				
				</aui:input>
			</li>
			<li>
				<aui:input name="newsDescription" showRequiredLabel="<%=false %>" type="textarea" label="Description">
				<aui:validator name="required"/>
				</aui:input>
			</li>
			<li>
				<%-- <aui:select name="newsLocation" label="Location">
					<aui:option value="Global">Global</aui:option>
					<aui:option value="London">London</aui:option>
					<aui:option value="Zurich">Zurich</aui:option>
				</aui:select> --%>
				<label>Location</label>
				<liferay-ui:custom-attribute classPK="<%= 0 %>"  name="Location" className="<%= JournalArticle.class.getName() %>" editable="true"></liferay-ui:custom-attribute>
			</li>
			<%-- <li>
				<label>Categories</label>
				<liferay-ui:asset-categories-selector ></liferay-ui:asset-categories-selector>
			</li>
			<li>
				<label>Tags</label>
				<liferay-ui:asset-tags-selector className="<%= JournalArticle.class.getName() %>" classPK=""></liferay-ui:asset-tags-selector>
			</li> --%>
		</ul>
		<p align="right" style="padding-right:5px;"><aui:button type="submit" value="Publish"/> <a href="<%= viewAllInternalNews.toString() %>"><aui:button type="cancel" value="cancel"/></a></p>
		
	</div>
<% }%>
<%
if(Validator.isNotNull(articleId)){
	JournalArticle newsArticle=JournalArticleLocalServiceUtil.getArticle(Long.parseLong(articleId));
%>
	<aui:input name="articleId" value="<%= newsArticle.getId() %>" type="hidden"/>
	<div id="internal_news_form">
		<ul style="list-style-type: none;">
			<li>
				<aui:input name="newsTitle" type="text" showRequiredLabel="<%=false %>" label="Title" value="<%= newsArticle.getTitle(LocaleUtil.US) %>">
					<aui:validator  name="required"/>
				
				</aui:input>
			</li>
			<li>
				<aui:input name="newsDescription" showRequiredLabel="<%=false %>" type="textarea" label="Description" value="<%= newsArticle.getDescription(LocaleUtil.US) %>">
				<aui:validator name="required"/>
				</aui:input>
			</li>
			<li>
				<%-- <aui:select name="newsLocation" label="Location">
					<aui:option value="Global">Global</aui:option>
					<aui:option value="London">London</aui:option>
					<aui:option value="Zurich">Zurich</aui:option>
				</aui:select> --%>
				<label>Location</label>
				<liferay-ui:custom-attribute classPK="<%= newsArticle!=null ? newsArticle.getId():0 %>" label="Location" name="Location" className="<%= JournalArticle.class.getName() %>" editable="true"></liferay-ui:custom-attribute>
			</li>
			<%-- <li>
				<label>Categories</label>
				<liferay-ui:asset-categories-selector ></liferay-ui:asset-categories-selector>
			</li>
			<li>
				<label>Tags</label>
				<liferay-ui:asset-tags-selector className="<%= JournalArticle.class.getName() %>" classPK=""></liferay-ui:asset-tags-selector>
			</li> --%>
		</ul>
		<p align="right" style="padding-right:5px;"><aui:button type="submit" value="Update"/> <a href="<%= viewAllInternalNews.toString() %>"><aui:button type="cancel" value="cancel"/></a></p>
		
	</div>
<% }%>
</aui:form>