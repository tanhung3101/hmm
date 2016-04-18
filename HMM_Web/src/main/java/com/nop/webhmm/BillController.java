package com.nop.webhmm;

import java.util.List;
import java.util.Locale;

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

import com.google.gson.Gson;
import com.nop.DTO.TemplateBill;
import com.nop.services.CommonService;
import com.nop.ultilities.Utilities;

@Controller
public class BillController {
	private static final Logger logger = LoggerFactory.getLogger(TemplateBillController.class);
	private static final String VIEWS_FOLER="template_bill";

	@Autowired
	public CommonService comService;
	
	@RequestMapping(value="/bill",method=RequestMethod.GET)
	public String template_bill(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		
		try {
			if(!Utilities.validteSessionLogin(session)) return "redirect:/login";
			
			List<TemplateBill> lstTempBill=comService.getTemplateBills();
			if(lstTempBill!=null){
				Gson gson = new Gson();
				 // convert your list to json
				 String jsonCartList = gson.toJson(lstTempBill);
//				request.setAttribute("lstTempBill", jsonCartList);
				
				jsonCartList="{\"Result\":\"OK\",\"Records\":"+jsonCartList+"}";
				response.setContentType("application/json");
				response.getWriter().print(jsonCartList);
			}

			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		
		return VIEWS_FOLER+"/template_bill";
	}
	
}
