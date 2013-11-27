package com.codeholic.business.goods.view;

import java.io.File;
import java.util.List;

import com.codeholic.eao.ParamFilter;
import com.codeholic.eao.ParamMapper;
import com.codeholic.eao.support.Pageable;
import com.codeholic.pojos.jpa.Brand;
import com.codeholic.pojos.jpa.Good;
import com.codeholic.pojos.jpa.Goodsclass2;

public interface IGoodsclass2Service {
	boolean addBatchGoodsclass2sByExcel(File file);

	boolean addGoodsclass2(Goodsclass2 goodsclass2);

	boolean removeGoodsclass2(String goodsclass2Id);
	
	List<Goodsclass2> findAllGoodsclass2sInPage(int pageNumber, int pageSize);
	
	Goodsclass2 findByGoodsclass2Name(String goodsclass2Name);
	
	Goodsclass2 findByGoodsclass2Code(String goodsclass2Code);
	
	List<Goodsclass2> findGoodByFilter(Class cls,ParamMapper mapper,ParamFilter filter,Pageable pageable);
	
	List<Goodsclass2> findAllIdAndName();
}
