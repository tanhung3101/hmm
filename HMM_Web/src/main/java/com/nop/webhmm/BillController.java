package com.nop.webhmm;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nop.DTO.Bill;
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
	
}
