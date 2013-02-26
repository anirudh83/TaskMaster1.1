package com.example.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.form.TaskForm;

/**
 * 
 * @author anirudh
 *
 */
@Component
public class TaskValidator implements Validator{

	//Can this validator validate this class?
	@Override
	public boolean supports(Class<?> inputClass) {
		return TaskForm.class.equals(inputClass);
	}

	@Override
	public void validate(Object model, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "name.cannot.empty");
		ValidationUtils.rejectIfEmpty(errors, "date", "date.cannot.empty");
		ValidationUtils.rejectIfEmpty(errors, "description", "description.cannot.empty");
	}

}
