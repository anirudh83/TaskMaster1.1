package com.example.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.persistence.UserPersistence;
import com.example.service.UserService;

@Service("userServiceByName")
public class UserServiceImpl implements UserService{
	

	@Autowired
	private UserPersistence userPersistence;
	
	@Override
	public Set<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(long id) {
		return userPersistence.getUser(id);
	}

	@Override
	public User getUserByName(String userName) {
		return userPersistence.getUserByName(userName);
	}


}
