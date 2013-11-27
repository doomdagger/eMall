package com.codeholic.ui.gwt.server.shop;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import com.codeholic.business.shop.view.IShopService;
import com.codeholic.pojos.jpa.StoreInfo;
import com.codeholic.ui.gwt.server.util.ClassMapper;
import com.codeholic.ui.gwt.shared.shop.dto.IShop;
import com.codeholic.ui.gwt.shared.shop.service.IGWTShopService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class IGWTShopServiceImpl extends RemoteServiceServlet implements IGWTShopService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 764634146126675431L;
	
	@EJB
	private IShopService iShopService;

	@Override
	public List<IShop> getStoreList() {
		List<IShop> shopList = new ArrayList<IShop>();
		
		for(StoreInfo storeInfo:iShopService.getStoreList())
		{
			IShop shop = new IShop();
			ClassMapper.map(storeInfo, shop);//copy the value from storeinfo to shop
			shopList.add(shop);
		}
		return shopList;
	}

	@Override
	public List<IShop> getStoreListInPage(int pageNumber, int pageSize) {
		
		List<IShop> shopList = new ArrayList<IShop>();
		for (StoreInfo storeInfo :iShopService.getStoreListInPage(pageNumber, pageSize)) {
			IShop shop = new IShop();
			ClassMapper.map(storeInfo, shop);
			shopList.add(shop);
		}
		return null;
	}

	@Override
	public IShop getStoreById(String id) {
		IShop shop = new IShop();
		ClassMapper.map(iShopService.getStoreById(id),shop);
		return shop;
	}

	@Override
	public IShop getStoreByName(String storename) {
		IShop shop = new IShop();
		ClassMapper.map(iShopService.getStoreByName(storename), shop);
		return shop;
	}

	@Override
	public IShop getStoreByCountry(String country) {
		IShop shop = new IShop();
		ClassMapper.map(iShopService.getStoreByCountry(country), shop);
		return shop;
	}

	@Override
	public IShop getStoreByPrvi(String prvi) {
		IShop shop = new IShop();
		ClassMapper.map(iShopService.getStoreByPrvi(prvi), shop);
		return shop;
	}

	@Override
	public IShop getStoreByRegion(String region) {
		IShop shop = new IShop();
		ClassMapper.map(iShopService.getStoreByRegion(region), shop);
		return shop;
	}

	@Override
	public boolean addStore(IShop store) {
		StoreInfo storeInfo = new StoreInfo();
		ClassMapper.map(store, storeInfo);
		return iShopService.addStore(storeInfo);
	}

	@Override
	public boolean removeStore(String id) {
		return iShopService.removeStore(id);
	}

	@Override
	public boolean AddBatchShopStoreByExcel(String fileName) {
		File file = new File(fileName);
		return iShopService.AddBatchShopStoreByExcel(file);
	}

	@Override
	public boolean CreateStoreInfoBasicExcel(String fileName) {
		return iShopService.CreateStoreInfoBasicExcel(fileName);
	}

}
