package com.codeholic.business.goods.view;

import java.io.File;
import java.util.List;

import com.codeholic.eao.ParamFilter;
import com.codeholic.eao.ParamMapper;
import com.codeholic.eao.support.Pageable;
import com.codeholic.pojos.jpa.Brand;
import com.codeholic.pojos.jpa.Good;

public interface IGoodService {
	//通过excel批量添加商品
	boolean addBatchGoodsByExcel(File file);
	//添加商品
	boolean addGood(Good good);
	//删除商品
	boolean removeGood(String goodId);
	//分页查询到所有商品
	List<Good> findAllGoodsInPage(int pageNumber, int pageSize);
	//按照时间降序升序查询所有商品
	List<Good> findAllGoodsInCreateTimeDescInPage(int pageNumber, int pageSize);
	List<Good> findAllGoodsInCreateTimeAscInPage(int pageNumber, int pageSize);
	//分页查询按品牌查询商品
	List<Good> findGoodsByBrandInPage(String brandId, int pageNumber, int pageSize);
	//分页查询按品牌查询商品，按照时间降序升序查询
	List<Good> findGoodsByBrandInCreateTimeDescInPage(String brandId, int pageNumber, int pageSize);
	List<Good> findGoodsByBrandInCreateTimeAscInPage(String brandId, int pageNumber, int pageSize);
	//分页按一级分类查询商品
	List<Good> findGoodsByGoodclass1InPage(String goodclass1, int pageNumber, int pageSize);
	
	List<Good> findGoodsByGoodclass1InCreateTimeDescInPage(String goodclass1, int pageNumber, int pageSize);
	List<Good> findGoodsByGoodclass1InCreateTimeAscInPage(String goodclass1, int pageNumber, int pageSize);
	//分页按二级分类查询商品
	List<Good> findGoodsByGoodclass2InPage(String goodclass2, int pageNumber, int pageSize);
	
	List<Good> findGoodsByGoodclass2InCreateTimeDescInPage(String goodclass2, int pageNumber, int pageSize);
	List<Good> findGoodsByGoodclass2InCreateTimeAscInPage(String goodclass2, int pageNumber, int pageSize);
	
	//按名字查询具体商品
	Good findByGoodName(String goodName);
	//按商品编码查询具体商品
	Good findByGoodCode(String goodCode);
	
	//
	int getCount();
	
	List<Good> findGoodByFilter(Class cls,ParamMapper mapper,ParamFilter filter,Pageable pageable);
	
	List<Good> findAllIdAndName();
}
