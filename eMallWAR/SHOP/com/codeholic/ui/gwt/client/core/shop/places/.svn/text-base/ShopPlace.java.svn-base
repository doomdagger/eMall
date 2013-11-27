package com.codeholic.ui.gwt.client.core.shop.places;

import com.codeholic.ui.gwt.client.core.places.CorePlaceAdapter;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

/*
 * analyze the URL,such as "localhost#perfix:token"
 * and then at core/client.core/Core.gwt.xml add <inherit>																																																																																															
 */	 
public class ShopPlace extends CorePlaceAdapter{

	public ShopPlace(String token) {
		super(token);
	}
	
	
	@Prefix("shop")
	public static class Tokenizer implements PlaceTokenizer<ShopPlace>
	{

		@Override
		public ShopPlace getPlace(String place) {
			return new ShopPlace(place);
		}

		@Override
		public String getToken(ShopPlace place) {
			return place.getToken();
		}
		
	}
}
