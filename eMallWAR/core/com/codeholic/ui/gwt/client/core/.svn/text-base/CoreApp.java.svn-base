/*
 * Don't touch this class!!!!
 * 请不要触碰此类，触碰此类，只可能出于两种行为
 * 1 想要增加EventBus的事件监听，从而修改bind方法
 * 2 想要改变CoreApp的default place
 */

package com.codeholic.ui.gwt.client.core;

import com.codeholic.ui.gwt.client.core.events.CoreEvent;
import com.codeholic.ui.gwt.client.core.events.CoreHandler;
import com.codeholic.ui.gwt.client.core.places.BlankPlace;
import com.codeholic.ui.gwt.client.core.ui.CoreInfoIndicator;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class CoreApp {
	
	private EventBus eventBus;
	
	//injector，此为必须
	private final ICoreAppGinjector injector = GWT.create(ICoreAppGinjector.class);
	
	//默认一开始显示的Place
	private Place defaultPlace = new BlankPlace("0");
	
	@SuppressWarnings("deprecation")
	public CoreApp(AcceptsOneWidget appWidget) {
		this.eventBus = injector.getEventBus();
		
		//start core business logic, should not change it
		PlaceController placeController = injector.getPlaceController();
		
		ActivityMapper activityMapper = new CoreActivityMapper();
		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
		activityManager.setDisplay(appWidget);
		
		ICorePlacesHistoryMapper historyMapper = GWT.create(ICorePlacesHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);
		
		historyHandler.handleCurrentHistory();
		
		bind();
	}
	
	private void bind(){
		eventBus.addHandler(CoreEvent.getType(), new CoreHandler() {
			@Override
			public void onCoreEvent(CoreEvent event) {
				CoreInfoIndicator.busy();
				Scheduler.get().scheduleFixedDelay(new RepeatingCommand(){
					public boolean execute() {
						CoreInfoIndicator.free();
						return false;
					}	
				}, 2000);
			}
		});
	}
	
}
