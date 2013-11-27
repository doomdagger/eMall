package com.codeholic.ui.gwt.client.core.goods.places;

import com.codeholic.ui.gwt.client.core.places.CorePlaceAdapter;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class BrandPlace extends CorePlaceAdapter{

	public BrandPlace(String token) {
		super(token);
	}
	
	@Prefix("brand")
	public static class Tokenizer implements PlaceTokenizer<BrandPlace>{

		@Override
		public BrandPlace getPlace(String place) {
			return new BrandPlace(place);
		}

		@Override
		public String getToken(BrandPlace place) {
			return place.getToken();
		}
		
	}

}
