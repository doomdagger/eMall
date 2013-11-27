package com.codeholic.ui.gwt.shared.user.service;

import java.util.ArrayList;

import com.codeholic.ui.gwt.shared.user.dto.User;
import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;


public interface IGWTUserServiceAsync {

	Request getCurrentUser(AsyncCallback<User> callback);

	Request addUser(User user, AsyncCallback<Boolean> callback);

	Request editUserInfo(User user, AsyncCallback<Boolean> callback);

	Request removeUser(String userId, AsyncCallback<Boolean> callback);

	Request editUserRole(String userId, int Role, AsyncCallback<Boolean> callback);

	Request login(User user, AsyncCallback<Boolean> callback);

	Request findUsersByRoleInPage(int role, int pageNumber, int pageSize,
			AsyncCallback<ArrayList<User>> callback);

	Request findAllUsersInPage(int pageNumber, int pageSize,
			AsyncCallback<ArrayList<User>> callback);
	
	Request getUsers(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<User>> callback);
}
