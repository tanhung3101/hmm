package nop.controller;

import java.util.ArrayList;

import nop.dto.Person;

public class mainNoGui {
	public static void main(String arg[]){
		Controller control=new Controller();
//		control.savePerson();
		
//	 ArrayList<Person> test= control.model.getListPersons();
//	 test.clear();
//	 System.out.println("SIZE:"+control.model.getListPersons().size());
//	 control.loadPerson();
//	 System.out.println("SIZE:"+control.model.getListPersons().size());
//	 
//	 for(Person s:control.model.getListPersons()){
//		 System.out.println(s.getName());
//	 }
	 control.calculatePersonWithBill("10/2015");
	}
}	
