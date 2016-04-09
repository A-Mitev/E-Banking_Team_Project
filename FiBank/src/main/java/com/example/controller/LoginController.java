package com.example.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.dao.UserDAO;
import com.example.exception.UserException;
import com.example.model.User;
@Controller
@RequestMapping(value="/index")
public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9075837470601406564L;

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(Model model) {
		model.addAttribute("text", "Hello, please login!");
		return "index";
	}	
	
	@RequestMapping(method = RequestMethod.POST)
	public String userAuthentication(HttpServletRequest request,@RequestParam("email")String email,
			@RequestParam("pass") String pass, Model model) throws UserException{
		    UserDAO client = new UserDAO();
		    if(client.isUserExcisting(email, pass) != null){
			String id = client.isUserExcisting(email, pass).getId();
			String name = client.isUserExcisting(email, pass).getName();
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("id", id);
			
			session.setMaxInactiveInterval(1);
			
			return "Home";
		} else {
			model.addAttribute("text1", "Username ot password - invalid."
					+ " Please check and try again!");
			return "index";
		}
	}
	
}
