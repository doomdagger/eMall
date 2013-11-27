package com.codeholic.ui.gwt.shared.shop.service;

import java.util.List;

import com.codeholic.ui.gwt.shared.shop.dto.IShop;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("shop")
public interface IGWTShopService extends RemoteService {
	
public List<IShop> getStoreList();
	
	public List<IShop> getStoreListInPage(int pageNumber, int pageSize);
	
	public IShop getStoreById(String id);
	
	public IShop getStoreByName(String storename);
	
	public IShop getStoreByCountry(String country);
	
	public IShop getStoreByPrvi(String prvi);
	
	public IShop getStoreByRegion(String region);
	
	public boolean addStore(IShop store);
	
	public boolean removeStore(String id);
	
	//import the storeinfo data from excel files
	public boolean AddBatchShopStoreByExcel(String fileName);
	
	public boolean CreateStoreInfoBasicExcel(String fileName);

}
