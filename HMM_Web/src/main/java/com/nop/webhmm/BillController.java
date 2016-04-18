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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nop.DTO.Bill;
import com.nop.DTO.Person;
import com.nop.services.CommonService;
import com.nop.ultilities.Utilities;

@Controller
public class BillController {
	private static final Logger logger = LoggerFactory.getLogger(TemplateBillController.class);
	private static final String VIEWS_FOLER="bill";

	@Autowired
	public CommonService comService;
	
	@RequestMapping(value="/bill",method=RequestMethod.GET)
	public String template_bill(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response){
		
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
		@RequestMapping(value = "/bill", method = RequestMethod.POST)
		public String saveOrUpdateUser(@ModelAttribute("billForm") @Validated Bill bill,
				BindingResult result, Model model, ModelMap modelMap, final RedirectAttributes redirectAttributes,HttpServletRequest request) {

			logger.debug("saveOrUpdateUser() : {}", bill);

			if (result.hasErrors()) {
				return VIEWS_FOLER+"/billForm";
			} else {
//				request.getAttribute("status");
//				redirectAttributes.addFlashAttribute("css", "success");
//				String status =(String) modelMap.get("status");
//				modelMap.containsKey("status");
//				if(status.equals("create")){
//					redirectAttributes.addFlashAttribute("msg", "User added successfully!");
//				}else{
//					redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
//				}
				
				try {
					this.comService.addBill(bill);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// POST/REDIRECT/GET
				return "redirect:/bill/" + bill.getBillID();

				// POST/FORWARD/GET
				// return "user/list";

			}

		}
	
		
		// show update form
		@RequestMapping(value = "/bill/{id}", method = RequestMethod.GET)
		public String showUpdateUserForm(@PathVariable("id") int id, Model model) {

			logger.debug("showUpdateUserForm() : {}", id);

//			Bill bill find 
//			model.addAttribute("userForm", user);
//			
//			populateDefaultModel(model);
			
			return "bill/billform";

		}
	
	// show add user form
		@RequestMapping(value = "/bill/add", method = RequestMethod.GET)
		public String showAddUserForm(Model model) {

			logger.info("showAddBillForm()");
			model.addAttribute("status", "create");
			try{
				List<Person> lstPersons =this.comService.getPersons();
				model.addAttribute("personList", lstPersons);
				
				
				Bill bill=new Bill();
				bill.setDescription("Test123");
				
				
				model.addAttribute("billForm", bill);
			}catch(Exception e){
				return VIEWS_FOLER+"/billForm";
			}
			
			
		

			return VIEWS_FOLER+"/billForm";

		}

	
}
