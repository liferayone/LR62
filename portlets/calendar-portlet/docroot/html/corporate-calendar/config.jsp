<%@include file="init.jsp" %>
<script>
var portletNameSpace = "<portlet:namespace/>";

AUI().ready('event', 'node', function(A){
	
	AUI().use('aui-base','aui-io-request', function(A){
	 var siteId = document.getElementById(portletNameSpace+"siteDropDown").value;
	 A.io.request('<%=resourceURL%>',
				{
		                        dataType: 'json',
		                        method: 'GET',
		                        data: { site: siteId },
		                           on: {
		                                    success: function() {
		                                    	var data=this.get('responseData');
		                                    	var siteTitles = data.split("#");
												var size = siteTitles.length;
									
											for(var i=0;i<size;i++){
												var siteDetails = siteTitles[i].split(":");
												var lable = siteDetails[0];
												var val = siteDetails[1];
												var html = '<option value='+val+'>'+lable+'</option>';
											A.one('#<portlet:namespace/>sitePageId').append(html);
												}
											
												
		                                    }
		                        }
		            });
	
		});
	
	});
	



AUI().use('aui-base','aui-io-request', function(A){
	 A.one("#<portlet:namespace/>siteDropDown").on('change',function(){
		 
		 var siteId = document.getElementById(portletNameSpace+"siteDropDown").value;
		 
		 var mySelect = A.one('#<portlet:namespace />sitePageId');
		  mySelect.empty();
		 
		 A.io.request('<%=resourceURL%>',
					{
			                        dataType: 'json',
			                        method: 'GET',
			                        data: { site: siteId },
			                           on: {
			                                    success: function() {
			                                    	var data=this.get('responseData');
			                                    	var siteTitles = data.split("#");
													var size = siteTitles.length;
										
												for(var i=0;i<size;i++){
													var siteDetails = siteTitles[i].split(":");
													var lable = siteDetails[0];
													var val = siteDetails[1];
													var html = '<option value='+val+'>'+lable+'</option>';
													A.one('#<portlet:namespace/>sitePageId').append(html);
													}
												
													
			                                    }
			                        }
			            });
		})

	});

</script>




<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<%
		try {
			List<Group> groups = GroupLocalServiceUtil.getGroups(-1, -1);
			%>
				<aui:select  id="siteDropDown"  label="select-site-id" name="preferences--siteid--">
				<aui:option value="" />
			 <%
			 	for(int i=0;i<groups.size();i++){
					 Group  group = groups.get(i);
					%>
					<aui:option label="<%=group.getName()%>" selected="<%= configuredSiteId == group.getGroupId()  %>" value="<%=group.getGroupId()%>" /> 
						<%	 
					   }
				 %>
			 	</aui:select>
				 <%
			 }
			 catch (Exception e) {
				e.printStackTrace();
				}
			%>
			
			<input type="text" id="selectedSitePage" value="<%=configuredPage%>" disabled="disabled"/>
			<aui:select  id="sitePageId"  label="select-pages" name="preferences--sitepage--">
			</aui:select>
			<aui:button-row>
				<aui:button type="submit" />
			</aui:button-row>
			
	</aui:form>