package com.codeholic.ui.gwt.client.core.shop;

import com.codeholic.ui.gwt.client.core.shop.views.IShopView;
import com.codeholic.ui.gwt.shared.shop.service.IGWTShopServiceAsync;

public interface ShopGinjector {
	IGWTShopServiceAsync getShopServiceAsync();
	IShopView getShopView();
}
