package com.codeholic.ui.gwt.client.core.dict;

import com.codeholic.ui.gwt.client.core.dict.views.IDictView;
import com.codeholic.ui.gwt.shared.dict.service.IDictServiceAsync;

public interface DictGinjector {
	public IDictServiceAsync getIDictServiceAsync();
	public IDictView getDictView();
}
