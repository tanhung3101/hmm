package com.nop.webhmm;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nop.services.CommonService;

@Controller
public class ProfileController {
	

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	private static final String FOLDER="profile";
	@Autowired
	public CommonService comService;
	
	public ProfileController(){
		
	}
	
	@RequestMapping(value="/profile", method= RequestMethod.GET)
	public ModelAndView profile(HttpSession session){
		ModelAndView view =new ModelAndView();

		view.setViewName(FOLDER+"/profileDetail");
		
		return view;
		
		
		
	}
}
