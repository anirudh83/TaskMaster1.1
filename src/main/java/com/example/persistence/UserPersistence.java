package com.example.persistence;

import java.util.Set;

import com.example.model.User;

public interface UserPersistence {
	
	User saveUser(User user);
	Set<User> getUsers();
	User getUser(long id);
	User getUserByName(String userName);

}
