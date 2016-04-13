package com.nop.webhmm;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nop.Constant.Constant;
import com.nop.DTO.User;
import com.nop.services.CommonService;
import com.nop.services.CommonServiceImpl;

@Controller
@Scope("session")
public class LoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	public CommonService comService;
	
	public LoginController() {

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpSession session) {
		logger.info("init program.");
		User loginUser=(User) session.getAttribute(Constant.LOGIN_USER);
		if(loginUser!=null){
			return "redirect:/home";
		}
		return "loginForm";
	}
	

	@RequestMapping(value = "/submitLoginForm", method = RequestMethod.POST)
	public ModelAndView submitLoginForm(
			@ModelAttribute("userLogin") User userLogin,HttpSession session) {

		ModelAndView view = new ModelAndView("loginSucess");
		String userName = userLogin.getUserName();
		String pass = userLogin.getUserPassword();
		try {
			User loginUser= this.comService.findUserByUserName(userName);
			if (loginUser!=null && loginUser.getUserPassword().equals(pass)) {
				view.setViewName("redirect:../home");
				session.setAttribute("loginUser", loginUser);
				
			} else {
				view.setViewName("redirect:/login");
			}
			view.addObject("msg", "UserName :" + userName + "\n Password:"
					+ pass);
			view.addObject("userName", userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return view;

	}
}
