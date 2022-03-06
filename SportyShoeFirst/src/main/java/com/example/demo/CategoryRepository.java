package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

//@NoRepositoryBean
public interface CategoryRepository extends JpaRepository<CategoryDetails, Integer> {
	
//	@Query("select c from CategoryDetails c where c.categoryName=?1")
//    public CategoryDetails findByName(String categoryName);

}
