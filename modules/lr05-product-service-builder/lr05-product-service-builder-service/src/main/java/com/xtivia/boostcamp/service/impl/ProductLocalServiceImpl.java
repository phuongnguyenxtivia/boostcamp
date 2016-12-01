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

package com.xtivia.boostcamp.service.impl;

import aQute.bnd.annotation.ProviderType;

import java.util.Date;
import java.util.List;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.xtivia.boostcamp.model.Product;
import com.xtivia.boostcamp.service.ProductLocalServiceUtil;
import com.xtivia.boostcamp.service.base.ProductLocalServiceBaseImpl;
import com.xtivia.boostcamp.service.persistence.ProductFinder;

/**
 * The implementation of the product local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.xtivia.boostcamp.service.ProductLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author pnguyen
 * @see ProductLocalServiceBaseImpl
 * @see com.xtivia.boostcamp.service.ProductLocalServiceUtil
 */
@ProviderType
public class ProductLocalServiceImpl extends ProductLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.xtivia.boostcamp.service.ProductLocalServiceUtil} to access the product local service.
	 */
	public List<Product> findAll() {
		return getProductFinder().findAll();
	}
	
	public List<Product> findAllByKey(String key) {
		return getProductFinder().findAllByKey(key);
	}
	

	public Product addProduct(long userId, long groupId, String name, int quantity, String unitPrice, String desc,
			ServiceContext serviceContext) throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		long productId = counterLocalService.increment(Product.class.getName());

		Product product = productPersistence.create(productId);
	    product.setName(name);
	    product.setQuantity(quantity);
	    product.setUnitPrice(unitPrice);
	    product.setDescription(desc);
	    
		product.setUserId(user.getUserId());
		product.setUserName(user.getFullName());
		product.setGroupId(groupId);
		product.setCompanyId(user.getCompanyId());
		product.setCreateDate(serviceContext.getCreateDate(now));
		product.setModifiedDate(serviceContext.getModifiedDate(now));

		super.addProduct(product);

		resourceLocalService.addResources(product.getCompanyId(), product.getGroupId(), product.getUserId(),
				Product.class.getName(), product.getId(), false, true, true);

		long classTypeId = 0;
		boolean visible = true;
		Date startDate = null;
		Date endDate = null;
		Date expirationDate = null;
		String mimeType = ContentTypes.TEXT_HTML;
		String title = "";
		String description = "";
		String summary = "";
		String url = null;
		String layoutUuid = null;
		int height = 0;
		int width = 0;
		Integer priority = null;
		boolean sync = false;

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId, groupId, product.getCreateDate(),
				product.getModifiedDate(), Product.class.getName(), product.getId(), product.getUuid(), classTypeId,
				serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), visible, startDate, endDate,
				expirationDate, mimeType, title, description, summary, url, layoutUuid, height, width, priority, sync);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Product.class);
		indexer.reindex(product);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		return product;
	}
	
	public Product updateProduct(long productId, String name, int quantity, String unitPrice, String desc,
			ServiceContext serviceContext) throws PortalException, SystemException {
		long groupId = serviceContext.getScopeGroupId();

		Product product = ProductLocalServiceUtil.fetchProduct(productId);
	    long userId = serviceContext.getUserId();
	    
	    Date now = new Date();

	    product.setName(name);
	    product.setQuantity(quantity);
	    product.setUnitPrice(unitPrice);
	    product.setDescription(desc);
	    product.setModifiedDate(serviceContext.getModifiedDate(now));

	    super.updateProduct(product);

		long classTypeId = 0;
		boolean visible = true;
		Date startDate = null;
		Date endDate = null;
		Date expirationDate = null;
		String mimeType = ContentTypes.TEXT_HTML;
		String title = product.getName();
		String description = product.getName();
		String summary = product.getName();
		String url = null;
		String layoutUuid = null;
		int height = 0;
		int width = 0;
		Integer priority = null;
		boolean sync = false;

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(
			userId, groupId, product.getCreateDate(),
			product.getModifiedDate(), Product.class.getName(),
			product.getId(), product.getUuid(), classTypeId,
			serviceContext.getAssetCategoryIds(),
			serviceContext.getAssetTagNames(), visible, startDate, endDate,
			expirationDate, mimeType, title, description, summary, url,
			layoutUuid, height, width, priority, sync);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Product.class);
		indexer.reindex(product);

		assetLinkLocalService.updateLinks(
			userId, assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(),
			AssetLinkConstants.TYPE_RELATED);

	    return product;
	}
	
	public Product deleteProduct(Product product) {

		try {
			resourceLocalService.deleteResource(product.getCompanyId(), Product.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, product.getPrimaryKey());
		} catch (PortalException e) {
			e.printStackTrace();
		}

		return productPersistence.remove(product);
	}
	
	public Product deleteProduct(long productId) throws PortalException, SystemException {

		Product product = productPersistence.findByPrimaryKey(productId);

//		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(Product.class.getName(), productId);
//
//		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
//
//		assetEntryLocalService.deleteEntry(Product.class.getName(), product.getId());
//
//		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Product.class);
//		indexer.delete(product);

		return deleteProduct(product);
	}
	
	public List<Product> getProductsByGroupId(long groupId) throws SystemException {

		return productPersistence.findByGroupId(groupId);
	}
	
	public List<Product> getProductsByGroupId(long groupId, int start, int end) throws SystemException {

		return productPersistence.findByGroupId(groupId, start, end);
	}
	
	public int getProductsCountByGroupId(long groupId) throws SystemException {

		return productPersistence.countByGroupId(groupId);
	}
}