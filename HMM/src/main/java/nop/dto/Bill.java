package nop.dto;

import java.io.Serializable;
import java.util.Calendar;

public class Bill implements Serializable {
	String name;
	String month;
	Double amountMoney;
	int payerID;
	
	public Bill(String name, String month, Double amountMoney, int payerID) {
		super();
		this.name = name;
		this.month = month;
		this.amountMoney = amountMoney;
		this.payerID = payerID;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	}
	public int getPayerID() {
		return payerID;
	}
	public void setPayerID(int payerID) {
		this.payerID = payerID;
	}
}
