package com.codeholic.ui.gwt.client.core.user.places;

import com.codeholic.ui.gwt.client.core.places.CorePlaceAdapter;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class UserPlace extends CorePlaceAdapter{
	public UserPlace(String token){
		super(token);
	}
	
	
	@Prefix("user")
	public static class Tokenizer implements PlaceTokenizer<UserPlace>{

		@Override
		public UserPlace getPlace(String place) {
			return new UserPlace(place);
		}

		@Override
		public String getToken(UserPlace place) {
			return place.getToken();
		}
		
	}
}
