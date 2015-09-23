package nop.dto;

import java.io.Serializable;
import java.util.Calendar;

public class Bill implements Serializable {
	String name;
	String month;
	double amountMoney;
	int payerID;
	int billID;
	public Bill(){
		
	}
	
	public Bill(int billID,String name){
		this.billID=billID;
		this.name = name;
	}
	
	public Bill(int billID,String name, String month, Double amountMoney, int payerID) {
		super();
		this.billID=billID;
		this.name = name;
		this.month = month;
		this.amountMoney = amountMoney;
		this.payerID = payerID;
	}
	
	public int getBillID() {
		return billID;
	}

	public void setBillID(int billID) {
		this.billID = billID;
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
