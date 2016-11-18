<%@ include file="/init.jsp"%>

<div class="container">
	<p><h2><liferay-ui:message key="portlet.products.product.add.name"/></h2></p>
	<div>
		<portlet:actionURL var="urlAddProd" name="processActionAddProduct"/>
		
		<form id="<portlet:namespace />frm_AddProd" action="${urlAddProd}" method="post">
			<div class="form-group">
				<label for="prod_id"><liferay-ui:message key="prod.id"/></label> 
				<input type="text" class="form-control" id="prod_id"
					placeholder="<liferay-ui:message key="prod.id"/>" name="<portlet:namespace />prodId" />
			</div>
			<div class="form-group">
				<label for="prod_name"><liferay-ui:message key="prod.name"/></label> 
				<input type="text" class="form-control" id="prod_name"
					placeholder="<liferay-ui:message key="prod.name"/>" name="<portlet:namespace />prodName" />
			</div>			
			<div class="form-group">
				<label for="prod_quantity"><liferay-ui:message key="prod.quantity"/></label> 
				<input type="text" class="form-control" id="prod_quantity"
					placeholder="<liferay-ui:message key="prod.quantity"/>" name="<portlet:namespace />prodQuantity" />
			</div>
			<div class="form-group">
				<label for="prod_unitPrice"><liferay-ui:message key="prod.unitPrice"/></label> 
				<input type="text" class="form-control" id="prod_unitPrice"
					placeholder="<liferay-ui:message key="prod.unitPrice"/>" name="<portlet:namespace />prodUnitPrice" />
			</div>
			<div class="form-group">
				<!-- 
				<label for="prod_desc"><liferay-ui:message key="prod.desc"/></label> 
				<input type="text" class="form-control" id="prod_desc"
					placeholder="<liferay-ui:message key="prod.desc"/>" name="<portlet:namespace />prodDesc" />
				-->
				<label for="prod_desc"><liferay-ui:message key="prod.desc"/></label> 
				<liferay-ui:input-editor name="prodDesc" />
				<input id="prod_desc" name="<portlet:namespace />prodDesc" type="hidden" />
			</div>				
			<button type="submit" class="btn btn-primary"><liferay-ui:message key="frm.btnAdd"/></button>
		</form>
	</div>
	<div>
		<portlet:actionURL var="urlViewProductList" name="processActionViewProductList">
			<portlet:param name="jspPage" value="<%= ModuleConstants.URL_PRODUCTS_VIEW %>" />
		</portlet:actionURL>
		<a href="${urlViewProductList}"><liferay-ui:message key="url.cancel" /></a>
	</div>
</div>
