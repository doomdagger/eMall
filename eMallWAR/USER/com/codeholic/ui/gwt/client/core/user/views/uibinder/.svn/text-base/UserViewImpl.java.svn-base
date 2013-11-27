package com.codeholic.ui.gwt.client.core.user.views.uibinder;

import java.util.ArrayList;
import java.util.List;

import com.codeholic.ui.gwt.client.core.user.presenters.IUserPresenter;
import com.codeholic.ui.gwt.client.core.user.ui.PairProperties;
import com.codeholic.ui.gwt.client.core.user.ui.UserProperties;
import com.codeholic.ui.gwt.client.core.user.views.IUserView;
import com.codeholic.ui.gwt.shared.user.dto.Pair;
import com.codeholic.ui.gwt.shared.user.dto.User;
import com.codeholic.ui.gwt.shared.user.service.IGWTUserService;
import com.codeholic.ui.gwt.shared.user.service.IGWTUserServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.core.client.IdentityValueProvider;
import com.sencha.gxt.data.client.loader.RpcProxy;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import com.sencha.gxt.fx.client.Draggable;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.Popup;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.AbstractHtmlLayoutContainer.HtmlData;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.RefreshEvent;
import com.sencha.gxt.widget.core.client.event.RowClickEvent;
import com.sencha.gxt.widget.core.client.event.RowClickEvent.RowClickHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel.LabelAlign;
import com.sencha.gxt.widget.core.client.form.FormPanelHelper;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.CheckBoxSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

public class UserViewImpl extends Composite implements IUserView {

	private static UserViewImplUiBinder uiBinder = GWT
			.create(UserViewImplUiBinder.class);

	private IUserPresenter presenter;

	interface UserViewImplUiBinder extends UiBinder<Widget, UserViewImpl> {
	}

	public UserViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		parentPanel.setWidth("100%");
		parentPanel.setHeight("100%");

		VerticalPanel subPanel = new VerticalPanel();
		subPanel.setWidth("100%");
		subPanel.setHeight("100%");
		subPanel.add(createToolBar());
		subPanel.add(createGrid());
		subPanel.add(createForm());

		popup.add(createAddPanel());
		new Draggable(popup, popup).setUseProxy(false);
		
		parentPanel.add(subPanel);
	}

	@Override
	public void setPresenter(IUserPresenter presenter) {
		this.presenter = presenter;
	}

	@UiField
	SimplePanel parentPanel;

	/*
	 * Add User Panel
	 */
	Popup popup = new Popup();
	public Widget createAddPanel(){
		FramedPanel panel = new FramedPanel();
		panel.setHeadingText("Add A User");
		panel.setWidth(350);
		panel.setBodyStyle("background: none; padding: 5px");

		VerticalLayoutContainer p = new VerticalLayoutContainer();
		panel.add(p);

		final TextField userName = new TextField();
		userName.setAllowBlank(false);
		userName.setEmptyText("Enter your User Name...");
		userName.addValueChangeHandler(new ValueChangeHandler<String>() {
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				Info.display(
						"Value Changed",
						"First name changed to " + event.getValue() == null ? "blank"
								: event.getValue());
			}
		});
		p.add(new FieldLabel(userName, "User Name"), new VerticalLayoutData(1, -1));

		PairProperties pairProperties = GWT.create(PairProperties.class);
		ListStore<Pair> addFormStore = new ListStore<Pair>(pairProperties.theKey());
		
		Pair pair1 = new Pair(0, "超级管理员");
		Pair pair2 = new Pair(1, "数据分析员");
		Pair pair3 = new Pair(2, "大机操作员");
		addFormStore.add(pair1);
		addFormStore.add(pair2);
		addFormStore.add(pair3);

		final ComboBox<Pair> combo = new ComboBox<Pair>(addFormStore, pairProperties.valueLabel());

		combo.setAllowBlank(false);
		combo.setForceSelection(true);
		combo.setTriggerAction(TriggerAction.ALL);
		
		
		p.add(new FieldLabel(combo, "User Role"), new VerticalLayoutData(1, -1));

		TextButton addButton = new TextButton("Add");
		TextButton cancelButton = new TextButton("Cancel");
		
		addButton.addSelectHandler(new SelectHandler() {
			
			@Override
			public void onSelect(SelectEvent event) {
				User user = new User();
				user.setUserName(userName.getText());
				user.setUserRole(combo.getValue().getKey());
				user.setUserStatus((byte)0);
				user.setUserPass("1234");
				presenter.onAddUser(user);
				popup.setAutoHide(true);
				popup.hide();
				userName.setText("");
			}
		});
		
		cancelButton.addSelectHandler(new SelectHandler() {
			
			@Override
			public void onSelect(SelectEvent event) {
				popup.setAutoHide(true);
				popup.hide();

			}
		});
		
		panel.addButton(addButton);
		panel.addButton(cancelButton);

		return panel;
	}
	
	/*
	 * Add User toolBar
	 */
	public Widget createToolBar(){
		ToolBar toolbar = new ToolBar();
		
		TextButton addUserButton = new TextButton("Add User");
		
		addUserButton.addSelectHandler(new SelectHandler() {
			
			@Override
			public void onSelect(SelectEvent event) {
				popup.setAutoHide(false);
				popup.show();
			}
		});
		
		toolbar.add(addUserButton);
		toolbar.setLayoutData(new VerticalLayoutData(1, -1));
		return toolbar;
	}
	
	
	/*
	 * Grid Now
	 */
	UserProperties props = GWT.create(UserProperties.class);
	ListStore<User> store = new ListStore<User>(props.key());
	Grid<User> grid;

	public Widget createGrid() {
		final IGWTUserServiceAsync service = GWT.create(IGWTUserService.class);

		RpcProxy<PagingLoadConfig, PagingLoadResult<User>> proxy = new RpcProxy<PagingLoadConfig, PagingLoadResult<User>>() {
			@Override
			public void load(PagingLoadConfig loadConfig,
					AsyncCallback<PagingLoadResult<User>> callback) {
				service.getUsers(loadConfig, callback);
			}
		};

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

		grid = new Grid<User>(store, cm) {
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

		grid.addRowClickHandler(getGridRowClickHandler());

		return cp;
	}

	public RowClickHandler getGridRowClickHandler() {
		return new RowClickHandler() {

			@Override
			public void onRowClick(RowClickEvent event) {
				int i = event.getRowIndex();
				User user = store.get(i);
				applyView(user);
			}
		};
	}

	
	
	
	
	/*
	 *  Form Now
	 */
	private static final int COLUMN_FORM_WIDTH = 900;

	TextField userId = new TextField();
	final TextField userName = new TextField();
	ComboBox<Pair> combo;
	User currentUser = null;
	PairProperties pairProperties = GWT.create(PairProperties.class);
	ListStore<Pair> formStore = new ListStore<Pair>(pairProperties.theKey());

	public void applyView(User user) {
		currentUser = user;
		userId.setText(currentUser.getUserId());
		userName.setText(currentUser.getUserName());
		int userRole = currentUser.getUserRole();
		combo.setValue(formStore.get(userRole),true);
	}

	public Widget createForm() {
		FramedPanel panel = new FramedPanel();
		panel.setHeadingText("Selected User");
		panel.setWidth("100%");
		// panel.getElement().getStyle().setPadding(10, Unit.PX);

		HtmlLayoutContainer con = new HtmlLayoutContainer(getTableMarkup());
		panel.setWidget(con);

		int cw = (COLUMN_FORM_WIDTH / 5) - 12;

		userId.setReadOnly(true);
		userId.setAllowBlank(false);
		userId.setWidth(cw * 2);
		con.add(new FieldLabel(userId, "User Id"), new HtmlData(".fn"));

		userName.setAllowBlank(false);
		userName.setWidth(cw);
		con.add(new FieldLabel(userName, "User Name"), new HtmlData(".ln"));

		
		Pair pair1 = new Pair(0, "超级管理员");
		Pair pair2 = new Pair(1, "数据分析员");
		Pair pair3 = new Pair(2, "大机操作员");
		formStore.add(pair1);
		formStore.add(pair2);
		formStore.add(pair3);

		combo = new ComboBox<Pair>(formStore, pairProperties.valueLabel());

		combo.addValueChangeHandler(new ValueChangeHandler<Pair>() {
			@Override
			public void onValueChange(ValueChangeEvent<Pair> event) {
				Info.display("Warn",
						"You Change the Role of User: " + userName.getText()
								+ " to " + event.getValue());
			}
		});
		combo.setForceSelection(true);
		combo.setTriggerAction(TriggerAction.ALL);

		con.add(new FieldLabel(combo, "User Role"), new HtmlData(".ln"));

		TextButton resetButton = new TextButton("Reset");
		TextButton saveButton = new TextButton("Save");
		TextButton deleteButton = new TextButton("Delete");
		
		resetButton.addSelectHandler(new SelectHandler() {
			
			@Override
			public void onSelect(SelectEvent event) {
				userName.setText(currentUser.getUserName());
				combo.setValue(formStore.get(currentUser.getUserRole()), true);
			}
		});
		
		saveButton.addSelectHandler(new SelectHandler() {
			
			@Override
			public void onSelect(SelectEvent event) {
				if(currentUser==null||userId.getText().trim().equals(""))
					return;
				currentUser.setUserName(userName.getText());
				currentUser.setUserRole(combo.getValue().getKey());
				presenter.onSaveUser(currentUser);
				
			}
		});
		
		deleteButton.addSelectHandler(new SelectHandler() {
			
			@Override
			public void onSelect(SelectEvent event) {
				if(userId.getText().trim().equals(""))
					return;
				presenter.onDeleteUser(userId.getText());
				currentUser = null;
			}
		});
		
		panel.addButton(resetButton);
		panel.addButton(saveButton);
		panel.addButton(deleteButton);
		
		// need to call after everything is constructed
		List<FieldLabel> labels = FormPanelHelper.getFieldLabels(panel);
		for (FieldLabel lbl : labels) {
			lbl.setLabelAlign(LabelAlign.TOP);
		}

		return panel;
	}

	private native String getTableMarkup() /*-{
		return [
				'<table width=100% cellpadding=0 cellspacing=0>',
				'<tr><td class=fn width=50%></td><td class=ln width=50%></td></tr>',
				'<tr><td class=company></td><td class=email></td></tr>',
				'<tr><td class=birthday></td><td class=user></td></tr>',
				'<tr><td class=editor colspan=2></td></tr>', '</table>'

		].join("");
	}-*/;

	
	
	@Override
	public void reloadGrid() {
		grid.getLoader().load();
	}

	@Override
	public void cleanFormField() {
		userId.setText("");
		userName.setText("");
	}

}
