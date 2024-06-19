package com.alt.fin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alt.fin.entity.ProductEnt;
import com.alt.fin.exception.ProductNotFound;
import com.alt.fin.pojo.Product;
import com.alt.fin.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepo productRepo;

	@Override
	public void createProduct(Product product) {
		ProductEnt ent= ProductEnt.fromProduct(product);
		productRepo.save(ent);
		
	}

	@Override
	public void updateProductName(Integer productId, String name) {
		
	
	 ProductEnt ent= productRepo.getOne(productId);
	 if(ent!=null) {
			ent.setProductName(name);
		}else {
			throw new ProductNotFound();
		}
		productRepo.saveAndFlush(ent);
		
	}

	@Override
	public void updateProductValue(Integer productId, Integer value) {
		
		ProductEnt ent= productRepo.getOne(productId);
		if(ent!=null) {
			ent.setProductValue(value);
		}else {
			throw new ProductNotFound();
		}
		productRepo.saveAndFlush(ent);
	}

	@Override
	public Product getProductById(Integer productId) {
		ProductEnt ent =productRepo.getById(productId);
		if(ent==null) {
			throw new ProductNotFound();
		}
		return Product.fromProductEnt(ent);
	}

	@Override
	public void deleteProductById(Integer productId) {
		 Product p=	getProductById(productId);
		 if(p!=null) {
			 productRepo.deleteById(productId);
		 }
		
	}
	
	
	
	
	
	
}
