<%@ include file="/init.jsp"%>

<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ page import="com.xtivia.boostcamp.domain.Product" %>

<% 
	Product prod = (Product) request.getAttribute("product");
%>

<div class="container">
	<p><h2><liferay-ui:message key="portlet.products.product.edit.caption"/></h2></p>

	<div>
		<portlet:actionURL var="updateProductAU" name="updateProductPA"/>
		
		<form id="<portlet:namespace />frm_UpdateProduct" action="${updateProductAU}" method="post">
			<div class="form-group">
				<label for="prod_id"><liferay-ui:message key="prod.id" /></label> <label
					for="prod_id">${product.id}</label> 
				<input type="hidden"
					class="form-control" id="prod_id"
					name="<portlet:namespace />prodId" value="${product.id}" />
			</div>
			<div class="form-group">
				<label for="prod_name"><liferay-ui:message key="prod.name"/></label> 
				<input type="text" class="form-control" id="prod_name"
					placeholder="<liferay-ui:message key="prod.name"/>" name="<portlet:namespace />prodName" value="${product.name}" />
			</div>			
			<div class="form-group">
				<label for="prod_quantity"><liferay-ui:message key="prod.quantity"/></label> 
				<input type="text" class="form-control" id="prod_quantity"
					placeholder="<liferay-ui:message key="prod.quantity"/>" name="<portlet:namespace />prodQuantity" value="${product.quantity}" />
			</div>
			<div class="form-group">
				<label for="prod_unitPrice"><liferay-ui:message key="prod.unitPrice"/></label> 
				<input type="text" class="form-control" id="prod_unitPrice"
					placeholder="<liferay-ui:message key="prod.unitPrice"/>" name="<portlet:namespace />prodUnitPrice" value="${product.unitPrice}" />
			</div>
			<div class="form-group">
				<!-- 
				<label for="prod_desc"><liferay-ui:message key="prod.desc"/></label> 
				<input type="text" class="form-control" id="prod_desc"
					placeholder="<liferay-ui:message key="prod.desc"/>" name="<portlet:namespace />prodDesc"/>
				-->
				<label for="prod_desc"><liferay-ui:message key="prod.desc"/></label>
				<aui:field-wrapper label="description">
					<liferay-ui:input-editor name="prodDesc" initMethod="initEditor" />
					<script type="text/javascript">
						function <portlet:namespace />initEditor() {
							return "<%= UnicodeFormatter.toString(prod.getDescription()) %>";
						}
					</script>
				</aui:field-wrapper>
				<input id="prod_desc" name="<portlet:namespace />prodDesc" type="hidden" />
			</div>				
			<button type="submit" class="btn btn-primary"><liferay-ui:message key="frm.btnSubmit"/></button>
		</form>
	</div>
	
	<div>
		<portlet:actionURL var="goToViewProductPageAU" name="goToViewProductPagePA">
			<portlet:param name="prodId" value="${product.id}" />
		</portlet:actionURL>
		<a href="${goToViewProductPageAU}"><liferay-ui:message key="url.cancel" /></a>
	</div>
</div>
