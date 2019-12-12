package com.revature.caliber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.Category;
import com.revature.caliber.dao.CategoryRepository;

	
@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepo;
	
	public Category insertCategory(Category category) {
		return categoryRepo.findOne(category.getId());

		//		List<Category> categories = categoryRepo.findCategoryByBatchAndWeek(category.getBatchId(), category.getWeek());
//		for(Category c : categories) {
//			if(category.getSkillCategory().equals(c.getSkillCategory())) {
//				return null;
//			}
//		}

//		if(category.getBatchId() >= 0 ||
//				category.getCategoryId() >= 0 ||
//				category.getWeek() >= 0 ||
//				category.getSkillCategory() == null || category.getSkillCategory() == "") {
//			return null;
//		}
//		return category = categoryRepo.save(category);
	}
	
	public List<Category> findAllCategories() {
		return categoryRepo.findAll();
	}
	
	public List<Category> findCategoryByBatchAndWeek(Integer batchId, Integer week) {
		return categoryRepo.findCategoryByBatchAndWeek(batchId, week);
	}
	
	public void deleteCategoryById(Integer id) {
		categoryRepo.delete(id);
	}
	
}
