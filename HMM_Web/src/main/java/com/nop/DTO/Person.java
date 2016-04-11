package com.nop.DTO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Person")
public class Person implements Serializable {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="PERSON_ID", nullable=false, unique=true)
	 private int personID;
	
	@Column(name="PERSON_NAME",nullable=false)
	private  String personName;
	
//	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "persons")
//	private List<Bill> lstPaiedBill;
	
	
	
//	public List<Bill> getPaiedBills() {
//		return this.lstPaiedBill;
//	}
	
	public Person(){
		
	}
	
	public Person(String personName) {
		this.personName = personName;
	}
	
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public String getPersonName() {
		return personName;
	}
	
	public void setPersonName(String personName) {
		this.personName = personName;
	}


}
