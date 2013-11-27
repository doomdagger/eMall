package com.codeholic.ui.gwt.client.core.user;

import com.codeholic.ui.gwt.client.core.CoreViewBinder;
import com.codeholic.ui.gwt.client.core.user.views.IUserView;
import com.codeholic.ui.gwt.client.core.user.views.uibinder.UserViewImpl;

public class UserViewBinder extends CoreViewBinder{

	@Override
	public void bind() {
		bind(IUserView.class, UserViewImpl.class);
	}
	
}
