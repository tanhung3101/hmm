package nop.dto;

public class PersonBill {
	double amountPay=0;
	double prePay=0;
	Person person;
	
	public PersonBill(Person person){
		this.person=person;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public double getAmountPay() {
		return amountPay;
	}
	public void setAmountPay(double amountPay) {
		this.amountPay = amountPay;
	}
	public double getPrePay() {
		return prePay;
	}
	public void setPrePay(double prePay) {
		this.prePay = prePay;
	}
	
	public double getHasToPay(){
		return amountPay-prePay;
	}
}
