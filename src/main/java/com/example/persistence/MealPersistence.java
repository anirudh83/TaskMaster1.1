package com.example.persistence;

import java.util.List;

import com.example.model.Meal;

public interface MealPersistence extends GenericDAO<Meal, Long> {
	List<Meal> getAllMeals(Long userId);
}
