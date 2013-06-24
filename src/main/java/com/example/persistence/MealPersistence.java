package com.example.persistence;

import com.example.model.Meal;

public interface MealPersistence {
	Meal createMeal(Meal meal);
	void refreshSession();
	void delete(int mealId);
}
