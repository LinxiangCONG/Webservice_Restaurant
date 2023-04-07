package com.restaurant.model;

public class Category {
	private String cateId;
	
	private String cateName;
	
	public Category() {}

	public Category(String name) {
		this.cateName = name;
	}
	
	public Category(String cateId, String cateName) {
		this.cateId = cateId;
		this.cateName = cateName;
	}
	
	public String getCateId() {
		return cateId;
	}

	public void setCateId(String cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
}
