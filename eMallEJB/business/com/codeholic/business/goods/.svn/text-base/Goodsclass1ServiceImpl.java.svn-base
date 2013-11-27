package com.codeholic.business.goods;

import java.io.File;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.codeholic.business.goods.view.IGoodsclass1Service;
import com.codeholic.business.util.ExcelHandler;
import com.codeholic.eao.FilterQuery;
import com.codeholic.eao.ParamFilter;
import com.codeholic.eao.ParamMapper;
import com.codeholic.eao.UUIDGenerator;
import com.codeholic.eao.goods.Goodsclass1Eao;
import com.codeholic.eao.support.Pageable;
import com.codeholic.pojos.jpa.Goodsclass1;

/**
 * Session Bean implementation class Goodsclass1ServiceImpl
 */
@Stateless
@Local(IGoodsclass1Service.class)
public class Goodsclass1ServiceImpl implements IGoodsclass1Service {

	@EJB
	private Goodsclass1Eao goodsclass1Eao;
	@EJB
	private FilterQuery filterQuery;
    /**
     * Default constructor. 
     */
    public Goodsclass1ServiceImpl() {
    }

	@Override
	public boolean addBatchGoodsclass1sByExcel(File file) {
		try{
			ExcelHandler<Goodsclass1> brandExcelHandler = new ExcelHandler<Goodsclass1>(Goodsclass1.class);
			List<Goodsclass1> goodsclass1s = brandExcelHandler.readExcel(file);
			for(Goodsclass1 goodsclass1 : goodsclass1s){
				goodsclass1.setGclass1Id(UUIDGenerator.randomUUID());
				goodsclass1Eao.add(goodsclass1);
			}
			return true;
		}catch(Exception exception){
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addGoodsclass1(Goodsclass1 goodsclass1) {
		try {
			goodsclass1.setGclass1Id(UUIDGenerator.randomUUID());
			goodsclass1Eao.add(goodsclass1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeGoodsclass1(String goodsclass1Id) {
		try {
			Goodsclass1 goodsclass1 = goodsclass1Eao.findOneById(goodsclass1Id);
			if(goodsclass1==null){
				return false;
			}else {
				goodsclass1Eao.delete(goodsclass1);
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Goodsclass1> findAllGoodsclass1sInPage(int pageNumber,
			int pageSize) {
		try {
			return goodsclass1Eao.findAllInPage(Pageable.inPage(pageNumber, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Goodsclass1 findByGoodsclass1Name(String goodsclass1Name) {
		try {
			return goodsclass1Eao.findOneByParams("goodsclass1.findByGoodsclass1Name", ParamMapper.instance("gclass1Name", goodsclass1Name));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Goodsclass1 findByGoodsclass1Code(String goodsclass1Code) {
		try {
			return goodsclass1Eao.findOneByParams("goodsclass1.findByGoodsclass1Code", ParamMapper.instance("gclass1Code", goodsclass1Code));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Goodsclass1> findGoodByFilter(Class cls, ParamMapper mapper,
			ParamFilter filter, Pageable pageable) {
		Query query = filterQuery.getFilterQuery(cls, mapper, filter, pageable);
		List<Goodsclass1> classList = query.getResultList();
		return classList;
	}

	@Override
	public List<Goodsclass1> findAllIdAndName() {
		try {
			return goodsclass1Eao.findByNamedQuery("goodsClass1.findAllIdAndName");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
