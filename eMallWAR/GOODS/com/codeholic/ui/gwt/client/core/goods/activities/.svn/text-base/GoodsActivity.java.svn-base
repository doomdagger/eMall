package com.codeholic.ui.gwt.client.core.goods.activities;

import com.codeholic.ui.gwt.client.core.activities.CoreActivity;
import com.codeholic.ui.gwt.client.core.goods.places.GoodsPlace;
import com.codeholic.ui.gwt.client.core.goods.presenters.GoodsPresenter;
import com.codeholic.ui.gwt.client.core.goods.views.GoodsView;
import com.codeholic.ui.gwt.shared.goods.dto.GoodsDto;
import com.codeholic.ui.gwt.shared.goods.service.IGWTGoodsServiceAsync;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.sencha.gxt.widget.core.client.info.Info;

public class GoodsActivity extends
		CoreActivity<GoodsDto, GoodsView, GoodsPlace> implements GoodsPresenter {

	private IGWTGoodsServiceAsync goodsServiceAsync;

	public GoodsActivity(GoodsPlace place) {
		super(place);
		this.view = injector.getGoodsView();
		this.goodsServiceAsync = injector.getGoodsService();
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
	public void onSaveGoods(GoodsDto Goods) {
		
	}

	@Override
	public void onDeleteGoods(String GoodsId) {
		goodsServiceAsync.removeGood(GoodsId, new AsyncCallback<Boolean>() {

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
	public void onAddGoods(GoodsDto Goods) {
		goodsServiceAsync.addGood(Goods, new AsyncCallback<Boolean>() {

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

	@Override
	public void onGetAllBrands() {
		
	}

	@Override
	public void onGetAllClass1s() {
		
	}

	@Override
	public void onGetAllClass2s() {
		
	}

}
