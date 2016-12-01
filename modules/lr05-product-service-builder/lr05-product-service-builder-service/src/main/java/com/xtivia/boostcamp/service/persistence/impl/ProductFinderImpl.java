/**
 * 
 */
package com.xtivia.boostcamp.service.persistence.impl;

import com.xtivia.boostcamp.service.ProductLocalServiceUtil;
import com.xtivia.boostcamp.service.persistence.ProductFinder;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
//import com.liferay.util.dao.orm.CustomSQLUtil;
import com.xtivia.boostcamp.model.Product;
import com.xtivia.boostcamp.model.impl.ProductImpl;

/**
 * @author pnguyen
 *
 */
public class ProductFinderImpl extends ProductFinderBaseImpl implements ProductFinder {
	public static final String FIND_ALL = ProductFinder.class.getName() + ".findAll";
	public static final String FIND_ALL_BY_KEY = ProductFinder.class.getName() + ".findAllByKey";
	
	public List<Product> findAll() {
		return getProductPersistence().findAll();
//		Session session = null;
//	    try {
//	        session = openSession();
//
//	        // TODO: Unresolved requirement: Import-Package: com.liferay.util.dao.orm; version="[6.3.0,7.0.0)
//	        // Looks like the jar com.liferay.portal.dao.orm.custom.sql version does not match
////	        String sql = CustomSQLUtil.get(FIND_ALL);
////	        
////	        SQLQuery queryObject = session.createSQLQuery(sql);
////	        queryObject.setCacheable(false);
////	        queryObject.addEntity("Product_Finder", ProductImpl.class);
////	        QueryPos qPos = QueryPos.getInstance(queryObject);
////	        qPos.add(studentGende);
////	        qPos.add(studentAge);
////	        return (List<Product>) queryObject.list();
//
////	        SQLQuery q = session.createSQLQuery(sql);
////	        q.setCacheable(false);
////	        q.addEntity("Product_Find", ProductImpl.class);
////
////	        QueryPos qPos = QueryPos.getInstance(q);  
////
////	        return (List<Event>) QueryUtil.list(q, getDialect(), begin, end);
//	    } catch (Exception e) {
//	        try {
//	            throw new SystemException(e);
//	        } catch (SystemException se) {
//	            se.printStackTrace();
//	        }
//	    } finally {
//	        closeSession(session);
//	    }
//
//	    return null;
	}
	
	public List<Product> findAllByKey(String key) {
		Session session = null;
	    try {
	        session = openSession();
	        
	        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Product.class)
	                .add(RestrictionsFactoryUtil.like("id", key + "%"));
	        List<Product> entries = ProductLocalServiceUtil.dynamicQuery(query);
	        
	        return entries;

//	        String sql = CustomSQLUtil.get(FIND_ALL_BY_KEY);
//	        SQLQuery queryObject = session.createSQLQuery(sql);
//	        
//	        queryObject.setCacheable(false);
//	        queryObject.addEntity("Product_Finder", ProductImpl.class);
//	        
//	        QueryPos qPos = QueryPos.getInstance(queryObject);
//	        qPos.add(key + "%");
//	        
//	        return (List<Product>) queryObject.list();
	    } catch (Exception e) {
	        try {
	            throw new SystemException(e);
	        } catch (SystemException se) {
	            se.printStackTrace();
	        }
	    } finally {
	        closeSession(session);
	    }

	    return null;
	}
}
