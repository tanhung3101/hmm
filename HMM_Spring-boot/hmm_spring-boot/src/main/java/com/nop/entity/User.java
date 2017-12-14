package com.nop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HMM_User")
public class User {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="USER_ID")
	private long userID;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "USER_PASSWORD")
	private String userPassword;
	
//	public User(String userName, String userPassword) {
//		this.userName = userName;
//		this.userPassword = userPassword;
//	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
}
