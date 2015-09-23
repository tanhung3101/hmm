package nop.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import nop.dto.Bill;
import nop.dto.Person;
import nop.dto.PersonBill;
import nop.model.Model;

public class Controller {
	
	public Model model;
	BusinessService service;
	
	public Controller(){
		model=Model.getInstance();
		service=new BusinessService();
	}
	
	public Model getModel(){
		return this.model;
	}
	
	public void loadData(){
		loadPerson();
		loadBill();
		loadTemplateBill();
	}
	
	public void saveRentBill(){
		 try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(UltilConstance.RENT_BILL_DB));
            outputStream.writeObject(model.getListRentBills());
        } catch (IOException ex) {
       	 System.out.println(ex);
        } finally {
        }
	}
	
	public void loadRentBill(){
		try{
			ObjectInputStream inputStream =new ObjectInputStream(new FileInputStream(UltilConstance.RENT_BILL_DB));
			model.setListRentBills(((ArrayList<Bill>)inputStream.readObject()));
		}catch(Exception ex){
			
		}
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
			FileInputStream file=new FileInputStream(UltilConstance.PERSON_DB);
			if(file==null){
				return;
			}
			ObjectInputStream inputStream =new ObjectInputStream(new FileInputStream(UltilConstance.PERSON_DB));
			model.setListPerson((ArrayList<Person>)inputStream.readObject());
		}catch(Exception ex){
			
		}
	}
	
	
	public void saveBill(){
		try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(UltilConstance.BILL_DB));
            outputStream.writeObject(model.getListBills());
        } catch (IOException ex) {
       	 System.out.println(ex);
        } finally {
        }
	}
	
	public void loadBill(){
		try{
			FileInputStream file=new FileInputStream(UltilConstance.BILL_DB);
			if(file==null){
				return;
			}
			ObjectInputStream inputStream =new ObjectInputStream(new FileInputStream(UltilConstance.BILL_DB));
			model.setListBill((ArrayList<Person>)inputStream.readObject());
		}catch(Exception ex){
			
		}
	}
	
	public void saveTemplateBill(){
		try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(UltilConstance.TEMPLATE_BILL_DB));
            outputStream.writeObject(model.getLstTemplateBills());
        } catch (IOException ex) {
       	 System.out.println(ex);
        } finally {
        }
	}
	
	public void loadTemplateBill(){
		try{
			
			if(Utility.isExistedFile(UltilConstance.TEMPLATE_BILL_DB)){
			
			FileInputStream fileInput=new FileInputStream(UltilConstance.TEMPLATE_BILL_DB);
			
			ObjectInputStream inputStream =new ObjectInputStream(fileInput);
			model.setLstTemplateBills((ArrayList<Bill>)inputStream.readObject());
			}
		}catch(Exception ex){
			 System.out.println(ex);
		}
	}
	
	public void calculatePersonWithBill(String selectedMonth){
		ArrayList<PersonBill> lstPersonBill =getPersonWithBill(selectedMonth);
		
		for(PersonBill pb:lstPersonBill){
			System.out.println(pb.getPerson().getName()+" - "+ (int)pb.getHasToPay()+" VND");
		}
	}
	
	public ArrayList<PersonBill> getPersonWithBill(String selectedMonth){
		ArrayList<PersonBill> lstPersonBill =new ArrayList<PersonBill>();
		double avgAmountEachPerson=service.calculateNormalBill(model.getListBills(), model.getListPersons().size());
		HashMap lstRentforEachPerson=service.calculateRentBill(model.getListRentBills());
		ArrayList<Bill> lstBillsByMonths=filterBillsByMonth(selectedMonth);
		for(Person person:model.getListPersons()){
			if(person!=null){
				PersonBill pb=new PersonBill(person);
				for(int i=0;i<lstRentforEachPerson.size();i++){
					if(lstRentforEachPerson.containsKey(person.getId())){
						pb.setAmountPay(avgAmountEachPerson+ Utility.parseInDouble(lstRentforEachPerson.get(person.getId())));
					}
				}
				lstPersonBill.add(pb);
			}
		}
		
		for(PersonBill pb:lstPersonBill){
			for(Bill bill:lstBillsByMonths){
				if(bill.getPayerID()==pb.getPerson().getId())
					pb.setPrePay(pb.getPrePay()+bill.getAmountMoney());
			}
		}
		return lstPersonBill;
	}
	
	public ArrayList filterBillsByMonth(String selectedMonth){
		ArrayList<Bill> lstBillsByMonth =new ArrayList<Bill>();
		for(Bill bill:model.getListBills()){
			if(bill.getMonth().equals(selectedMonth)){
				lstBillsByMonth.add(Utility.copyBill(bill));
			}
		}
		return 	lstBillsByMonth;	
	}
	
	public void addObjectToTemplateList(Bill bill){
		try{
			model.getLstTemplateBills().add(bill);
			saveTemplateBill();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	
}
