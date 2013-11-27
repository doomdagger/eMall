package com.codeholic.ui.gwt.shared.goods.service;

import java.util.ArrayList;

import com.codeholic.ui.gwt.shared.goods.dto.Goodsclass1Dto;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("goods/goodsclass1")
public interface IGWTGoodsclass1Service extends RemoteService{
	boolean addBatchGoodsclass1sByExcel(String fileName);

	boolean addGoodsclass1(Goodsclass1Dto goodsclass1);

	boolean removeGoodsclass1(String goodsclass1Id);
	
	ArrayList<Goodsclass1Dto> findAllGoodsclass1sInPage(int pageNumber, int pageSize);
	
	Goodsclass1Dto findByGoodsclass1Name(String goodsclass1Name);
	
	Goodsclass1Dto findByGoodsclass1Code(String goodsclass1Code);
}
