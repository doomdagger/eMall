package com.codeholic.ui.gwt.client.core.ui;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;

public class BlankLabel extends Label implements HasValue<String>{

	public BlankLabel(String text) {
		super(text);
	}
	
	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<String> handler) {
		return addHandler(handler, ValueChangeEvent.getType());
	}

	@Override
	public String getValue() {
		return this.getText();
	}

	@Override
	public void setValue(String arg0) {
		this.setText(arg0);
	}

	@Override
	public void setValue(String arg0, boolean arg1) {
		this.setText(arg0);
	}

}
