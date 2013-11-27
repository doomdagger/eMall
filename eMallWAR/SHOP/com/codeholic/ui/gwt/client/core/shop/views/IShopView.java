package com.codeholic.ui.gwt.client.core.shop.views;

import com.codeholic.ui.gwt.client.core.shop.presenters.IShopPresenter;
import com.codeholic.ui.gwt.client.core.views.ICoreView;

public interface IShopView extends ICoreView<IShopPresenter>{
	String getShopname();
	void setShopname(String shopname);
	String getLocation();
	void setLocation(String location);
}
