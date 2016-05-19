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
import javax.persistence.Transient;


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
	
	@Transient
	private double amountMoneyMustPay=0;

	@Transient
	private double amountMoneyAlreayPaid=0;
	
	@Transient
	private double amountMoneyTotalinAMonth=0;
	
//	public List<Bill> getPaiedBills() {
//		return this.lstPaiedBill;
//	}
	
	public Person(){
		
	}
	
	public Person(String personName) {
		this.personName = personName;
	}
	
	public double getAmountMoneyMustPay() {
		return amountMoneyMustPay;
	}

	public void setAmountMoneyMustPay(double amountMoneyMustPay) {
		this.amountMoneyMustPay = amountMoneyMustPay;
	}

	public double getAmountMoneyAlreayPaid() {
		return amountMoneyAlreayPaid;
	}

	public void setAmountMoneyAlreayPaid(double amountMoneyAlreayPaid) {
		this.amountMoneyAlreayPaid = amountMoneyAlreayPaid;
	}

	public double getAmountMoneyTotalinAMonth() {
		return amountMoneyTotalinAMonth;
	}

	public void setAmountMoneyTotalinAMonth(double amountMoneyTotalinAMonth) {
		this.amountMoneyTotalinAMonth = amountMoneyTotalinAMonth;
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

	public String toString(){
		return personName;
	}
	
	public void addAmountMoneyAlreadyPaid(double value){
		this.amountMoneyAlreayPaid+=value;
	}
}
