package com.nop.DTO;


import javax.persistence.*;

@Entity
@Table(name="Template_Bill")
public class TemplateBill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BILL_ID", nullable = false, unique = true)
	private int billID;

	@Column(name = "BILL_DESCRIPTION",nullable = false)
	private String description;
	
	public TemplateBill(){
		
	}
	

	public TemplateBill(String description) {
		this.description = description;
	}

	public int getBillID() {
		return billID;
	}

	public void setBillID(int billID) {
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
