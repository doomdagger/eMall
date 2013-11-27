package com.codeholic.business.shop.view;

import java.io.File;
import java.util.List;

import com.codeholic.pojos.jpa.StoreInfo;

public interface IShopService {

	public List<StoreInfo> getStoreList();
	
	public List<StoreInfo> getStoreListInPage(int pageNumber, int pageSize);
	
	public StoreInfo getStoreById(String id);
	
	public StoreInfo getStoreByName(String storename);
	
	public StoreInfo getStoreByCountry(String country);
	
	public StoreInfo getStoreByPrvi(String prvi);
	
	public StoreInfo getStoreByRegion(String region);
	
	public boolean addStore(StoreInfo store);
	
	public boolean removeStore(String id);
	
	//import the storeinfo data from excel files
	public boolean AddBatchShopStoreByExcel(File file);
	
	public boolean CreateStoreInfoBasicExcel(String fileName);
	
	public List<StoreInfo> findAllIdAndName();
}
