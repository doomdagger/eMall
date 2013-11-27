package com.codeholic.business.user;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.codeholic.business.user.view.IUserService;
import com.codeholic.business.util.EncryptAES;
import com.codeholic.eao.ParamMapper;
import com.codeholic.eao.UUIDGenerator;
import com.codeholic.eao.support.Pageable;
import com.codeholic.eao.user.UserEao;
import com.codeholic.pojos.jpa.User;

/**
 * Session Bean implementation class UserServiceImpl
 */
@Stateless
@Local(IUserService.class)
public class UserServiceImpl implements IUserService {

	@EJB
	private UserEao userEao;

	/**
	 * Default constructor.
	 */
	public UserServiceImpl() {

	}

	@Override
	public User getCurrentUser(String userId) {
		try{
			User user = userEao.findOneById(userId);
			user.setUserPass("");
			return user;
		}catch(Exception exception){
			exception.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addUser(User user) {
		if (user == null) {
			return false;
		}

		try {
			if (absentUserId(user)) {
				user.setUserId(UUIDGenerator.randomUUID());
			}
			user.setUserPass(EncryptAES.encode((user.getUserPass())));
			userEao.add(user);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean editUserInfo(User user) {
		if (absentUserId(user)) {
			return false;
		}

		try {
			userEao.update(user);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean removeUser(String userId) {
		try {
			User user = userEao.findOneById(userId);
			userEao.delete(user);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean editUserRole(String userId, int Role) {
		try {
			User user = userEao.findOneById(userId);
			user.setUserRole(Role);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean login(User user) {
		try {
			User savedUser = userEao.findOneByParams("user.findByUserName",
					ParamMapper.instance("userName", user.getUserName()));
			if (savedUser == null) {
				return false;
			}
			
			System.out.println(savedUser.getUserPass()+"\t"+savedUser.getUserPass().length());
			
			if (user.getUserPass().equals(
					EncryptAES.decode(savedUser.getUserPass().trim()))) {
				return true;
			}else {
				return false;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	private boolean absentUserId(User user) {
		if (user.getUserId() == null || user.getUserId().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<User> findUsersByRoleInPage(int role, int pageNumber, int pageSize) {
		try{
			return userEao.findByParamsInPage("user.findByRole", ParamMapper.instance("userRole", role), Pageable.inPage(pageNumber, pageSize));
		}catch(Exception exception){
			exception.printStackTrace();
			return null;
		}
	}

	@Override
	public List<User> findAllUsersInPage(int pageNumber, int pageSize) {
		try{
			return userEao.findAllInPage(Pageable.inPage(pageNumber, pageSize));
		}catch(Exception exception){
			exception.printStackTrace();
			return null;
		}
	}

}
