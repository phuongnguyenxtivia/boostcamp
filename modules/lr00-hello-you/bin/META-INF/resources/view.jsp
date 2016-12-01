<%@ include file="/init.jsp" %>

<jsp:useBean id="userName" class="java.lang.String" scope="request" />

<p>
	<b><liferay-ui:message key="view.caption"/></b>
	<p>Hello <%= userName %>!</p>
</p>