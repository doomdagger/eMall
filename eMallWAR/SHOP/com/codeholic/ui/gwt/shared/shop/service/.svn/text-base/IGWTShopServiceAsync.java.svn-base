package com.codeholic.ui.gwt.shared.shop.service;

import java.util.List;

import com.codeholic.ui.gwt.shared.shop.dto.IShop;
import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IGWTShopServiceAsync {

	Request AddBatchShopStoreByExcel(String fileName, AsyncCallback<Boolean> callback);

	Request CreateStoreInfoBasicExcel(String fileName,
			AsyncCallback<Boolean> callback);

	Request addStore(IShop store, AsyncCallback<Boolean> callback);

	Request getStoreByCountry(String country, AsyncCallback<IShop> callback);

	Request getStoreById(String id, AsyncCallback<IShop> callback);

	Request getStoreByName(String storename, AsyncCallback<IShop> callback);

	Request getStoreByPrvi(String prvi, AsyncCallback<IShop> callback);

	Request getStoreByRegion(String region, AsyncCallback<IShop> callback);

	Request getStoreList(AsyncCallback<List<IShop>> callback);

	Request getStoreListInPage(int pageNumber, int pageSize,
			AsyncCallback<List<IShop>> callback);

	Request removeStore(String id, AsyncCallback<Boolean> callback);

}
