<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portlet.PortletURLFactory"%>
<%@page import="com.liferay.calendar.model.CalendarBooking"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@page import="com.liferay.portal.service.GroupLocalServiceUtil" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="com.liferay.portal.model.Group" %>
<%@ page import="java.util.*"%>
<%@page import="com.liferay.portal.model.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="javax.portlet.PortletURL" %>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<portlet:defineObjects />

<theme:defineObjects/>

<%
long configuredSiteId = GetterUtil.getLong(portletPreferences.getValue("siteid", "0"));
long configuredPage =GetterUtil.getLong(portletPreferences.getValue("sitepage", "0"));
String redirect = ParamUtil.getString(request, "redirect");

LiferayPortletURL resourceURL = (LiferayPortletURL) renderResponse.createResourceURL();
				  resourceURL.setPortletId(ParamUtil.getString(request, "portletResource"));
  %>