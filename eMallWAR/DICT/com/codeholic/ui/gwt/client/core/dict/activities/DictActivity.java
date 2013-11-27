package com.codeholic.ui.gwt.client.core.dict.activities;

import java.util.ArrayList;
import java.util.HashMap;

import com.codeholic.ui.gwt.client.core.activities.CoreActivity;
import com.codeholic.ui.gwt.client.core.dict.places.DictPlace;
import com.codeholic.ui.gwt.client.core.dict.presenters.IDictPresenter;
import com.codeholic.ui.gwt.client.core.dict.views.IDictView;
import com.codeholic.ui.gwt.shared.dict.dto.DictDto;
import com.codeholic.ui.gwt.shared.dict.service.IDictServiceAsync;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class DictActivity extends CoreActivity<DictDto, IDictView, DictPlace> implements  IDictPresenter {

	//如有需要，存相关的实体对象，或存一些可重用字段
	private String name;
	//与本activity相关的异步处理接口，进行RPC调用与model交互
	private IDictServiceAsync serviceAsync;
	
	
	public DictActivity(DictPlace place) {
		super(place);
		this.name = tokens[0];
		this.serviceAsync = injector.getIDictServiceAsync();
		this.view = injector.getDictView();
	}
	@Override
	public String mayStop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCancel() {
		if(httpRequest!=null&&httpRequest.isPending()){
			httpRequest.cancel();
		}
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus event) {
		bind();
		panel.setWidget(view.asWidget());
		this.view.initView();
	}

	@Override
	public void bind() {
		this.view.setPresenter(this);
	}
	@Override
	public void getDictList() {
		 serviceAsync.getDicFieldtList(new AsyncCallback<HashMap<String, String> >() {

			@Override
			public void onFailure(Throwable arg0) {
				System.out.println("presenter faild.....");
			}

			@Override
			public void onSuccess(HashMap<String, String> items) {
				view.setDictField_TreeView(items);
			}
		});
	}
	@Override
	public void getDictChildList(String field_name) {
		serviceAsync.getDictChildList(field_name, new AsyncCallback<ArrayList<DictDto>>() {

			@Override
			public void onFailure(Throwable arg0) {
				System.out.println(arg0.getMessage());
				
			}

			@Override
			public void onSuccess(ArrayList<DictDto> arg0) {
				view.addAll(arg0);
			}
		});
	}
	@Override
	public void updateField_name(String field_code, String newField_name) {
		serviceAsync.updateField(field_code, newField_name, new AsyncCallback<Boolean>() {
			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onSuccess(Boolean arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	@Override
	public void deleteLabel(String dictId) {
		serviceAsync.deleteLabel(dictId, new AsyncCallback<Boolean>() {
			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onSuccess(Boolean arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	@Override
	public void updateLabel(DictDto model) {

		serviceAsync.updateLabel(model, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Boolean arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
}
