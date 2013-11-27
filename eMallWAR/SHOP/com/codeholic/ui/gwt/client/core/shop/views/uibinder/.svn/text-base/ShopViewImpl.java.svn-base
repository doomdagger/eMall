package com.codeholic.ui.gwt.client.core.shop.views.uibinder;

import com.codeholic.ui.gwt.client.core.shop.presenters.IShopPresenter;
import com.codeholic.ui.gwt.client.core.shop.views.IShopView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ShopViewImpl extends Composite implements IShopView {

	private static ShopViewImplUiBinder uiBinder = GWT
			.create(ShopViewImplUiBinder.class);
	
	@SuppressWarnings("unused")
	private IShopPresenter presenter;

	interface ShopViewImplUiBinder extends UiBinder<Widget, ShopViewImpl> {
	}

	
	
	public ShopViewImpl() {
		
		initWidget(uiBinder.createAndBindUi(this));
		

	}

	

	@Override
	public void setPresenter(IShopPresenter presenter) {
		this.presenter = presenter;
		
	}

	@Override
	public String getLocation() {
		return null;
	}

	@Override
	public void setLocation(String location) {
		
	}



	@Override
	public String getShopname() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void setShopname(String shopname) {
		// TODO Auto-generated method stub
		
	}

}
