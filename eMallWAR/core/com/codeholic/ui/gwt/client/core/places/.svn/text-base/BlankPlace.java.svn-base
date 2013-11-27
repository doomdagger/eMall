package com.codeholic.ui.gwt.client.core.places;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;


public class BlankPlace extends CorePlaceAdapter{

	
	public BlankPlace(String token){
		super(token);
	}
	
	

	@Prefix("blank")
	public static class Tokenizer implements PlaceTokenizer<BlankPlace>{

		@Override
		public BlankPlace getPlace(String str) { //str的值就是prefix的冒号后面的东西
			return new BlankPlace(str);
		}

		@Override
		public String getToken(BlankPlace place) {
			return place.getToken();
		}

		
	}
	

}
