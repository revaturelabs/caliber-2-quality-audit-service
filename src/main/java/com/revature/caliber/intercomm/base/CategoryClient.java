package com.revature.caliber.intercomm.base;

import com.revature.caliber.beans.Category;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CategoryClient {
	
	@GetMapping(value = "/category/all/active", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Category> getAllActiveCategories();
	
	@GetMapping(value = "/category/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Category getCategoryById(@PathVariable(name = "id") Integer id);
}
