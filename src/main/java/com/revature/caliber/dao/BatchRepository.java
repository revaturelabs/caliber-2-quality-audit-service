package com.revature.caliber.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.Batch;

@Repository
public interface BatchRepository  extends JpaRepository <Batch, Integer> {

}
