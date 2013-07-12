package com.example.persistence;

import java.util.List;

import com.example.model.User;

public interface UserPersistence {
	
	User saveUser(User user);
	List<User> getAllUsers();
	User getUser(int id);
	User getUserByEmail(String email);
	void refreshUser(User user);
	User loadUser(int id);

}
