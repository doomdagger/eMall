package com.codeholic.ui.gwt.client.core.goods.activities;

import com.codeholic.ui.gwt.client.core.activities.CoreActivity;
import com.codeholic.ui.gwt.client.core.goods.places.BrandPlace;
import com.codeholic.ui.gwt.client.core.goods.presenters.BrandPresenter;
import com.codeholic.ui.gwt.client.core.goods.views.BrandView;
import com.codeholic.ui.gwt.shared.goods.dto.BrandDto;
import com.codeholic.ui.gwt.shared.goods.service.IGWTBrandServiceAsync;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.sencha.gxt.widget.core.client.info.Info;

public class BrandActivity extends
		CoreActivity<BrandDto, BrandView, BrandPlace> implements BrandPresenter {

	private IGWTBrandServiceAsync brandServiceAsync;

	public BrandActivity(BrandPlace place) {
		super(place);
		this.view = injector.getBrandView();
		this.brandServiceAsync = injector.getBrandService();
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
	public void onSaveBrand(BrandDto brand) {
		brandServiceAsync.updateBrand(brand, new AsyncCallback<Boolean>() {

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
	public void onDeleteBrand(String brandId) {
		brandServiceAsync.removeBrand(brandId, new AsyncCallback<Boolean>() {

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
	public void onAddBrand(BrandDto brand) {
		brandServiceAsync.addBrand(brand, new AsyncCallback<Boolean>() {

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
