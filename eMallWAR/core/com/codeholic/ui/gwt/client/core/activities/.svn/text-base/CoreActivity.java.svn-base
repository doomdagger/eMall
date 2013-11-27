package com.codeholic.ui.gwt.client.core.activities;

import com.codeholic.ui.gwt.client.core.ICoreAppGinjector;
import com.codeholic.ui.gwt.client.core.places.CorePlaceAdapter;
import com.codeholic.ui.gwt.client.core.views.ICoreView;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.http.client.Request;

@SuppressWarnings("rawtypes")
public abstract class CoreActivity<Model,View extends ICoreView,Place extends CorePlaceAdapter> implements Activity {

	protected ICoreAppGinjector injector = GWT
			.create(ICoreAppGinjector.class);

	// 如有需要，存相关的实体对象，或存一些可重用字段
	protected Model model;
	
	//存储place的tokens
	protected String[] tokens;
	
	// 事件总线，应用程序级别的事件监听调用，如有需要，可存储此实例变量
	protected EventBus eventBus;
	// 视图对象，与View交互所需，勿忘实现并调用bind，绑定此activity与View
	protected View view;
	// Request，当RPC与服务器端交互时，此对象生成，可以选择性保留此对象对当前连接进行控制，见onCancel方法
	protected Request httpRequest;
	
	public CoreActivity(Place place){
		tokens = place.decodeToken();
		eventBus = injector.getEventBus();
	}
	
	

}
