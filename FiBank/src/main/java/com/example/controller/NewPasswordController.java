package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.IUserDAO;
import com.example.dao.UserDAO;
import com.example.exception.UserException;
import com.example.model.User;

@Controller
@RequestMapping(value = "/newPassword")
public class NewPasswordController {
	
	@RequestMapping(method = RequestMethod.POST)
	public String changePass(User newPassword, Model model, HttpSession session) {
		IUserDAO newPass = new UserDAO();
		
		if (!newPassword.getPassword().equals(newPassword.getRepeatPassword())) {
			model.addAttribute("text","The passwords didn-t match!");
			model.addAttribute("user12", newPassword);
			return "PassworReset";
		} 
		
		try {
			newPass.updadeUserPassword((String)session.getAttribute("email"), User.hashPasswordWithMD5(newPassword.getRepeatPassword()));
		} catch (UserException e) {
			return "Error";
			
		} catch (Exception e) {
			return "Error";
		}
		System.out.println(session.getAttribute("email"));
		model.addAttribute("passChanged","The passwor has been changed successfully!");
		
		return "index";

}
}

