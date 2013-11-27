package com.codeholic.ui.gwt.client.core.goods;

import com.codeholic.ui.gwt.client.core.goods.activities.BrandActivity;
import com.codeholic.ui.gwt.client.core.goods.activities.GoodsActivity;
import com.codeholic.ui.gwt.client.core.goods.activities.Goodsclass1Activity;
import com.codeholic.ui.gwt.client.core.goods.activities.Goodsclass2Activity;
import com.codeholic.ui.gwt.client.core.goods.places.BrandPlace;
import com.codeholic.ui.gwt.client.core.goods.places.GoodsPlace;
import com.codeholic.ui.gwt.client.core.goods.places.Goodsclass1Place;
import com.codeholic.ui.gwt.client.core.goods.places.Goodsclass2Place;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;



public class GoodsActivityMapper implements ActivityMapper{

	@Override
	public Activity getActivity(Place place) {
		Activity activity = null;
		
		if(place instanceof GoodsPlace){
			activity = new GoodsActivity((GoodsPlace)place);
		}else if (place instanceof BrandPlace) {
			activity = new BrandActivity((BrandPlace)place);
		}else if(place instanceof Goodsclass1Place){
			activity = new Goodsclass1Activity((Goodsclass1Place)place);
		}else if(place instanceof Goodsclass2Place){
			activity = new Goodsclass2Activity((Goodsclass2Place)place);
		}
		
		return activity;
	}

}
