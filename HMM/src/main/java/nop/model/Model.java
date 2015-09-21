package nop.model;

import java.awt.List;
import java.util.ArrayList;
import nop.dto.*;

import nop.dto.Person;

public class Model {
	public static Model instance;
	private static ArrayList<Person> lstPersons=new ArrayList<Person>();
	private static ArrayList<Bill> lstBills =new  ArrayList<Bill>();
	private static ArrayList<Bill> lstTemplateBills =new  ArrayList<Bill>();
	
	public Model(){
		addPerson();
	}
	
	public static Model getInstance(){
		if(instance==null)
			return instance=new Model();
		return instance;
	}
	
	public ArrayList<Person> getListPersons(){
		return this.lstPersons;
	}
	
	public ArrayList<Bill> getListBills(){
		return this.lstBills;
	}
	
	public void setListPerson(ArrayList lstPersons){
		this.lstPersons=lstPersons;
	}
	
	public void setListBill(ArrayList lstBill){
		this.lstBills=lstBill;
	}
	
	public void addBill(){
		Bill elec=new Bill("Elec", "10/2015", 320000.0, 1);
		Bill water=new Bill("Elec", "10/2015", 200000.0, 1);
		Bill rent1=new Bill("Rent Nop", "10/2015", 900000.0, 1);
		Bill rent2=new Bill("Rent No", "10/2015", 900000.0, 2);
		Bill rent3=new Bill("Rent Be", "10/2015", 120000.0, 3);
		
		
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
