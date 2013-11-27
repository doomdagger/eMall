package com.codeholic.ui.gwt.client;

import com.codeholic.ui.gwt.client.core.ui.LoginPanelImpl;
import com.codeholic.ui.gwt.shared.user.dto.User;
import com.google.gwt.user.client.ui.Composite;

public class EMallAppLoginPanel extends Composite{
	private LoginPanelImpl loginPanelImpl;
	
	public EMallAppLoginPanel(){
		//SimplePanel panel = new SimplePanel();
		loginPanelImpl = new LoginPanelImpl();
		//panel.add(loginPanelImpl);
		initWidget(loginPanelImpl);
	}
	
	public void setPresenter(EMallAppPresenter presenter){
		loginPanelImpl.setPresenter(presenter);
	}
	
	public User getUser(){
		User user = new User();
		user.setUserName(loginPanelImpl.getUserName());
		user.setUserPass(loginPanelImpl.getUserPassword());
		return user;
	}
}
