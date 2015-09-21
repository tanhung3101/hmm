package nop.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import nop.dto.Person;
import nop.model.Model;

public class Controller {
	
	public Model model;
	BusinessService service;
	
	public Controller(){
		model=Model.getInstance();
		service=new BusinessService();
	}
	
	public void loadData(){
		
	}
	
	
	public void savePerson(){
		 try {
             ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(UltilConstance.PERSON_DB));
             outputStream.writeObject(model.getListPersons());
         } catch (IOException ex) {
        	 System.out.println(ex);
         } finally {
         }
	}
	
	public void loadPerson(){
		try{
			ObjectInputStream inputStream =new ObjectInputStream(new FileInputStream(UltilConstance.PERSON_DB));
			model.setListPerson((ArrayList<Person>)inputStream.readObject());
		}catch(Exception ex){
			
		}
	}
	
	
	public void saveBill(){
		try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(UltilConstance.BILL_DB));
            outputStream.writeObject(model.getListPersons());
        } catch (IOException ex) {
       	 System.out.println(ex);
        } finally {
        }
	}
	
	public void loadBill(){
		try{
			ObjectInputStream inputStream =new ObjectInputStream(new FileInputStream(UltilConstance.PERSON_DB));
			model.setListPerson((ArrayList<Person>)inputStream.readObject());
		}catch(Exception ex){
			
		}
	}
	
	public void saveTemplateBill(){
		try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(UltilConstance.TEMPLATE_BILL_DB));
            outputStream.writeObject(model.getListPersons());
        } catch (IOException ex) {
       	 System.out.println(ex);
        } finally {
        }
	}
	
	public void loadTemplateBill(){
		try{
			ObjectInputStream inputStream =new ObjectInputStream(new FileInputStream(UltilConstance.TEMPLATE_BILL_DB));
			model.setListPerson((ArrayList<Person>)inputStream.readObject());
		}catch(Exception ex){
			
		}
	}
	
	
	
}
