package com.alt.fin.entity;

import com.alt.fin.pojo.Product;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEnt {
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="product_id")
	private Integer productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name = "product_value")
	private Integer ProductValue;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductValue() {
		return ProductValue;
	}

	public void setProductValue(Integer productValue) {
		ProductValue = productValue;
	}
	
	
	public static ProductEnt fromProduct(Product product) {
		
		
		ProductEnt productent= new ProductEnt();
		productent.setProductName(product.getName());
		productent.setProductValue(Integer.parseInt(product.getValue()));
		
		return productent;
	}

}
