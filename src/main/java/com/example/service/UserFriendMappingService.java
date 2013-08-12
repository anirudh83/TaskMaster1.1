package com.example.service;

import java.util.List;

import com.example.model.User;

public interface UserFriendMappingService {
	
	List<User> findFriends(Long userId,String status);
	void addFriend(Long userId,Long friendUserId);
	void confirmFriend(Long userId,Long friendUserId);
	List<User> findPendingIncomingFriendRequests(Long userId);

}
