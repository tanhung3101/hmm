package com.nop.webhmm;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nop.DTO.User;
import com.nop.services.CommonService;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	@Qualifier("CommonServiceImpl")
	private CommonService comService;

	public LoginController() {

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("init program.");

		return "loginForm";
	}

	@RequestMapping(value = "/submitLoginForm", method = RequestMethod.POST)
	public ModelAndView submitLoginForm(
			@ModelAttribute("userLogin") User userLogin) {

		ModelAndView view = new ModelAndView("loginSucess");
		String userName = userLogin.getUserName();
		String pass = userLogin.getUserPassword();
		try {
			User loginUser= this.comService.findUserByUserName(userName);
			if (loginUser!=null && loginUser.getUserPassword().equals(pass)) {
				view.setViewName("loginSucess");
			} else {
				view.setViewName("loginFail");
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
