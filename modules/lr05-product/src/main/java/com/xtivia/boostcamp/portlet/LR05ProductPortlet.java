package com.xtivia.boostcamp.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.xtivia.boostcamp.common.ModuleConstants;
import com.xtivia.boostcamp.model.Product;
import com.xtivia.boostcamp.portlet.configuration.ProductConfiguration;
import com.xtivia.boostcamp.service.ProductLocalServiceUtil;
import aQute.bnd.annotation.metatype.Configurable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

@Component(
	configurationPid = "com.xtivia.boostcamp.portlet.configuration.ProductConfiguration",
	immediate = true,
	property = {
		"com.liferay.portlet.configuration-action-class=com.xtivia.boostcamp.portlet.configuration.ProductConfigurationAction",
		"com.liferay.portlet.display-category=PhuongNguyen.LR05",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=lr05-product Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.path-jsp=/jsp/products",
		"javax.portlet.init-param.view-template=/jsp/products/view.jsp",
		"javax.portlet.init-param.edit-template=/jsp/products/preferences.jsp",
		"javax.portlet.init-param.config-template=/configuration.jsp",
		"javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.portlet-mode=text/html;view,edit",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.requires-namespaced-parameters=false"
	},
	service = Portlet.class
)
public class LR05ProductPortlet extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(LR05ProductPortlet.class);
	private volatile ProductConfiguration _configuration;
	
	public LR05ProductPortlet() {
		
	}
	
	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet#doConfig(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	public void doConfig(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		super.doConfig(renderRequest, renderResponse);
	}
	
	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet#render(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// if has portlet session, then render product detail page
		PortletSession ps = renderRequest.getPortletSession();
		String searchByProdId = (String) ps.getAttribute("searchByProdId", PortletSession.APPLICATION_SCOPE);

		List<Product> list = new ArrayList<Product>();
		if (Validator.isBlank(searchByProdId)) {
			list = ProductLocalServiceUtil.findAll();//productService.getList();
		} else {
			// remove session attribute
			ps.setAttribute("searchByProdId", null, PortletSession.APPLICATION_SCOPE);

			list = ProductLocalServiceUtil.findAllByKey(searchByProdId); //productService.getListByKey(searchByProdId);
		}

		// get message welcome from Prefs, if don't have use default message
		PortletPreferences prefs = renderRequest.getPreferences();
		String msgWelcome = prefs.getValue("msgWelcome", ModuleConstants.MSG_WELCOME);

		renderRequest.setAttribute("msgWelcome", msgWelcome);
		renderRequest.setAttribute(ProductConfiguration.class.getName(), _configuration);
		renderRequest.setAttribute("products", list);
		super.render(renderRequest, renderResponse);
	}
	
	@ProcessAction(name="editPrefsProcessAction")
	public void savePreferences(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortletException, IOException {
		String msgWelcome = ParamUtil.getString(actionRequest, "prefsWelcome");
		
		PortletPreferences prefs = actionRequest.getPreferences();
		if (Validator.isBlank(msgWelcome)){
			msgWelcome = ModuleConstants.MSG_WELCOME;
		} 
		prefs.setValue("msgWelcome", msgWelcome);
		prefs.store();
	}
	
	@ProcessAction(name="addProductPA")
	public void addProduct(ActionRequest actionRequest, ActionResponse actionResponse) {
		Product product = ProductLocalServiceUtil.createProduct(ParamUtil.getLong(actionRequest, "prodId"));
		product.setName(ParamUtil.getString(actionRequest, "prodName"));
		product.setQuantity(ParamUtil.getInteger(actionRequest, "prodQuantity"));
		product.setUnitPrice(ParamUtil.getString(actionRequest, "prodUnitPrice"));
		product.setDescription(ParamUtil.getString(actionRequest, "prodDesc"));
		
		//if (productService.validate(product)) {
		ProductLocalServiceUtil.addProduct(product);
		//}
	}
	
	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
	 */
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		if (Validator.isNumber(ParamUtil.getString(resourceRequest, "prodId"))) {
			try {
				long key = ParamUtil.getLong(resourceRequest, "prodId");
				ProductLocalServiceUtil.deleteProduct(key);
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
//		super.serveResource(resourceRequest, resourceResponse);
	}

	@ProcessAction(name="updateProductPA")
	public void updateProduct(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		
		Product product = ProductLocalServiceUtil.getProduct(ParamUtil.getLong(actionRequest, "prodId"));
		product.setName(ParamUtil.getString(actionRequest, "prodName"));
		product.setQuantity(ParamUtil.getInteger(actionRequest, "prodQuantity"));
		product.setUnitPrice(ParamUtil.getString(actionRequest, "prodUnitPrice"));
		product.setDescription(ParamUtil.getString(actionRequest, "prodDesc"));
		
		//if (productService.validate(product)) {
			ProductLocalServiceUtil.updateProduct(product);
			
			// back to /jsp/products/product/view.jsp page
			actionRequest.setAttribute("product", product);
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			actionResponse.setRenderParameter("jspPage", ModuleConstants.URL_PRODUCT_VIEW);
		//}
	}

	@ProcessAction(name="deleteProductPA")
	public void deleteProduct(ActionRequest actionRequest, ActionResponse actionResponse) {
		if (Validator.isNumber(ParamUtil.getString(actionRequest, "prodId"))) {
			try {
				long key = ParamUtil.getLong(actionRequest, "prodId");
				ProductLocalServiceUtil.deleteProduct(key);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			actionRequest.setAttribute("products", ProductLocalServiceUtil.findAll());
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		}
	}
	
	@ProcessAction(name="goToEditProductPagePA")
	public void goToEditProductPage(ActionRequest actionRequest, ActionResponse actionResponse) {
		if (Validator.isNumber(ParamUtil.getString(actionRequest, "prodId"))) {
			try {
				long key = ParamUtil.getLong(actionRequest, "prodId");
				actionRequest.setAttribute("product", ProductLocalServiceUtil.getProduct(key));
				
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);
				actionResponse.setRenderParameter("jspPage", ModuleConstants.URL_PRODUCT_EDIT);
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
	}
	
	@ProcessAction(name="goToViewProductPagePA")
	public void goToViewProductPage(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		if (Validator.isNumber(ParamUtil.getString(actionRequest, "prodId"))) {
			try {
				long key = ParamUtil.getLong(actionRequest, "prodId");
				actionRequest.setAttribute("product", ProductLocalServiceUtil.getProduct(key));
				
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);
				actionResponse.setRenderParameter("jspPage", ModuleConstants.URL_PRODUCT_VIEW);
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
	}
	
	@ProcessAction(name="goToViewProductListPagePA")
	public void goToViewProductListPage(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionResponse.setRenderParameter("jspPage", ModuleConstants.URL_PRODUCTS_VIEW);
	}
//	
//	@ProcessAction(name="invokeTaglibDiscussion")
//	public void discussion(ActionRequest actionRequest, ActionResponse actionResponse) {
//		goToViewProductPage(actionRequest, actionResponse);
//	}
	
	/**
	 * This method is invoked when the application starts (due to the @Activate
	 * annotation) and whenever the configuration is modified (due to
	 * the @Modified annotation)
	 */
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = Configurable.createConfigurable(ProductConfiguration.class, properties);
	}
}