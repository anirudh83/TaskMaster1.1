package com.example.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.common.CommonUtils;
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
		TaskForm task = (TaskForm)model;

		ValidationUtils.rejectIfEmpty(errors, "date", "date.cannot.empty");
		ValidationUtils.rejectIfEmpty(errors, "name", "name.cannot.empty");
		ValidationUtils.rejectIfEmpty(errors, "description", "description.cannot.empty");
		if(!errors.hasFieldErrors("date")){
			try{
				CommonUtils.getFormattedDate(task.getDate());
			}catch(Exception e){
				errors.rejectValue("date", "date.format.invalid");
			}
		}
	}

}
