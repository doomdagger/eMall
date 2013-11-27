package com.codeholic.ui.gwt.client.core.user;

import com.codeholic.ui.gwt.client.core.user.views.IUserView;
import com.codeholic.ui.gwt.shared.user.service.IGWTUserServiceAsync;

public interface UserGinjector {
	IGWTUserServiceAsync getUserServiceAsync();
	IUserView getUserView();
}
