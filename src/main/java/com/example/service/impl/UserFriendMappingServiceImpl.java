package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.FriendRequestStatus;
import com.example.model.User;
import com.example.model.UserFriendMapping;
import com.example.persistence.UserFriendMappingPersistence;
import com.example.service.UserFriendMappingService;
import com.example.service.UserService;

@Service
@Transactional
public class UserFriendMappingServiceImpl implements UserFriendMappingService{

	@Autowired
	private UserFriendMappingPersistence userFriendMappingPersistence;
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<User> findFriends(Long userId,String status) {
		List<UserFriendMapping> allFriends = userFriendMappingPersistence.getAllFriends(userId,status);
		List<UserFriendMapping> friendsWhoAddedMe = userFriendMappingPersistence.getByFriendId(userId,status);
		List<User> friends = new ArrayList<User>();
		for (UserFriendMapping userFriendMapping : allFriends) {
			friends.add(userFriendMapping.getFriend());
		}
		for (UserFriendMapping userFriendMapping : friendsWhoAddedMe) {
			friends.add(userFriendMapping.getUser());
		}
		
		return friends;
	}

	@Override
	public void addFriend(Long userId, Long friendUserId) {
		UserFriendMapping mapping = new UserFriendMapping();
		User user = userService.getUserById(userId);
		User friend = userService.getUserById(friendUserId);
		mapping.setUser(user);
		mapping.setFriend(friend);
		mapping.setStatus(FriendRequestStatus.PENDING.toString());
		userFriendMappingPersistence.makePersistant(mapping);
	}

	@Override
	public void confirmFriend(Long userId, Long friendUserId) {
		UserFriendMapping mapping = userFriendMappingPersistence.getByUserIdAndFriendId(userId, friendUserId);
		UserFriendMapping persistedMapping = userFriendMappingPersistence.findById(mapping.getId());
		if(persistedMapping==null){
			//TODO : Implement Exception handling framework
		//	throw new NoSuchFriendRequestException()
		}else{
			persistedMapping.setStatus(FriendRequestStatus.CONFIRMED.toString());
		}
	}

	@Override
	public List<User> findPendingIncomingFriendRequests(Long userId) {
		List<UserFriendMapping> mappings = userFriendMappingPersistence.getByFriendId(userId,FriendRequestStatus.PENDING.toString());
		List<User> friends = new ArrayList<User>();
		for (UserFriendMapping userFriendMapping : mappings) {
			friends.add(userFriendMapping.getUser());
		}
		return friends;
	}
	

}
