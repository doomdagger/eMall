package com.codeholic.ui.gwt.client.core.views.hardcoded;

import com.codeholic.ui.gwt.client.core.presenters.IBlankPresenter;
import com.codeholic.ui.gwt.client.core.ui.BlankLabel;
import com.codeholic.ui.gwt.client.core.ui.CorePieChart;
import com.codeholic.ui.gwt.client.core.views.IBlankView;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

public class BlankViewImpl implements IBlankView{
	private IBlankPresenter presenter;
	
	private FocusPanel focusPanel = new FocusPanel();
	private final BlankLabel label = new BlankLabel("Hello~~~");
	 
	@Override
	public Widget asWidget() {
		FlowPanel panel = new FlowPanel();
		panel.add(label);
		panel.add(new CorePieChart());
		focusPanel.add(panel);
		
		bind();
		
		return focusPanel;
	}

	@Override
	public void setPresenter(IBlankPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void setLabel(String value) {
		label.setText(value);
	}

	@Override
	public HasValue<String> getLabelValue() {
		return label;
	}
	
	public void bind(){
		focusPanel.addMouseOverHandler(new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				//Info.display("Hello", "Bitch");
				presenter.onUpdateLabelValue();
			}
		});
	}

}
