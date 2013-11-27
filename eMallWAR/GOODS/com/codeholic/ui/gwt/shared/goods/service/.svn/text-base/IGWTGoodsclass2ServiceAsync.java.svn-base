package com.codeholic.ui.gwt.shared.goods.service;

import java.util.ArrayList;

import com.codeholic.ui.gwt.shared.goods.dto.Goodsclass2Dto;
import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IGWTGoodsclass2ServiceAsync {

	Request addBatchGoodsclass2sByExcel(String fileName, AsyncCallback<Boolean> callback);

	Request addGoodsclass2(Goodsclass2Dto goodsclass2, AsyncCallback<Boolean> callback);

	Request findAllGoodsclass2sInPage(int pageNumber, int pageSize,
			AsyncCallback<ArrayList<Goodsclass2Dto>> callback);

	Request findByGoodsclass2Code(String goodsclass2Code,
			AsyncCallback<Goodsclass2Dto> callback);

	Request findByGoodsclass2Name(String goodsclass2Name,
			AsyncCallback<Goodsclass2Dto> callback);

	Request removeGoodsclass2(String goodsclass2Id, AsyncCallback<Boolean> callback);

}
