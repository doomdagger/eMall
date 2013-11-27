package com.codeholic.ui.gwt.client.core.user.ui;

import java.util.List;

import com.codeholic.ui.gwt.shared.user.dto.Pair;
import com.codeholic.ui.gwt.shared.user.dto.User;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.AbstractHtmlLayoutContainer.HtmlData;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel.LabelAlign;
import com.sencha.gxt.widget.core.client.form.FormPanelHelper;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.info.Info;

public class AdvancedFormsExample implements IsWidget, EntryPoint {

	public void onModuleLoad() {
		RootPanel.get().add(asWidget());
	}

	
	private static final int COLUMN_FORM_WIDTH = 900;
	
	TextField userId = new TextField();
	final TextField userName = new TextField();
	ComboBox<Pair> combo;
	User currentUser = null;
	
	
	public void applyView(User user){
		currentUser = user;
		userId.setText(currentUser.getUserId());
		userName.setText(currentUser.getUserName());
		int userRole = currentUser.getUserRole();
		
		combo.select(new Pair(userRole,""));
	}
	
	
	public Widget asWidget() {
		FramedPanel panel = new FramedPanel();
		panel.setHeadingText("Selected User");
		panel.setWidth("100%");
		//panel.getElement().getStyle().setPadding(10, Unit.PX);
		
		HtmlLayoutContainer con = new HtmlLayoutContainer(getTableMarkup());
		panel.setWidget(con);

		
		int cw = (COLUMN_FORM_WIDTH / 5) - 12;

		userId.setReadOnly(true);
		userId.setAllowBlank(false);
		userId.setWidth(cw*2);
		con.add(new FieldLabel(userId, "User Id"), new HtmlData(".fn"));

		userName.setAllowBlank(false);
		userName.setWidth(cw);
		con.add(new FieldLabel(userName, "User Name"), new HtmlData(".ln"));

		PairProperties props = GWT.create(PairProperties.class);
		ListStore<Pair> store = new ListStore<Pair>(props.theKey());
		Pair pair1 = new Pair(0,"超级管理员");
		Pair pair2 = new Pair(1,"数据分析员");
		Pair pair3 = new Pair(2,"大机操作员");
		store.add(pair1);
		store.add(pair2);
		store.add(pair3);

		combo = new ComboBox<Pair>(store, props.valueLabel());
		
		combo.addValueChangeHandler(new ValueChangeHandler<Pair>() {
			@Override
			public void onValueChange(ValueChangeEvent<Pair> event) {
				Info.display("Warn", "You Change the Role of User: "+userName.getText()+" to "+event.getValue());
			}
		});
		combo.setForceSelection(true);
		combo.setTriggerAction(TriggerAction.ALL);
		
		con.add(new FieldLabel(combo, "User Role"), new HtmlData(".ln"));
		

		
		panel.addButton(new TextButton("Reset"));
		panel.addButton(new TextButton("Save"));

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

}