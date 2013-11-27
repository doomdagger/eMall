package com.codeholic.ui.gwt.client.core.ui;

import com.codeholic.ui.gwt.client.EMallAppPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LoginPanelImpl extends Composite {

	private EMallAppPresenter presenter;
	
	private static LoginPanelImplUiBinder uiBinder = GWT
			.create(LoginPanelImplUiBinder.class);

	interface LoginPanelImplUiBinder extends UiBinder<Widget, LoginPanelImpl> {
	}

	public LoginPanelImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField TextBox userNameField;
	
	public String getUserName(){
		return userNameField.getText();
	}
	
	@UiField PasswordTextBox userPassField;
	
	public String getUserPassword(){
		return userPassField.getText();
	}
	
	@UiField Button loginButton;
	
	@UiHandler("loginButton")
	void onClick(ClickEvent e) {
		presenter.onLogin();
	}
	
	public void setPresenter(EMallAppPresenter presenter){
		this.presenter = presenter;
	}
	
}
