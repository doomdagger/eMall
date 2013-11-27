package com.codeholic.ui.gwt.client.core.user.ui;

import java.util.ArrayList;
import java.util.List;

import com.codeholic.ui.gwt.shared.user.dto.User;
import com.codeholic.ui.gwt.shared.user.service.IGWTUserService;
import com.codeholic.ui.gwt.shared.user.service.IGWTUserServiceAsync;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.IdentityValueProvider;
import com.sencha.gxt.data.client.loader.RpcProxy;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.RefreshEvent;
import com.sencha.gxt.widget.core.client.event.RowClickEvent;
import com.sencha.gxt.widget.core.client.event.RowClickEvent.RowClickHandler;
import com.sencha.gxt.widget.core.client.grid.CheckBoxSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;

public class PagingGridExample implements IsWidget, EntryPoint {

	@Override
	public void onModuleLoad() {
		RootPanel.get().add(this);
	}

	@Override
	public Widget asWidget() {
		final IGWTUserServiceAsync service = GWT.create(IGWTUserService.class);

		RpcProxy<PagingLoadConfig, PagingLoadResult<User>> proxy = new RpcProxy<PagingLoadConfig, PagingLoadResult<User>>() {
			@Override
			public void load(PagingLoadConfig loadConfig,
					AsyncCallback<PagingLoadResult<User>> callback) {
				service.getUsers(loadConfig, callback);
			}
		};

		UserProperties props = GWT.create(UserProperties.class);

		ListStore<User> store = new ListStore<User>(props.key());

		final PagingLoader<PagingLoadConfig, PagingLoadResult<User>> loader = new PagingLoader<PagingLoadConfig, PagingLoadResult<User>>(
				proxy);
		loader.setRemoteSort(true);
		loader.addLoadHandler(new LoadResultListStoreBinding<PagingLoadConfig, User, PagingLoadResult<User>>(
				store));

		final PagingToolBar toolBar = new PagingToolBar(50);
		toolBar.getElement().getStyle().setProperty("borderBottom", "none");
		toolBar.bind(loader);

		IdentityValueProvider<User> identity = new IdentityValueProvider<User>();
		final CheckBoxSelectionModel<User> sm = new CheckBoxSelectionModel<User>(
				identity) {
			@Override
			protected void onRefresh(RefreshEvent event) {
				// this code selects all rows when paging if the header checkbox
				// is selected
				if (isSelectAllChecked()) {
					selectAll();
				}
				super.onRefresh(event);
			}
		};

		ColumnConfig<User, String> forumColumn = new ColumnConfig<User, String>(
				props.userId(), 300, "User ID");
		ColumnConfig<User, String> usernameColumn = new ColumnConfig<User, String>(
				props.userName(), 150, "User Name");
		ColumnConfig<User, Integer> subjectColumn = new ColumnConfig<User, Integer>(
				props.userRole(), 150, "User Role");
		ColumnConfig<User, Byte> dateColumn = new ColumnConfig<User, Byte>(
				props.userStatus(), 150, "User Status");

		List<ColumnConfig<User, ?>> l = new ArrayList<ColumnConfig<User, ?>>();
		l.add(sm.getColumn());
		l.add(forumColumn);
		l.add(usernameColumn);
		l.add(subjectColumn);
		l.add(dateColumn);

		ColumnModel<User> cm = new ColumnModel<User>(l);

		final Grid<User> grid = new Grid<User>(store, cm) {
			@Override
			protected void onAfterFirstAttach() {
				super.onAfterFirstAttach();
				Scheduler.get().scheduleDeferred(new ScheduledCommand() {
					@Override
					public void execute() {
						loader.load();
					}
				});
			}
		};
		grid.setSelectionModel(sm);
		
		grid.getView().setForceFit(true);
		grid.setLoadMask(true);
		grid.setLoader(loader);

		FramedPanel cp = new FramedPanel();
		cp.setCollapsible(true);
		cp.setHeadingText("User List");
		cp.setWidth("100%");
		cp.setHeight(300);
		cp.addStyleName("margin-10");

		VerticalLayoutContainer con = new VerticalLayoutContainer();
		con.setBorders(true);
		con.add(grid, new VerticalLayoutData(1, 1));
		con.add(toolBar, new VerticalLayoutData(1, -1));
		cp.setWidget(con);

		
		grid.addRowClickHandler(new RowClickHandler() {
			
			@Override
			public void onRowClick(RowClickEvent event) {
				int i = event.getRowIndex();
				User user = grid.getStore().get(i);
			}
		});
		
		return cp;
	}

}