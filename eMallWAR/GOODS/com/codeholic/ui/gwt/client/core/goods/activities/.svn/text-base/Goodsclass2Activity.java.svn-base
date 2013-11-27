package com.codeholic.ui.gwt.client.core.goods.activities;

import com.codeholic.ui.gwt.client.core.activities.CoreActivity;
import com.codeholic.ui.gwt.client.core.goods.places.Goodsclass2Place;
import com.codeholic.ui.gwt.client.core.goods.presenters.Goodsclass2Presenter;
import com.codeholic.ui.gwt.client.core.goods.views.Goodsclass2View;
import com.codeholic.ui.gwt.shared.goods.dto.Goodsclass2Dto;
import com.codeholic.ui.gwt.shared.goods.service.IGWTGoodsclass2ServiceAsync;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.sencha.gxt.widget.core.client.info.Info;

public class Goodsclass2Activity extends
		CoreActivity<Goodsclass2Dto, Goodsclass2View, Goodsclass2Place>
		implements Goodsclass2Presenter {

	private IGWTGoodsclass2ServiceAsync goodsclass2ServiceAsync;

	public Goodsclass2Activity(Goodsclass2Place place) {
		super(place);
		this.view = injector.getGoodsclass2View();
		this.goodsclass2ServiceAsync = injector.getGoodsclass2Service();
	}

	@Override
	public String mayStop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCancel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus arg1) {
		bind();

		panel.setWidget(view);
	}

	@Override
	public void bind() {
		view.setPresenter(this);
	}

	@Override
	public void onSaveGoodsclass2(Goodsclass2Dto Goodsclass2) {

	}

	@Override
	public void onDeleteGoodsclass2(String Goodsclass2Id) {
		goodsclass2ServiceAsync.removeGoodsclass2(Goodsclass2Id,
				new AsyncCallback<Boolean>() {

					@Override
					public void onFailure(Throwable arg0) {
						Info.display("Fail", "Failed");
					}

					@Override
					public void onSuccess(Boolean arg0) {
						if (arg0) {
							Info.display("Success", "Successful");
							view.reloadGrid();
							view.clearForm();
						} else {
							Info.display("Fail", "Failed");
						}
					}
				});
	}

	@Override
	public void onAddGoodsclass2(Goodsclass2Dto Goodsclass2) {
		goodsclass2ServiceAsync.addGoodsclass2(Goodsclass2,
				new AsyncCallback<Boolean>() {

					@Override
					public void onSuccess(Boolean result) {
						if (result) {
							Info.display("Success", "Successful");
							view.reloadGrid();
						} else {
							Info.display("Fail", "Failed");
						}
					}

					@Override
					public void onFailure(Throwable arg0) {
						Info.display("Fail", "Failed");
					}
				});
	}

}
