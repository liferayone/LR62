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

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>

<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.model.Company"%>
<%@page import="java.text.Format"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.model.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.sanitizer.Sanitizer" %>
<%@page import="com.liferay.portal.kernel.sanitizer.SanitizerException" %>
<%@page import="com.liferay.portal.kernel.sanitizer.SanitizerUtil" %>
<%@page import="com.twelve.capital.external.feed.util.RSSUtil" %>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %>

<%@page import="com.sun.syndication.feed.synd.SyndContent" %>
<%@page import="com.sun.syndication.feed.synd.SyndEnclosure" %>
<%@page import="com.sun.syndication.feed.synd.SyndEntry" %>
<%@page import="com.sun.syndication.feed.synd.SyndFeed" %>
<%@page import="com.sun.syndication.feed.synd.SyndImage" %>


<%@page import="com.liferay.portal.kernel.sanitizer.Sanitizer" %>
<%@page import="com.liferay.portal.kernel.sanitizer.SanitizerException" %>
<%@page import="com.liferay.portal.kernel.sanitizer.SanitizerUtil" %>

<%@ page import="com.sun.syndication.feed.synd.SyndContent" %>
<%@page import="com.sun.syndication.feed.synd.SyndEnclosure" %>
<%@page import="com.sun.syndication.feed.synd.SyndEntry" %>
<%@page import="com.sun.syndication.feed.synd.SyndFeed" %>
<%@page import="com.sun.syndication.feed.synd.SyndImage" %>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>

<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.model.User" %>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@page import="javax.portlet.WindowState" %>
<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="java.util.*"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>


<%@page import="com.sun.syndication.feed.synd.SyndFeedImpl"%>
<%@page import="com.liferay.portal.kernel.util.Http"%>
<%@page import="com.liferay.portal.kernel.util.ContentTypes"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.sun.syndication.feed.synd.SyndEnclosure"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.sun.syndication.feed.synd.SyndContent"%>
<%@page import="com.sun.syndication.feed.synd.SyndEntry"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.sun.syndication.feed.synd.SyndImage"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.sun.syndication.feed.synd.SyndFeed"%>
<%@page import="com.liferay.portal.kernel.util.ObjectValuePair"%>

<%@page import="javax.portlet.ValidatorException" %>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="java.text.SimpleDateFormat"%>

<theme:defineObjects />

<portlet:defineObjects />

<%
String portletResource = ParamUtil.getString(request, "portletResource");

String[] urls = portletPreferences.getValues("urls", new String[0]);
String[] titles = portletPreferences.getValues("titles", new String[0]);
int entriesPerFeed = GetterUtil.getInteger(portletPreferences.getValue("entriesPerFeed", "3"));
int expandedEntriesPerFeed = GetterUtil.getInteger(portletPreferences.getValue("expandedEntriesPerFeed", "1"));
boolean showFeedTitle = GetterUtil.getBoolean(portletPreferences.getValue("showFeedTitle", Boolean.TRUE.toString()));
boolean showFeedPublishedDate = GetterUtil.getBoolean(portletPreferences.getValue("showFeedPublishedDate", Boolean.TRUE.toString()));
boolean showFeedDescription = GetterUtil.getBoolean(portletPreferences.getValue("showFeedDescription", Boolean.TRUE.toString()));
boolean showFeedImage = GetterUtil.getBoolean(portletPreferences.getValue("showFeedImage", Boolean.TRUE.toString()));
String feedImageAlignment = portletPreferences.getValue("feedImageAlignment", "right");
boolean showFeedItemAuthor = GetterUtil.getBoolean(portletPreferences.getValue("showFeedItemAuthor", Boolean.TRUE.toString()));

String[] headerArticleValues = portletPreferences.getValues("headerArticleValues", new String[] {"0", ""});

long headerArticleGroupId = GetterUtil.getLong(headerArticleValues[0]);
String headerArticleId = headerArticleValues[1];

String[] footerArticleValues = portletPreferences.getValues("footerArticleValues", new String[] {"0", ""});

long footerArticleGroupId = GetterUtil.getLong(footerArticleValues[0]);
String footerArticleId = footerArticleValues[1];

Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
%>
