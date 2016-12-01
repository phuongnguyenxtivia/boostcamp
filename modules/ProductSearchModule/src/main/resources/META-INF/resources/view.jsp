<%@ include file="/init.jsp" %>

<div class="container">
	<p><h2><liferay-ui:message key="portlet.products.product.search.caption"/></h2></p>
	<div>
		<portlet:actionURL var="searchProdActionURL" name="searchProdProcessAction"/>
		
		<form class="form-inline" id="<portlet:namespace />frm_searchProd" action="${searchProdActionURL}" method="post">
			<div class="form-group">
				<label for="prod_id"><liferay-ui:message key="prod.id"/></label> 
				<input type="text" class="form-control" id="prod_id"
					placeholder="<liferay-ui:message key="prod.id"/>" name="<portlet:namespace />prodId" />
				<button type="submit" class="btn btn-primary"><liferay-ui:message key="frm.btnSearch"/></button>
			</div>		
		</form>
	</div>
</div>