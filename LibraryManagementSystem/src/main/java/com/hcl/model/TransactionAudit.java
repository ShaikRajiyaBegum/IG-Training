package com.hcl.model;

import java.awt.print.Book;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Transaction_Audit")
public class TransactionAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Transaction_Audit_Id")
	private Long transaction_Audit_Id;

	@ManyToOne
	@JoinColumn(name = "Transaction_Id")
	private BookIssue transaction_Id;

	@ManyToOne
	@JoinColumn(name = "Book_Id")
	private Book book_Id;

	@ManyToOne
	@JoinColumn(name = "Issued_To")
	private User issued_To;

	@ManyToOne
	@JoinColumn(name = "Issued_By")
	private User issued_By;

	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date book_Return_Date;

	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date book_Issued_Date;

	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date book_Actual_Return_Date;

	@CreatedBy
	private String created_By;

	@LastModifiedBy
	private String modified_By;

	@CreatedDate
	private Date created_Date;

	@LastModifiedDate
	private Date modified_Date;

	@Column(name = "Status")
	private String status;

}
