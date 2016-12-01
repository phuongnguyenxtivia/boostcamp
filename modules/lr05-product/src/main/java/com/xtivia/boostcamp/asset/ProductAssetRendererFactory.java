/**
 * 
 */
package com.xtivia.boostcamp.asset;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.xtivia.boostcamp.model.Product;
import com.xtivia.boostcamp.service.ProductLocalService;
import com.xtivia.boostcamp.service.ProductService;
import com.xtivia.boostcamp.service.permission.ProductPermission;
import com.xtivia.boostcamp.common.ProductPortletKeys;

import com.xtivia.boostcamp.asset.ProductAssetRenderer;

/**
 * @author pnguyen
 *
 */
@Component(
		immediate = true, 
		property = {
				"javax.portlet.name=" + ProductPortletKeys.PRODUCTS }, 
		service = AssetRendererFactory.class
)
public class ProductAssetRendererFactory extends BaseAssetRendererFactory<Product> {
	
	/**
	 * 
	 */
	public ProductAssetRendererFactory() {
		super();
		setClassName(Product.class.getName());
		setCategorizable(true);
		setLinkable(true);
		setPortletId(ProductPortletKeys.PRODUCTS);
		setSearchable(true);
		setSelectable(true);
	}
	
	@Override
	public AssetRenderer<Product> getAssetRenderer(long classPK, int type) throws PortalException {
		Product product = _productLocalService.getProduct(classPK);

	    ProductAssetRenderer productAssetRenderer =
	        new ProductAssetRenderer(product, _resourceBundleLoader);

	    productAssetRenderer.setAssetRendererType(type);
	    productAssetRenderer.setServletContext(_servletContext);

	    return productAssetRenderer;
	}

//	@Override
//	public AssetRenderer<Product> getAssetRenderer(
//			long groupId, String urlTitle)
//		throws PortalException {
//
//		Product product = _productService..getEntry(groupId, urlTitle);
//
//		return new ProductAssetRenderer(product, _resourceBundleLoader);
//	}

	@Override
	public String getClassName() {
		return Product.class.getName();
	}

	@Override
	public String getIconCssClass() {
		return "blogs";
	}

	@Override
	public String getType() {
		return TYPE;
	}

//	@Override
//	public PortletURL getURLAdd(
//		LiferayPortletRequest liferayPortletRequest,
//		LiferayPortletResponse liferayPortletResponse, long classTypeId) {
//
//		PortletURL portletURL = PortalUtil.getControlPanelPortletURL(
//			liferayPortletRequest, getGroup(liferayPortletRequest),
//			ProductPortletKeys.PRODUCTS, 0, 0, PortletRequest.RENDER_PHASE);
//
//		portletURL.setParameter("mvcRenderCommandName", "/blogs/edit_entry");
//
//		return portletURL;
//	}
//
//	@Override
//	public PortletURL getURLView(
//		LiferayPortletResponse liferayPortletResponse,
//		WindowState windowState) {
//
//		LiferayPortletURL liferayPortletURL =
//			liferayPortletResponse.createLiferayPortletURL(
//				ProductPortletKeys.PRODUCTS, PortletRequest.RENDER_PHASE);
//
//		try {
//			liferayPortletURL.setWindowState(windowState);
//		}
//		catch (WindowStateException wse) {
//		}
//
//		return liferayPortletURL;
//	}

	@Override
	public boolean hasAddPermission(
			PermissionChecker permissionChecker, long groupId, long classTypeId)
		throws Exception {

		return ProductPermission.contains(
			permissionChecker, groupId, ActionKeys.ADD_ENTRY);
	}

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, long classPK, String actionId)
		throws Exception {

		return ProductPermission.contains(
			permissionChecker, classPK, actionId);
	}

	@Reference(
		target = "(bundle.symbolic.name=com.xtivia.boostcamp)", unbind = "-"
	)
	public void setResourceBundleLoader(
		ResourceBundleLoader resourceBundleLoader) {

		_resourceBundleLoader = resourceBundleLoader;
	}

	@Reference(
		target = "(osgi.web.symbolicname=com.xtivia.boostcamp)", unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	@Reference(unbind = "-")
	protected void setProductLocalService(
			ProductLocalService productLocalService) {

		_productLocalService = productLocalService;
	}

	@Reference(unbind = "-")
	protected void setProductService(ProductService productService) {
		_productService = productService;
	}

	public static final String TYPE = "product";
	private ProductLocalService _productLocalService;
	private ProductService _productService;
	private ResourceBundleLoader _resourceBundleLoader;
	private ServletContext _servletContext;
}
