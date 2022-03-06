package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@NamedQueries(value = { @NamedQuery(name = "getAllProducts", query = "select p from Product p"),
		@NamedQuery(name = "getProductByCategory", query = "select p from Product p") })
public class Product {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int prodId;
	@Column(nullable = false)
	private String prodName;
	private String prodCode;
	private BigDecimal prodPrice;
	private String prodDesc;
	private String prodReview;
	private String prodAddedDate;
	@Transient
	private String productCategory;

	public String getProductCategory() {
		if (productCategories != null && productCategories.size() > 0)
			return productCategories.get(0).getCategoryName();
		else
			return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	@ManyToMany
	@JoinTable(name = "PRODUCTANDCATEGORY", joinColumns = @JoinColumn(name = "PRODUCT_ID"), inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
	// to customize join table names and columns. by default table name comes in
	// plural
//	@JsonIgnore
	private List<CategoryDetails> productCategories = new ArrayList<>();

	@Override
	public String toString() {
		// adding category to this, would fetch category table. would decrease
		// performance
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodCode=" + prodCode + ", prodPrice="
				+ prodPrice + ", prodDesc=" + prodDesc + ", prodReview=" + prodReview + ", prodAddedDate="
				+ prodAddedDate + "]";
	}

	// whether default constructor is needed when there is no parameterized
	// contsructor

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public BigDecimal getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(BigDecimal prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public String getProdReview() {
		return prodReview;
	}

	public void setProdReview(String prodReview) {
		this.prodReview = prodReview;
	}

	public String getProdAddedDate() {
		return prodAddedDate;
	}

	public void setProdAddedDate(String prodAddedDate) {
		this.prodAddedDate = prodAddedDate;
	}

	public List<CategoryDetails> getProductCategories() {
		return productCategories;
	}

	public void addProductCategory(CategoryDetails productCategory) {
		productCategories.add(productCategory);
	}

}
