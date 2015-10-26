<%@ include file="init.jsp" %>

<%
int flagValue = AnnouncementsFlagConstants.NOT_HIDDEN;

LinkedHashMap<Long, long[]> scopes = AnnouncementsUtil.getAnnouncementScopes(themeDisplay.getUserId());

int newUserAlertCount = AnnouncementsEntryLocalServiceUtil.getEntriesCount(themeDisplay.getUserId(), scopes, true, flagValue);
int unreadUserNotificationsCount = AnnouncementsEntryLocalServiceUtil.getEntriesCount(themeDisplay.getUserId(), scopes, true, AnnouncementsFlagConstants.HIDDEN);

%>
<liferay-portlet:resourceURL var="refreshAlertURL"></liferay-portlet:resourceURL>
<ul style="list-style-type: none; width:23px;">
<li class="dockbar-user-notifications dropdown toggle-controls" id="<portlet:namespace />userAlertNotifications">
	 <a class="dropdown-toggle user-notification-link" href="javascript:;">
	 
	 <span class='user-notifications-count' id="<portlet:namespace />userAlertNotificationsCount"> 
	 <% if(unreadUserNotificationsCount > 0){ %>
	 <img class="bell" alt="alert_icon" src="<%= themeDisplay.getPathThemeImages() %>/common/bell.png"/>
	 <% } %>
	 
	 <% if(!(unreadUserNotificationsCount > 0)){ %>
	 <img  alt="alert_icon" src="<%= themeDisplay.getPathThemeImages() %>/common/bell.png"/>
	 <% } %>
	 </span> 
	</a>
 
	<ul class="dropdown-menu pull-right user-notifications-list" style="list-style: none;margin-right:-38px;margin-top:7px;"></ul>
	
	<aui:script use="aui-base,aui-io-plugin-deprecated,liferay-poller">
	
	 var userAlertNotifications= A.one('#<portlet:namespace/>userAlertNotifications');
	 
	 var userAlertNotificationsCount =A.one('#<portlet:namespace/>userAlertNotificationsCount');
	 
	 var onAlertPollerUpdate = function(response,chunkId){
	 	//alert("Control Inside Poller Update");
	 		var newUserAlertCount = Number(response.userAlertNotificationCount);
	 		//alert("Control Inside Poller Update1"+newUserAlertCount);
	 		var unreadAlertUserNotificationsCount = Number(response.unreadUserAlertNotificationCount);
	 		//alert("Control Inside Poller Update2"+unreadAlertUserNotificationsCount);
	 		//userAlertNotificationsCount.toggleClass('alert', (newUserAlertCount > 0));
			//alert("Control Inside Poller Update3");
			//userAlertNotificationsCount.setHTML(newUserAlertCount);
			//alert("Control Inside Poller Update"+newUserAlertCount+"---"+unreadAlertUserNotificationsCount);
	}
	
	A.on(
		'domready',
		function() {
			Liferay.Poller.addListener('<%= themeDisplay.getPortletDisplay().getRootPortletId()  %>', onAlertPollerUpdate, this);
				   }
		);
	var userAlertNotificationsList = userAlertNotifications.one('.dropdown-menu');
	
	if (!userAlertNotificationsList.io) {
				userAlertNotificationsList.plug(
					A.Plugin.IO,
					{
						autoLoad: false
					}
				);
			}
	userAlertNotifications.on(
				'click',
				function(event) {
					var currentAlertTarget = event.currentTarget;

					var alertTarget = event.target;

					var alertHandle = Liferay.Data['<portlet:namespace />userAlertNotificationsHandle'];

					if (!alertTarget.hasClass('user-notification') && !alertTarget.ancestor('.user-notification')) {
						currentAlertTarget.toggleClass('open');

						var menuOpen = currentAlertTarget.hasClass('open');

						if (menuOpen && !alertHandle) {
							alertHandle = currentAlertTarget.on(
								'clickoutside',
								function(event) {
									Liferay.Data['<portlet:namespace />userAlertNotificationsHandle'] = null;

									alertHandle.detach();

									currentAlertTarget.removeClass('open');
								}
							);
						}
						else if (alertHandle) {
							alertHandle.detach();

							alertHandle = null;
						}

						Liferay.Data['<portlet:namespace />userAlertNotificationsHandle'] = alertHandle;

						if (menuOpen) {
							<portlet:renderURL var="unreadURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
								<portlet:param name="mvcPath" value="/html/alert-notification/allalerts.jsp" />
								
							</portlet:renderURL>

							 userAlertNotificationsList.io.set('uri', '<%= unreadURL %>');

							userAlertNotificationsList.io.start();

							<!-- A.io.request('<liferay-portlet:actionURL name="setDelivered" />'); -->

							userAlertNotificationsCount.removeClass('alert'); 
						}

					}
				}
			);
			
			
	</aui:script>
</li>
</ul>
