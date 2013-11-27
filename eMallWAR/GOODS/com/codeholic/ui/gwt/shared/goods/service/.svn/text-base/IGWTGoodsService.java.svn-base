package com.codeholic.ui.gwt.shared.goods.service;

import java.util.ArrayList;

import com.codeholic.ui.gwt.shared.goods.dto.GoodsDto;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

@RemoteServiceRelativePath("goods/goods")
public interface IGWTGoodsService extends RemoteService {
	// 通过excel批量添加商品
	boolean addBatchGoodsByExcel(String fileName);

	// 添加商品
	boolean addGood(GoodsDto good);

	// 删除商品
	boolean removeGood(String goodId);

	// 分页查询到所有商品
	ArrayList<GoodsDto> findAllGoodsInPage(int pageNumber, int pageSize);

	// 按照时间降序升序查询所有商品
	ArrayList<GoodsDto> findAllGoodsInCreateTimeDescInPage(int pageNumber, int pageSize);

	ArrayList<GoodsDto> findAllGoodsInCreateTimeAscInPage(int pageNumber, int pageSize);

	// 分页查询按品牌查询商品
	ArrayList<GoodsDto> findGoodsByBrandInPage(String brandId, int pageNumber,
			int pageSize);

	// 分页查询按品牌查询商品，按照时间降序升序查询
	ArrayList<GoodsDto> findGoodsByBrandInCreateTimeDescInPage(String brandId,
			int pageNumber, int pageSize);

	ArrayList<GoodsDto> findGoodsByBrandInCreateTimeAscInPage(String brandId,
			int pageNumber, int pageSize);

	// 分页按一级分类查询商品
	ArrayList<GoodsDto> findGoodsByGoodclass1InPage(String goodclass1, int pageNumber,
			int pageSize);

	ArrayList<GoodsDto> findGoodsByGoodclass1InCreateTimeDescInPage(String goodclass1,
			int pageNumber, int pageSize);

	ArrayList<GoodsDto> findGoodsByGoodclass1InCreateTimeAscInPage(String goodclass1,
			int pageNumber, int pageSize);

	// 分页按二级分类查询商品
	ArrayList<GoodsDto> findGoodsByGoodclass2InPage(String goodclass2, int pageNumber,
			int pageSize);

	ArrayList<GoodsDto> findGoodsByGoodclass2InCreateTimeDescInPage(String goodclass2,
			int pageNumber, int pageSize);

	ArrayList<GoodsDto> findGoodsByGoodclass2InCreateTimeAscInPage(String goodclass2,
			int pageNumber, int pageSize);

	// 按名字查询具体商品
	GoodsDto findByGoodName(String goodName);

	// 按商品编码查询具体商品
	GoodsDto findByGoodCode(String goodCode);
	
	PagingLoadResult<GoodsDto> getGoods(final PagingLoadConfig loadConfig);
}
