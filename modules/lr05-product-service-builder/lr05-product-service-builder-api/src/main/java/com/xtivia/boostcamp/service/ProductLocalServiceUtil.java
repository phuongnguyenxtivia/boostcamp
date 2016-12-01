/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.xtivia.boostcamp.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Product. This utility wraps
 * {@link com.xtivia.boostcamp.service.impl.ProductLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author pnguyen
 * @see ProductLocalService
 * @see com.xtivia.boostcamp.service.base.ProductLocalServiceBaseImpl
 * @see com.xtivia.boostcamp.service.impl.ProductLocalServiceImpl
 * @generated
 */
@ProviderType
public class ProductLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.xtivia.boostcamp.service.impl.ProductLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the product to the database. Also notifies the appropriate model listeners.
	*
	* @param product the product
	* @return the product that was added
	*/
	public static com.xtivia.boostcamp.model.Product addProduct(
		com.xtivia.boostcamp.model.Product product) {
		return getService().addProduct(product);
	}

	public static com.xtivia.boostcamp.model.Product addProduct(long userId,
		long groupId, java.lang.String name, int quantity,
		java.lang.String unitPrice, java.lang.String desc,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addProduct(userId, groupId, name, quantity, unitPrice,
			desc, serviceContext);
	}

	/**
	* Creates a new product with the primary key. Does not add the product to the database.
	*
	* @param id the primary key for the new product
	* @return the new product
	*/
	public static com.xtivia.boostcamp.model.Product createProduct(long id) {
		return getService().createProduct(id);
	}

	/**
	* Deletes the product from the database. Also notifies the appropriate model listeners.
	*
	* @param product the product
	* @return the product that was removed
	*/
	public static com.xtivia.boostcamp.model.Product deleteProduct(
		com.xtivia.boostcamp.model.Product product) {
		return getService().deleteProduct(product);
	}

	/**
	* Deletes the product with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the product
	* @return the product that was removed
	* @throws PortalException if a product with the primary key could not be found
	* @throws SystemException
	*/
	public static com.xtivia.boostcamp.model.Product deleteProduct(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProduct(id);
	}

	public static com.xtivia.boostcamp.model.Product fetchProduct(long id) {
		return getService().fetchProduct(id);
	}

	/**
	* Returns the product matching the UUID and group.
	*
	* @param uuid the product's UUID
	* @param groupId the primary key of the group
	* @return the matching product, or <code>null</code> if a matching product could not be found
	*/
	public static com.xtivia.boostcamp.model.Product fetchProductByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchProductByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the product with the primary key.
	*
	* @param id the primary key of the product
	* @return the product
	* @throws PortalException if a product with the primary key could not be found
	*/
	public static com.xtivia.boostcamp.model.Product getProduct(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getProduct(id);
	}

	/**
	* Returns the product matching the UUID and group.
	*
	* @param uuid the product's UUID
	* @param groupId the primary key of the group
	* @return the matching product
	* @throws PortalException if a matching product could not be found
	*/
	public static com.xtivia.boostcamp.model.Product getProductByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getProductByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the product in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param product the product
	* @return the product that was updated
	*/
	public static com.xtivia.boostcamp.model.Product updateProduct(
		com.xtivia.boostcamp.model.Product product) {
		return getService().updateProduct(product);
	}

	public static com.xtivia.boostcamp.model.Product updateProduct(
		long productId, java.lang.String name, int quantity,
		java.lang.String unitPrice, java.lang.String desc,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateProduct(productId, name, quantity, unitPrice, desc,
			serviceContext);
	}

	/**
	* Returns the number of products.
	*
	* @return the number of products
	*/
	public static int getProductsCount() {
		return getService().getProductsCount();
	}

	public static int getProductsCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProductsCountByGroupId(groupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.xtivia.boostcamp.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.xtivia.boostcamp.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<com.xtivia.boostcamp.model.Product> findAll() {
		return getService().findAll();
	}

	public static java.util.List<com.xtivia.boostcamp.model.Product> findAllByKey(
		java.lang.String key) {
		return getService().findAllByKey(key);
	}

	/**
	* Returns a range of all the products.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.xtivia.boostcamp.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @return the range of products
	*/
	public static java.util.List<com.xtivia.boostcamp.model.Product> getProducts(
		int start, int end) {
		return getService().getProducts(start, end);
	}

	public static java.util.List<com.xtivia.boostcamp.model.Product> getProductsByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProductsByGroupId(groupId);
	}

	public static java.util.List<com.xtivia.boostcamp.model.Product> getProductsByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProductsByGroupId(groupId, start, end);
	}

	/**
	* Returns all the products matching the UUID and company.
	*
	* @param uuid the UUID of the products
	* @param companyId the primary key of the company
	* @return the matching products, or an empty list if no matches were found
	*/
	public static java.util.List<com.xtivia.boostcamp.model.Product> getProductsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getProductsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of products matching the UUID and company.
	*
	* @param uuid the UUID of the products
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching products, or an empty list if no matches were found
	*/
	public static java.util.List<com.xtivia.boostcamp.model.Product> getProductsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.xtivia.boostcamp.model.Product> orderByComparator) {
		return getService()
				   .getProductsByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ProductLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProductLocalService, ProductLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ProductLocalService.class);
}