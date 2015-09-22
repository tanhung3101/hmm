package nop.controller;

import nop.dto.Bill;
import nop.dto.Person;

public class Utility {
	
	public static double parseInDouble(Object value){
		double result=0;
			if(value==null) return 0;
			else
			if(value.toString().length()==0) return 0;
			else
				result=Double.valueOf(value.toString());
		return result;
	}
	
	public static Person copyPerson(Person source){
		Person value=null;
		if(source!=null){
			value.setId(source.getId());
			value.setName(source.getName());
			value.setAge(source.getAge());
		}
		return value;
	}
	
	public static Bill copyBill(Bill source){
		Bill value=null;
		if(source!=null){
			value=new Bill();
			value.setBillID(source.getBillID());
			value.setName(source.getName());
			value.setAmountMoney(source.getAmountMoney());
			value.setMonth(source.getMonth());
			value.setPayerID(source.getPayerID());
		}
		return value;
	}
}
