package com.hcl.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Book_Issue")
public class BookIssue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Transaction_Id")
	private Long transaction_Id;

	@ManyToOne
	@JoinColumn(name = "Book_Id", referencedColumnName = "bookId")
	private BookInfo book_Id;

	@ManyToOne
	@JoinColumn(name = "issued_To", referencedColumnName = "userId")
	private User issued_To;

	@ManyToOne
	@JoinColumn(name = "issued_By", referencedColumnName = "userId")
	private User issued_By;

	@Column(name = "Book_Pages")
	private Long book_Pages;

	@Column(name = "No_Of_Copies")
	private Long no_Of_Copies;

	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date book_Return_Date;

	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date book_Issued_Date;

	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date book_Actual_Return_Date;

	@ManyToOne
	@JoinColumn(name = "Created_By", referencedColumnName = "bookId")
	private User created_By;

	@ManyToOne
	@JoinColumn(name = "Modified_By", referencedColumnName = "bookId")
	private User modified_By;

	@Column(name = "Created_On")
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date created_On;

	@Column(name = "Modified_On")
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date modified_On;

	@Column(name = "Status")
	private String status;

	@OneToMany
	private List<TransactionAudit> transactionAudit;

	public BookIssue() {
		super();
	}

	public BookIssue(Long transaction_Id, BookInfo book_Id, User issued_To, User issued_By, Long book_Pages,
			Long no_Of_Copies, Date book_Return_Date, Date book_Issued_Date, Date book_Actual_Return_Date,
			User created_By, User modified_By, Date created_On, Date modified_On, String status) {
		super();
		this.transaction_Id = transaction_Id;
		this.book_Id = book_Id;
		this.issued_To = issued_To;
		this.issued_By = issued_By;
		this.book_Pages = book_Pages;
		this.no_Of_Copies = no_Of_Copies;
		this.book_Return_Date = book_Return_Date;
		this.book_Issued_Date = book_Issued_Date;
		this.book_Actual_Return_Date = book_Actual_Return_Date;
		this.created_By = created_By;
		this.modified_By = modified_By;
		this.created_On = created_On;
		this.modified_On = modified_On;
		this.status = status;
	}

	public Long getTransaction_Id() {
		return transaction_Id;
	}

	public void setTransaction_Id(Long transaction_Id) {
		this.transaction_Id = transaction_Id;
	}

	public BookInfo getBook_Id() {
		return book_Id;
	}

	public void setBook_Id(BookInfo book_Id) {
		this.book_Id = book_Id;
	}

	public User getIssued_To() {
		return issued_To;
	}

	public void setIssued_To(User issued_To) {
		this.issued_To = issued_To;
	}

	public User getIssued_By() {
		return issued_By;
	}

	public void setIssued_By(User issued_By) {
		this.issued_By = issued_By;
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

	public Date getBook_Return_Date() {
		return book_Return_Date;
	}

	public void setBook_Return_Date(Date book_Return_Date) {
		this.book_Return_Date = book_Return_Date;
	}

	public Date getBook_Issued_Date() {
		return book_Issued_Date;
	}

	public void setBook_Issued_Date(Date book_Issued_Date) {
		this.book_Issued_Date = book_Issued_Date;
	}

	public Date getBook_Actual_Return_Date() {
		return book_Actual_Return_Date;
	}

	public void setBook_Actual_Return_Date(Date book_Actual_Return_Date) {
		this.book_Actual_Return_Date = book_Actual_Return_Date;
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

	public void setCreated_On(Date created_On) {
		this.created_On = created_On;
	}

	public Date getModified_On() {
		return modified_On;
	}

	public void setModified_On(Date modified_On) {
		this.modified_On = modified_On;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BookIssue [transaction_Id=" + transaction_Id + ", book_Id=" + book_Id + ", issued_To=" + issued_To
				+ ", issued_By=" + issued_By + ", book_Pages=" + book_Pages + ", no_Of_Copies=" + no_Of_Copies
				+ ", book_Return_Date=" + book_Return_Date + ", book_Issued_Date=" + book_Issued_Date
				+ ", book_Actual_Return_Date=" + book_Actual_Return_Date + ", created_By=" + created_By
				+ ", modified_By=" + modified_By + ", created_On=" + created_On + ", modified_On=" + modified_On
				+ ", status=" + status + "]";
	}

}
