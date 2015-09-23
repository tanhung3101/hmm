package nop.model;

import java.awt.List;
import java.util.ArrayList;
import nop.dto.*;

import nop.dto.Person;
	public class Model {

		public static Model instance;
	private static ArrayList<Person> lstPersons=new ArrayList<Person>();
	private static ArrayList<Bill> lstBills =new  ArrayList<Bill>();
	private static ArrayList<Bill> lstRentBills =new  ArrayList<Bill>();
	private static ArrayList<Bill> lstTemplateBills =new  ArrayList<Bill>();
	
	public Model(){
		addPerson();
		addBill();
	}
	
	

	public static Model getInstance(){
		if(instance==null)
			return instance=new Model();
		return instance;
	}
	
	public static ArrayList<Bill> getLstTemplateBills() {
		return lstTemplateBills;
	}

	public static void setLstTemplateBills(ArrayList<Bill> lstTemplateBills) {
		Model.lstTemplateBills = lstTemplateBills;
	}
	
	public ArrayList<Person> getListPersons(){
		return this.lstPersons;
	}
	
	public ArrayList<Bill> getListBills(){
		return this.lstBills;
	}
	
	public static ArrayList<Bill> getListRentBills() {
		return lstRentBills;
	}

	public static void setListRentBills(ArrayList<Bill> lstRentBills) {
		Model.lstRentBills = lstRentBills;
	}

	public void setListPerson(ArrayList lstPersons){
		this.lstPersons=lstPersons;
	}
	
	public void setListBill(ArrayList lstBill){
		this.lstBills=lstBill;
	}
	
	public void addBill(){
		Bill elec=new Bill(1,"Elec", "10/2015", 320000.0, 1);
		Bill water=new Bill(2,"Elec", "10/2015", 200000.0, 1);
		
		lstBills.add(elec);
		lstBills.add(water);
		
		Bill rent1=new Bill(3,"Rent Nop", "10/2015", 900000.0, 1);
		Bill rent2=new Bill(4,"Rent No", "10/2015", 900000.0, 2);
		Bill rent3=new Bill(5,"Rent Be", "10/2015", 1200000.0, 3);
		
		lstRentBills.add(rent1);
		lstRentBills.add(rent2);
		lstRentBills.add(rent3);
	}
	
	public void addPerson(){
		Person nop=new Person(1,"Nop",24);
		Person no=new Person(2,"No",26);
		Person be=new Person(3,"Be Em",28);
		
		lstPersons.add(nop);
		lstPersons.add(no);
		lstPersons.add(be);
	}
	
	
	
}
