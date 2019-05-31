package com.revature.caliber.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class Category {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "BATCH_ID")
	private Integer batchId;
	
	@Column(name="WEEK_NUMBER")
	private Integer week;
	
	@Column(name="CATEGORY_ID")
	private Integer categoryId;
	
	@Column(name="SKILL_CATEGORY")
	private String skillCategory;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Integer id, Integer batchId, Integer week, Integer categoryId, String skillCategory) {
		super();
		this.id = id;
		this.batchId = batchId;
		this.week = week;
		this.categoryId = categoryId;
		this.skillCategory = skillCategory;
	}

	public Category(Integer batchId, Integer week, Integer categoryId, String skillCategory) {
		super();
		this.batchId = batchId;
		this.week = week;
		this.categoryId = categoryId;
		this.skillCategory = skillCategory;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public Integer getWeek() {
		return week;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getSkillCategory() {
		return skillCategory;
	}

	public void setSkillCategory(String skillCategory) {
		this.skillCategory = skillCategory;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", batchId=" + batchId + ", week=" + week + ", categoryId=" + categoryId
				+ ", skillCategory=" + skillCategory + "]";
	}




	

}
