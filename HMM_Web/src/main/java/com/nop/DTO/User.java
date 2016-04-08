package com.nop.DTO;

import javax.persistence.*;


@Entity
@Table(name = "User")
public class User {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="USER_ID", nullable=false, unique=true)
	private int userID;
	
	@Column(name = "USER_NAME", nullable =false)
	private String userName;
	
	@Column(name = "USER_PASSWORD", nullable =false)
	private String userPassword;
	
	
	
	public User(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
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
