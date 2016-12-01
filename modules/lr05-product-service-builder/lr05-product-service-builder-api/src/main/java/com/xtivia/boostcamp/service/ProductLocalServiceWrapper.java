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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductLocalService}.
 *
 * @author pnguyen
 * @see ProductLocalService
 * @generated
 */
@ProviderType
public class ProductLocalServiceWrapper implements ProductLocalService,
	ServiceWrapper<ProductLocalService> {
	public ProductLocalServiceWrapper(ProductLocalService productLocalService) {
		_productLocalService = productLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _productLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _productLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _productLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _productLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _productLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the product to the database. Also notifies the appropriate model listeners.
	*
	* @param product the product
	* @return the product that was added
	*/
	@Override
	public com.xtivia.boostcamp.model.Product addProduct(
		com.xtivia.boostcamp.model.Product product) {
		return _productLocalService.addProduct(product);
	}

	@Override
	public com.xtivia.boostcamp.model.Product addProduct(long userId,
		long groupId, java.lang.String name, int quantity,
		java.lang.String unitPrice, java.lang.String desc,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _productLocalService.addProduct(userId, groupId, name, quantity,
			unitPrice, desc, serviceContext);
	}

	/**
	* Creates a new product with the primary key. Does not add the product to the database.
	*
	* @param id the primary key for the new product
	* @return the new product
	*/
	@Override
	public com.xtivia.boostcamp.model.Product createProduct(long id) {
		return _productLocalService.createProduct(id);
	}

	/**
	* Deletes the product from the database. Also notifies the appropriate model listeners.
	*
	* @param product the product
	* @return the product that was removed
	*/
	@Override
	public com.xtivia.boostcamp.model.Product deleteProduct(
		com.xtivia.boostcamp.model.Product product) {
		return _productLocalService.deleteProduct(product);
	}

	/**
	* Deletes the product with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the product
	* @return the product that was removed
	* @throws PortalException if a product with the primary key could not be found
	* @throws SystemException
	*/
	@Override
	public com.xtivia.boostcamp.model.Product deleteProduct(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _productLocalService.deleteProduct(id);
	}

	@Override
	public com.xtivia.boostcamp.model.Product fetchProduct(long id) {
		return _productLocalService.fetchProduct(id);
	}

	/**
	* Returns the product matching the UUID and group.
	*
	* @param uuid the product's UUID
	* @param groupId the primary key of the group
	* @return the matching product, or <code>null</code> if a matching product could not be found
	*/
	@Override
	public com.xtivia.boostcamp.model.Product fetchProductByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _productLocalService.fetchProductByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the product with the primary key.
	*
	* @param id the primary key of the product
	* @return the product
	* @throws PortalException if a product with the primary key could not be found
	*/
	@Override
	public com.xtivia.boostcamp.model.Product getProduct(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _productLocalService.getProduct(id);
	}

	/**
	* Returns the product matching the UUID and group.
	*
	* @param uuid the product's UUID
	* @param groupId the primary key of the group
	* @return the matching product
	* @throws PortalException if a matching product could not be found
	*/
	@Override
	public com.xtivia.boostcamp.model.Product getProductByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _productLocalService.getProductByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the product in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param product the product
	* @return the product that was updated
	*/
	@Override
	public com.xtivia.boostcamp.model.Product updateProduct(
		com.xtivia.boostcamp.model.Product product) {
		return _productLocalService.updateProduct(product);
	}

	@Override
	public com.xtivia.boostcamp.model.Product updateProduct(long productId,
		java.lang.String name, int quantity, java.lang.String unitPrice,
		java.lang.String desc,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _productLocalService.updateProduct(productId, name, quantity,
			unitPrice, desc, serviceContext);
	}

	/**
	* Returns the number of products.
	*
	* @return the number of products
	*/
	@Override
	public int getProductsCount() {
		return _productLocalService.getProductsCount();
	}

	@Override
	public int getProductsCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productLocalService.getProductsCountByGroupId(groupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _productLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _productLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _productLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _productLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.xtivia.boostcamp.model.Product> findAll() {
		return _productLocalService.findAll();
	}

	@Override
	public java.util.List<com.xtivia.boostcamp.model.Product> findAllByKey(
		java.lang.String key) {
		return _productLocalService.findAllByKey(key);
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
	@Override
	public java.util.List<com.xtivia.boostcamp.model.Product> getProducts(
		int start, int end) {
		return _productLocalService.getProducts(start, end);
	}

	@Override
	public java.util.List<com.xtivia.boostcamp.model.Product> getProductsByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productLocalService.getProductsByGroupId(groupId);
	}

	@Override
	public java.util.List<com.xtivia.boostcamp.model.Product> getProductsByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productLocalService.getProductsByGroupId(groupId, start, end);
	}

	/**
	* Returns all the products matching the UUID and company.
	*
	* @param uuid the UUID of the products
	* @param companyId the primary key of the company
	* @return the matching products, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.xtivia.boostcamp.model.Product> getProductsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _productLocalService.getProductsByUuidAndCompanyId(uuid,
			companyId);
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
	@Override
	public java.util.List<com.xtivia.boostcamp.model.Product> getProductsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.xtivia.boostcamp.model.Product> orderByComparator) {
		return _productLocalService.getProductsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _productLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _productLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public ProductLocalService getWrappedService() {
		return _productLocalService;
	}

	@Override
	public void setWrappedService(ProductLocalService productLocalService) {
		_productLocalService = productLocalService;
	}

	private ProductLocalService _productLocalService;
}