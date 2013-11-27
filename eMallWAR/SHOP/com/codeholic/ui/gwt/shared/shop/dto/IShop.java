package com.codeholic.ui.gwt.shared.shop.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

public class IShop implements IsSerializable{
	
	private String storeId;
	
	private String storeName;
	
	private String storeCode;
	
	private int storeCountry;
	
	private int	storePrvi;
	
	private String storeRegion;
	
	public IShop()
	{
		
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public int getStoreCountry() {
		return storeCountry;
	}

	public void setStoreCountry(int storeCountry) {
		this.storeCountry = storeCountry;
	}

	public int getStorePrvi() {
		return storePrvi;
	}

	public void setStorePrvi(int storePrvi) {
		this.storePrvi = storePrvi;
	}

	public String getStoreRegion() {
		return storeRegion;
	}

	public void setStoreRegion(String storeRegion) {
		this.storeRegion = storeRegion;
	}
	
}
