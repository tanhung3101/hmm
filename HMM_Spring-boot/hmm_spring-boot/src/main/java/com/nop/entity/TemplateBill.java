package com.nop.entity;


import javax.persistence.*;

@Entity
@Table(name="HMM_Template_Bill")
public class TemplateBill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BILL_ID")
	private long billID;

	@Column(name = "BILL_DESCRIPTION")
	private String description;
	
	public TemplateBill(){
		
	}
	

	public TemplateBill(String description) {
		this.description = description;
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

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString(){
		return this.description;
	}
}
