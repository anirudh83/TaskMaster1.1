package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Meal;
import com.example.model.User;
import com.example.persistence.UserPersistence;
import com.example.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	

	@Autowired
	private UserPersistence userPersistence;
	
	@Override
	public List<User> getUsers() {
		return userPersistence.getAllUsers();
	}

	@Override
	public User getUserById(Long id) {
		return userPersistence.findById(id);
	}

	@Override
	public User getUserByEmail(String emailAddress) {
		return userPersistence.getUserByEmail(emailAddress);
	}

	@Override
	public User createUser(User user) {
		return userPersistence.makePersistant(user);
	}

	@Override
	public List<Meal> getAllMeals(Long userId) {
		return userPersistence.findById(userId).getMeals();
	}


}
