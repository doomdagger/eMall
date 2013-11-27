package com.codeholic.ui.gwt.shared.user.service;

import java.util.ArrayList;

import com.codeholic.ui.gwt.shared.user.dto.User;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

@RemoteServiceRelativePath("user")
public interface IGWTUserService extends RemoteService {
	User getCurrentUser();

	boolean addUser(User user);

	boolean editUserInfo(User user);

	boolean removeUser(String userId);

	boolean editUserRole(String userId, int Role);

	boolean login(User user);

	ArrayList<User> findUsersByRoleInPage(int role, int pageNumber, int pageSize);

	ArrayList<User> findAllUsersInPage(int pageNumber, int pageSize);

	PagingLoadResult<User> getUsers(PagingLoadConfig loadConfig);

}
