package com.codeholic.ui.gwt.server.goods;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import com.codeholic.business.goods.view.IGoodService;
import com.codeholic.pojos.jpa.Good;
import com.codeholic.ui.gwt.server.util.ClassMapper;
import com.codeholic.ui.gwt.shared.goods.dto.GoodsDto;
import com.codeholic.ui.gwt.shared.goods.dto.GoodsPagingLoadResult;
import com.codeholic.ui.gwt.shared.goods.service.IGWTGoodsService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

public class GWTGoodsServiceImpl extends RemoteServiceServlet implements
		IGWTGoodsService {

	private static final long serialVersionUID = 1067580522166391352L;

	@EJB
	private IGoodService goodService;

	@Override
	public boolean addBatchGoodsByExcel(String fileName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addGood(GoodsDto good) {
		Good good2 = new Good();
		ClassMapper.map(good, good2);
		return goodService.addGood(good2);
	}

	@Override
	public boolean removeGood(String goodId) {
		return goodService.removeGood(goodId);
	}

	@Override
	public ArrayList<GoodsDto> findAllGoodsInPage(int pageNumber, int pageSize) {
		List<Good> list = goodService.findAllGoodsInPage(pageNumber, pageSize);

		ArrayList<GoodsDto> result = new ArrayList<GoodsDto>();

		for (Good good : list) {
			GoodsDto dto = new GoodsDto();
			ClassMapper.map(good, dto);
			result.add(dto);
		}

		return result;
	}

	@Override
	public ArrayList<GoodsDto> findAllGoodsInCreateTimeDescInPage(
			int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GoodsDto> findAllGoodsInCreateTimeAscInPage(
			int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GoodsDto> findGoodsByBrandInPage(String brandId,
			int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GoodsDto> findGoodsByBrandInCreateTimeDescInPage(
			String brandId, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GoodsDto> findGoodsByBrandInCreateTimeAscInPage(
			String brandId, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GoodsDto> findGoodsByGoodclass1InPage(String goodclass1,
			int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GoodsDto> findGoodsByGoodclass1InCreateTimeDescInPage(
			String goodclass1, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GoodsDto> findGoodsByGoodclass1InCreateTimeAscInPage(
			String goodclass1, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GoodsDto> findGoodsByGoodclass2InPage(String goodclass2,
			int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GoodsDto> findGoodsByGoodclass2InCreateTimeDescInPage(
			String goodclass2, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GoodsDto> findGoodsByGoodclass2InCreateTimeAscInPage(
			String goodclass2, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoodsDto findByGoodName(String goodName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoodsDto findByGoodCode(String goodCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagingLoadResult<GoodsDto> getGoods(PagingLoadConfig loadConfig) {
		int limit = loadConfig.getLimit();
		int offset = loadConfig.getOffset();

		List<GoodsDto> goodsDtos = this.findAllGoodsInPage(offset / limit,
				limit);

		GoodsPagingLoadResult result = new GoodsPagingLoadResult();
		result.setData(goodsDtos);
		result.setOffset(offset);
		result.setTotalLength((int) goodService.getCount());

		return result;
	}

}
