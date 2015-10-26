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

<%@include file="/init.jsp" %>
<script type="text/javascript" src="<%= themeDisplay.getPathThemeJavaScript() %>/datatables/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%= themeDisplay.getPathThemeCss() %>/datatables/jquery.dataTables.css"/>
<portlet:defineObjects/>

<%
String url = ParamUtil.getString(request, "url");
String title = StringPool.BLANK;
if(urls.length == 0) {
%>

To Add External News please click on <aui:icon cssClass="icon-gear"></aui:icon> icon.
 	<%-- <aui:button href="<%= portletDisplay.getURLConfiguration()%>" useDialog="true" cssClass="icon-wrench"></aui:button> --%>
<% 
} else {
%>
	<div>
		<table class="event_list" id="event_list" width="100%" style="font-family:helvetica;color: #4d4d4d;">
			<thead>
			
			<th></th>
			
			</thead>
			<tbody>
<%
	int failCnt = 0;
	for (int i = 0; i < urls.length; i++) {
		try {
		
			url = urls[i];
		
			if (i < titles.length) {
				title = titles[i];
			}
			else {
				title = StringPool.BLANK;
			}
		
			boolean last = false;
		
			if (i == (urls.length - 1)) {
				last = true;
			}
	%>
			<%@ include file="feed.jspf" %>
	<%
		} catch(Exception e) {
			failCnt++;
%>
			Feed with Title:<%=title %> is currently unavailable.
			</Br>
<%			
			continue;
		}
	}
	if(failCnt > 0 ) {
%>
		Please reload/refresh the Page.<aui:button href="<%=portletDisplay.getURLRefresh() %>" iconAlign="true" cssClass="icon-refresh"></aui:button>
<%
	}
%>
		</tbody>
		</table>
	</div>
<%
}
%>
<script type="text/javascript">
jQuery(document).ready(function() {
    jQuery('#event_list').DataTable({
    "searching": false,
    "lengthChange": false,
    "pageLength": 5,
    "sort": false
    });
    
    
});
</script>

<style>
table.dataTable tbody th, table.dataTable tbody td{
padding :1px;
}
table.dataTable thead th, table.dataTable thead td{
padding: 0px;

}
table.dataTable thead th, table.dataTable thead td{
border-bottom: none !important;
}
table.dataTable.no-footer{
border-bottom: none !important;
}
.aui .icon-plus::before{
	display:none !important;
}
</style>