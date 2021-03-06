package com.xtivia.boostcamp.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author pnguyen
 *
 */

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=PhuongNguyen.LR01",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=lr01-product-search Module Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.add-process-action-success-action=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.requires-namespaced-parameters=false"
	},
	service = Portlet.class
)
public class ProductSearchModulePortlet extends MVCPortlet {

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		super.doView(renderRequest, renderResponse);
		//PortletUtils.include(getPortletContext(), ModuleConstants.URL_PRODUCT_SEARCH_BY_ID, renderRequest, renderResponse);
	}
	
	@ProcessAction(name="searchProdProcessAction")
	public void searchByProdId(ActionRequest actionRequest, ActionResponse actionResponse) {
		String prodId = ParamUtil.getString(actionRequest, "prodId");
		
		// TODO: validate product Id
		if (!Validator.isBlank(prodId)) {
			PortletSession ps = actionRequest.getPortletSession();
			ps.setAttribute("searchByProdId", prodId ,PortletSession.APPLICATION_SCOPE);
		}
	}
}