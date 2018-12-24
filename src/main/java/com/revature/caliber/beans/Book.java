package com.revature.caliber.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOK")
public class Book implements Serializable {
	
	private static final long serialVersionUID = -9090223980655307018L;
	
	@Id
	@Column
	@GeneratedValue
	private int id;
	
	@Column
	private String title;
	@Column
	private double price;
	


	public Book() {
		super();
	}

	public Book(String title, double price) {
		super();
		this.title = title;
		this.price = price;
		
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
//	public String getAuthor() {
//		return author.getFirstName();
//	}
	
	
//	public String getAuthorBio() {
//		return author.getBio();
//	}
//
//	public void setAuthor(Author author) {
//		this.author = author;
//	}

	

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", price=" + price  + "]";
	}

}
