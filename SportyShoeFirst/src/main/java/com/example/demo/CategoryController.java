package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Category")
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepository;

	@RequestMapping(value = "getAllCategory", method = RequestMethod.GET)
	public List<CategoryDetails> getAllCategory() {
		return categoryRepository.findAll();
	}

	@RequestMapping(value = "deleteCategory", method = RequestMethod.GET)
	public void deleteCategory(CategoryDetails categoryDetails) {
		categoryRepository.delete(categoryDetails);
	}

	@RequestMapping(value = "saveCategory", method = RequestMethod.GET)
	public void saveCategory(CategoryDetails categoryDetails) {
		categoryRepository.save(categoryDetails);
	}

	@RequestMapping(value = "updateCategory", method = RequestMethod.GET)
	public void updateCategory(CategoryDetails categoryDetails) {
		// id should be existing
		categoryRepository.save(categoryDetails);
	}

}
