<%@ include file="/init.jsp"%>

<div class="container">
	<p><h2><liferay-ui:message key="portlet.products.preferences.caption"/></h2></p>
	<div>
		<portlet:actionURL var="editPrefsActionURL" name="editPrefsProcessAction"/>
		
		<form id="<portlet:namespace />frm_editPrefs" action="${editPrefsActionURL}" method="post">
			<div class="form-group">
				<label for="prefs_welcome"><liferay-ui:message key="products.prefs.welcome"/></label> 
				<input type="text" class="form-control" id="prefs_welcome"
					placeholder="<liferay-ui:message key="products.prefs.welcome"/>" name="<portlet:namespace />prefsWelcome" />
			</div>			
			<button type="submit" class="btn btn-primary"><liferay-ui:message key="frm.btnSave"/></button>
		</form>
	</div>
</div>
