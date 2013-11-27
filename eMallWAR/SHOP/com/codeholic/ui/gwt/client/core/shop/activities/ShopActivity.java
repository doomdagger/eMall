package com.codeholic.ui.gwt.client.core.shop.activities;

import com.codeholic.ui.gwt.client.core.activities.CoreActivity;
import com.codeholic.ui.gwt.client.core.shop.places.ShopPlace;
import com.codeholic.ui.gwt.client.core.shop.presenters.IShopPresenter;
import com.codeholic.ui.gwt.client.core.shop.views.IShopView;
import com.codeholic.ui.gwt.shared.shop.dto.IShop;
import com.codeholic.ui.gwt.shared.shop.service.IGWTShopServiceAsync;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ShopActivity extends CoreActivity<IShop, IShopView, ShopPlace> implements IShopPresenter{

	
	private String name;
	
	private IGWTShopServiceAsync serviceAsync;
	
	public ShopActivity(ShopPlace place) {
		super(place);
		this.name = tokens[0];
		this.view = injector.getShopView();//here is a mess~,you should add interface at interface :ICoreAppGinjector
		this.serviceAsync = injector.getShopServiceAsync();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void bind() {
		//set the current acivity as the Presenter 
		this.view.setPresenter(this);
		
	}

	@Override
	public String mayStop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCancel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus arg1) {
		
		bind();
		
		this.onGetShop(name);
		
		panel.setWidget(view.asWidget());
		
	}

	
	
	//this method defined by ShopPresenter
	@Override
	public void onGetShop(String shopname) {
		
	}

}
