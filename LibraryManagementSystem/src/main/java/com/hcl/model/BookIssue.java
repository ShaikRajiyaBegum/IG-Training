package com.hcl.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

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
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class BookIssue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;

	@ManyToOne
	@JoinColumn(name = "BookId", referencedColumnName = "bookId")
	private BookInfo bookId;

	@ManyToOne
	@JoinColumn(name = "IssuedTo", referencedColumnName = "userId")
	private User issuedTo;

	@ManyToOne
	@JoinColumn(name = "IssuedBy", referencedColumnName = "userId")
	private User issuedBy;

	private Long bookPages;

	private Long noOfCopies;

	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date bookReturnDate;

	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date bookIssuedDate;

	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date bookActualReturnDate;

	@ManyToOne
	@JoinColumn(name = "CreatedBy", referencedColumnName = "userId")
	private User createdBy;

	@ManyToOne
	@JoinColumn(name = "ModifiedBy", referencedColumnName = "userId")
	private User modifiedBy;

	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date createdOn;

	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date modifiedOn;

	private String status;

}
