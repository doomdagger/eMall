package com.codeholic.ui.gwt.client.core.dict.places;

import com.codeholic.ui.gwt.client.core.places.CorePlaceAdapter;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class DictPlace extends CorePlaceAdapter{


	
	public DictPlace(String token){
		super(token);
	}
	
	
	@Prefix("dict")
	public static class Tokenizer implements PlaceTokenizer<DictPlace>{

		@Override
		public DictPlace getPlace(String place) {
			return new DictPlace(place);
		}

		@Override
		public String getToken(DictPlace place) {
			return place.getToken();
		}
		
	}

}
