package com.nop.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.joda.time.DateTime;


@Entity
@Table(name = "HMM_Bill")
public class Bill implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BILL_ID")
	private long billID;

	@Column(name = "BILL_DESCRIPTION")
	private String description;

	@Column(name = "MONTH")
	private String month;

	@Column(name = "AMOUNT_MONEY")
	private double amountMoney;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	@JoinTable(name = "bill_person", joinColumns = { 
//			@JoinColumn(name = "BILL_ID", nullable = false, updatable = true) }, 
//			inverseJoinColumns = { @JoinColumn(name = "PERSON_ID", 
//					nullable = false, updatable = true) })
	private Person payer;
	
	@Column(name = "CREATED_DATE")
	private DateTime createdDate;
	
	@Transient
	private String amountMoneyStringValue;

	

	public Bill() {

	}

	public Bill(int billID, String name) {
		this.billID = billID;
		this.description = name;
	}
	
	public Bill(String name, String month, Double amountMoney) {
		this.description = name;
		this.month = month;
		this.amountMoney = amountMoney;
	}

	public Bill(String name, String month, Double amountMoney,
			Person payer) {
		this.description = name;
		this.month = month;
		this.amountMoney = amountMoney;
		this.payer=payer;
	}

	public DateTime getCreateDate() {
		return createdDate;
	}

	public void setCreateDate(DateTime createDate) {
		this.createdDate = createDate;
	}

	public long getBillID() {
		return billID;
	}

	public void setBillID(long billID) {
		this.billID = billID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String name) {
		this.description = name;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Double getAmountMoney() {
		return amountMoney;
	}
	
	
	public void setAmountMoney(Double amountMoney) {
		this.amountMoney = amountMoney;
//		this.setAmountMoneyStringValue(Utilities.convertDoubleToMoney(this.amountMoney));
	}
	
	public Person getPayer() {
		return this.payer;
	}
	
	public void setPayer(Person p) {
		this.payer =p;
	}
	
	public String getAmountMoneyStringValue() {
		return amountMoneyStringValue;
	}

	public void setAmountMoneyStringValue(String amountMoneyStringValue) {
		this.amountMoneyStringValue = amountMoneyStringValue;
	}

}