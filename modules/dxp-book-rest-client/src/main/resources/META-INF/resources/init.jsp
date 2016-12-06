<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.util.*, com.liferay.portal.kernel.model.*"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.xtivia.book.portlet.configuration.PortletInstanceClientConfiguration" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
    PortletInstanceClientConfiguration configuration =
            portletDisplay.getPortletInstanceConfiguration(PortletInstanceClientConfiguration.class);
    String defaultRoute = configuration != null?configuration.defaultRoute():"/recent";
%>