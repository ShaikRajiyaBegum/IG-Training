package com.hcl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "User_Id")
	private Long user_Id;

	@Column(name = "User_Name")
	private String user_Name;

	@Column(name = "User_Age")
	private Long user_Age;

	@Column(name = "User_Gender")
	private String user_Gender;

	@Column(name = "User_EmailId")
	private String user_EmailId;

	@Column(name = "User_MobileNo")
	private String user_MobileNo;

	@Column(name = "User_Address")
	private String user_Address;

	@Column(name = "User_Type")
	private String user_Type;

	public Long getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(Long user_Id) {
		this.user_Id = user_Id;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public Long getUser_Age() {
		return user_Age;
	}

	public void setUser_Age(Long user_Age) {
		this.user_Age = user_Age;
	}

	public String getUser_Gender() {
		return user_Gender;
	}

	public void setUser_Gender(String user_Gender) {
		this.user_Gender = user_Gender;
	}

	public String getUser_EmailId() {
		return user_EmailId;
	}

	public void setUser_EmailId(String user_EmailId) {
		this.user_EmailId = user_EmailId;
	}

	public String getUser_MobileNo() {
		return user_MobileNo;
	}

	public void setUser_MobileNo(String user_MobileNo) {
		this.user_MobileNo = user_MobileNo;
	}

	public String getUser_Address() {
		return user_Address;
	}

	public void setUser_Address(String user_Address) {
		this.user_Address = user_Address;
	}

	public String getUser_Type() {
		return user_Type;
	}

	public void setUser_Type(String user_Type) {
		this.user_Type = user_Type;
	}

	public User(Long user_Id, String user_Name, Long user_Age, String user_Gender, String user_EmailId,
			String user_MobileNo, String user_Address, String user_Type) {
		super();
		this.user_Id = user_Id;
		this.user_Name = user_Name;
		this.user_Age = user_Age;
		this.user_Gender = user_Gender;
		this.user_EmailId = user_EmailId;
		this.user_MobileNo = user_MobileNo;
		this.user_Address = user_Address;
		this.user_Type = user_Type;
	}

	@Override
	public String toString() {
		return "User [user_Id=" + user_Id + ", user_Name=" + user_Name + ", user_Age=" + user_Age + ", user_Gender="
				+ user_Gender + ", user_EmailId=" + user_EmailId + ", user_MobileNo=" + user_MobileNo
				+ ", user_Address=" + user_Address + ", user_Type=" + user_Type + "]";
	}

}
