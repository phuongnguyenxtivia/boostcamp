package com.xtivia.boostcamp.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
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
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

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
		"javax.portlet.init-param.config-template=/configuration.jsp",
		"javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProductPortlet extends MVCPortlet {
	private static Log _log = LogFactoryUtil.getLog(ProductPortlet.class);
	protected IProductService productService;
	protected String productsViewJSP;
	protected String productsEditJSP;
	private volatile ProductConfiguration _configuration;
	
	public ProductPortlet() {
		productService = new ProductServiceImpl(new InMemoryProductDAOImpl());
	}
	
	public ProductPortlet(IProductService productService) {
		this.productService = productService;
	}
	
	@Override
	public void init() throws PortletException {
		super.init();
		//productsEditJSP = getInitParameter("edit-template");
		productsViewJSP = getInitParameter("view-template");
	}
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// put returned data to render request
		renderRequest.setAttribute("products", productService.getList());
		
		// set product portlet configuration data
		renderRequest.setAttribute(ProductConfiguration.class.getName(), _configuration);
//		Map<String, Boolean> config = new HashMap<String, Boolean>();
//		config.put("prodId", _configuration.productId());
//		config.put("prodName", _configuration.productName());
//		config.put("prodQuantity", _configuration.productQuantity());
//		config.put("prodUnitPrice", _configuration.productUnitPrice());
//		config.put("prodDescription", _configuration.productDescription());
//		renderRequest.setAttribute("configDisplay", config);

		PortletUtils.include(getPortletContext(), productsViewJSP, renderRequest, renderResponse);
	}
	
	public void processActionAddProduct(ActionRequest actionRequest, ActionResponse actionResponse) {
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
	
	public void processActionUpdateProduct(ActionRequest actionRequest, ActionResponse actionResponse) {
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
			actionResponse.setRenderParameter("jspPage", ModuleConstants.URL_PRODUCT_VIEW);
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		}
	}

	public void processActionDeleteProduct(ActionRequest actionRequest, ActionResponse actionResponse) {
		String key = ParamUtil.getString(actionRequest, "prodId");
		if (key == null || "".equalsIgnoreCase(key)) {
			SessionErrors.add(actionRequest, "Key is empty.");
		} else {
			productService.delete(key);
			actionRequest.setAttribute("products", productService.getList());
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		}
	}
	
	public void processActionDoEditProduct(ActionRequest actionRequest, ActionResponse actionResponse) {
		String key = ParamUtil.getString(actionRequest, "prodId");
		if (key == null || "".equalsIgnoreCase(key)) {
			SessionErrors.add(actionRequest, "Key is empty.");
		} else {
			actionRequest.setAttribute("product", productService.get(key));
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		}
	}
	
	public void processActionViewProductDetail(ActionRequest actionRequest, ActionResponse actionResponse) {
		// String key = actionRequest.getParameter("prodId");
		String key = ParamUtil.getString(actionRequest, "prodId");
		if (key == null || "".equalsIgnoreCase(key)) {
			SessionErrors.add(actionRequest, "Key is empty.");
		} else {
			// set product
			actionRequest.setAttribute("product", productService.get(key));
		
			// in case we have many parameters, should use PorttalUtil.copyRequestParameters()
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			
			// copy parameter prodId from actionRequest to actionResponse
			// actionResponse.setRenderParameter("prodId", key);

			//actionResponse.setRenderParameter("jspPage","/jsp/products/product/view.jsp");
		}
	}
	
	public void processActionViewProductList(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.setAttribute("products", productService.getList());
		actionRequest.setAttribute(ProductConfiguration.class.getName(), _configuration);
		PortalUtil.copyRequestParameters(actionRequest, actionResponse);
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