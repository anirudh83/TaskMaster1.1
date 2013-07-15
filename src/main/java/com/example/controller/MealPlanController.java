package com.example.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.common.CommonUtils;
import com.example.form.MealForm;
import com.example.model.Meal;
import com.example.model.User;
import com.example.service.MealService;

/**
 * 
 * @author anirudh
 *
 */
@Controller
@RequestMapping("/meals")
public class MealPlanController {
	
	@Autowired
	private MealService mealService;
	
	
	@RequestMapping(value="/view/eatingschedule", method =RequestMethod.GET)
	public String viewEatingSchedule(Model model,HttpSession session){
		User user = (User)session.getAttribute("user");
		List<Meal> meals = mealService.getAllMeals(user.getId());
		model.addAttribute("meals", meals);
		return "eatingSchedule";
	}

	@RequestMapping(value="/view" ,method =RequestMethod.GET)
	public String viewCreateMealPlanPage(Model model,HttpSession session){
		MealForm mealForm = new MealForm();
		model.addAttribute("meal",mealForm);
		return "prepareMealPlan";
	}
	
	@RequestMapping(value="/{id}" , method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteMeal(@PathVariable String id){
		mealService.deleteMeal(Long.valueOf(id));
		return "deleted successfully";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String createMealPlan(@ModelAttribute("meal") MealForm meal,Model model,HttpSession session) throws ParseException{
		
		User user = (User)session.getAttribute("user");
		Meal newMeal = new Meal();
		newMeal.setBreakfast(meal.getBreakfast());
		newMeal.setLunch(meal.getLunch());
		newMeal.setDinner(meal.getDinner());
		newMeal.setCreatedBy(user);
		newMeal.setDate(CommonUtils.getFormattedDateWithoutTime(meal.getDate()));
		
		mealService.createMeal(newMeal);
		model.addAttribute("meals", mealService.getAllMeals(user.getId()));
		return "eatingSchedule";
	}
}
