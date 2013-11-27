package com.codeholic.ui.gwt.client.core.goods.places;

import com.codeholic.ui.gwt.client.core.places.CorePlaceAdapter;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class Goodsclass1Place extends CorePlaceAdapter{

	public Goodsclass1Place(String token) {
		super(token);
	}
	
	@Prefix("goodsclass1")
	public static class Tokenizer implements PlaceTokenizer<Goodsclass1Place>{

		@Override
		public Goodsclass1Place getPlace(String place) {
			return new Goodsclass1Place(place);
		}

		@Override
		public String getToken(Goodsclass1Place place) {
			return place.getToken();
		}
		
	}

}
