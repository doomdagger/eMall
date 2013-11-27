package com.codeholic.ui.gwt.shared.goods.service;

import java.util.ArrayList;

import com.codeholic.ui.gwt.shared.goods.dto.Goodsclass1Dto;
import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IGWTGoodsclass1ServiceAsync {

	Request addBatchGoodsclass1sByExcel(String fileName, AsyncCallback<Boolean> callback);

	Request addGoodsclass1(Goodsclass1Dto goodsclass1, AsyncCallback<Boolean> callback);

	Request findAllGoodsclass1sInPage(int pageNumber, int pageSize,
			AsyncCallback<ArrayList<Goodsclass1Dto>> callback);

	Request findByGoodsclass1Code(String goodsclass1Code,
			AsyncCallback<Goodsclass1Dto> callback);

	Request findByGoodsclass1Name(String goodsclass1Name,
			AsyncCallback<Goodsclass1Dto> callback);

	Request removeGoodsclass1(String goodsclass1Id, AsyncCallback<Boolean> callback);

}
