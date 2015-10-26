<%@include file="init.jsp" %>

<% if(configuredPage == 0 || configuredSiteId == 0){
	%>
	<br>Please configure Configration firstly</br>
	<%
} else{%>
<%
	List<CalendarBooking> futureCalendarEvents= (List<CalendarBooking>)renderRequest.getAttribute("futureCalendarEvents");
	//System.out.println("Future Events"+futureCalendarEvents.size());
	//Grid Icon URL
	//System.out.println("Calendar Layout Plid----"+LayoutLocalServiceUtil.getDefaultPlid(themeDisplay.getScopeGroupId(), true, "1_WAR_calendarportlet"));
	PortletURL calendarURL= PortletURLFactoryUtil.create(request, "1_WAR_calendarportlet", configuredPage, "RENDER_PHASE");
	calendarURL.setWindowState(LiferayWindowState.MAXIMIZED);
	
	// Date Formats for Date Icon
	SimpleDateFormat startDate = new SimpleDateFormat("dd");
	SimpleDateFormat startMonth = new SimpleDateFormat("MMM");
	SimpleDateFormat endDate = new SimpleDateFormat("MM/dd/yyyy");
	SimpleDateFormat startTime = new SimpleDateFormat("hh:mm a");
	SimpleDateFormat endTime = new SimpleDateFormat("hh:mm a");
	
	// counter for restricting normal and exclusive 
	int index =0;
%>
<script type="text/javascript" src="<%= themeDisplay.getPathThemeJavaScript() %>/datatables/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%= themeDisplay.getPathThemeCss() %>/datatables/jquery.dataTables.css"/>


<div id="table_content">

<div style="float:right; margin-top: 2px;">
<a class="cal_color_link" href="<%= calendarURL.toString() %>" >
<img src="<%= themeDisplay.getPathThemeImages() %>/common/grid_view.png" id ="cal_view_icon" height="18" width="18" title="Grid view" alt="expande" style="opacity: 0.8;margin-left: -20px; margin-top: 3px; float:right;position: absolute;"/></a></div>
 <table class="event_list" id="event_list"  style="font-family:helvetica;color: #4d4d4d;width: 100%;">
 
 
 

 <thead>
   
   <th> </th>
  
</thead>
<tbody>

<%
if(futureCalendarEvents.size() > 0){
for(CalendarBooking futurebooking : futureCalendarEvents){ 

	index++;
%>
  <tr>
 
  <td >
 <table width="100%";>

   <tr>
   <td>
   
    <div id="cal_date_wrapper" style="float:left;clear:both;background-color: #f4f4f4; border: 1px solid #f4f4f4;border-radius: 1px; box-shadow: 0 0 10px #fff inset; height: 25px; padding-left: 4px; padding-top: 6px;widh: 72px; z-index: 9999;margin-top: 6px;">
   
    <div id="cal_month" style="float:left;transform: rotate(-90deg);transfom-origin: right top 0;font-size: 11px; color: #555;"><%= startMonth.format(new Date(futurebooking.getStartTime())) %></div>
   
    <div id="cal_date" style="float:left;border-left: 1px solid #ccc;color: #3b73af; font-size: 19px; margin-left: 5px; padding-left: 5px;padding-right: 6px;"><%= startDate.format(new Date(futurebooking.getStartTime())) %></div>
    
    
    </div></td>
</tr>

<tr >
<td>
<div style="margin-top: -38px;">
<div style="font-size:12px;font-weight: bolder; font-family:helvetica;color:#555;margin-left: 73px;"><%= futurebooking.getTitle(Locale.US) %></div>

<!-- Modified by Sachin Jagtap,PRT-739 -->

<div style="margin-left: 73px;">  <%= startTime.format(new Date(futurebooking.getStartTime())) +" UTC" %><% if(!futurebooking.getLocation().isEmpty()) {%>, <%= futurebooking.getLocation() %> <%} %></div>


<div style="margin-left: 73px;"><p><%= futurebooking.getDescription(Locale.US) %></p></div>
  

<div style="border-bottom: 1px dotted #ccc ; width: 100%"></div>
</div>
</td>
 
</tr>

</table>
</td>
</tr>
<% 
	if((renderRequest.getWindowState().toString().equalsIgnoreCase("normal") || (renderRequest.getWindowState().toString().equalsIgnoreCase("exclusive") ))){
		
		if(index == 3){
			break;
		}
		
	}

}
}
%>


</tbody>

</table>

</div>
<%
if((renderRequest.getWindowState().toString().equalsIgnoreCase("normal") || (renderRequest.getWindowState().toString().equalsIgnoreCase("exclusive") ))){
%>
<script type="text/javascript">
    jQuery(document).ready(function(){
        jQuery('#cal_view_icon').hide();
        jQuery('#table_content').hover(function(){
        jQuery('#cal_view_icon').show();
        jQuery('#table_content').mouseleave(function(){
        jQuery('#cal_view_icon').hide();

            });
        });
    });
</script>
<% } %>
<%
	if((renderRequest.getWindowState().toString().equalsIgnoreCase("maximized"))){
%>
<script type="text/javascript">
jQuery(document).ready(function() {
    jQuery('#event_list').dataTable({
    "searching": false,
    "lengthChange": false,
    "pageLength": 5,
    "bSort": false
    });
 jQuery('#cal_view_icon').show();   
    
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
.dataTables_wrapper{
position: static !important;
}

</style>

<%
	}
}
%>