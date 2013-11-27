package com.codeholic.ui.gwt.client.core;

import java.util.ArrayList;

import com.codeholic.ui.gwt.client.core.dict.DictGinjector;
import com.codeholic.ui.gwt.client.core.goods.GoodsGinjector;
import com.codeholic.ui.gwt.client.core.shop.ShopGinjector;
import com.codeholic.ui.gwt.client.core.user.UserGinjector;
import com.codeholic.ui.gwt.client.core.views.IBlankView;
import com.codeholic.ui.gwt.shared.service.receipt.IBlankServiceAsync;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;

@GinModules(CoreAppGinModule.class)
public interface ICoreAppGinjector extends Ginjector,DictGinjector,UserGinjector,ShopGinjector,GoodsGinjector{

	//第一类，View
	public IBlankView getIBlankView();

	//第二类，EventBus，仅此一个，EventBus的事件绑定写在了CoreApp的bind()方法里，
	//自定义全局事件和handler接口请写在events包中
	public EventBus getEventBus();
	
	//第三类，异步接口，无需在Modules中写bind，可直接在此写get方法
	public IBlankServiceAsync getIBlankServiceAsync();
	
	//第四类，placeController，仅此一个
	public PlaceController getPlaceController();

	public ArrayList<ActivityMapper> getMappers();

	
	//添加。。。。
	
	
	
	
	
}
