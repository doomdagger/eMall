package com.codeholic.ui.gwt.client.core.ui;

import com.gargoylesoftware.htmlunit.javascript.host.Document;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class LMenuViewImpl extends Composite {

	private static LMenuViewImplUiBinder uiBinder = GWT
			.create(LMenuViewImplUiBinder.class);

	interface LMenuViewImplUiBinder extends UiBinder<Widget, LMenuViewImpl> {
	}

	public LMenuViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		test();
	}
	public native void test() /*-{
		
	}-*/;
}
