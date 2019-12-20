package com.revature.caliber.beans;

import java.io.Serializable;
import java.util.Date;

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
	public boolean equals(Object obj) {

		return super.equals(obj);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + batchId;
		/*result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((technicalStatus == null) ? 0 : technicalStatus.hashCode());
		result = prime * result + ((softSkillStatus == null) ? 0 : softSkillStatus.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + week;
		result = prime * result + batchId;
		result = prime * result + traineeId;
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((lastSavedBy == null) ? 0 : lastSavedBy.hashCode());
		result = prime * result + lastSavedById;*/
		//Original return value
		//return super.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "BatchEntity [batchId=" + batchId + ", trainingName=" + trainingName + ", trainingType=" + trainingType
				+ ", skillType=" + skillType + ", trainer=" + trainer + ", coTrainer=" + coTrainer + ", locationId="
				+ locationId + ", location=" + location + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", goodGrade=" + goodGrade + ", passingGrade=" + passingGrade + ", weeks=" + weeks + "]";
	}

	

	

}
