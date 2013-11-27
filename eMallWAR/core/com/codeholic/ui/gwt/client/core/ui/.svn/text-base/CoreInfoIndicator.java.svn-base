package com.codeholic.ui.gwt.client.core.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;


public class CoreInfoIndicator extends Composite{
	static CoreInfoIndicator busy;

	@UiField FlowPanel view;

	static public void busy(){
		if (busy == null) busy = new CoreInfoIndicator();
		busy.setVisible(true);
	}
	
	static public void free(){
		if (busy == null) busy = new CoreInfoIndicator();
		busy.setVisible(false);
	}
	
	interface BusyIndicatorUiBinder extends UiBinder<Widget, CoreInfoIndicator> {}
	private static BusyIndicatorUiBinder uiBinder = GWT.create(BusyIndicatorUiBinder.class);

	
	public CoreInfoIndicator(){
		// Implement a simple "Busy" display that can be shown when application is busy.
		initWidget(uiBinder.createAndBindUi(this));
		this.setVisible(false);
		RootPanel.get().add(this,Window.getClientWidth()-200,40);
	}
}
