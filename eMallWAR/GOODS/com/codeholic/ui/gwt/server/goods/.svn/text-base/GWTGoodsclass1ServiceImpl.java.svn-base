package com.codeholic.ui.gwt.server.goods;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import com.codeholic.business.goods.view.IGoodsclass1Service;
import com.codeholic.pojos.jpa.Goodsclass1;
import com.codeholic.ui.gwt.server.util.ClassMapper;
import com.codeholic.ui.gwt.shared.goods.dto.Goodsclass1Dto;
import com.codeholic.ui.gwt.shared.goods.service.IGWTGoodsclass1Service;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GWTGoodsclass1ServiceImpl extends RemoteServiceServlet implements IGWTGoodsclass1Service{

	private static final long serialVersionUID = 6180479745302853258L;

	@EJB
	private IGoodsclass1Service service;
	
	@Override
	public boolean addBatchGoodsclass1sByExcel(String fileName) {
		
		return false;
	}

	@Override
	public boolean addGoodsclass1(Goodsclass1Dto goodsclass1) {
		Goodsclass1 class1 = new Goodsclass1();
		
		ClassMapper.map(goodsclass1, class1);
		
		return service.addGoodsclass1(class1);
	}

	@Override
	public boolean removeGoodsclass1(String goodsclass1Id) {
		return service.removeGoodsclass1(goodsclass1Id);
	}

	@Override
	public ArrayList<Goodsclass1Dto> findAllGoodsclass1sInPage(int pageNumber,
			int pageSize) {
		List<Goodsclass1> list = service.findAllGoodsclass1sInPage(pageNumber, pageSize);
		
		ArrayList<Goodsclass1Dto> result = new ArrayList<Goodsclass1Dto>();
		
		for(Goodsclass1 goodsclass1 : list){
			Goodsclass1Dto dto = new Goodsclass1Dto();
			ClassMapper.map(goodsclass1, dto);
			result.add(dto);
		}
		
		return result;
	}

	@Override
	public Goodsclass1Dto findByGoodsclass1Name(String goodsclass1Name) {
		Goodsclass1 goodsclass1 = service.findByGoodsclass1Name(goodsclass1Name);
		Goodsclass1Dto dto = new Goodsclass1Dto();
		ClassMapper.map(goodsclass1, dto);
		return dto;
	}

	@Override
	public Goodsclass1Dto findByGoodsclass1Code(String goodsclass1Code) {
		Goodsclass1 goodsclass1 = service.findByGoodsclass1Code(goodsclass1Code);
		Goodsclass1Dto dto = new Goodsclass1Dto();
		ClassMapper.map(goodsclass1, dto);
		return dto;
	}

}
