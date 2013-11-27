package com.codeholic.ui.gwt.client.core.user.ui;

import java.util.ArrayList;
import java.util.List;

import com.codeholic.ui.gwt.client.core.user.ui.UserPagingGrid.UserExchange;
import com.codeholic.ui.gwt.shared.user.dto.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.client.editor.ListStoreEditor;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent.SelectionChangedHandler;

/**
 * Demonstrates using the ListStoreEditor, and some concept of building multiple
 * editors. Note that as currently written, when a User object is saved, it
 * will modify the UserExchange's instances, instead of cloning models before
 * editing them.
 */
public class UserPagingGrid implements IsWidget,
		Editor<UserExchange> {

	public static class UserExchange {
		private List<User> users = UserPagingGrid.getUsers();

		public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}
	}

	interface ListDriver extends
			SimpleBeanEditorDriver<UserExchange, UserPagingGrid> {
	}

	interface UserDriver extends SimpleBeanEditorDriver<User, UserEditor> {
	}

	private ListDriver driver = GWT.create(ListDriver.class);

	private UserDriver itemDriver = GWT.create(UserDriver.class);

	private FramedPanel panel;

	Grid<User> userList;
	ListStoreEditor<User> users;

	@Ignore
	UserEditor userEditor;

	@Override
	public Widget asWidget() {
		if (panel == null) {
			panel = new FramedPanel();
			panel.setHeadingText("用户列表");
			panel.setPixelSize(500, 450);
			panel.setBodyBorder(false);

			panel.addStyleName("margin-10");

			VerticalLayoutContainer c = new VerticalLayoutContainer();

			final UserProperties props = GWT.create(UserProperties.class);

			List<ColumnConfig<User, ?>> columns = new ArrayList<ColumnConfig<User, ?>>();
			columns.add(new ColumnConfig<User, String>(props.userName(), 200,
					"用户名"));
			columns.add(new ColumnConfig<User, Integer>(props.userRole(), 200,
					"用户身份"));

			userList = new Grid<User>(new ListStore<User>(props.key()),
					new ColumnModel<User>(columns));
			userList.getSelectionModel()
					.setSelectionMode(SelectionMode.SINGLE);
			userList.setBorders(true);

			users = new ListStoreEditor<User>(userList.getStore());

			c.add(userList, new VerticalLayoutData(1, 1));
			userList.getSelectionModel().addSelectionChangedHandler(
					new SelectionChangedHandler<User>() {
						@Override
						public void onSelectionChanged(
								SelectionChangedEvent<User> event) {
							if (event.getSelection().size() > 0) {
								edit(event.getSelection().get(0));
							} else {
								userEditor.setSaveEnabled(false);
							}
						}
					});

			userEditor = new UserEditor();

			userEditor.getSaveButton().addSelectHandler(new SelectHandler() {

				@Override
				public void onSelect(SelectEvent event) {
					saveCurrentUser();

				}
			});
			c.add(userEditor, new VerticalLayoutData(1, -1, new Margins(5)));
			panel.add(c);

			itemDriver.initialize(userEditor);
			driver.initialize(this);
		}

		driver.edit(new UserExchange());
		return panel;
	}

	

	protected void edit(User User) {
		itemDriver.edit(User);
		userEditor.setSaveEnabled(true);
	}

	protected void saveCurrentUser() {
		User edited = itemDriver.flush();
		if (!itemDriver.hasErrors()) {
			userEditor.setSaveEnabled(false);

			userList.getStore().update(edited);
		}
	}

	public static List<User> getUsers() {
		List<User> users = new ArrayList<User>();

		User user = new User();
		user.setUserId("94ds9f08r23jfdslaj");
		user.setUserName("李赫");
		user.setUserRole(0);
		user.setUserStatus((byte)0);
		users.add(user);
		
		User user2 = new User();
		user2.setUserId("94ds9f08r23jfdslaj");
		user2.setUserName("超超");
		user2.setUserRole(1);
		user2.setUserStatus((byte)0);
		users.add(user2);
		
		User user3 = new User();
		user3.setUserId("94ds9f08r23jfdslaj");
		user3.setUserName("小辉");
		user3.setUserRole(1);
		user3.setUserStatus((byte)0);
		users.add(user3);
		
		return users;

	}

}