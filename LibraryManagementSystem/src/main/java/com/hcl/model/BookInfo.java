package com.hcl.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class BookInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;

	private String bookName;

	private String author;

	private float price;

	private Long bookPages;

	private Long noOfCopies;

	private String bookPublication;

	@ManyToOne
	@JoinColumn(name = "CreatedBy")
	private User createdBy;

	@ManyToOne
	@JoinColumn(name = "ModifiedBy")
	private User modifiedBy;

	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date createdOn;

	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date modifiedOn;

	private int activeFlag;

}
