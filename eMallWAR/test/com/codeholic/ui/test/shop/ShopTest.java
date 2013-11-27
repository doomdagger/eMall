package com.codeholic.ui.test.shop;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeholic.business.shop.view.IShopService;
import com.codeholic.business.util.ExcelHandler;
import com.codeholic.eao.UUIDGenerator;
import com.codeholic.pojos.jpa.StoreInfo;
import com.codeholic.ui.test.GenericTestServlet;

@WebServlet("/test/shop")
public class ShopTest extends GenericTestServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShopTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@EJB 
	IShopService iShopService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		super.doPost(request, response);
		testGetStoreListInPage(response);
		testAddStore(response);
		//testFindAllIdAndName(response);
		testFindBySingleParam(response);
		testGetStoreList(response);
		
		
	}
	
	//excel导入商店
	private void testExcelImport(HttpServletResponse response)
	{
		iShopService.AddBatchShopStoreByExcel(new File("C:\\Users\\赫\\Desktop\\test.xls"));
		ExcelHandler<StoreInfo> handler = new ExcelHandler<StoreInfo>(StoreInfo.class);
		handler.writeExcel("\\home\\ltc\\Desktop\\test1.xls");
		resultOut( true);
	}
	
	private void testAddStore(HttpServletResponse response)
	{
		StoreInfo storeInfo = new StoreInfo();
		storeInfo.setStoreCode("123456");
		storeInfo.setStoreCountry(2);
		storeInfo.setStoreName("JOECHOW");
		storeInfo.setStorePrvi(1);
		storeInfo.setStoreRegion(3);
		try {
			
			System.out.println(iShopService.addStore(storeInfo));
			resultOut( true);
		} catch (Exception e) {
			e.printStackTrace();
			resultOut( false);
		}
		
	}
	
	private void testGetStoreList(HttpServletResponse response)
	{
		List<StoreInfo> storeList = iShopService.getStoreList();
		try {
			objectOutputToConsole(response, storeList);
			resultOut( true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultOut( false);
		}
	}
	
	private void testFindAllIdAndName(HttpServletResponse response)
	{
		try {
			objectOutputToConsole(response, iShopService.findAllIdAndName());
			resultOut( true);
		} catch (Exception e) {
			resultOut( false);
			e.printStackTrace();
		}
		
	}
	
	private void testFindBySingleParam(HttpServletResponse response)
	{
		try {
			iShopService.getStoreByCountry("1");
			iShopService.getStoreByRegion("1");
			iShopService.getStoreByPrvi("1");
			iShopService.getStoreById("1f481b4b-2c64-4bd9-9b4c-20690b75248d");
			resultOut( true);
		} catch (Exception e) {
			resultOut( false);
			e.printStackTrace();
		}
	}
	
	private void testGetStoreListInPage(HttpServletResponse response)
	{
		try {
			objectOutputToConsole(response, iShopService.getStoreListInPage(1, 5));
			resultOut( true);
		} catch (Exception e) {
			resultOut( false);
			e.printStackTrace();
		}
	}
}
