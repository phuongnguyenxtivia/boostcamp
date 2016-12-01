/**
 * 
 */
package com.xtivia.boostcamp.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.xtivia.boostcamp.dao.IProductDAO;
import com.xtivia.boostcamp.domain.Product;
import com.xtivia.boostcamp.service.IProductService;

/**
 * @author pnguyen
 *
 */
public class ProductServiceImpl implements IProductService {

	private IProductDAO productDAO;
	
	public ProductServiceImpl(IProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	@Override
	public List<Product> getList() {
		return productDAO.getList();
	}

	@Override
	public Product get(String key) {
		return productDAO.get(key);
	}

	@Override
	public void add(Product entity) {
		productDAO.add(entity);
	}

	@Override
	public void update(Product entity) {
		productDAO.update(entity);
	}

	@Override
	public void delete(String key) {
		productDAO.delete(key);
	}

	@Override
	public boolean validate(Product entity) {
		if ("".equals(entity.getId())) {
			return false;
		}
		
		if ("".equals(entity.getName())) {
			return false;
		}
		
		if (entity.getQuantity() < 0) {
			return false;
		}
		
		if (entity.getUnitPrice().compareTo(new BigDecimal(0)) < 1) {
			return false;
		}
		
		return true;
	}

	@Override
	public List<Product> getListByKey(String key) {
		return productDAO.getListByKey(key);
	}
}
