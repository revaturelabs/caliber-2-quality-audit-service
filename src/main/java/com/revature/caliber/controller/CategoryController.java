package com.revature.caliber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Category;
import com.revature.caliber.beans.Note;
import com.revature.caliber.service.CategoryService;

@RestController
@CrossOrigin(value="*")
@RequestMapping("/category")
public class CategoryController {


	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Category>> findAllCategories() {
		List<Category> category = categoryService.findAllCategories();
		if (category == null) {
			return new ResponseEntity<List<Category>>(HttpStatus.CONFLICT);
		}
		else {
			return new ResponseEntity<List<Category>>(category, HttpStatus.OK);
		}
	}
	@GetMapping("/{batchId}/{week}/all")
	public ResponseEntity<List<Category>> findAllCategoriesByBatchAndWeek(@PathVariable Integer batchId, @PathVariable Integer week) {
		List<Category> category =  categoryService.findCategoryByBatchAndWeek(batchId, week);
		if (category == null) {
			return new ResponseEntity<List<Category>>(HttpStatus.CONFLICT);
		}
		else {
			return new ResponseEntity<List<Category>>(category, HttpStatus.OK);
		}
	}
	
	@PostMapping("")
	public ResponseEntity<Category> insertCategory(@RequestBody Category category) {
		Category c = categoryService.insertCategory(category);
		if(c == null) {
			return new ResponseEntity<Category>(HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<Category>(category, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		categoryService.deleteCategoryById(id);
	}
}
