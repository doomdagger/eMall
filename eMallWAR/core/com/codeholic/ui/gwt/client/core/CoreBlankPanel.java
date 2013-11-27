package com.codeholic.ui.gwt.client.core;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;


public class CoreBlankPanel extends Composite {
	SimplePanel container = new SimplePanel();

	// This would be the onModuleLoad method of a normal application (but as we
	// wrap into our GWTiA framework, it sits on its own)
	public CoreBlankPanel() {
		ScrollPanel scrollPanel = new ScrollPanel(container);
		new CoreApp(container);
		initWidget(scrollPanel);
		container.setSize("100%", "100%");
	}
}
