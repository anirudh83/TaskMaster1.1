package com.example.persistence;

import java.util.List;

import com.example.model.User;

public interface UserPersistence extends GenericDAO<User, Long>{
	
	List<User> getAllUsers();
	User getUserByEmail(String email);
}
