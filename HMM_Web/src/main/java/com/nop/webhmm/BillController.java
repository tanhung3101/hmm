package com.nop.webhmm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nop.DTO.Bill;
import com.nop.DTO.Person;
import com.nop.DTO.TemplateBill;
import com.nop.services.CommonService;
import com.nop.ultilities.Utilities;
import com.nop.validator.BillFormValidator;

@Controller
public class BillController {
	private static final Logger logger = LoggerFactory.getLogger(TemplateBillController.class);
	private static final String VIEWS_FOLER="bill";

	@Autowired
	public CommonService comService;
	
	@Autowired
	private BillFormValidator billFormValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(billFormValidator);
	}
	
	
	@RequestMapping(value="/bill",method=RequestMethod.GET)
	public String showBillPage(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response){
		
		try {
			if(!Utilities.validteSessionLogin(session)) return "redirect:/login";
			
		List<Bill> lstBill=comService.getBills();	
		
		if (lstBill == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Bill not found");
		}
		
		model.addAttribute("lstBills",lstBill);
		
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		
		return VIEWS_FOLER+"/bills";
	}
	
	// save or update user
		@RequestMapping(value = "/bill", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
		public String saveOrUpdateBill(@ModelAttribute("billForm")@Validated Bill bill,
				BindingResult result,Model model, final RedirectAttributes redirectAttributes,HttpServletRequest request) {

			logger.debug("saveOrUpdateUser() : {}", bill);
		

			if (result.hasErrors()) {
				if(bill.getBillID()==0)
				model.addAttribute("status", "create");
				else
					model.addAttribute("status", "update");	
				populateDefaultData(model);
				return VIEWS_FOLER+"/billForm";
			} else {
				redirectAttributes.addFlashAttribute("css", "success");
//				if(status.equals("create")){
//					redirectAttributes.addFlashAttribute("msg", "User added successfully!");
//				}else{
//					redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
//				}
				try {
				
				if(bill.getPayer().getPersonName().equals("NONE")){
					bill.setPayer(null);
				}else if(Utilities.isNumeric(bill.getPayer().getPersonName())){
					int personId=Utilities.parseInt(bill.getPayer().getPersonName());
					Person payer=this.comService.getPersonByID(personId);
					if (payer!=null)
						bill.setPayer(payer);
				}
				
				if(bill.getBillID()>0)
					this.comService.updateBill(bill);
				else
					this.comService.addBill(bill);
//					bill.setDescription("Nước");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// POST/REDIRECT/GET
				return "redirect:/bill";

				// POST/FORWARD/GET
				// return "user/list";

			}

		}
	
		
		// show update form
		@RequestMapping(value = "/bill/{id}", method = RequestMethod.GET)
		public String showDetailBillForm(@PathVariable("id") int id, Model model) {

			logger.debug("showUpdateUserForm() : {}", id);

//			Bill bill find 
			Bill billSelected = null;
			try {
				billSelected=this.comService.getBillByID(id);
				List<Person> lstPersons =this.comService.getPersons();
				model.addAttribute("personList", lstPersons);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			model.addAttribute("billForm", billSelected);
//			
//			populateDefaultModel(model);
			
			return VIEWS_FOLER+"/billForm";

		}
		
		public void populateDefaultData(Model model){
			try{
				List<Person> lstPersons =this.comService.getPersons();
				model.addAttribute("personList", lstPersons);
				
				List<TemplateBill> lstTempBill=this.comService.getTemplateBills();
				model.addAttribute("templateBillList", lstTempBill);
				
			}catch(Exception e){
			}
		}
	
	// show add user form
		@RequestMapping(value = "/bill/add", method = RequestMethod.GET)
		public String showAddNewBill(Model model) {

			logger.info("showAddBillForm()");
			model.addAttribute("status", "create");
			try{

				Bill bill=new Bill();
				
				model.addAttribute("billForm", bill);
			populateDefaultData(model);
			}catch(Exception e){
				return VIEWS_FOLER+"/billForm";
			}
			return VIEWS_FOLER+"/billForm";

		}
		
		//get update User
		@RequestMapping(value = "/bill/{id}/update", method = RequestMethod.GET)
		public String updateBillForm(@PathVariable("id") int id, Model model) {

			logger.info("updateBillForm()");
			model.addAttribute("status", "update");
			try{
				List<Person> lstPersons =this.comService.getPersons();
				model.addAttribute("personList", lstPersons);
				
				List<TemplateBill> lstTempBill=this.comService.getTemplateBills();
				model.addAttribute("templateBillList", lstTempBill);
				
				Bill bill=new Bill();
				bill=this.comService.getBillByID(id);
				model.addAttribute("billForm", bill);
			}catch(Exception e){
				return VIEWS_FOLER+"/billForm";
			}
			
			
		

			return VIEWS_FOLER+"/billForm";

		}

		// delete user
		@RequestMapping(value = "/bill/{id}/delete", method = RequestMethod.POST)
		public String deleteBill(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

			logger.debug("deleteUser() : {}", id);
			
			try {
				this.comService.deleteBill(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "User is deleted!");
			
			return "redirect:/bill";

		}
}
