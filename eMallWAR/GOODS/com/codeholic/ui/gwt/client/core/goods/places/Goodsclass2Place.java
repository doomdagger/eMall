package com.codeholic.ui.gwt.client.core.goods.places;

import com.codeholic.ui.gwt.client.core.places.CorePlaceAdapter;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class Goodsclass2Place extends CorePlaceAdapter{

	public Goodsclass2Place(String token) {
		super(token);
	}
	
	@Prefix("goodsclass2")
	public static class Tokenizer implements PlaceTokenizer<Goodsclass2Place>{

		@Override
		public Goodsclass2Place getPlace(String place) {
			return new Goodsclass2Place(place);
		}

		@Override
		public String getToken(Goodsclass2Place place) {
			return place.getToken();
		}
		
	}


}
