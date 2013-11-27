package com.codeholic.ui.gwt.client.core.dict.views.uibinder;

import java.util.ArrayList;
import java.util.HashMap;

import com.codeholic.ui.gwt.client.core.dict.presenters.IDictPresenter;
import com.codeholic.ui.gwt.client.core.dict.views.IDictView;
import com.codeholic.ui.gwt.shared.dict.dto.DictDto;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;

public class DictViewImpl extends Composite implements IDictView {
	
	private IDictPresenter presenter;

	private static DictViewImplUiBinder uiBinder = GWT
			.create(DictViewImplUiBinder.class);

	interface DictViewImplUiBinder extends UiBinder<Widget, DictViewImpl> {}
	
	public DictViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void addAll(ArrayList<DictDto> list){
		for(DictDto data : list){
			currItem.addItem(getChildTreeItem(data));
		}
		
	}

	@Override
	public void initView() {
		dictTree.addItem(treeRoot);
		this.presenter.getDictList();
	}
	
	@UiField Tree dictTree;
	TreeItem treeRoot = new TreeItem();
	TreeItem currItem = null;
	
	@UiHandler("dictTree")
	void treeOpen(OpenEvent<TreeItem> event){
		TreeItem item = event.getTarget();
		
		if(!item.getHTML().equals("")){
			this.currItem = item;
			item.removeItems();
			this.presenter.getDictChildList(item.getText());
		}
		
	}

	@Override
	public void setPresenter(IDictPresenter presenter) {
		this.presenter = presenter;
	}

	
	@Override
	public void setDictField_TreeView(HashMap<String, String> fieldMap) {
		java.util.Set<String> keys = fieldMap.keySet();
		for (String key : keys) {
			TreeItem item = this.getRootTreeItem(key, fieldMap.get(key));
			treeRoot.addItem(item);
			item.addTextItem("");
		}
		treeRoot.setState(true);
	}
	
	//设置field
	private TreeItem getRootTreeItem(final String field_code, final String field_name){
		final TreeItem item = new TreeItem();
		
		final HorizontalPanel panel = new HorizontalPanel();
		panel.setSpacing(3);
		
		Label text = new Label(field_name);
		Button updateBtn = new Button("修改");
		
		updateBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				DialogBox box = getFiled_DialogBox(field_code, field_name);
				
				DialogBox dialogBox = new DialogBox();
				dialogBox.setAnimationEnabled(true);
				
				box.center();
				box.show();
			}
		});
		
		panel.add(text);
		panel.add(updateBtn);
		item.setWidget(panel);
		
		return item;
	}

	//设置label
	private TreeItem getChildTreeItem(final DictDto model){
		final TreeItem child = new TreeItem();
		final HorizontalPanel panel = new HorizontalPanel();
		panel.setSpacing(3);
		
		Label text = new Label(model.getLabel());
		Button updateBtn = new Button("修改");
		Button delBtn = new Button("删除");
		
		delBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				presenter.deleteLabel(model.getDictId());
				
				if (child.getParentItem().getChildCount() == 1) {
					child.getParentItem().remove();
				}else {
					child.remove();
				}
			}
		});
		
		updateBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				presenter.updateLabel(model);
			}
		});
		
		panel.add(text);
		panel.add(updateBtn);
		panel.add(delBtn);
		child.setWidget(panel);
		return child;
	}
	
	//设置更新 域 对话框
	private DialogBox getFiled_DialogBox(final String field_code, final String field_name){
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setAnimationEnabled(true);
		
		HorizontalPanel panel = new HorizontalPanel();
		final TextBox textBox = new TextBox();
		Button saveBtn = new Button("保存");
		Button canBtn = new Button("取消");

		textBox.setText(field_name);
		dialogBox.setText("修改数据字典属性");
		
		saveBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				presenter.updateField_name(field_code, textBox.getText());
				dialogBox.hide();
			}
		});
		canBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				dialogBox.hide();
			}
		});
		
		
		panel.add(textBox);
		panel.add(saveBtn);
		panel.add(canBtn);
		dialogBox.add(panel);
		return dialogBox;
	}
	
	//设置更新 model 对话框
	private DialogBox getModel_DialogBox(DictDto model){
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setAnimationEnabled(true);
		
		HorizontalPanel panel = new HorizontalPanel();
		Button saveBtn = new Button("保存");
		Button canBtn = new Button("取消");
		
		dialogBox.setText("修改数据字典属性");
		
		panel.add(saveBtn);
		panel.add(canBtn);
		dialogBox.add(panel);
		return dialogBox;
	}
}
