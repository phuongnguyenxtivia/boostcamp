package com.xtivia.boostcamp.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.xtivia.boostcamp.common.ModuleConstants;
import com.xtivia.boostcamp.dao.impl.InMemoryProductDAOImpl;
import com.xtivia.boostcamp.domain.Product;
import com.xtivia.boostcamp.portlet.configuration.ProductConfiguration;
import com.xtivia.boostcamp.portlet.utils.PortletUtils;
import com.xtivia.boostcamp.service.IProductService;
import com.xtivia.boostcamp.service.impl.ProductServiceImpl;

import aQute.bnd.annotation.metatype.Configurable;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author pnguyen
 *
 */
/*
 * Configuration: 
 * 		com.liferay.portlet.configuration-action-class
 * 		javax.portlet.init-param.config-template
 * 		javax.portlet.init-param.add-process-action-success-action
 * 
 * Turn on/off message:
 * 		javax.portlet.init-param.add-process-action-success-action
 * 
 * Turn on/off preference/mode
 * 		javax.portlet.portlet-mode
 * 
 * PortletSession:
 * 		com.liferay.portlet.private-session-attributes
 * 		com.liferay.portlet.requires-namespaced-parameters
 * 
 */
@Component(
	configurationPid = "com.xtivia.boostcamp.portlet.configuration.ProductConfiguration",
	immediate = true,
	property = {
		"com.liferay.portlet.configuration-action-class=com.xtivia.boostcamp.portlet.configuration.ProductConfigurationAction",
		"com.liferay.portlet.display-category=PhuongNguyen",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Product Portlet",
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
public class ProductPortlet extends MVCPortlet {
	private static Log _log = LogFactoryUtil.getLog(ProductPortlet.class);
	protected IProductService productService;
	// protected String productsViewJSP;
	// protected String productsEditJSP;
	private volatile ProductConfiguration _configuration;
	public static final String MSG_WELCOME = "Personalizable welcome message; please click on Edit Preferences to edit this message";

	public ProductPortlet() {
		productService = new ProductServiceImpl(new InMemoryProductDAOImpl());
	}
	
	public ProductPortlet(IProductService productService) {
		this.productService = productService;
	}
	
	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet#doConfig(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	public void doConfig(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
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
			list = productService.getList();
		} else {
			// remove session attribute
			ps.setAttribute("searchByProdId", null, PortletSession.APPLICATION_SCOPE);

			list = productService.getListByKey(searchByProdId);
		}

		// get message welcome from Prefs, if don't have use default message
		PortletPreferences prefs = renderRequest.getPreferences();
		String msgWelcome = prefs.getValue("msgWelcome", MSG_WELCOME);

		renderRequest.setAttribute("msgWelcome", msgWelcome);
		renderRequest.setAttribute(ProductConfiguration.class.getName(), _configuration);
		renderRequest.setAttribute("products", list);
		super.render(renderRequest, renderResponse);
	}

	@Override
	public void init() throws PortletException {
		super.init();
		//productsEditJSP = getInitParameter("edit-template");
		//productsViewJSP = getInitParameter("view-template");
	}
	
	@ProcessAction(name="editPrefsProcessAction")
	public void savePreferences(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortletException, IOException {
		String msgWelcome = ParamUtil.getString(actionRequest, "prefsWelcome");
		
		PortletPreferences prefs = actionRequest.getPreferences();
		if (Validator.isBlank(msgWelcome)){
			msgWelcome = MSG_WELCOME;
		} 
		prefs.setValue("msgWelcome", msgWelcome);
		prefs.store();
	}
	
//	@Override
//	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
//			throws IOException, PortletException {
//		// TODO: share PortletSession between difference modules,
//		// https://web.liferay.com/community/forums/-/message_boards/message/79675450
//		// Liferay 7 got the issue with shared PortletSession
//		
//		// if has portlet session, then render product detail page
//		PortletSession ps = renderRequest.getPortletSession();
//	    String searchByProdId = (String) ps.getAttribute("searchByProdId", PortletSession.APPLICATION_SCOPE);
//	    
//	    List<Product> list = new ArrayList<Product>();
//		if (Validator.isBlank(searchByProdId)) {
//			list = productService.getList();
//		} else {
//			// remove session attribute 
//			ps.setAttribute("searchByProdId", null, PortletSession.APPLICATION_SCOPE);
//
//			list = productService.getListByKey(searchByProdId);
//		}
//		
//		// get message welcome from Prefs, if don't have use default message
//		PortletPreferences prefs = renderRequest.getPreferences();
//		String msgWelcome = prefs.getValue("msgWelcome", MSG_WELCOME);
//
//		renderRequest.setAttribute("msgWelcome", msgWelcome);
//		renderRequest.setAttribute(ProductConfiguration.class.getName(), _configuration);
//		renderRequest.setAttribute("products", list);
//		PortletUtils.include(getPortletContext(), ModuleConstants.URL_PRODUCTS_VIEW, renderRequest, renderResponse);
//	}
	
	@ProcessAction(name="addProductPA")
	public void addProduct(ActionRequest actionRequest, ActionResponse actionResponse) {
		Product product = new Product();
		product.setId(ParamUtil.getString(actionRequest, "prodId"));
		product.setName(ParamUtil.getString(actionRequest, "prodName"));
		product.setQuantity(ParamUtil.getInteger(actionRequest, "prodQuantity"));
		product.setUnitPrice(new BigDecimal(ParamUtil.getString(actionRequest, "prodUnitPrice")));
		product.setDescription(ParamUtil.getString(actionRequest, "prodDesc"));
		
		if (productService.validate(product)) {
			productService.add(product);
		}
	}
	
	@ProcessAction(name="updateProductPA")
	public void updateProduct(ActionRequest actionRequest, ActionResponse actionResponse) {
		Product product = new Product();
		product.setId(ParamUtil.getString(actionRequest, "prodId"));
		product.setName(ParamUtil.getString(actionRequest, "prodName"));
		product.setQuantity(ParamUtil.getInteger(actionRequest, "prodQuantity"));
		product.setUnitPrice(new BigDecimal(ParamUtil.getString(actionRequest, "prodUnitPrice")));
		product.setDescription(ParamUtil.getString(actionRequest, "prodDesc"));
		
		if (productService.validate(product)) {
			productService.update(product);
			
			// back to /jsp/products/product/view.jsp page
			actionRequest.setAttribute("product", product);
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			actionResponse.setRenderParameter("jspPage", ModuleConstants.URL_PRODUCT_VIEW);
		}
	}

	@ProcessAction(name="deleteProductPA")
	public void deleteProduct(ActionRequest actionRequest, ActionResponse actionResponse) {
		String key = ParamUtil.getString(actionRequest, "prodId");
		if (!Validator.isBlank(key)) {
			productService.delete(key);
			actionRequest.setAttribute("products", productService.getList());
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		}
	}
	
	@ProcessAction(name="goToEditProductPagePA")
	public void goToEditProductPage(ActionRequest actionRequest, ActionResponse actionResponse) {
		String key = ParamUtil.getString(actionRequest, "prodId");
		if (!Validator.isBlank(key)) {
			actionRequest.setAttribute("product", productService.get(key));
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			actionResponse.setRenderParameter("jspPage", ModuleConstants.URL_PRODUCT_EDIT);
		}
	}
	
	@ProcessAction(name="goToViewProductPagePA")
	public void goToViewProductPage(ActionRequest actionRequest, ActionResponse actionResponse) {
		String key = ParamUtil.getString(actionRequest, "prodId");
		if (!Validator.isBlank(key)) {
			actionRequest.setAttribute("product", productService.get(key));
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			actionResponse.setRenderParameter("jspPage", ModuleConstants.URL_PRODUCT_VIEW);
		}
	}
	
	@ProcessAction(name="goToViewProductListPagePA")
	public void goToViewProductListPage(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionResponse.setRenderParameter("jspPage", ModuleConstants.URL_PRODUCTS_VIEW);
	}
	
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