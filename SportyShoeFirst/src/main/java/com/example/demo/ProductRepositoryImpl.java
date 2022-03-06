package com.example.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	EntityManager entityManager;
//	@PersistenceContext
//	EntityManager entityManager1;

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	CategoryRepository categoryRepo;

	@Override
	@Transactional
	public void saveProduct(Product product) {
//		CategoryDetails catDetails=categoryRepo.findByCategoryName(product.getProductCategory());

////		obj.setCatId(1);
//		obj.setProdCatName("kids");
//		CategoryDetails obj1=new CategoryDetails();
////		obj1.setCatId(2);
//		obj1.setProdCatName("ladies");
//		CategoryDetails obj2=new CategoryDetails();
////		obj2.setCatId(3);
//		obj2.setProdCatName("men");
		// TODO Auto-generated method stub

//		TypedQuery<CategoryDetails> query = entityManager.createQuery(
//				"select c from CategoryDetails c where c.categoryName='" + product.getProductCategory() + "'",
//				CategoryDetails.class);
//		CategoryDetails catDetails = query.getSingleResult();

		String categoryName = product.getProductCategory();

		Query query = entityManager
				.createNativeQuery("select * from category where category_name='" + categoryName + "'");
		Object[] catObj = (Object[]) query.getSingleResult();
		CategoryDetails catDetails = new CategoryDetails();
		catDetails.setCatId((int) catObj[0]);
		catDetails.setProdCatName((categoryName));
		product.addProductCategory(catDetails);
		catDetails.addProduct(product);
//
//		em.persist(student);
//		em.persist(course);

//		System.out.println("ppp---->>"+product.toString());
		entityManager.persist(product);
//		entityManager.persist(obj);
//		entityManager.persist(obj1);
//		entityManager.persist(obj2);
	}

	@Override
	public List<Product> getAllProducts() {
		// using jpql
		// TODO Auto-generated method stub
		TypedQuery<Product> query = entityManager.createNamedQuery("getAllProducts", Product.class);// return type is
																									// known
		List<Product> resultList = query.getResultList();

		logger.info("getAllProducts ProductRepositoryImp->{}", resultList);

//		Query query1 = entityManager.createNamedQuery("getAllProducts");//return type is unknown
//		List resultList1 = query1.getResultList();

		return resultList;

	}

	@Override
	@Transactional
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub

//		Product product = entityManager.find(Product.class, productId);
//		product.getProductCategories();

		TypedQuery<Product> query = entityManager.createQuery("select p from Product p where p.prodId=" + productId,
				Product.class);
		Product product = query.getSingleResult();
		logger.info("getProductById->{}", product.getProductCategories().toString());
		return product;

	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		// entityManager.remove(product);
//		String categoryName = product.getProductCategory();
//		categoryName = "wardrobe";
//		Query query = entityManager
//				.createNativeQuery("select * from category where category_name='" + categoryName + "'");
//		Object[] catObj = (Object[]) query.getSingleResult();
//		CategoryDetails catDetails = new CategoryDetails();
//		catDetails.setCatId((int) catObj[0]);
//		catDetails.setProdCatName((categoryName));

//		product.addProductCategory(catDetails);
//		product.getProductCategories().remove(catDetails);
//		catDetails.addProduct(product);

//		entityManager.remove(product);
//		entityManager.

//		Query query = entityManager
//				.createNativeQuery("delete from productandcategory where product_id=" + product.getProdId());
//		query.executeUpdate();
////		entityManager.refresh(product);
////		entityManager.remove(product);
//		Query query1 = entityManager
//				.createNativeQuery("delete from product where prod_id=" + product.getProdId());
//		query1.executeUpdate();

		entityManager.merge(product);
		Query query1 = entityManager.createNativeQuery("delete from product where prod_id=" + product.getProdId());
		query1.executeUpdate();

	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		entityManager.merge(product);

	}
//
//	@Override
//	public void updateProductById(int productId) {
//		Product product = entityManager.find(Product.class, productId);
//		// TODO Auto-generated method stub
//		product.setProdName("name-updated");// after end of transaction, this change would be automatically committed
//
//	}

	@Override
	public List<Product> getProductByCategory(int categoryId) {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery(
				"select * from product p inner join productandcategory pc on p.prod_id=pc.product_id where pc.category_id=?",
				Product.class);// return type is
		query.setParameter(1, categoryId);
		// known
		List<Product> resultList = query.getResultList();

		return resultList;

	}

}
