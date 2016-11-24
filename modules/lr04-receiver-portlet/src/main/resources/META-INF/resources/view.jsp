<%@ include file="/init.jsp" %>

<script>

	Liferay.on('getUser', function(event) {
		jQuery('#userInformation').empty();
		jQuery('#errorInformation').empty();
		if (event.userData.error != null) {
			jQuery('#errorInformation').html(event.userData.error);
		} else {
			var htmlString = "Hello, " + event.userData.userName + "!";
			jQuery('#userInformation').html(htmlString);
		}
	});
</script>

<div id="userInformation"></div>
<div id="errorInformation" style="color:red;font-weight:bold;"></div>