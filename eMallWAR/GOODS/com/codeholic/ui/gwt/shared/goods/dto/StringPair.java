package com.codeholic.ui.gwt.shared.goods.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

public class StringPair implements IsSerializable{
	private String key;
	private String value;
	
	public StringPair(){
		
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public StringPair(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
}
