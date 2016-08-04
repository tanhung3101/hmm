package com.nop.webhmm;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nop.Constant.Constant;
import com.nop.DTO.Bill;
import com.nop.DTO.Person;
import com.nop.DTO.User;
import com.nop.services.CommonService;
import com.nop.ultilities.Utilities;

@Controller
public class CalculatePageController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@Autowired
	public CommonService comService;
	
	private static final String VIEWS_FOLER="calculatePage";
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/calculate", method = RequestMethod.GET)
	public String showPage(Locale locale, Model model,HttpSession session) {
		
		try {
			if(!Utilities.validteSessionLogin(session)) return "redirect:/login";
			
		
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		model.addAttribute("isCalculated","false");
		
		return VIEWS_FOLER+"/calculate";
	}
	
	
	@RequestMapping(value = "/calculate", method = RequestMethod.POST)
	public String doCalculationHMM(@RequestParam(value="month") String month,Model model,HttpSession session){
		
		//month=05/2016
		
		try{
			//get list bill by month
			model.addAttribute("isCalculated","true");
			model.addAttribute("monthCalculate",month);
			
			if(month.trim().length()>0){
				model.addAttribute("isHasRecord","true");
				List<Bill> lstBill=this.comService.getBillsByMonth(month);
				List<Person> lstPersonInHouse=this.comService.getPersons();
				int numberPersonInHouse=lstPersonInHouse.size();
				double totalAmountMoneyAllPerson=0;
				if(lstBill==null){
					model.addAttribute("isHasRecord","false");
					return VIEWS_FOLER+"/calculate";
				}
				for(Bill eachBill:lstBill){
					totalAmountMoneyAllPerson+=eachBill.getAmountMoney();
					eachBill.setAmountMoneyStringValue(Utilities.convertDoubleToMoney(eachBill.getAmountMoney()));
				}
				
				double totalEachPersonMustPay=totalAmountMoneyAllPerson/numberPersonInHouse;
				setAmountMoneyAlreadyPaidToPerson(lstBill,lstPersonInHouse);
				for(Person eachPerson:lstPersonInHouse){
					eachPerson.setAmountMoneyTotalinAMonth(totalEachPersonMustPay);
					eachPerson.setAmountMoneyMustPay(eachPerson.getAmountMoneyTotalinAMonth()-eachPerson.getAmountMoneyAlreayPaid());
				}
				
				for(Person eachPerson:lstPersonInHouse){
					System.out.println("Person:"+eachPerson.getPersonName());
					System.out.println("TotalinAMonth:"+eachPerson.getAmountMoneyTotalinAMonth());
					System.out.println("AleadyPaid:"+eachPerson.getAmountMoneyAlreayPaid());
					System.out.println("MustPaid:"+eachPerson.getAmountMoneyMustPay());
				}
				model.addAttribute("personInHouse",lstPersonInHouse);
				model.addAttribute("lstBills",lstBill);
				model.addAttribute("totalAmountInMonth",Utilities.roundUpMoneyToString(totalAmountMoneyAllPerson));
				
			}else{
				model.addAttribute("isHasRecord","false");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return VIEWS_FOLER+"/calculate";
	}
	
	public void setAmountMoneyAlreadyPaidToPerson(List<Bill> lstBill,List<Person> lstPerson){
		
		for(int i=0;i<lstBill.size();i++){
			Bill itemBill=lstBill.get(i);
			if(itemBill.getPayer()!=null){
				for(int j=0;j<lstPerson.size();j++){
					Person itemPerson=lstPerson.get(j);
					if( itemBill.getPayer().getPersonID()==itemPerson.getPersonID()){
						itemPerson.addAmountMoneyAlreadyPaid(itemBill.getAmountMoney());
					}
				}
			}
		}
		
	}
}
