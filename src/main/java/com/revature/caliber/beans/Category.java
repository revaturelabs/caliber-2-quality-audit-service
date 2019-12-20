package com.revature.caliber.beans;

import javax.persistence.*;

@Entity
@Table(name = "QC_CATEGORY")
public class Category {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "CATEGORY_ID_SEQUENCE")
	@SequenceGenerator(name = "CATEGORY_ID_SEQUENCE", sequenceName = "CATEGORY_ID_SEQUENCE")
	private int id;
	
	@Column(name = "BATCH_ID")
	private int batchId;
	
	@Column(name="WEEK_NUMBER")
	private int week;
	
	@Column(name="CATEGORY_ID")
	private int categoryId;
	
	@Column(name="SKILL_CATEGORY")
	private String skillCategory;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int id, int batchId, int week, int categoryId, String skillCategory) {
		super();
		this.id = id;
		this.batchId = batchId;
		this.week = week;
		this.categoryId = categoryId;
		this.skillCategory = skillCategory;
	}

	public Category(int batchId, int week, int categoryId, String skillCategory) {
		super();
		this.batchId = batchId;
		this.week = week;
		this.categoryId = categoryId;
		this.skillCategory = skillCategory;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batchId;
		result = prime * result + categoryId;
		result = prime * result + id;
		result = prime * result + ((skillCategory == null) ? 0 : skillCategory.hashCode());
		result = prime * result + week;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (batchId != other.batchId)
			return false;
		if (categoryId != other.categoryId)
			return false;
		if (id != other.id)
			return false;
		if (skillCategory == null) {
			if (other.skillCategory != null)
				return false;
		} else if (!skillCategory.equals(other.skillCategory))
			return false;
		if (week != other.week)
			return false;
		return true;
	}




	

}
