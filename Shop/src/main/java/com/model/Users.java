package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")

public class Users {
	@Id
	private String userid;
	private String firstname;
	private String lastname;
	private String role;
	private String password;
	private String contactno;
	private String emailid;
	private String gender;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Users(String userid, String firstname, String lastname, String role, String password, String contactno,
			String emailid, String gender) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
		this.password = password;
		this.contactno = contactno;
		this.emailid = emailid;
		this.gender = gender;
	}
	public Users() {
		super();
	}

	
	
}