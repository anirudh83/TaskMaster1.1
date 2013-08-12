package com.example.persistence;

import java.util.List;

import com.example.model.UserFriendMapping;

public interface UserFriendMappingPersistence extends GenericDAO<UserFriendMapping,Long>{
	
     List<UserFriendMapping> getAllFriends(Long userId,String status);
     UserFriendMapping getByUserIdAndFriendId(Long userId, Long friendId);
     List<UserFriendMapping> getByFriendId(Long friendId,String status);
}
