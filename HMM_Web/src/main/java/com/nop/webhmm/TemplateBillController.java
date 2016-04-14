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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.nop.DTO.Json;
import com.nop.DTO.JsonResult;
import com.nop.DTO.TemplateBill;
import com.nop.services.CommonService;
import com.nop.ultilities.Utilities;

@Controller
@Scope("request")
public class TemplateBillController {
	
	private static final Logger logger = LoggerFactory.getLogger(TemplateBillController.class);
	private static final String VIEWS_FOLER="template_bill";

	@Autowired
	public CommonService comService;
	
	@RequestMapping(value="/templateBill",method=RequestMethod.GET)
	public String template_bill(Locale locale, Model model,HttpSession session, HttpServletRequest request, HttpServletResponse response){
		
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
	
//	@RequestMapping(value="/templateBill/list",headers = "Accept=application/json")
//    public 	@ResponseBody List<TemplateBill>  StudentList()
//    {
//        try{
//            //Get data from database
//            int studentCount = comService.getTemplateBills().size();
//            List<TemplateBill> students =                                                    
//            		comService.getTemplateBills();
//            //Return result to jTable
////            return new ResponseEntity<Object>(students, HttpStatus.OK);
//            return students;
//            
//                 
//        }catch(Exception e){
//                return null;
//          }
//    }
	
	@RequestMapping(value="/templateBill/list",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public 	JsonResult   StudentList()
    {
        try{
            //Get data from database
            int studentCount = comService.getTemplateBills().size();
            List<TemplateBill> students =                                                    
            		comService.getTemplateBills();
            //Return result to jTable
            return new Json("OK",students,studentCount );
            
                 
        }catch(Exception e){
                return null;
          }
    }
	
	@RequestMapping(value="/templateBill/create",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public 	JsonResult   createTemplateBill(@ModelAttribute TemplateBill temp)
    {
        	 try
             {
        		 TemplateBill addedBill=this.comService.addTemplateBill(temp);
                 return new  Json("OK",addedBill);
             }
             catch (Exception ex)
             {
                 return new  Json("ERROR",ex);
             }
            
                 
    }
	
	
	@RequestMapping(value="/templateBill/update",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public 	JsonResult updateTemplateBill(@ModelAttribute TemplateBill temp)
    {
        	 try
             {
        		 this.comService.updateTemplateBill(temp);
                 return new  Json("OK");
             }
             catch (Exception ex)
             {
                 return new  Json("ERROR",ex);
             }
            
                 
    }
	
	
	@RequestMapping(value="/templateBill/delete",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public 	JsonResult deleteTemplateBill(@ModelAttribute TemplateBill temp)
    {
        	 try
             {
        		 this.comService.deleteTemplateBill(temp);
                 return new  Json("OK");
             }
             catch (Exception ex)
             {
                 return new  Json("ERROR",ex);
             }
            
                 
    }
	
	
	
}
