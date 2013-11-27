package com.codeholic.ui.test.dict;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeholic.business.dict.view.IDictService;
import com.codeholic.pojos.jpa.Dict;
import com.codeholic.pojos.jpa.User;
import com.codeholic.ui.gwt.server.util.ClassMapper;
import com.codeholic.ui.gwt.shared.dict.dto.DictDto;
import com.codeholic.ui.test.GenericTestServlet;

@WebServlet("test/dict")
public class DictTest extends GenericTestServlet{

	@EJB
	private IDictService service;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		List<Dict> dicts = service.readLabelsByFieldName("性别");
		objectOutputToConsole(response, dicts);
	}
}
