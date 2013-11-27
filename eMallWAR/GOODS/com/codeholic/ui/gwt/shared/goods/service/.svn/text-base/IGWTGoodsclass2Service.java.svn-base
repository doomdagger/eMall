package com.codeholic.ui.gwt.shared.goods.service;

import java.util.ArrayList;

import com.codeholic.ui.gwt.shared.goods.dto.Goodsclass2Dto;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("goods/goodsclass2")
public interface IGWTGoodsclass2Service extends RemoteService{
	boolean addBatchGoodsclass2sByExcel(String fileName);

	boolean addGoodsclass2(Goodsclass2Dto goodsclass2);

	boolean removeGoodsclass2(String goodsclass2Id);
	
	ArrayList<Goodsclass2Dto> findAllGoodsclass2sInPage(int pageNumber, int pageSize);
	
	Goodsclass2Dto findByGoodsclass2Name(String goodsclass2Name);
	
	Goodsclass2Dto findByGoodsclass2Code(String goodsclass2Code);
}
