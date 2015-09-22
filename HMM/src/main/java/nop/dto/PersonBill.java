package nop.dto;

public class PersonBill {
	double amountPay;
	double prePay;
	Person person;
	
	public PersonBill(Person person){
		this.person=person;
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
