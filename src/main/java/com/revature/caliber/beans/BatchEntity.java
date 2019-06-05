package com.revature.caliber.beans;

import java.io.Serializable;
import java.util.Date;

public class BatchEntity implements Serializable{

	private static final long serialVersionUID = 2916173221333913998L;

	private Integer batchId;
	private String trainingName;
	private String trainingType;
	private String skillType;
	private String trainer;
	private String coTrainer;
	private Integer locationId;
	private String location;
	private Date startDate;
	private Date endDate;
	private Integer goodGrade;
	private Integer passingGrade;
	private Integer weeks;
	
	public BatchEntity() {}

	public BatchEntity(Integer batchId, String trainingName, String trainingType, String skillType, String trainer,
			String coTrainer, Integer locationId, String location, Date startDate, Date endDate, Integer goodGrade,
			Integer passingGrade, Integer weeks) {
		super();
		this.batchId = batchId;
		this.trainingName = trainingName;
		this.trainingType = trainingType;
		this.skillType = skillType;
		this.trainer = trainer;
		this.coTrainer = coTrainer;
		this.locationId = locationId;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.goodGrade = goodGrade;
		this.passingGrade = passingGrade;
		this.weeks = weeks;
	}

	public BatchEntity(String trainingName, String trainingType, String skillType, String trainer, String coTrainer,
			Integer locationId, String location, Date startDate, Date endDate, Integer goodGrade, Integer passingGrade,
			Integer weeks) {
		super();
		this.trainingName = trainingName;
		this.trainingType = trainingType;
		this.skillType = skillType;
		this.trainer = trainer;
		this.coTrainer = coTrainer;
		this.locationId = locationId;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.goodGrade = goodGrade;
		this.passingGrade = passingGrade;
		this.weeks = weeks;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}

	public String getSkillType() {
		return skillType;
	}

	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public String getCoTrainer() {
		return coTrainer;
	}

	public void setCoTrainer(String coTrainer) {
		this.coTrainer = coTrainer;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getGoodGrade() {
		return goodGrade;
	}

	public void setGoodGrade(Integer goodGrade) {
		this.goodGrade = goodGrade;
	}

	public Integer getPassingGrade() {
		return passingGrade;
	}

	public void setPassingGrade(Integer passingGrade) {
		this.passingGrade = passingGrade;
	}

	public Integer getWeeks() {
		return weeks;
	}

	public void setWeeks(Integer weeks) {
		this.weeks = weeks;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BatchEntity [batchId=" + batchId + ", trainingName=" + trainingName + ", trainingType=" + trainingType
				+ ", skillType=" + skillType + ", trainer=" + trainer + ", coTrainer=" + coTrainer + ", locationId="
				+ locationId + ", location=" + location + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", goodGrade=" + goodGrade + ", passingGrade=" + passingGrade + ", weeks=" + weeks + "]";
	}

	

	

}
