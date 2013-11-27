package com.codeholic.ui.test.receipt;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeholic.business.util.ReceiptGenerator;
import com.codeholic.pojos.jpa.Receipt;
import com.codeholic.ui.test.GenericTestServlet;

@WebServlet("test/receipt")
public class ReceiptTest extends GenericTestServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private ReceiptGenerator rGenerator;
	
	public ReceiptTest()
	{
		super();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		super.doPost(request, response);
		
		
		Receipt receipt = rGenerator.next(1);
		
		
		objectOutputToConsole(response, receipt);
		
		
	}
	
}
