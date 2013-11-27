package com.codeholic.ui.gwt.client.core.user;

import com.codeholic.ui.gwt.client.core.user.activities.UserActivity;
import com.codeholic.ui.gwt.client.core.user.places.UserPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class UserActivityMapper implements ActivityMapper{

	@Override
	public Activity getActivity(Place place) {
		Activity activity = null;
		
		if(place instanceof UserPlace){
			activity = new UserActivity((UserPlace)place);
		}
		
		return activity;
	}

}
