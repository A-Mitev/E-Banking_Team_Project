package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.UserDAO;
import com.example.exception.UserException;
import com.example.model.User;

@Controller
@RequestMapping(value = "/newPassword")
public class NewPasswordController {
	
	@RequestMapping(method = RequestMethod.POST)
	public String changePass(User newPassword, Model model, HttpSession session) throws UserException {
		UserDAO newPass = new UserDAO();
		
		if (!newPassword.getPassword().equals(newPassword.getRepeatPassword())) {
			model.addAttribute("text","The passwords didn-t match!");
			model.addAttribute("user12", newPassword);
			System.out.println("Stiga l ido redirekta");
			return "PassworReset";
		} 
		
		System.out.println("samo levski ole");
		newPass.updadeUserPassword((String)session.getAttribute("email"), newPassword.getRepeatPassword());
		
		System.out.println(session.getAttribute("email"));
		model.addAttribute("passChanged","The passwor has been changed successfully!");
		
		return "index";
	

}
}

