package com.codeholic.ui.gwt.client.core.goods.places;

import com.codeholic.ui.gwt.client.core.places.CorePlaceAdapter;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class GoodsPlace extends CorePlaceAdapter{

	public GoodsPlace(String token) {
		super(token);
	}
	
	@Prefix("goods")
	public static class Tokenizer implements PlaceTokenizer<GoodsPlace>{

		@Override
		public GoodsPlace getPlace(String place) {
			return new GoodsPlace(place);
		}

		@Override
		public String getToken(GoodsPlace place) {
			return place.getToken();
		}
		
	}

}
