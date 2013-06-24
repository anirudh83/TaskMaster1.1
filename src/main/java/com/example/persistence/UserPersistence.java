package com.example.persistence;

import java.util.Set;

import com.example.model.User;

public interface UserPersistence {
	
	User saveUser(User user);
	Set<User> getUsers();
	User getUser(int id);
	User getUserByEmail(String email);
	void refreshUser(User user);
	User loadUser(int id);

}
