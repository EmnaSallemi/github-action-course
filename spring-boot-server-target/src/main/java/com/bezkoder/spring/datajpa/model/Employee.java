package com.bezkoder.spring.datajpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "user")
	private String user;

	@Column(name = "abb")
	private String abb;
	
	@Column(name = "email_id")
	private String emailId;

	@Column(name = "password")
	private String password;
	
	public Employee() {
		
	}
	
	public Employee(String user, String abb, String emailId, String password) {
		super();
		this.user = user;
		this.abb = abb;
		this.emailId = emailId;
		this.password=password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public String getAbb() {
		return abb;
	}
	public String getPassword() {
		return password;
	}

	public String getEmailId( ) {
		return emailId;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public void setAbb(String abb) {
		this.abb =abb;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", user=" + user + ", abb=" + abb + ", email=" + emailId +", passwoed=" + password + "]";
	}

    public void forEach(Object object) {
    }
}
