package com.example.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.User;
import com.example.persistence.UserPersistence;
import com.example.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	

	@Autowired
	private UserPersistence userPersistence;
	
	@Override
	public Set<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int id) {
		return userPersistence.getUser(id);
	}

	@Override
	public User getUserByEmail(String emailAddress) {
		return userPersistence.getUserByEmail(emailAddress);
	}

	@Override
	public User createUser(User user) {
		return userPersistence.saveUser(user);
	}


}
