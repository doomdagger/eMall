package com.codeholic.ui.gwt.client.core.shop;

import com.codeholic.ui.gwt.client.core.shop.activities.ShopActivity;
import com.codeholic.ui.gwt.client.core.shop.places.ShopPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class ShopActivityMapper implements ActivityMapper{

	
	@Override
	public Activity getActivity(Place place) {
		Activity activity = null;
		
		if(place instanceof ShopPlace)
		{
			activity = new ShopActivity((ShopPlace)place);
		}
		return activity;
	}

}
