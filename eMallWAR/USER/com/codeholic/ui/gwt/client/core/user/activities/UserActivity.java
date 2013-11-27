package com.codeholic.ui.gwt.client.core.user.activities;

import com.codeholic.ui.gwt.client.core.activities.CoreActivity;
import com.codeholic.ui.gwt.client.core.user.places.UserPlace;
import com.codeholic.ui.gwt.client.core.user.presenters.IUserPresenter;
import com.codeholic.ui.gwt.client.core.user.views.IUserView;
import com.codeholic.ui.gwt.shared.user.dto.User;
import com.codeholic.ui.gwt.shared.user.service.IGWTUserServiceAsync;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.sencha.gxt.widget.core.client.info.Info;

public class UserActivity extends CoreActivity<User, IUserView, UserPlace> implements IUserPresenter{

	
	private IGWTUserServiceAsync serviceAsync;
	
	public UserActivity(UserPlace place) {
		super(place);
		this.view = injector.getUserView();
		this.serviceAsync = injector.getUserServiceAsync();
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
	public void start(AcceptsOneWidget panel, EventBus arg1) {
		
		bind();
		
		panel.setWidget(view.asWidget());
		
	}

	@Override
	public void bind() {
		this.view.setPresenter(this);
	}


	@Override
	public void onSaveUser(User user) {
		serviceAsync.editUserInfo(user, new AsyncCallback<Boolean>() {
			
			@Override
			public void onSuccess(Boolean arg0) {
				if(arg0){
					Info.display("Succeed","Update User Successful");
					view.reloadGrid();
				}else{
					Info.display("Fail", "Update User Failed");
				}
			}
			
			@Override
			public void onFailure(Throwable arg0) {
				Info.display("Fail", "Update User Failed");
			}
		});
		
	}

	@Override
	public void onDeleteUser(String userId) {
		serviceAsync.removeUser(userId, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable arg0) {
				Info.display("Fail", "Remove User Failed");
			}

			@Override
			public void onSuccess(Boolean arg0) {
				if(arg0){
					Info.display("Success", "Remove User Successful");
					view.cleanFormField();
					view.reloadGrid();
				}else {
					Info.display("Fail", "Remove User Failed");
				}
			}
		});
	}

	@Override
	public void onAddUser(User user) {
		serviceAsync.addUser(user, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable arg0) {
				Info.display("Fail", "Add User Failed");
			}

			@Override
			public void onSuccess(Boolean arg0) {
				if(arg0){
					Info.display("Success", "Add User Successful");
					view.reloadGrid();
				}else {
					Info.display("Fail", "Add User Failed");
				}
			}
		});
	}

}
