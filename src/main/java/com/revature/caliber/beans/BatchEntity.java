package com.revature.caliber.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class BatchEntity implements Serializable{

	private static final long serialVersionUID = 2916173221333913998L;

	private int batchId;
	private String trainingName;
	private String trainingType;
	private String skillType;
	private String trainer;
	private String coTrainer;
	private int locationId;
	private String location;
	private Date startDate;
	private Date endDate;
	private int goodGrade;
	private int passingGrade;
	private int weeks;
	
	public BatchEntity() {}

	public BatchEntity(int batchId, String trainingName, String trainingType, String skillType, String trainer,
			String coTrainer, int locationId, String location, Date startDate, Date endDate, int goodGrade,
			int passingGrade, int weeks) {
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
			int locationId, String location, Date startDate, Date endDate, int goodGrade, int passingGrade,
			int weeks) {
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

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
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

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
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

	public int getGoodGrade() {
		return goodGrade;
	}

	public void setGoodGrade(int goodGrade) {
		this.goodGrade = goodGrade;
	}

	public int getPassingGrade() {
		return passingGrade;
	}

	public void setPassingGrade(int passingGrade) {
		this.passingGrade = passingGrade;
	}

	public int getWeeks() {
		return weeks;
	}

	public void setWeeks(int weeks) {
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


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BatchEntity that = (BatchEntity) o;
		return batchId == that.batchId &&
						locationId == that.locationId &&
						goodGrade == that.goodGrade &&
						passingGrade == that.passingGrade &&
						weeks == that.weeks &&
						Objects.equals(trainingName, that.trainingName) &&
						Objects.equals(trainingType, that.trainingType) &&
						Objects.equals(skillType, that.skillType) &&
						Objects.equals(trainer, that.trainer) &&
						Objects.equals(coTrainer, that.coTrainer) &&
						Objects.equals(location, that.location) &&
						Objects.equals(startDate, that.startDate) &&
						Objects.equals(endDate, that.endDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(batchId, trainingName, trainingType, skillType, trainer, coTrainer, locationId, location, startDate, endDate, goodGrade, passingGrade, weeks);
	}
}
