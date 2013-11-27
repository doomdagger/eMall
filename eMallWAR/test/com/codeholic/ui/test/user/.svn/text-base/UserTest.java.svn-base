package com.codeholic.ui.test.user;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeholic.business.user.view.IUserService;
import com.codeholic.pojos.jpa.User;
import com.codeholic.ui.test.GenericTestServlet;

/**
 * Servlet implementation class UserTest
 */
@WebServlet("/test/user")
public class UserTest extends GenericTestServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserTest() {
        super();
    }

    @EJB
    private IUserService userService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		User user = new User();
		
		user.setUserName("lh");
		user.setUserPass("660802");
		
		
		boolean result = userService.login(user);
		
		objectOutputToConsole(response, result);
	}

}
