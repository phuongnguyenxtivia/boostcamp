<%@ include file="/init.jsp"%>

<jsp:useBean class="java.lang.String" id="addNameURL" scope="request" />

<form id="<portlet:namespace />helloForm" action="<%=addNameURL%>"
	method="post">

	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="<portlet:namespace />userName"></td>
		</tr>
	</table>
	<input type="submit" id="nameButton" title="Add Name" value="Add Name">
</form>