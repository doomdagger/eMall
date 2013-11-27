package com.codeholic.business.user.view;

import java.util.List;

import com.codeholic.pojos.jpa.User;

public interface IUserService {
	//获取当前用户
	User getCurrentUser(String userId);
	
	boolean addUser(User user);
	
	boolean editUserInfo(User user);
	
	boolean removeUser(String userId);
	
	boolean editUserRole(String userId, int Role);
	
	boolean login(User user);
	
	List<User> findUsersByRoleInPage(int role, int pageNumber, int pageSize);
	
	List<User> findAllUsersInPage(int pageNumber, int pageSize);
	
}
