package com.codeholic.business.goods.view;

import java.io.File;
import java.util.List;

import com.codeholic.eao.ParamFilter;
import com.codeholic.eao.ParamMapper;
import com.codeholic.eao.support.Pageable;
import com.codeholic.pojos.jpa.Brand;
import com.codeholic.pojos.jpa.Good;
import com.codeholic.pojos.jpa.Goodsclass1;

public interface IGoodsclass1Service {
	boolean addBatchGoodsclass1sByExcel(File file);

	boolean addGoodsclass1(Goodsclass1 goodsclass1);

	boolean removeGoodsclass1(String goodsclass1Id);
	
	List<Goodsclass1> findAllGoodsclass1sInPage(int pageNumber, int pageSize);
	
	Goodsclass1 findByGoodsclass1Name(String goodsclass1Name);
	
	Goodsclass1 findByGoodsclass1Code(String goodsclass1Code);
	
	List<Goodsclass1> findGoodByFilter(Class cls,ParamMapper mapper,ParamFilter filter,Pageable pageable);
	
	List<Goodsclass1> findAllIdAndName();
}
