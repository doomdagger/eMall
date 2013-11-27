package com.codeholic.ui.gwt.server.goods;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import com.codeholic.business.goods.view.IGoodsclass2Service;
import com.codeholic.pojos.jpa.Goodsclass2;
import com.codeholic.ui.gwt.server.util.ClassMapper;
import com.codeholic.ui.gwt.shared.goods.dto.Goodsclass2Dto;
import com.codeholic.ui.gwt.shared.goods.service.IGWTGoodsclass2Service;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GWTGoodsclass2ServiceImpl extends RemoteServiceServlet implements
		IGWTGoodsclass2Service {

	private static final long serialVersionUID = -4379787507429454992L;

	@EJB
	private IGoodsclass2Service service;

	@Override
	public boolean addBatchGoodsclass2sByExcel(String fileName) {

		return false;
	}

	@Override
	public boolean addGoodsclass2(Goodsclass2Dto goodsclass2) {
		Goodsclass2 class2 = new Goodsclass2();

		ClassMapper.map(goodsclass2, class2);

		return service.addGoodsclass2(class2);
	}

	@Override
	public boolean removeGoodsclass2(String goodsclass2Id) {
		return service.removeGoodsclass2(goodsclass2Id);
	}

	@Override
	public ArrayList<Goodsclass2Dto> findAllGoodsclass2sInPage(int pageNumber,
			int pageSize) {
		List<Goodsclass2> list = service.findAllGoodsclass2sInPage(pageNumber,
				pageSize);

		ArrayList<Goodsclass2Dto> result = new ArrayList<Goodsclass2Dto>();

		for (Goodsclass2 goodsclass2 : list) {
			Goodsclass2Dto dto = new Goodsclass2Dto();
			ClassMapper.map(goodsclass2, dto);
			result.add(dto);
		}

		return result;
	}

	@Override
	public Goodsclass2Dto findByGoodsclass2Name(String goodsclass2Name) {
		Goodsclass2 goodsclass2 = service
				.findByGoodsclass2Name(goodsclass2Name);
		Goodsclass2Dto dto = new Goodsclass2Dto();
		ClassMapper.map(goodsclass2, dto);
		return dto;
	}

	@Override
	public Goodsclass2Dto findByGoodsclass2Code(String goodsclass2Code) {
		Goodsclass2 goodsclass2 = service
				.findByGoodsclass2Code(goodsclass2Code);
		Goodsclass2Dto dto = new Goodsclass2Dto();
		ClassMapper.map(goodsclass2, dto);
		return dto;
	}

}
