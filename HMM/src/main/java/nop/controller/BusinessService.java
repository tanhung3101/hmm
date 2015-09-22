package nop.controller;

import java.util.ArrayList;
import java.util.HashMap;

import nop.dto.Bill;

/**
 * 
 * @author HungNHT
 * We do calculate the business rules in here.
 * rules:
 * 
 * Sum of normal bill/ No of person + (Rent Payed of each Person)
 * 
 */
public class BusinessService {
	
	public double calculateNormalBill(ArrayList<Bill> lstBills, int noOfPerson){
		double result=0;
		for(Bill bill: lstBills){
			result+=bill.getAmountMoney();
		}
		return (result/noOfPerson);
	}
	
	public HashMap calculateRentBill(ArrayList<Bill> lstRentBills){
			HashMap map=new HashMap();
			for(Bill bill: lstRentBills){
				map.put(bill.getPayerID(), bill.getAmountMoney());
			}
		return map;
	}
	
}
