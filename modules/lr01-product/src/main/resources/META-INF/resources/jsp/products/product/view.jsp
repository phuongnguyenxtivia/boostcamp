<%@ include file="/init.jsp"%>

<div class="container">
	<p><h2><liferay-ui:message key="portlet.products.product.view.caption"/></h2></p>
	<div class="table-responsive">
		<table class="table">
			<tbody>
				<fmt:setLocale value="en_US" />
				<tr>
					<td><liferay-ui:message key="prod.id" /></td>
					<td>${product.id}</td>
				</tr>
				<tr>
					<td><liferay-ui:message key="prod.name" /></td>
					<td>${product.name}</td>
				</tr>
				<tr>
					<td><liferay-ui:message key="prod.quantity" /></td>
					<td>${product.quantity}</td>
				</tr>
				<tr>	
					<td><liferay-ui:message key="prod.unitPrice" /></td>
					<td><fmt:formatNumber value="${product.unitPrice}"
							type="currency" /></td>
				</tr>
				<tr>
					<td><liferay-ui:message key="prod.desc" /></td>
					<td>${product.description}</td>
				</tr>

			</tbody>
		</table>
	</div>
	<div>
		<portlet:actionURL var="goToViewProductListPageAU" name="goToViewProductListPagePA" />
		<a href="${goToViewProductListPageAU}"><liferay-ui:message key="url.back" /></a>
		
		<portlet:actionURL var="goToEditProductPageAU" name="goToEditProductPagePA" >
			<portlet:param name="prodId" value="${product.id}" />
		</portlet:actionURL>
		<a href="${goToEditProductPageAU}"><liferay-ui:message key="url.edit" /></a>
	</div>
</div>
