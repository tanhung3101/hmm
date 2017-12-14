package com.nop.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nop.Constant.Constant;
import com.nop.entity.User;
import com.nop.services.CommonService;
import com.nop.services.SecurityService;
import com.nop.services.UserService;

@Controller
//@Scope("session")
public class LoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	public CommonService comService;
	
	@Autowired
	public SecurityService securityService;
	
	@Autowired
	public UserService userService;
	
	public LoginController() {

	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, Model model) {
    	String password=userForm.getUserPassword();
        userService.save(userForm);
        securityService.addLoginUserToSession(userForm.getUserName(), password);
        return "redirect:/welcome";
    }
    
    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "home";
    }
	
	@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String home(Locale locale, Model model,HttpSession session) {
//		logger.info("init program.");
////		User loginUser=(User) session.getAttribute(Constant.LOGIN_USER);
//		String loginUser = securityService.findLoggedInUsername();
//		if(loginUser!=null){
//			return "redirect:/home";
//		}
//		return "login/loginForm";
//	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "login/loginForm";
    }
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(Model model, String error, String logout, @ModelAttribute("userForm") User userForm) {
		String password=userForm.getUserPassword();
		if(securityService.addLoginUserToSession(userForm.getUserName(), password)){
			return "home";
		}
        return "login";
    }

	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(Locale locale, Model model,HttpSession session) {
		logger.info("init program.");
		ModelAndView view = new ModelAndView("loginForm");
		view.setViewName("redirect:/login");
		User loginUser=(User) session.getAttribute(Constant.LOGIN_USER);
		session.removeAttribute(Constant.LOGIN_USER);
		return view;
	}
	

//	@RequestMapping(value = "/submitLoginForm", method = RequestMethod.POST)
//	public ModelAndView submitLoginForm(
//			@ModelAttribute("userLogin") User userLogin,HttpSession session) {
//
//		ModelAndView view = new ModelAndView("login/loginSucess");
//		String userName = userLogin.getUserName();
//		String pass = userLogin.getUserPassword();
//		try {
//			User loginUser= this.comService.findUserByUserName(userName);
//			if (loginUser!=null && loginUser.getUserPassword().equals(pass)) {
////				view.setViewName("redirect:../home");
//				view.setViewName("redirect:/home");
//				view.addObject("loginUser", loginUser);
////				appSession.setAttribute("loginUser", loginUser);
//				securityService.autologin(userName, pass);
//			} else {
//				view.setViewName("redirect:/login");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return view;
//
//	}
	
//	@RequestMapping(value = "/submitLoginForm", method = RequestMethod.POST)
//	public String submitLoginForm(
//			@ModelAttribute("userLogin") User userLogin,HttpSession session) {
//		String view = "login/loginSucess";
////		ModelAndView view = new ModelAndView("login/loginSucess");
//		String userName = userLogin.getUserName();
//		String pass = userLogin.getUserPassword();
//		try {
//			User loginUser= this.comService.findUserByUserName(userName);
//			if (loginUser!=null && loginUser.getUserPassword().equals(pass)) {
////				view.setViewName("redirect:../home");
////				view.setViewName("redirect:/home");
////				view.addObject("loginUser", loginUser);
//				appSession.setAttribute("loginUser", loginUser);
//				view = "redirect:/home";
//			} else {
////				view.setViewName("redirect:/login");
//				view = "redirect:/login";
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return view;
//
//	}
	
	
	
}
