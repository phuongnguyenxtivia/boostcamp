<%@ include file="/init.jsp"%>

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

	boolean showProductId = ("true".equalsIgnoreCase(productId)) ? true : false;
	boolean showProductName = ("true".equalsIgnoreCase(productName)) ? true : false;
	boolean showProductQuantity = ("true".equalsIgnoreCase(productQuantity)) ? true : false;
	boolean showProductUnitPrice = ("true".equalsIgnoreCase(productUnitPrice)) ? true : false;
	boolean showProductDescription = ("true".equalsIgnoreCase(productDescription)) ? true : false;
%>

<div class="container">
	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
				<tr>
					<c:if test="<%= showProductId %>">
						<th><liferay-ui:message key="prod.id" /></th>
					</c:if>
					<c:if test="<%= showProductName %>">
						<th><liferay-ui:message key="prod.name" /></th>
					</c:if>
					<c:if test="<%= showProductQuantity %>">
						<th><liferay-ui:message key="prod.quantity" /></th>
					</c:if>
					<c:if test="<%= showProductUnitPrice %>">
						<th><liferay-ui:message key="prod.unitPrice" /></th>
					</c:if>
					<c:if test="<%= showProductDescription %>">
						<th><liferay-ui:message key="prod.desc" /></th>
					</c:if>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<fmt:setLocale value="en_US"/>

				<c:forEach items="${products}" var="product">
					<tr>
						<c:if test="<%= showProductId %>">
							<td>
								<portlet:actionURL var="urlViewProductDetail">
									<portlet:param name="javax.portlet.action"
										value="processActionViewProductDetail" />
									<portlet:param name="jspPage" value="<%= ModuleConstants.URL_PRODUCT_VIEW %>" />
									<portlet:param name="prodId" value="${product.id}" />
								</portlet:actionURL>
								<a href="${urlViewProductDetail}">${product.id}</a>
							</td>
						</c:if>
						<c:if test="<%= showProductName %>">
							<td>${product.name}</td>
						</c:if>
						<c:if test="<%= showProductQuantity %>">
							<td>${product.quantity}</td>
						</c:if>
						<c:if test="<%= showProductUnitPrice %>">
							<td>
								<fmt:formatNumber value="${product.unitPrice}" type="currency" />
							</td>
						</c:if>
						<c:if test="<%= showProductDescription %>">
							<td>${product.description}</td>
						</c:if>
						<td>
							<portlet:actionURL var="urlDeleteProduct">
								<portlet:param name="javax.portlet.action"
									value="processActionDeleteProduct" />
								<portlet:param name="prodId" value="${product.id}" />
							</portlet:actionURL>
							<a href="${urlDeleteProduct}"><liferay-ui:message key="url.delete"/></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<portlet:renderURL var="renderAddProdUrl"
			windowState="${renderRequest.windowState}"
			copyCurrentRenderParameters="false"
			portletMode="${renderRequest.portletMode}">
			<portlet:param name="jspPage" value="<%= ModuleConstants.URL_PRODUCT_ADD %>" />
		</portlet:renderURL>
		<a href="${renderAddProdUrl}"><liferay-ui:message key="url.add"/></a>
	</div>
</div>
