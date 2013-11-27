package com.codeholic.ui.test.good;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeholic.business.goods.view.IGoodsclass1Service;
import com.codeholic.ui.test.GenericTestServlet;

@WebServlet("test/class1")
public class GoodsClass1Test extends GenericTestServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IGoodsclass1Service iGoodsclass1Service;
	
	public GoodsClass1Test()
	{
		super();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		test();
	}
	
	private void test()
	{
		try {
			objectOutputToConsole(response,iGoodsclass1Service.findAllGoodsclass1sInPage(1, 5));
			resultOut(true);
		} catch (Exception e) {
			e.printStackTrace();
			resultOut(false);
		}
	}
	

}
