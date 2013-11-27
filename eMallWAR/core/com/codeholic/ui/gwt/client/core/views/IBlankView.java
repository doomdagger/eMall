package com.codeholic.ui.gwt.client.core.views;

import com.codeholic.ui.gwt.client.core.presenters.IBlankPresenter;
import com.google.gwt.user.client.ui.HasValue;

public interface IBlankView extends ICoreView<IBlankPresenter>{
	
	void setLabel(String value);
	
	HasValue<String> getLabelValue();

}
