package com.codeholic.ui.test.good;

import java.io.IOException;
import java.util.Date;

import java_cup.internal_error;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.bcel.classfile.Code;

import com.codeholic.business.goods.GoodServiceImpl;
import com.codeholic.business.goods.view.IGoodService;
import com.codeholic.eao.UUIDGenerator;
import com.codeholic.eao.support.Pageable;
import com.codeholic.pojos.jpa.Brand;
import com.codeholic.pojos.jpa.Good;
import com.codeholic.pojos.jpa.Goodsclass1;
import com.codeholic.pojos.jpa.Goodsclass2;
import com.codeholic.ui.test.GenericTestServlet;
import com.gargoylesoftware.htmlunit.Page;


@WebServlet("test/goods")
public class GoodsTest extends GenericTestServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private IGoodService goodServiceImpl;
	
	public GoodsTest()
	{
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		//testAddGood();
		//testFindByNameCode("", "");
		//testFindAllGoodsInCreateTimeAscInPage(response);
		//testFindAllGoodsInCreateTimeDescInPage(response);
		//testFindAllGoodsInPage(response);
		//testFindGoodByFilter();
		testGetCount();
	}
	
	public void testAddGood()
	{
		Good good = new Good();
		//good.setBrand(new Brand());
		good.setBrand(null);
		//good.setClass1(new Goodsclass1());
		good.setClass1(null);
		//good.setClass2(new Goodsclass2());
		good.setClass2(null);
		good.setDelflag((byte)0);
		good.setGoodsCreatetime(new Date());
		good.setGoodsId(UUIDGenerator.randomUUID());
		good.setGoodsMode(0);
		good.setGoodsName("goods");
		good.setGoodsPrice(100);
		good.setGoodsUnit("Unit");
		good.setGoodsValid((byte)0);
		try {
			goodServiceImpl.addGood(good);
			resultOut(true);
		} catch (Exception e) {
			e.printStackTrace();
			resultOut(false);
			//table is not exist...
		}
		
	}
	
	
	public void testFindAllGoodsInCreateTimeAscInPage(HttpServletResponse response)
	{
		try {
			resultOut(true);
			objectOutputToConsole(response, goodServiceImpl.findAllGoodsInCreateTimeAscInPage(1, 5));
		} catch (IOException e) {
			e.printStackTrace();
			resultOut(false);
		}
	}
	
	public void testFindAllGoodsInCreateTimeDescInPage(HttpServletResponse response)
	{
		try {
			resultOut(true);
			objectOutputToConsole(response, goodServiceImpl.findAllGoodsInCreateTimeDescInPage(2, 10));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resultOut(false);
		}
		
	}
	
	public void testFindAllGoodsInPage(HttpServletResponse response)
	{
		try {
			resultOut(true);
			objectOutputToConsole(response,  goodServiceImpl.findAllGoodsInPage(3, 5));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resultOut(false);
		}
	}
	
	public void testFindByNameCode(String name,String code)
	{
		try {
			goodServiceImpl.findByGoodCode(code);
			goodServiceImpl.findByGoodName(name);
			resultOut(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resultOut(false);
		}
	}
	
	
	public void testFindGoodByFilter()
	{
		try {
			goodServiceImpl.findGoodByFilter(Good.class, null, null, Pageable.inPage(1, 5));
			goodServiceImpl.getCount();
			resultOut(true);
		} catch (Exception e) {
			resultOut(false);
		}
	}
	
	
	public void testGetCount()
	{
		try {
			resultOut(true);
			int count = goodServiceImpl.getCount();
			String result = "Count:"+count;
			objectOutputToConsole(response, result);
		} catch (Exception e) {
			e.printStackTrace();
			resultOut(false);
		}
	}

}
