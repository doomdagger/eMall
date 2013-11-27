package com.codeholic.ui.gwt.client.core.dict;

import com.codeholic.ui.gwt.client.core.dict.activities.DictActivity;
import com.codeholic.ui.gwt.client.core.dict.places.DictPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class DictActivityMapper implements ActivityMapper{

	@Override
	public Activity getActivity(Place place) {
		Activity activity = null;
		
		if(place instanceof DictPlace){
			activity = new DictActivity((DictPlace)place);
		}
		
		return activity;
	}

}
