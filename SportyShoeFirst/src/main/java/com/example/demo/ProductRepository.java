package com.example.demo;

import java.util.List;

public interface ProductRepository {

	public void saveProduct(Product product);

	public List<Product> getAllProducts();

	public void updateProduct(Product product);

	public List<Product> getProductByCategory(int categoryId);

	public Product getProductById(int productId);

	public void deleteProduct(Product product);

//	public void updateProductById(int productId);

}
