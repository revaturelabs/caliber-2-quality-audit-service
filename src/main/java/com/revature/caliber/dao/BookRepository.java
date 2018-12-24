package com.revature.caliber.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.Book;
import com.revature.caliber.beans.Note;

@Repository
public interface BookRepository extends JpaRepository <Book, Integer> {

}
