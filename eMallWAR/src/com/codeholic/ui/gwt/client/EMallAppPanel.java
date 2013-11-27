package com.codeholic.ui.gwt.client;

import com.codeholic.ui.gwt.client.core.CoreBlankPanel;
import com.codeholic.ui.gwt.client.core.ui.LMenuViewImpl;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;

public class EMallAppPanel extends Composite {

	//private DockLayoutPanel dockLayoutPanel;
	
	public EMallAppPanel() {
		/*
		 * dockLayoutPanel = new DockLayoutPanel(Unit.PX); SimplePanel menuPanel
		 * = new SimplePanel(); menuPanel.add(menuView);
		 * 
		 * menuView = new LMenuViewImpl(); blankPanel = new CoreBlankPanel();
		 * 
		 * dockLayoutPanel.addWest(menuPanel,200);
		 * dockLayoutPanel.add(blankPanel);
		 * 
		 * initWidget(dockLayoutPanel);
		 */
		// SimplePanel simplePanel = new SimplePanel();
		// menuView = new LMenuViewImpl();
		// simplePanel.add(menuView);

		//SimplePanel simplePanel = new SimplePanel();
		LMenuViewImpl menu = new LMenuViewImpl();
		DockLayoutPanel panel = new DockLayoutPanel(Unit.PX);
		CoreBlankPanel blankPanel = new CoreBlankPanel();
		panel.addWest(menu, 230);
		panel.add(blankPanel);

		initWidget(panel);
	}
}
