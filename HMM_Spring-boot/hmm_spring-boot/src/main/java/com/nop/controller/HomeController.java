package com.nop.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nop.Constant.Constant;
import com.nop.entity.Bill;
import com.nop.entity.Person;
import com.nop.entity.User;
import com.nop.services.BillService;
import com.nop.services.CommonService;
import com.nop.services.SecurityService;

/**
 * Handles requests for the application home page.
 */
@Controller
//@Scope("session")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@Autowired
	public CommonService comService;
	
	@Autowired
	public BillService billService;
	
	@Autowired
	SecurityService securityService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, ModelAndView model,HttpSession session) {
		
		
		String loginUser = securityService.findLoggedInUsername();
		if(loginUser==null){
//			return "redirect:/login";
		}
		
		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public void doCalculationHMM(@RequestParam(value="month") String month,Model model,HttpSession session){
		
		//month=05/2016
		
		try{
			//get list bill by month
			model.addAttribute("isCalculated","true");
			model.addAttribute("monthCalculate",month);
			List<Bill> lstBill=this.billService.getBills();
			List<Person> lstPersonInHouse=this.comService.getPersons();
			int numberPersonInHouse=lstPersonInHouse.size();
			double totalAmountMoneyAllPerson=0;
			for(Bill eachBill:lstBill){
				totalAmountMoneyAllPerson+=eachBill.getAmountMoney();
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
		}catch(Exception ex){
			ex.printStackTrace();
		}
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