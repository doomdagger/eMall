package com.codeholic.ui.gwt.client.core.dict;


import com.codeholic.ui.gwt.client.core.CoreViewBinder;
import com.codeholic.ui.gwt.client.core.dict.views.IDictView;
import com.codeholic.ui.gwt.client.core.dict.views.uibinder.DictViewImpl;

public class DictViewBinder extends CoreViewBinder{
	
	public void bind(){
		bind(IDictView.class,DictViewImpl.class);
	}
	
	
}
