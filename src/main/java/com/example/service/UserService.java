package com.example.service;

import java.util.List;

import com.example.model.Meal;
import com.example.model.User;

public interface UserService {
	
	List<User> getUsers();
	User getUserById(Long id);
	User getUserByEmail(String emailAddress);
	User createUser(User newUser);
	List<Meal> getAllMeals(Long userId);

}
