package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.User;
import com.example.service.UserService;

/**
 * 
 * @author anirudh
 *
 */
@Controller
@RequestMapping
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginUser(@RequestParam("emailAddress") String email,
			@RequestParam("password") String password,Model model,HttpSession session){
		
		User persistedUser = userService.getUserByEmail(email);
		if(persistedUser!=null && persistedUser.getPassword().equals(password)){
			session.setAttribute("user", persistedUser);
			return "home";
		}else{
			model.addAttribute("error", "Incorrect username or password, Please try again!");
			return "login";
		}
		
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logoutUser(HttpSession session){
		if(session.getAttribute("user")!=null){
			session.invalidate();
		}
		return "index";
	}

	@RequestMapping(value="/showlogin",method=RequestMethod.GET)
	public String showloginPage(){
		return "login";
	}
	
}
