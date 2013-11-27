package com.codeholic.business.goods;

import java.io.File;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.codeholic.business.goods.view.IGoodsclass2Service;
import com.codeholic.business.util.ExcelHandler;
import com.codeholic.eao.FilterQuery;
import com.codeholic.eao.ParamFilter;
import com.codeholic.eao.ParamMapper;
import com.codeholic.eao.UUIDGenerator;
import com.codeholic.eao.goods.Goodsclass2Eao;
import com.codeholic.eao.support.Pageable;
import com.codeholic.pojos.jpa.Goodsclass2;

/**
 * Session Bean implementation class Goodsclass2ServiceImpl
 */
@Stateless
@Local(IGoodsclass2Service.class)
public class Goodsclass2ServiceImpl implements IGoodsclass2Service {

	
	@EJB
	private Goodsclass2Eao goodsclass2Eao;
	@EJB
	private FilterQuery filterQuery;
    /**
     * Default constructor. 
     */
    public Goodsclass2ServiceImpl() {
    }

	@Override
	public boolean addBatchGoodsclass2sByExcel(File file) {
		try{
			ExcelHandler<Goodsclass2> brandExcelHandler = new ExcelHandler<Goodsclass2>(Goodsclass2.class);
			List<Goodsclass2> goodsclass2s = brandExcelHandler.readExcel(file);
			for(Goodsclass2 goodsclass2 : goodsclass2s){
				goodsclass2.setGclass2Id(UUIDGenerator.randomUUID());
				goodsclass2Eao.add(goodsclass2);
			}
			return true;
		}catch(Exception exception){
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addGoodsclass2(Goodsclass2 goodsclass2) {
		try {
			goodsclass2.setGclass2Id(UUIDGenerator.randomUUID());
			goodsclass2Eao.add(goodsclass2);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeGoodsclass2(String goodsclass2Id) {
		try {
			Goodsclass2 goodsclass2 = goodsclass2Eao.findOneById(goodsclass2Id);
			if(goodsclass2==null){
				return false;
			}else {
				goodsclass2Eao.delete(goodsclass2);
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Goodsclass2> findAllGoodsclass2sInPage(int pageNumber,
			int pageSize) {
		try {
			return goodsclass2Eao.findAllInPage(Pageable.inPage(pageNumber, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Goodsclass2 findByGoodsclass2Name(String goodsclass2Name) {
		try {
			return goodsclass2Eao.findOneByParams("goodsclass2.findByGoodsclass2Name", ParamMapper.instance("gclass2Name", goodsclass2Name));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Goodsclass2 findByGoodsclass2Code(String goodsclass2Code) {
		try {
			return goodsclass2Eao.findOneByParams("goodsclass2.findByGoodsclass2Code", ParamMapper.instance("gclass2Code", goodsclass2Code));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Goodsclass2> findGoodByFilter(Class cls, ParamMapper mapper,
			ParamFilter filter, Pageable pageable) {
		Query query = filterQuery.getFilterQuery(cls, mapper, filter, pageable);
		List<Goodsclass2> classList = query.getResultList();
		return classList;
	}

	@Override
	public List<Goodsclass2> findAllIdAndName() {
		try {
			return goodsclass2Eao.findByNamedQuery("goodsclass2.findAllIdAndName");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
