package com.codeholic.ui.gwt.client.core.places;


import java.util.HashMap;

import com.google.gwt.place.shared.Place;

public abstract class CorePlaceAdapter extends Place implements ICorePlace{

	private HashMap<String, String> map;
	private String token;

	public CorePlaceAdapter(String token){
		this.token = token;
		this.map = new HashMap<String, String>();
		decodeIntoMap();
	}

	private void decodeIntoMap(){
		String[] parts = token.split("&");
		for(String part : parts){
			String[] items = part.split("=");
			if(items.length!=2){
				continue;
			}
			map.put(items[0], items[1]);
		}
	}
	
	public String get(String string){
		return map.get(string);
	}
	
	@Override
	public String[] decodeToken() {
		return new String[]{token};
	}

	@Override
	public void encodeToken(String[] args) {
	}
	
	@Override
	public String getToken() {
		return this.token;
	}

}
