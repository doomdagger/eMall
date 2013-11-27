package com.codeholic.ui.test.util;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeholic.business.goods.BrandServiceImpl;
import com.codeholic.eao.FilterQuery;
import com.codeholic.eao.ParamFilter;
import com.codeholic.eao.ParamMapper;
import com.codeholic.eao.ParamFilter.order;
import com.codeholic.eao.support.Pageable;
import com.codeholic.pojos.jpa.Brand;
import com.codeholic.ui.test.GenericTestServlet;

@WebServlet("test/filter")
public class FilterTest extends GenericTestServlet{

	/**
	 * 
	 */
	@EJB
	private FilterQuery filterQuery;
	@PersistenceContext(unitName = "eMallJPA")
	private EntityManager entityManager;
	@EJB
	private BrandServiceImpl brandServiceImpl;
	
	private static final long serialVersionUID = 1L;
	
	public FilterTest()
	{
		super();
	}
	
	//@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		super.doPost(request, response);
		/*
		Query query =  filterQuery.getFilterQuery(Brand.class, null, ParamFilter.Instance("brandId", order.ASC_ORDER), Pageable.inPage(1, 10));
		List<Brand> brandList = query.getResultList();
		System.out.println("querySql: "+filterQuery.getQuerySql() + " @");
		System.out.println("result: "+brandList);
		objectOutputToConsole(response, brandList);
		*/
		List<Brand> brandList = brandServiceImpl.findInParamFilter(Brand.class, null, null, Pageable.inPage(2, 20));
		objectOutputToConsole(response, brandList);
	}
	
}
