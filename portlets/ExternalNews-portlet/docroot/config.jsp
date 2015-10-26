


<%--
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
--%>


<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

String typeSelection = ParamUtil.getString(request, "typeSelection");

int assetOrder = ParamUtil.getInteger(request, "assetOrder", -1);
%>

<liferay-portlet:renderURL portletConfiguration="true" var="configurationURL" />

<%
PortletURL configurationActionURL = renderResponse.createActionURL();

configurationActionURL.setParameter("struts_action", "/portlet_configuration/edit_configuration");
configurationActionURL.setParameter("redirect", configurationURL.toString());
configurationActionURL.setParameter("backURL", redirect);
configurationActionURL.setParameter("portletResource", portletResource);

PortletURL configurationRenderURL = renderResponse.createRenderURL();

configurationRenderURL.setParameter("struts_action", "/portlet_configuration/edit_configuration");
configurationRenderURL.setParameter("redirect", configurationURL.toString());
configurationRenderURL.setParameter("backURL", redirect);
configurationRenderURL.setParameter("portletResource", portletResource);
%>

<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= configurationURL.toString() %>" />
	<aui:input name="typeSelection" type="hidden" />
	<aui:input name="articleGroupId" type="hidden" />
	<aui:input name="articleId" type="hidden" />
	<aui:input name="assetOrder" type="hidden" />
	<aui:input name="urlCnt" type="hidden" value="<%=urls.length %>"/>
	
	<c:choose>
		<c:when test="<%= typeSelection.equals(StringPool.BLANK) %>">
			<liferay-ui:panel-container extended="<%= true %>" id="rssFeedsSettingsPanelContainer" persistState="<%= true %>">
				<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="rssFeedsSettingsPanel" persistState="<%= true %>" title="feeds">
					<liferay-ui:error exception="<%= ValidatorException.class %>">

					<%
					ValidatorException ve = (ValidatorException)errorException;
					%>

					<liferay-ui:message key="the-following-are-invalid-urls" />

					<%
					Enumeration enu = ve.getFailedKeys();

					while (enu.hasMoreElements()) {
						String url = (String)enu.nextElement();
					%>

						<strong><%= url %></strong><%= (enu.hasMoreElements()) ? ", " : "." %>

					<%
					}
					%>

					</liferay-ui:error>

					<aui:fieldset cssClass="subscriptions">

						<%
						if (urls.length == 0) {
							urls = new String[1];
							urls [0] = StringPool.BLANK;
						}

						for (int i = 0; i < urls.length; i++) {
							String title = StringPool.BLANK;

							if (i < titles.length) {
								title = titles[i];
							}
						%>

							<div class="lfr-form-row lfr-form-row-inline">
								<div class="row-fields">
									<aui:input cssClass="lfr-input-text-container" label="title" name='<%= "title" + i %>' value="<%= title %>" required="true">
										<aui:validator name="custom" errorMessage="Please enter alphabets">
											function (val, fieldNode, ruleValue) {
											var result = false;
											var regexp =/^[a-zA-Z0-9\s]+$/;
											if(val.search(regexp) != -1){
												result = true;
											}
											return result;
											}
										</aui:validator>
										<aui:validator name="maxLength">30</aui:validator>
									</aui:input>

									<aui:input cssClass="lfr-input-text-container" label="url" id='<%= "url" + i %>' name='<%= "url" + i %>' value="<%= urls[i] %>" required="true">
										<aui:validator name="url" />
									</aui:input>
								</div>
							</div>

						<%
						}
						%>

					</aui:fieldset>
				</liferay-ui:panel>

				<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="rssFeedsDisplaySettingsPanel" persistState="<%= true %>" title="display-settings">
					<aui:fieldset>
						<%-- <aui:input name="preferences--showFeedTitle--" type="checkbox" value="<%= showFeedTitle %>" />

						<aui:input name="preferences--showFeedPublishedDate--" type="checkbox" value="<%= showFeedPublishedDate %>" />

						<aui:input name="preferences--showFeedDescription--" type="checkbox" value="<%= showFeedDescription %>" /> --%>

						<%-- <%
						String taglibShowFeedImageOnClick = "if (this.checked) {document." + renderResponse.getNamespace() + "fm." + renderResponse.getNamespace() + "feedImageAlignment.disabled = '';} else {document." + renderResponse.getNamespace() + "fm." + renderResponse.getNamespace() + "feedImageAlignment.disabled = 'disabled';}";
						%>

						<aui:input name="preferences--showFeedImage--" onClick="<%= taglibShowFeedImageOnClick %>" type="checkbox" value="<%= showFeedImage %>" />

						<aui:input name="preferences--showFeedItemAuthor--" type="checkbox" value="<%= showFeedItemAuthor %>" /> --%>

						<aui:select label="num-of-entries-per-feed" name="preferences--entriesPerFeed--">

							<%
							for (int i = 3; i < 10; i++) {
							%>

								<aui:option label="<%= i %>" selected="<%= i == entriesPerFeed %>" />

							<%
							}
							%>

						</aui:select>

						<%-- <aui:select label="num-of-expanded-entries-per-feed" name="preferences--expandedEntriesPerFeed--">

							<%
							for (int i = 0; i < 10; i++) {
							%>

								<aui:option label="<%= i %>" selected="<%= i == expandedEntriesPerFeed %>" />

							<%
							}
							%>

						</aui:select> --%>

						<%-- <aui:select disabled="<%= !showFeedImage %>" name="preferences--feedImageAlignment--">
							<aui:option label="left" selected='<%= feedImageAlignment.equals("left") %>' />
							<aui:option label="right" selected='<%= feedImageAlignment.equals("right") %>' />
						</aui:select> --%>
					</aui:fieldset>
				</liferay-ui:panel>
			</liferay-ui:panel-container>

			<aui:button-row>
				<aui:button onClick='<%= renderResponse.getNamespace() + "saveSettings();" %>' type="button" value="Save" />
				<aui:button type="cancel" />
			</aui:button-row>

			<aui:script use="aui-base">
				var subscriptionsTable = A.one('#<portlet:namespace />subscriptions');

				if (subscriptionsTable) {
					subscriptionsTable.delegate(
						'click',
						function(event) {
							event.currentTarget.get('parentNode.parentNode').remove();
						},
						'.remove-subscription'
					);
				}
			</aui:script>
		</c:when>
			</c:choose>
</aui:form>

<aui:script>
	function <portlet:namespace />removeSelectionForFooter() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = 'remove-footer-article';

		submitForm(document.<portlet:namespace />fm, '<%= configurationActionURL.toString() %>');
	}

	function <portlet:namespace />removeSelectionForHeader() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = 'remove-header-article';

		submitForm(document.<portlet:namespace />fm, '<%= configurationActionURL.toString() %>');
	}

	function <portlet:namespace />selectAsset(articleGroupId, articleId, assetOrder) {
		if (assetOrder == 1) {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = 'set-footer-article';
		}
		else {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = 'set-header-article';
		}

		document.<portlet:namespace />fm.<portlet:namespace />articleGroupId.value = articleGroupId;
		document.<portlet:namespace />fm.<portlet:namespace />articleId.value = articleId;
		document.<portlet:namespace />fm.<portlet:namespace />typeSelection.value = '';

		submitForm(document.<portlet:namespace />fm, '<%= configurationActionURL.toString() %>');
	}

	function <portlet:namespace />saveSettings() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = '<%= Constants.UPDATE %>';
		document.<portlet:namespace />fm.<portlet:namespace />typeSelection.value = '';
		
		var totalUrls = document.<portlet:namespace />fm.<portlet:namespace />urlCnt.value;
		
		if( checkUrls(totalUrls)) {	
			if(totalUrls <= 10) {
				submitForm(document.<portlet:namespace />fm, '<%= configurationActionURL.toString() %>');
			} else {
				alert('Limit Exceed : Maximum 10 External Feeds can be configured');
				document.<portlet:namespace />fm.action='';
				return false;
			}
		} else {
			alert('Found One or more Url(s) duplicate');
			document.<portlet:namespace />fm.action='';
			return false;
		}
	}

	<%-- function <portlet:namespace />selectionForHeader() {
		document.<portlet:namespace />fm.<portlet:namespace />typeSelection.value = '<%= JournalArticle.class.getName() %>';
		document.<portlet:namespace />fm.<portlet:namespace />assetOrder.value = 0;

		submitForm(document.<portlet:namespace />fm);
	}

	function <portlet:namespace />selectionForFooter() {
		document.<portlet:namespace />fm.<portlet:namespace />typeSelection.value = '<%= JournalArticle.class.getName() %>';
		document.<portlet:namespace />fm.<portlet:namespace />assetOrder.value = 1;

		submitForm(document.<portlet:namespace />fm);
	} --%>
</aui:script>

<script type="text/javascript">
$(document).ready(function() {
	checkUrls = function(totalUrls) {
		/* alert(totalUrls); */
		var stat = true;
		var unique_values = {};
		var list_of_values = [];
		$('input[name$="url"]').
		    each(function(item) { 
		    	alert(item.value);
		        if ( ! unique_values[item.value] ) {
		            unique_values[item.value] = true;
		            list_of_values.push(item.value);
		        } else {
		        	stat = false;
		        }
		    });
			return stat;
		}
});
</script>

<aui:script use="liferay-auto-fields, aui-base">
 var cnt = <%=urls.length %>;
//console.log('---------------------------->' + cnt);
 var autoFields = new Liferay.AutoFields(
	         {
	            contentBox: 'fieldset.subscriptions',
				fieldIndexes: '<portlet:namespace />subscriptionIndexes',
				namespace: '<portlet:namespace />'
	        }).render();
	   	 
	 // add row event
	autoFields.on("clone", function(newField) {
		cnt = cnt +1;
       	document.<portlet:namespace />fm.<portlet:namespace />urlCnt.value=cnt;
	               
	});
	
	// delete row event
	autoFields.on("delete", function() {
		cnt = cnt -1;
		document.<portlet:namespace />fm.<portlet:namespace />urlCnt.value=cnt;
	 });
</aui:script>