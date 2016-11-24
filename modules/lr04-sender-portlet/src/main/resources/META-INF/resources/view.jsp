<%@ include file="/init.jsp" %>

<portlet:resourceURL var="getUser"></portlet:resourceURL>

<script>
$(document).on('ready',function(){
	$('#<portlet:namespace/>getUser').click(function(event) {
		
		var userName = jQuery('#<portlet:namespace/>user').val();
		alert(userName);
		Liferay.fire('getUser', { userData: { "userName": userName} } );
		alert('sent');
	});
});
</script>

<aui:form method="POST">
<aui:input type="text" name="user" id="user" label="Say to User" />
<aui:button type="button" name="getUser" value="Send" id="getUser" />
</aui:form>
