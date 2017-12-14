package com.nop.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nop.entity.Bill;
import com.nop.services.CommonService;

@Component
public class BillFormValidator implements Validator {

	
	@Autowired
	public CommonService comService;
	
	
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Bill.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		Bill bill=(Bill) target;	
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty.billForm.description");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "month", "NotEmpty.billForm.month");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amountMoney", "NotEmpty.billForm.amountMoney");
		
		
		if(bill.getDescription()==null || bill.getDescription().length()==0){
			errors.rejectValue("description", "NotEmpty.billForm.description");
		}
		
		if(bill.getMonth()==null || bill.getMonth().length()==0){
			errors.rejectValue("month", "NotEmpty.billForm.month");
		}
//		
		if (bill.getAmountMoney()==null || bill.getAmountMoney()==0) {
			errors.rejectValue("amountMoney", "NotEmpty.billForm.amountMoney");
		}
	}

}
