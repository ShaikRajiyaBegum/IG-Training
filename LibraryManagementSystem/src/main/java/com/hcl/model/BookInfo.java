package com.hcl.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Book_Info")
public class BookInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Book_Id")
	private Long book_Id;

	@Column(name = "Book_Name")
	private String book_Name;

	@Column(name = "Author")
	private String author;

	@Column
	private float price;

	@Column(name = "Book_Pages")
	private Long book_Pages;

	@Column(name = "No_Of_Copies")
	private Long no_Of_Copies;

	@Column(name = "Book_Publication")
	private String book_Publication;

	@ManyToOne
	@Column(name = "Created_By")
	private User created_By;

	@ManyToOne
	@Column(name = "Modified_By")
	private User modified_By;

	@Column(name = "Created_On")
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date created_On;

	@Column(name = "Modified_On")
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date modified_On;

	public BookInfo() {
		super();
	}

	public BookInfo(Long book_Id, String book_Name, String author, float price, Long book_Pages, Long no_Of_Copies,
			String book_Publication, User created_By, User modified_By, Timestamp created_On, Timestamp modified_On) {
		super();
		this.book_Id = book_Id;
		this.book_Name = book_Name;
		this.author = author;
		this.price = price;
		this.book_Pages = book_Pages;
		this.no_Of_Copies = no_Of_Copies;
		this.book_Publication = book_Publication;
		this.created_By = created_By;
		this.modified_By = modified_By;
		this.created_On = created_On;
		this.modified_On = modified_On;
	}

	public Long getBook_Id() {
		return book_Id;
	}

	public void setBook_Id(Long book_Id) {
		this.book_Id = book_Id;
	}

	public String getBook_Name() {
		return book_Name;
	}

	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Long getBook_Pages() {
		return book_Pages;
	}

	public void setBook_Pages(Long book_Pages) {
		this.book_Pages = book_Pages;
	}

	public Long getNo_Of_Copies() {
		return no_Of_Copies;
	}

	public void setNo_Of_Copies(Long no_Of_Copies) {
		this.no_Of_Copies = no_Of_Copies;
	}

	public String getBook_Publication() {
		return book_Publication;
	}

	public void setBook_Publication(String book_Publication) {
		this.book_Publication = book_Publication;
	}

	public User getCreated_By() {
		return created_By;
	}

	public void setCreated_By(User created_By) {
		this.created_By = created_By;
	}

	public User getModified_By() {
		return modified_By;
	}

	public void setModified_By(User modified_By) {
		this.modified_By = modified_By;
	}

	public Date getCreated_On() {
		return created_On;
	}

	public void setCreated_On(Timestamp created_On) {
		this.created_On = created_On;
	}

	public Date getModified_On() {
		return modified_On;
	}

	public void setModified_On(Timestamp modified_On) {
		this.modified_On = modified_On;
	}

}
