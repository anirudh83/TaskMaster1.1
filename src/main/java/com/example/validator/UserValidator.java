package com.example.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.form.UserForm;
import com.example.service.UserService;

/**
 * 
 * @author anirudh
 *
 */
@Component
public class UserValidator implements Validator{
	
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> supoprtedClassName) {
		return UserForm.class.equals(supoprtedClassName);
	}

	@Override
	public void validate(Object model, Errors errors) {
		UserForm user = (UserForm)model;
		ValidationUtils.rejectIfEmpty(errors, "firstName", "firstname.not.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "email.not.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "password.not.empty");
		
		if(!errors.hasErrors()){
			if(userService.getUserByEmail(user.getEmail())!=null){
				errors.rejectValue("email", "user.already.exists");
			}
		}
		
	}

}
