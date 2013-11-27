package com.codeholic.ui.gwt.shared.user.dto;

public class Pair {
	private int key;
	private String value;
	
	public Pair(){
		
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Pair(int key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	
}
