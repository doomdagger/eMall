package com.codeholic.ui.gwt.client.core.views;

import com.codeholic.ui.gwt.client.core.presenters.ICorePresenter;
import com.google.gwt.user.client.ui.IsWidget;

public interface ICoreView<T extends ICorePresenter> extends IsWidget{
	/*
	 * 暴露一些控件的属性给Presenter，方便Presenter获取控件属性，或改变控件属性，
	 * 所有的方法基本上不由View自己调用，而是留给Presenter调用以改变View自身，
	 * 无论如何，都要留有一个设置Presenter的方法，设置为专属此View的Presenter，以便于View
	 * 在响应事件时调用Presenter的方法与model交互，获取model值，或改变model值
	 */
	
	public void setPresenter(T presenter);
}
