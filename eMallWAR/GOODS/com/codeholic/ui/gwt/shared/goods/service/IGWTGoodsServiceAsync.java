package com.codeholic.ui.gwt.shared.goods.service;

import java.util.ArrayList;

import com.codeholic.ui.gwt.shared.goods.dto.GoodsDto;
import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

public interface IGWTGoodsServiceAsync {

	Request addBatchGoodsByExcel(String fileName, AsyncCallback<Boolean> callback);

	Request addGood(GoodsDto good, AsyncCallback<Boolean> callback);

	Request findAllGoodsInCreateTimeAscInPage(int pageNumber, int pageSize,
			AsyncCallback<ArrayList<GoodsDto>> callback);

	Request findAllGoodsInCreateTimeDescInPage(int pageNumber, int pageSize,
			AsyncCallback<ArrayList<GoodsDto>> callback);

	Request findAllGoodsInPage(int pageNumber, int pageSize,
			AsyncCallback<ArrayList<GoodsDto>> callback);

	Request findByGoodCode(String goodCode, AsyncCallback<GoodsDto> callback);

	Request findByGoodName(String goodName, AsyncCallback<GoodsDto> callback);

	Request findGoodsByBrandInCreateTimeAscInPage(String brandId, int pageNumber,
			int pageSize, AsyncCallback<ArrayList<GoodsDto>> callback);

	Request findGoodsByBrandInCreateTimeDescInPage(String brandId, int pageNumber,
			int pageSize, AsyncCallback<ArrayList<GoodsDto>> callback);

	Request findGoodsByBrandInPage(String brandId, int pageNumber, int pageSize,
			AsyncCallback<ArrayList<GoodsDto>> callback);

	Request findGoodsByGoodclass1InCreateTimeAscInPage(String goodclass1,
			int pageNumber, int pageSize,
			AsyncCallback<ArrayList<GoodsDto>> callback);

	Request findGoodsByGoodclass1InCreateTimeDescInPage(String goodclass1,
			int pageNumber, int pageSize,
			AsyncCallback<ArrayList<GoodsDto>> callback);

	Request findGoodsByGoodclass1InPage(String goodclass1, int pageNumber,
			int pageSize, AsyncCallback<ArrayList<GoodsDto>> callback);

	Request findGoodsByGoodclass2InCreateTimeAscInPage(String goodclass2,
			int pageNumber, int pageSize,
			AsyncCallback<ArrayList<GoodsDto>> callback);

	Request findGoodsByGoodclass2InCreateTimeDescInPage(String goodclass2,
			int pageNumber, int pageSize,
			AsyncCallback<ArrayList<GoodsDto>> callback);

	Request findGoodsByGoodclass2InPage(String goodclass2, int pageNumber,
			int pageSize, AsyncCallback<ArrayList<GoodsDto>> callback);

	Request removeGood(String goodId, AsyncCallback<Boolean> callback);

	Request getGoods(PagingLoadConfig loadConfig,
			AsyncCallback<PagingLoadResult<GoodsDto>> callback);

}
