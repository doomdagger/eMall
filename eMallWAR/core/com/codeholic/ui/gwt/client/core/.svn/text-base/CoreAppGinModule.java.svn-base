package com.codeholic.ui.gwt.client.core;

import java.util.ArrayList;
import java.util.Map.Entry;

import com.codeholic.ui.gwt.client.core.dict.DictActivityMapper;
import com.codeholic.ui.gwt.client.core.dict.DictViewBinder;
import com.codeholic.ui.gwt.client.core.goods.GoodsActivityMapper;
import com.codeholic.ui.gwt.client.core.goods.GoodsViewBinder;
import com.codeholic.ui.gwt.client.core.shop.ShopActivityMapper;
import com.codeholic.ui.gwt.client.core.shop.ShopViewBinder;
import com.codeholic.ui.gwt.client.core.user.UserActivityMapper;
import com.codeholic.ui.gwt.client.core.user.UserViewBinder;
import com.codeholic.ui.gwt.client.core.views.IBlankView;
import com.codeholic.ui.gwt.client.core.views.hardcoded.BlankViewImpl;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Provides;
import com.google.inject.Singleton;

/*
 * 在这里添加完bind关系后，再到ICoreAppGinjector接口中定义获取方法，
 * 请注意！！！！ServiceAsync异步接口注入无需在此类中bind，直接去写获取方法，demo中有事例
 */
public class CoreAppGinModule extends AbstractGinModule{

	@Override
	protected void configure() {
		
		
		//视图对象请bind为Singleton，为性能考虑，但是由此也会有一个弊端，可能会污染视图对象，
		//一定要在Presenter（Activity）的onCancel()方法里清除冗余字段，此方法为Activity的life cycle方法，
		//由系统调用
		bind(IBlankView.class).to(BlankViewImpl.class).in(Singleton.class);
		
		//为了全局事件响应，EventBus为Singleton
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		
		//PlaceController,MVP2必须的组件
		bind(PlaceController.class).to(CorePlaceController.class).in(Singleton.class);
		
		
		
		//dict，添加viewBinder？在此后继续调用analyseViewBinder
		analyseViewBinder(new DictViewBinder());
		analyseViewBinder(new UserViewBinder());
		analyseViewBinder(new ShopViewBinder());
		analyseViewBinder(new GoodsViewBinder());
	}
	
	
	@Provides
	ArrayList<ActivityMapper> provideMappers(){
		ArrayList<ActivityMapper> mappers = new ArrayList<ActivityMapper>();
		mappers.add(new DictActivityMapper());
		//想要添加mappers，再次调用add方法，创建添加
		mappers.add(new UserActivityMapper());
		mappers.add(new ShopActivityMapper());
		mappers.add(new GoodsActivityMapper());
		return mappers;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void analyseViewBinder(CoreViewBinder viewBinder){
		viewBinder.bind();
		for(Entry<Class, Class> entry : viewBinder.getEntrySet()){
			bind(entry.getKey()).to(entry.getValue()).in(Singleton.class);
		}
	}

}
