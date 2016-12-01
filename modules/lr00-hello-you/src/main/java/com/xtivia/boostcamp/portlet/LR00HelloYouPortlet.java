package com.xtivia.boostcamp.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=PhuongNguyen.LR00",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=lr00-hello-you Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.portlet-mode=text/html;view,edit",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.init-param.edit-template=/edit.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class LR00HelloYouPortlet extends MVCPortlet {
	protected String editJSP;
	protected String viewJSP;
	private static Log _log = LogFactoryUtil.getLog(LR00HelloYouPortlet.class);
	
	@Override
	public void init() throws PortletException {
		super.init();
		editJSP = getInitParameter("edit-template");
		viewJSP = getInitParameter("view-template");
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		PortletPreferences prefs = renderRequest.getPreferences();
		String username = (String) prefs.getValue("userName", "no");
		if (username.equalsIgnoreCase("no")) {
			username = "";
		}
		renderRequest.setAttribute("userName", username);
		include(viewJSP, renderRequest, renderResponse);
	}
	
	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		renderResponse.setContentType("text/html");
		PortletURL addNameURL = renderResponse.createActionURL();
		addNameURL.setParameter("addName", "addName");
		renderRequest.setAttribute("addNameURL", addNameURL.toString());
		include(editJSP, renderRequest, renderResponse);
	}
	
	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String addName = actionRequest.getParameter("addName");
		if (addName != null) {
			PortletPreferences prefs = actionRequest.getPreferences();
			prefs.setValue("userName", actionRequest.getParameter("userName"));
			prefs.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		}
	}

	protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);
		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}
}