package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.IUserDAO;
import com.example.dao.UserDAO;
import com.example.exception.UserException;
import com.example.model.User;



@Controller
@RequestMapping(value = "/codeCheck")
public class CodecheckAndPassRenewController {
	
	@RequestMapping( method = RequestMethod.POST)
	public String codeCheck(Model model, @RequestParam("code") String code,HttpServletRequest request)  {
		if(request.getSession() == null){
			return "index";
		}
		String email = (String) request.getSession().getAttribute("email");
		IUserDAO user = new UserDAO();
		try {
			if(user.emailConfirmationCodeMatch(email, code)){
				User newPassword= new User();
				model.addAttribute("user12", newPassword);
			return "PassworReset";
			} else {
				model.addAttribute("noConfirmation", "Wrong combination of email and confirmation code");
				request.getSession().invalidate();
				return "index";
			}
		} catch (UserException e) {
			return "Error";
		}
	}

}
