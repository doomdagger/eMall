package com.codeholic.ui.gwt.client.core.goods.activities;

import com.codeholic.ui.gwt.client.core.activities.CoreActivity;
import com.codeholic.ui.gwt.client.core.goods.places.Goodsclass1Place;
import com.codeholic.ui.gwt.client.core.goods.presenters.Goodsclass1Presenter;
import com.codeholic.ui.gwt.client.core.goods.views.Goodsclass1View;
import com.codeholic.ui.gwt.shared.goods.dto.Goodsclass1Dto;
import com.codeholic.ui.gwt.shared.goods.service.IGWTGoodsclass1ServiceAsync;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.sencha.gxt.widget.core.client.info.Info;

public class Goodsclass1Activity extends
		CoreActivity<Goodsclass1Dto, Goodsclass1View, Goodsclass1Place>
		implements Goodsclass1Presenter {

	private IGWTGoodsclass1ServiceAsync goodsclass1ServiceAsync;

	public Goodsclass1Activity(Goodsclass1Place place) {
		super(place);
		this.view = injector.getGoodsclass1View();
		this.goodsclass1ServiceAsync = injector.getGoodsclass1Service();
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
	public void onSaveGoodsclass1(Goodsclass1Dto Goodsclass1) {

	}

	@Override
	public void onDeleteGoodsclass1(String Goodsclass1Id) {
		goodsclass1ServiceAsync.removeGoodsclass1(Goodsclass1Id,
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
	public void onAddGoodsclass1(Goodsclass1Dto Goodsclass1) {
		goodsclass1ServiceAsync.addGoodsclass1(Goodsclass1,
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
