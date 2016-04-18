package com.nop.webhmm;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.nop.DTO.Json;
import com.nop.DTO.JsonResult;
import com.nop.DTO.Person;
import com.nop.DTO.TemplateBill;
import com.nop.services.CommonService;
import com.nop.ultilities.Utilities;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	private static final String FOLDER="user";
	@Autowired
	public CommonService comService;
	
	public UserController(){
		
	}
	
	@RequestMapping(value="/user", method= RequestMethod.GET)
	public String profile(HttpSession session, HttpServletRequest request, HttpServletResponse response){

		try {
			if(!Utilities.validteSessionLogin(session)) return "redirect:/login";
			
			List<Person> lstPerson=comService.getPersons();
			if(lstPerson!=null){
				Gson gson = new Gson();
				 // convert your list to json
				 String jsonCartList = gson.toJson(lstPerson);
				jsonCartList="{\"Result\":\"OK\",\"Records\":"+jsonCartList+"}";
				response.setContentType("application/json");
				response.getWriter().print(jsonCartList);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return FOLDER+"/users";
	}
	
	
	@RequestMapping(value="/user/list",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public 	JsonResult   PersonList()
    {
        try{
            //Get data from database
            int userCount = comService.getPersons().size();
            List<Person> lstPerson =                                                    
            		comService.getPersons();
            //Return result to jTable
            return new Json("OK",lstPerson,userCount );
        }catch(Exception e){
                return null;
          }
    }
	
	@RequestMapping(value="/user/create",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public 	JsonResult   createPerson(@ModelAttribute Person temp)
    {
        	 try
             {
        		 Person addedPerson=this.comService.addPerson(temp);
                 return new  Json("OK",addedPerson);
             }
             catch (Exception ex)
             {
                 return new  Json("ERROR",ex);
             }
            
                 
    }
	
	
	@RequestMapping(value="/user/update",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public 	JsonResult updateTemplateBill(@ModelAttribute Person temp)
    {
        	 try
             {
        		 this.comService.updatePerson(temp);
                 return new  Json("OK");
             }
             catch (Exception ex)
             {
                 return new  Json("ERROR",ex);
             }
            
                 
    }
	
	
	@RequestMapping(value="/user/delete",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public 	JsonResult deleteTemplateBill(@ModelAttribute Person temp)
    {
        	 try
             {
        		 this.comService.deletePerson(temp);
                 return new  Json("OK");
             }
             catch (Exception ex)
             {
                 return new  Json("ERROR",ex);
             }
            
                 
    }
	
	
	
		
}
