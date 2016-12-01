/**
 * 
 */
package com.xtivia.boostcamp.service.permission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.exportimport.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.xtivia.boostcamp.model.Product;
import com.xtivia.boostcamp.service.ProductLocalService;

/**
 * @author pnguyen
 *
 */
@Component(property = {
		"model.class.name=com.xtivia.boostcamp.model.Product" }, service = BaseModelPermissionChecker.class)
public class ProductPermission implements BaseModelPermissionChecker {

	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, long groupId, long primaryKey, String actionId)
			throws PortalException {
		
		check(permissionChecker, primaryKey, actionId);
	}

	public static void check(PermissionChecker permissionChecker, Product product, String actionId)
			throws PortalException {

		if (!contains(permissionChecker, product, actionId)) {
			throw new PrincipalException.MustHavePermission(permissionChecker, Product.class.getName(), product.getId(),
					actionId);
		}
	}

	public static void check(PermissionChecker permissionChecker, long productId, String actionId)
			throws PortalException {

		if (!contains(permissionChecker, productId, actionId)) {
			throw new PrincipalException.MustHavePermission(permissionChecker, Product.class.getName(), productId,
					actionId);
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, Product product, String actionId) {

		String portletId = PortletProviderUtil.getPortletId(Product.class.getName(), PortletProvider.Action.EDIT);

		Boolean hasPermission = StagingPermissionUtil.hasPermission(permissionChecker, product.getGroupId(),
				Product.class.getName(), product.getId(), portletId, actionId);

		if (hasPermission != null) {
			return hasPermission.booleanValue();
		}

		if (permissionChecker.hasOwnerPermission(product.getCompanyId(), Product.class.getName(), product.getId(),
				product.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(product.getGroupId(), Product.class.getName(), product.getId(),
				actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, long productId, String actionId)
			throws PortalException {

		Product product = _productLocalService.getProduct(productId);

		return contains(permissionChecker, product, actionId);
	}

	@Reference(unbind = "-")
	protected void setProductLocalService(ProductLocalService productLocalService) {

		_productLocalService = productLocalService;
	}

	private static ProductLocalService _productLocalService;
}
