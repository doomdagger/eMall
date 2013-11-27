package com.codeholic.ui.gwt.client.core.user.ui;

import com.codeholic.ui.gwt.shared.user.dto.User;
import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface UserProperties extends PropertyAccess<User> {
	@Path("userId")
	ModelKeyProvider<User> key();

	@Path("userName")
	LabelProvider<User> nameLabel();

	ValueProvider<User, String> userName();

	ValueProvider<User, Integer> userRole();
	
	ValueProvider<User, Byte> userStatus();
	
	ValueProvider<User, String> userId();

}