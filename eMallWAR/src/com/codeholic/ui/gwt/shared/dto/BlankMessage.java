package com.codeholic.ui.gwt.shared.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

public class BlankMessage implements IsSerializable{
	private String name;
	private String message;
	
	public BlankMessage(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
