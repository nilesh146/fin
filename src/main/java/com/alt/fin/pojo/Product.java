package com.alt.fin.pojo;

import com.alt.fin.entity.ProductEnt;

public class Product {

	private String name;

	private String value;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static Product fromProductEnt(ProductEnt ent) {

		Product p = new Product();

		p.setName(ent.getProductName());
		p.setValue(String.valueOf(ent.getProductValue()));

		return p;
	}

}
