package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity(name="CATEGORY")
public class CategoryDetails {
	// @Value and @AllArgsConstructor does not include proudcts list in
	// constructor.but we dont require list setter and getter and hence removing
	// @value and @allagrsConstructor
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;
	@Column
	private String categoryName;

	@ManyToMany(mappedBy = "productCategories")
	private List<Product> products = new ArrayList<>();

	public int getCategoryId() {
		return categoryId;
	}

	public void setCatId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setProdCatName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void addProduct(Product productItem) {
		products.add(productItem);
	}

}
