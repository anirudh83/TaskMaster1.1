package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.form.UserForm;
import com.example.model.User;
import com.example.service.UserService;
import com.example.validator.UserValidator;


/**
 * 
 * @author anirudh
 * 
 */
@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value="/createuser" , method = RequestMethod.GET)
	public String showCreateUserPage(Model model) {
		UserForm user = new UserForm();
		model.addAttribute("user", user);
		return "createUser";
	}

	/**
	 * POST request to create User
	 * 
	 * @param modell
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") UserForm user,
			BindingResult errors,HttpSession session) {

		userValidator.validate(user, errors);

		if (!errors.hasErrors()) {
			User newUser = populateUserFromForm(user);
			userService.createUser(newUser);
			session.setAttribute("user", newUser);
			return "home";
		} else {
			return "createUser";
		}
	}

	private User populateUserFromForm(UserForm user) {
		User newUser = new User();
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		newUser.setEmail(user.getEmail());
		return newUser;
	}
	
	private UserForm transform(User user){
		UserForm newUser = new UserForm();
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		newUser.setEmail(user.getEmail());
		return newUser;
	}
	
	/**
	 * Returns JSON data
	 * @param id
	 * @return
	 */

	@RequestMapping(value="/json/{id}" , method =RequestMethod.GET )
    @ResponseBody
	public UserForm getUserInJSon(@PathVariable String id){
		User userById = userService.getUserById(Long.valueOf(id));
		if(userById!=null){
			System.out.println("there is result");
			return transform(userById);
		}else{
			System.out.println("empty");
			return new UserForm();
			
		}
		 
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getUsers(Model model){
		 List<User> users = userService.getUsers();
		 model.addAttribute("users", users);
		 return "searchUsers";
	}
	
	
}
