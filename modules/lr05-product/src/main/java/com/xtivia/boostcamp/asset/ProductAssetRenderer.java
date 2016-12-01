/**
 * 
 */
package com.xtivia.boostcamp.asset;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRenderer;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.trash.TrashRenderer;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.util.PropsValues;
import com.xtivia.boostcamp.common.ModuleConstants;
import com.xtivia.boostcamp.model.Product;
import com.xtivia.boostcamp.service.permission.ProductPermission;

/**
 * @author pnguyen
 *
 */
public class ProductAssetRenderer extends BaseJSPAssetRenderer<Product> implements TrashRenderer{

	private final Product _product;
	private final ResourceBundleLoader _resourceBundleLoader;
	public static final String TYPE = "product";
	
	/**
	 * @param _product
	 * @param _resourceBundleLoader
	 */
	public ProductAssetRenderer(Product _product, ResourceBundleLoader _resourceBundleLoader) {
		super();
		this._product = _product;
		this._resourceBundleLoader = _resourceBundleLoader;
	}

	@Override
	public String getClassName() {
		return Product.class.getName();
	}
	
	@Override
	public long getClassPK() {
		return _product.getId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		return "Summary: " + _product.getName();
	}

	@Override
	public String getTitle(Locale locale) {
		return _product.getName();
	}

	@Override
	public Product getAssetObject() {
		return _product;
	}

	@Override
	public long getGroupId() {
		return _product.getGroupId();
	}

	@Override
	public long getUserId() {
		return _product.getUserId();
	}

	@Override
	public String getUserName() {
		return _product.getUserName();
	}

	@Override
	public String getUuid() {
		return _product.getUuid();
	}

	@Override
	public String getPortletId() {
		AssetRendererFactory<Product> assetRendererFactory =
		        getAssetRendererFactory();

		return assetRendererFactory.getPortletId();
	}

	@Override
	public String getType() {
		return TYPE;
	}

//	/* (non-Javadoc)
//	 * @see com.liferay.asset.kernel.model.BaseAssetRenderer#getDiscussionPath()
//	 */
//	@Override
//	public String getDiscussionPath() {
//		if (PropsValues.BLOGS_ENTRY_COMMENTS_ENABLED) {
//	        return "edit_entry_discussion";
//	    }
//	    else {
//	        return null;
//	    }
//		//return super.getDiscussionPath();
//	}

	@Override
	public String getJspPath(HttpServletRequest request, String template) {
		return ModuleConstants.URL_PRODUCT_VIEW;
	}

	/* (non-Javadoc)
	 * @see com.liferay.asset.kernel.model.BaseAssetRenderer#hasEditPermission(com.liferay.portal.kernel.security.permission.PermissionChecker)
	 */
	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) throws PortalException {
		return ProductPermission.contains(
		        permissionChecker, _product, ActionKeys.UPDATE);
	}

	/* (non-Javadoc)
	 * @see com.liferay.asset.kernel.model.BaseAssetRenderer#hasViewPermission(com.liferay.portal.kernel.security.permission.PermissionChecker)
	 */
	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) throws PortalException {
		return ProductPermission.contains(
		        permissionChecker, _product, ActionKeys.VIEW);
	}
	
	public boolean hasDeletePermission(PermissionChecker permissionChecker) {
	    return ProductPermission.contains(
	        permissionChecker, _product, ActionKeys.DELETE);
	}

}
