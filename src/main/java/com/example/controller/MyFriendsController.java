package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.FriendRequestStatus;
import com.example.model.User;
import com.example.service.UserFriendMappingService;

@Controller
@RequestMapping("/myFriends")
public class MyFriendsController {

	@Autowired
	private UserFriendMappingService userFriendMappingService;

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String showMyFriendsPage(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		List<User> friends = userFriendMappingService.findFriends(user.getId(),FriendRequestStatus.CONFIRMED.toString());
		model.addAttribute("friends", friends);
		return "myFriends";
	}

	@RequestMapping(value = "/friend/{friendUserId}", method = RequestMethod.POST)
	@ResponseBody
	public String addAsFriend(@PathVariable("friendUserId") Long friendUserId,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		userFriendMappingService.addFriend(user.getId(), friendUserId);
		return "success";

	}

	@RequestMapping(value = "/pending", method = RequestMethod.GET)
	public String getPendingRequests(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<User> friends = userFriendMappingService.findPendingIncomingFriendRequests(user.getId());
		model.addAttribute("friends", friends);
		return "pendingFriendRequests";
	}

	@RequestMapping(value = "/confirm/friend/{friendUserId}", method = RequestMethod.PUT)
	@ResponseBody
	public String confirmAsFriend(@PathVariable("friendUserId") Long friendUserId,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		userFriendMappingService.confirmFriend(friendUserId,user.getId());
		return "success";

	}

}
