package com.codeholic.ui.gwt.client.core;

import com.codeholic.ui.gwt.client.core.activities.BlankActivity;
import com.codeholic.ui.gwt.client.core.places.BlankPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;

public class CoreActivityMapper implements ActivityMapper{
	//在这里继续添加Activity与Place的绑定
	
	private final ICoreAppGinjector injector = GWT.create(ICoreAppGinjector.class);
	
	@Override
	public Activity getActivity(Place place) {
		Activity activity = null;
		
		if(place instanceof BlankPlace){
			activity = new BlankActivity((BlankPlace)place);
		}
		
		
		if(activity!=null){
			return activity;
		}
		
		for(ActivityMapper mapper : injector.getMappers()){
			activity = mapper.getActivity(place);
			if(activity!=null){
				break;
			}
		}
		
		
		
		return activity;
	}

}
