package com.example.service;

import com.example.model.Meal;

public interface MealService {
	Meal createMeal(Meal meal);
	void refresh();
	void deleteMeal(int parseInt);
}
