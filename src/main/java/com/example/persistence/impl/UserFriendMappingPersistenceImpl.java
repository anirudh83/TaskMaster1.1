package com.example.persistence.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.example.model.UserFriendMapping;
import com.example.persistence.UserFriendMappingPersistence;

@Repository
public class UserFriendMappingPersistenceImpl extends GenericDAOImpl<UserFriendMapping,Long> implements UserFriendMappingPersistence{

	@Override
	public List<UserFriendMapping> getAllFriends(Long userId,String status) {
		Session sess = getSession();
		List<UserFriendMapping> userFriendMappings = sess.createQuery("from UserFriendMapping as ufm where ufm.user.id = ? and status =?").setLong(0, userId).setString(1, status).list();
		return userFriendMappings;
	}

	@Override
	public UserFriendMapping getByUserIdAndFriendId(Long userId, Long friendId) {
		Session sess = getSession();
		UserFriendMapping mapping = (UserFriendMapping)sess.createQuery("from UserFriendMapping as ufm where ufm.user.id = ? and ufm.friend.id = ?").setLong(0, userId).setLong(1, friendId).uniqueResult();
		return mapping;
	}

	@Override
	public List<UserFriendMapping> getByFriendId(Long friendId,String status) {
		Session sess = getSession();
		List<UserFriendMapping> list = sess.createQuery("from UserFriendMapping as ufm where ufm.friend.id = ? and status =?").setLong(0, friendId).setString(1, status).list();
		return list;
	}

	
}
