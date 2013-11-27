package com.codeholic.ui.gwt.server.user;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.codeholic.business.user.view.IUserService;
import com.codeholic.ui.gwt.server.util.ClassMapper;
import com.codeholic.ui.gwt.shared.user.dto.User;
import com.codeholic.ui.gwt.shared.user.service.IGWTUserService;
import com.codeholic.ui.gwt.shared.user.service.UserPagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

public class GWTUserServiceImpl extends RemoteServiceServlet implements
		IGWTUserService {

	public static final String USER_ID = "userId";

	private static final long serialVersionUID = 5452080712234931686L;

	@EJB
	private IUserService userImpl;

	@Override
	public User getCurrentUser() {
		HttpServletRequest request = getThreadLocalRequest();
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute(USER_ID);

		if (userId == null || userId.equals("")) {
			return null;
		}

		User user = new User();

		ClassMapper.map(userImpl.getCurrentUser(userId), user);

		return user;
	}

	@Override
	public boolean addUser(User user) {

		com.codeholic.pojos.jpa.User userjpa = new com.codeholic.pojos.jpa.User();

		ClassMapper.map(user, userjpa);

		return userImpl.addUser(userjpa);
	}

	@Override
	public boolean editUserInfo(User user) {
		com.codeholic.pojos.jpa.User userjpa = new com.codeholic.pojos.jpa.User();

		ClassMapper.map(user, userjpa);

		return userImpl.editUserInfo(userjpa);
	}

	@Override
	public boolean removeUser(String userId) {

		return userImpl.removeUser(userId);

	}

	@Override
	public boolean editUserRole(String userId, int Role) {

		return userImpl.editUserRole(userId, Role);
	}

	@Override
	public boolean login(User user) {
		HttpServletRequest request = getThreadLocalRequest();
		HttpSession session = request.getSession(true);
		session.setAttribute(USER_ID, user.getUserId());
		
		com.codeholic.pojos.jpa.User userjpa = new com.codeholic.pojos.jpa.User();

		ClassMapper.map(user, userjpa);

		return userImpl.login(userjpa);
	}

	@Override
	public ArrayList<User> findUsersByRoleInPage(int role, int pageNumber,
			int pageSize) {

		System.out.println("Here Once");
		
		List<com.codeholic.pojos.jpa.User> users = userImpl
				.findUsersByRoleInPage(role, pageNumber, pageSize);

		ArrayList<User> userlist = new ArrayList<User>();

		for (com.codeholic.pojos.jpa.User user : users) {
			User user2 = new User();
			ClassMapper.map(user, user2);
			userlist.add(user2);
		}

		return userlist;
	}

	@Override
	public ArrayList<User> findAllUsersInPage(int pageNumber, int pageSize) {
		List<com.codeholic.pojos.jpa.User> users = userImpl.findAllUsersInPage(
				pageNumber, pageSize);

		ArrayList<User> userlist = new ArrayList<User>();

		for (com.codeholic.pojos.jpa.User user : users) {
			User user2 = new User();
			ClassMapper.map(user, user2);
			userlist.add(user2);
		}

		return userlist;
	}

	@Override
	public PagingLoadResult<User> getUsers(final PagingLoadConfig loadConfig) {
		
		int limit = loadConfig.getLimit();
		int offset = loadConfig.getOffset();
				
		List<User> users = this.findAllUsersInPage(offset/limit, limit);
		
		UserPagingLoadResult result = new UserPagingLoadResult(users);
		result.setOffset(offset);
		result.setTotalLength(users.size());
		
		return result;
	}

}
