package com.alt.fin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alt.fin.pojo.AppError;
import com.alt.fin.pojo.Product;
import com.alt.fin.pojo.ProductCreateRequest;
import com.alt.fin.pojo.ProductDeleteRequest;
import com.alt.fin.pojo.ProductGetRequest;
import com.alt.fin.pojo.ProductUpdateRequest;
import com.alt.fin.service.ProductService;

@RestController
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	
	
	@PostMapping("/product/get")
	public ResponseEntity getProductById(@RequestBody ProductGetRequest pgr){
		if(pgr.getProductId()==null) {
			return ResponseEntity.badRequest().body(new AppError("product Id cannot be null"));
		}
		Product product=productService.getProductById(Integer.parseInt(pgr.getProductId()));
		return ResponseEntity.ok(product);
	}
	
	@PostMapping("/product/delete")
	public ResponseEntity deleteProduct(@RequestBody ProductDeleteRequest pdr) {
		if(pdr.getProductId()==null) {
			return ResponseEntity.badRequest().body(new AppError("product Id cannot be null"));
		}
		productService.deleteProductById(Integer.parseInt(pdr.getProductId()));
		return ResponseEntity.ok().build();
		
	}
	@PostMapping("/product/update")
	public ResponseEntity updateProduct(@RequestBody ProductUpdateRequest pur) {
		
		if(pur.getProductId()==null) {
			return ResponseEntity.badRequest().body(new AppError("product Id cannot be null"));
		}
		if(pur.getName()==null && pur.getValue()==null) {
			return ResponseEntity.badRequest().body(new AppError("invalid request"));
		}
		
		if(pur.getName()!=null) {
			productService.updateProductName(Integer.parseInt(pur.getProductId()), pur.getName());
		}
		
		if(pur.getValue()!=null) {
			productService.updateProductValue(Integer.parseInt(pur.getProductId()), Integer.parseInt(pur.getValue()));
		}
		
		return ResponseEntity.ok().build();
	}
	
	
	@PostMapping("/product/create")
	public ResponseEntity createProduct(@RequestBody Product pcr) {
		
		if(pcr.getName()!=null && pcr.getValue()!=null) {
			productService.createProduct(pcr);
		}else {
			
			return ResponseEntity.badRequest().body(new AppError("invalid request"));
		}
	
		
		return ResponseEntity.ok().build();
		
	}
	
	

}
