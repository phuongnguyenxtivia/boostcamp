<%@ include file="/init.jsp"%>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<%
	ProductConfiguration configuration = (ProductConfiguration) renderRequest
			.getAttribute(ProductConfiguration.class.getName());

	String productId = StringPool.BLANK;
	String productName = StringPool.BLANK;
	String productQuantity = StringPool.BLANK;
	String productUnitPrice = StringPool.BLANK;
	String productDescription = StringPool.BLANK;

	if (Validator.isNotNull(configuration)) {
		productId = portletPreferences.getValue("productId", String.valueOf(configuration.productId()));
		productName = portletPreferences.getValue("productName", String.valueOf(configuration.productName()));
		productQuantity = portletPreferences.getValue("productQuantity",
				String.valueOf(configuration.productQuantity()));
		productUnitPrice = portletPreferences.getValue("productUnitPrice",
				String.valueOf(configuration.productUnitPrice()));
		productDescription = portletPreferences.getValue("productDescription",
				String.valueOf(configuration.productDescription()));
	}

	String showProductId = ("true".equalsIgnoreCase(productId)) ? "checked" : "";
	String showProductName = ("true".equalsIgnoreCase(productName)) ? "checked" : "";
	String showProductQuantity = ("true".equalsIgnoreCase(productQuantity)) ? "checked" : "";
	String showProductUnitPrice = ("true".equalsIgnoreCase(productUnitPrice)) ? "checked" : "";
	String showProductDescription = ("true".equalsIgnoreCase(productDescription)) ? "checked" : "";
%>

<div class="container">
	<div>
		<liferay-portlet:actionURL portletConfiguration="<%=true%>"
			var="configurationActionURL" />

		<liferay-portlet:renderURL portletConfiguration="<%=true%>"
			var="configurationRenderURL" />

		<form id="<portlet:namespace />frm_configProductsView" action="${configurationActionURL}"
			method="post">
			<input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
			<input name="redirect" type="hidden" value="${configurationRenderURL}" />

			<div class="checkbox">
				<input type="checkbox" class="form-control" id="prod_id"
					name="<portlet:namespace />prodId"
					<%= showProductId %> /> 
				<label for="prod_id">
					<liferay-ui:message	key="prod.id" />
				</label>
			</div>
			<div class="checkbox">
				<input type="checkbox" class="form-control" id="prod_name"
					name="<portlet:namespace />prodName"
					<%= showProductName %> /> 
				<label for="prod_name">
					<liferay-ui:message	key="prod.name" />
				</label>
			</div>
			<div class="checkbox">
				<input type="checkbox" class="form-control" id="prod_quantity"
					name="<portlet:namespace />prodQuantity"
					<%= showProductQuantity %> /> 
				<label for="prod_quantity">
					<liferay-ui:message	key="prod.quantity" />
				</label>
			</div>
			<div class="checkbox">
				<input type="checkbox" class="form-control" id="prod_unitPrice"
					name="<portlet:namespace />prodUnitPrice"
					<%= showProductUnitPrice %> /> 
				<label for="prod_unitPrice">
					<liferay-ui:message	key="prod.unitPrice" />
				</label>
			</div>
			<div class="checkbox">
				<input type="checkbox" class="form-control" id="prod_desc"
					name="<portlet:namespace />prodDescription"
					<%= showProductDescription %> /> 
				<label for="prod_desc">
					<liferay-ui:message	key="prod.desc" />
				</label>
			</div>
			<button type="submit" class="btn btn-primary">
				<liferay-ui:message key="frm.btnSave" />
			</button>
		</form>
	</div>
</div>
