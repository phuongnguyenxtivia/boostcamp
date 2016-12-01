<%@ include file="/init.jsp"%>
<%@ page import="com.xtivia.boostcamp.model.Product"%>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="com.liferay.asset.kernel.model.AssetEntry"%>
<%@ page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil"%>


<%	
	String currentUrl = PortalUtil.getCurrentURL(request);
	Product product = (Product) renderRequest.getAttribute("product");
%>

<div class="container">
	<p>
	<h2>
		<liferay-ui:message key="portlet.products.product.view.caption" />
	</h2>
	</p>
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
		<portlet:actionURL var="goToViewProductListPageAU"
			name="goToViewProductListPagePA" />
		<a href="${goToViewProductListPageAU}"><liferay-ui:message
				key="url.back" /></a>

		<portlet:actionURL var="goToEditProductPageAU"
			name="goToEditProductPagePA">
			<portlet:param name="prodId" value="${product.id}" />
		</portlet:actionURL>
		<a href="${goToEditProductPageAU}"><liferay-ui:message
				key="url.edit" /></a>
	</div>
	<div>
		<liferay-ui:ratings className="<%=Product.class.getName()%>"
			classPK="<%=product.getId()%>" type="stars" />
	</div>
	<div>
		<c:if test="<%= themeDisplay.isSignedIn() %>">
			<liferay-ui:panel-container extended="<%=false%>"
				id="productCommentsPanelContainer" persistState="<%=true%>">
	
				<liferay-ui:panel collapsible="<%=true%>" extended="<%=true%>"
					id="productCommentsPanel" persistState="<%=true%>"
					title="<%=LanguageUtil.get(request, "Collaboration")%>">
	
					<portlet:actionURL name="invokeTaglibDiscussion" var="discussionURL" />
	
					<liferay-ui:discussion className="<%=Product.class.getName()%>"
						classPK="<%= product.getId()%>" formAction="<%=discussionURL%>"
						formName="fm2" ratingsEnabled="<%=true%>"
						redirect="<%=currentUrl%>" userId="<%= themeDisplay.getUserId() %>" />
	
				</liferay-ui:panel>
			</liferay-ui:panel-container>
		</c:if>
	</div>
</div>
