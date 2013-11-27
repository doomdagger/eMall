package com.codeholic.ui.gwt.client.core.shop;

import com.codeholic.ui.gwt.client.core.CoreViewBinder;
import com.codeholic.ui.gwt.client.core.shop.views.IShopView;
import com.codeholic.ui.gwt.client.core.shop.views.uibinder.ShopViewImpl;

public class ShopViewBinder extends CoreViewBinder{

	@Override
	public void bind() {
		bind(IShopView.class, ShopViewImpl.class);
	}

}
