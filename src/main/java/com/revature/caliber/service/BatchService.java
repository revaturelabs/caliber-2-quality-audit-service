package com.revature.caliber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.Batch;
import com.revature.caliber.beans.Note;
import com.revature.caliber.dao.BatchRepository;

@Service
public class BatchService {
	
	@Autowired
	BatchRepository batchRepo;
	
	public List<Batch> getAllBatches() {
		return batchRepo.findAll();
	}
	
	/*
	public List<Batch> getBatchesByYear(int startYear, int endYear) {
		return batchRepo.findAll();
	}
	*/
	
	public Batch findById(Integer id) {
		return batchRepo.findOne(id);
	}
	

}
