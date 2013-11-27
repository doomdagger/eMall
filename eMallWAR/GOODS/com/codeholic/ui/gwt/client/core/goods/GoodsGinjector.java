package com.codeholic.ui.gwt.client.core.goods;

import com.codeholic.ui.gwt.client.core.goods.views.BrandView;
import com.codeholic.ui.gwt.client.core.goods.views.GoodsView;
import com.codeholic.ui.gwt.client.core.goods.views.Goodsclass1View;
import com.codeholic.ui.gwt.client.core.goods.views.Goodsclass2View;
import com.codeholic.ui.gwt.shared.goods.service.IGWTBrandServiceAsync;
import com.codeholic.ui.gwt.shared.goods.service.IGWTGoodsServiceAsync;
import com.codeholic.ui.gwt.shared.goods.service.IGWTGoodsclass1ServiceAsync;
import com.codeholic.ui.gwt.shared.goods.service.IGWTGoodsclass2ServiceAsync;

public interface GoodsGinjector {
	IGWTBrandServiceAsync getBrandService();
	IGWTGoodsclass1ServiceAsync getGoodsclass1Service();
	IGWTGoodsclass2ServiceAsync getGoodsclass2Service();
	IGWTGoodsServiceAsync getGoodsService();
	
	BrandView getBrandView();
	GoodsView getGoodsView();
	Goodsclass1View getGoodsclass1View();
	Goodsclass2View getGoodsclass2View();
}
