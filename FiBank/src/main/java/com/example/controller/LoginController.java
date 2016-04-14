package com.example.controller;

import java.sql.Date;
import java.util.Calendar;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.dao.ILogInRecordDAO;
import com.example.dao.IUserDAO;
import com.example.dao.LogInRecordDAO;
import com.example.dao.UserDAO;
import com.example.exception.LogInRecordException;
import com.example.exception.UserException;
import com.example.model.LogInRecord;
import com.example.model.User;
@Controller
@RequestMapping(value="/index")
public class LoginController extends HttpServlet {

	private static final int MAX_INACTIVE_INTERVAL = 6;
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
			@RequestParam("pass") String pass, Model model) {
		    IUserDAO client = new UserDAO();
		    String password;
			try {
				password = User.hashPasswordWithMD5(pass);
			} catch (Exception e) {
				return "Error";
			}
		    pass=null;
		    User user;
			try {
				user = client.isUserExcisting(email, password);
			} catch (UserException e) {
				return "Error";
			}
		    if( user != null){
			String id = user.getId();
			String name = user.getName();
			 HttpSession session = request.getSession(true);
			session.setAttribute("name", name);
			session.setAttribute("id", id);
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL);
			
			LogInRecord log=new LogInRecord(new Date(Calendar.getInstance().getTime().getTime()),user , request.getRemoteAddr());
			ILogInRecordDAO logDAO=new LogInRecordDAO();
			try {
				logDAO.addLogInRecord(log);
			} catch (LogInRecordException e) {
				return "Error";
			}
			
			return "Home";
		} else {
			model.addAttribute("text1", "Username ot password - invalid."
					+ " Please check and try again!");
			return "index";
		}
	}
	
}
