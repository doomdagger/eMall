package com.codeholic.ui.gwt.client.core.activities;

import com.codeholic.ui.gwt.client.core.events.CoreEvent;
import com.codeholic.ui.gwt.client.core.places.BlankPlace;
import com.codeholic.ui.gwt.client.core.presenters.IBlankPresenter;
import com.codeholic.ui.gwt.client.core.views.IBlankView;
import com.codeholic.ui.gwt.shared.dto.BlankMessage;
import com.codeholic.ui.gwt.shared.service.receipt.IBlankServiceAsync;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class BlankActivity extends CoreActivity<BlankMessage, IBlankView, BlankPlace> implements IBlankPresenter{

	
	private String name;
	
	//与本activity相关的异步处理接口，进行RPC调用与model交互
	private IBlankServiceAsync serviceAsync;
	
	
	public BlankActivity(BlankPlace place){
		super(place);
		this.name = tokens[0];
		this.serviceAsync = injector.getIBlankServiceAsync();
		this.view = injector.getIBlankView();
	}
	
	
	//********************Presenter Logic Started************************
	@Override
	public void bind() {
		view.setPresenter(this);
	}

	@Override
	public void onUpdateLabelValue() {
		eventBus.fireEvent(new CoreEvent());
		
		//可以调用RPC来更新Server端Model的值
		//serviceAsync.fetchBlankMessage(name, callback);
		
		serviceAsync.fetchBlankMessage(name, new AsyncCallback<BlankMessage>() {

			@Override
			public void onFailure(Throwable throwable) {
				
			}

			@Override
			public void onSuccess(BlankMessage msg) {
				model = msg;
				view.getLabelValue().setValue(model.getMessage());
			}
		});
		
	}
	//********************Presenter Logic Ended************************
	
	//********************Activity Life-cycle Started************************
	@Override
	public String mayStop() {
		//return "Now you are in MayStop Life_cycle method";
		return null;
	}

	@Override
	public void onCancel() {
		if(httpRequest!=null&&httpRequest.isPending()){
			httpRequest.cancel();
			Window.alert("Cancelling RPC");
		}
	}

	@Override
	public void onStop() {
		if(view!=null){
			view.getLabelValue().setValue("");
		}
	}

	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		
		bind();
		
		this.eventBus.fireEvent(new CoreEvent());
		//CoreInfoIndicator.busy();

		httpRequest = serviceAsync.fetchBlankMessage(name, new AsyncCallback<BlankMessage>() {
			
			@Override
			public void onSuccess(BlankMessage msg) {
				model = msg;
				view.getLabelValue().setValue(model.getMessage());
				panel.setWidget(view.asWidget());
			}
			
			@Override
			public void onFailure(Throwable throwable) {
				
			}
		});
	}
	//********************Activity Life-cycle Ended************************

}
