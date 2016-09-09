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

import com.nop.ultilities.Utilities;


@Entity
@Table(name = "Person")
public class Person implements Serializable {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="PERSON_ID", nullable=false, unique=true)
	 private int personID;
	
	@Column(name="PERSON_NAME",nullable=false)
	private  String personName;
	
	@Column(name="PERSON_EMAIL",nullable=true)
	private String personEmail;
	
	
//	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "persons")
//	private List<Bill> lstPaiedBill;
	
	@Transient
	private double amountMoneyMustPay=0;

	@Transient
	private double amountMoneyAlreayPaid=0;
	
	@Transient
	private double amountMoneyTotalinAMonth=0;
	
	@Transient
	private String amountMoneyMustPayStringValue;
	
	@Transient
	private String amountMoneyAlreayPaidStringValue;
	
	@Transient
	private String amountMoneyTotalinAMonthStringValue;
	
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
		this.setAmountMoneyMustPayStringValue(Utilities.roundUpMoneyToString(amountMoneyMustPay));
	}

	public double getAmountMoneyAlreayPaid() {
		return amountMoneyAlreayPaid;
	}

	public void setAmountMoneyAlreayPaid(double amountMoneyAlreayPaid) {
		this.amountMoneyAlreayPaid = amountMoneyAlreayPaid;
		this.setAmountMoneyAlreayPaidStringValue(Utilities.roundUpMoneyToString(amountMoneyAlreayPaid));
	}

	public double getAmountMoneyTotalinAMonth() {
		return amountMoneyTotalinAMonth;
	}

	public void setAmountMoneyTotalinAMonth(double amountMoneyTotalinAMonth) {
		this.amountMoneyTotalinAMonth = amountMoneyTotalinAMonth;
		this.setAmountMoneyTotalinAMonthStringValue(Utilities.roundUpMoneyToString(amountMoneyTotalinAMonth));
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
		this.setAmountMoneyAlreayPaidStringValue(Utilities.roundUpMoneyToString(amountMoneyAlreayPaid));
	}

	public String getAmountMoneyMustPayStringValue() {
		return amountMoneyMustPayStringValue;
	}

	public String getAmountMoneyAlreayPaidStringValue() {
		return amountMoneyAlreayPaidStringValue;
	}

	public String getAmountMoneyTotalinAMonthStringValue() {
		return amountMoneyTotalinAMonthStringValue;
	}

	public void setAmountMoneyMustPayStringValue(
			String amountMoneyMustPayStringValue) {
		this.amountMoneyMustPayStringValue = amountMoneyMustPayStringValue;
	}

	public void setAmountMoneyAlreayPaidStringValue(
			String amountMoneyAlreayPaidStringValue) {
		this.amountMoneyAlreayPaidStringValue = amountMoneyAlreayPaidStringValue;
	}

	public void setAmountMoneyTotalinAMonthStringValue(
			String amountMoneyTotalinAMonthStringValue) {
		this.amountMoneyTotalinAMonthStringValue = amountMoneyTotalinAMonthStringValue;
	}

	public String getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}
	
	
}
