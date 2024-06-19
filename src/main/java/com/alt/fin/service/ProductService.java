package com.alt.fin.service;

import com.alt.fin.pojo.Product;

public interface ProductService {
	
	
	void createProduct(Product product);
	
	void updateProductName(Integer productId,String name);
	
	void updateProductValue(Integer productId,Integer value);
	
	Product getProductById(Integer productId);
	
	void deleteProductById(Integer productId);

}
