package com.codeholic.ui.gwt.client.core.user.ui;

import com.codeholic.ui.gwt.shared.user.dto.User;
import com.codeholic.ui.gwt.shared.user.dto.UserRole;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent.HasSelectHandlers;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.TextField;

public class UserEditor implements IsWidget, Editor<User> {

	private FormPanel panel;
	private VerticalLayoutContainer container;

	TextField userName;
	ComboBox<UserRole> userRole;

	private TextButton save;

	interface UserRoleAccess extends PropertyAccess<UserRole> {
		@Path("roleCode")
		ModelKeyProvider<UserRole> key();

		@Path("roleDescription")
		LabelProvider<UserRole> descriptionLabel();

		ValueProvider<UserRole, Integer> roleCode();

		ValueProvider<UserRole, String> roleDescription();

	} 
	
	private static UserRoleAccess userRoleAccess = GWT.create(UserRoleAccess.class);
	
	public UserEditor() {
		panel = new FormPanel();
		panel.setLabelWidth(50);

		container = new VerticalLayoutContainer();
		panel.setWidget(container);

		userName = new TextField();
		userName.setEnabled(false);
		
		ListStore<UserRole> store = new ListStore<UserRole>(userRoleAccess.key());
		store.add(new UserRole(0,"超级管理员"));
		store.add(new UserRole(1,"数据分析员"));
		store.add(new UserRole(2,"大机操作员"));
		userRole = new ComboBox<UserRole>(store, userRoleAccess.descriptionLabel());
		
		userRole.setEnabled(false);

		container.add(new FieldLabel(userName, "用户名"), new VerticalLayoutData(
				1, -1));
		container.add(new FieldLabel(userRole, "用户身份"), new VerticalLayoutData(
				1, -1));

		save = new TextButton("Save");
		save.setEnabled(false);
		container.add(save);

		panel.setLabelWidth(50);
	}

	@Override
	public Widget asWidget() {
		return panel;
	}

	public void setSaveEnabled(boolean enabled) {
		save.setEnabled(enabled);
		userName.setEnabled(enabled);
		userRole.setEnabled(enabled);
		if (!enabled) {

			userName.setValue("");
			
		}
	}

	public HasSelectHandlers getSaveButton() {
		return save;
	}
}