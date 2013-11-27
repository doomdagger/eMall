package com.codeholic.business.goods;

import java.io.File;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.codeholic.business.goods.view.IGoodService;
import com.codeholic.eao.FilterQuery;
import com.codeholic.eao.ParamFilter;
import com.codeholic.eao.ParamMapper;
import com.codeholic.eao.UUIDGenerator;
import com.codeholic.eao.goods.GoodEao;
import com.codeholic.eao.support.Pageable;
import com.codeholic.pojos.jpa.Good;

/**
 * Session Bean implementation class GoodsServiceImpl
 */
@Stateless
@Local(IGoodService.class)
public class GoodServiceImpl implements IGoodService {

	
	@EJB
	private GoodEao goodEao;
	@EJB
	private FilterQuery filterQuery;
    /**
     * Default constructor. 
     */
    public GoodServiceImpl() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public boolean addBatchGoodsByExcel(File file) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addGood(Good good) {
		try {
			good.setGoodsId(UUIDGenerator.randomUUID());
			goodEao.add(good);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean removeGood(String goodId) {
		try {
			goodEao.deleteByParams("good.removeGood", ParamMapper.instance("goodId",goodId));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Good> findAllGoodsInPage(int pageNumber, int pageSize) {
		try {
			List<Good> goodList = goodEao.findAllInPage(Pageable.inPage(pageNumber, pageSize));
			return goodList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Good> findAllGoodsInCreateTimeDescInPage(int pageNumber,
			int pageSize) {
		try {
			List<Good> goodList = goodEao.findByParamsInPage("good.allInCreateTimeDescInPage", ParamMapper.instance("", ""), Pageable.inPage(pageNumber, pageSize));
			return goodList;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Good> findAllGoodsInCreateTimeAscInPage(int pageNumber,
			int pageSize) {
		try {
			List<Good> goodList = goodEao.findByParamsInPage("good.allInCreateTimeAscInPage", ParamMapper.instance("", ""), Pageable.inPage(pageNumber, pageSize));
			return goodList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Good> findGoodsByBrandInPage(String brandId, int pageNumber,
			int pageSize) {
		try {
			List<Good> goodList = goodEao.findByParamsInPage("good.allInBrandInPage", ParamMapper.instance("brandId", brandId), Pageable.inPage(pageNumber, pageSize));
			return goodList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Good> findGoodsByBrandInCreateTimeDescInPage(String brandId,
			int pageNumber, int pageSize) {
		try {
			List<Good> goodList = goodEao.findByParamsInPage("good.allInBrandInCreateTimeDescInPage", ParamMapper.instance("brandId", brandId), Pageable.inPage(pageNumber, pageSize));
			return goodList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Good> findGoodsByBrandInCreateTimeAscInPage(String brandId,
			int pageNumber, int pageSize) {
		try {
			List<Good> goodList = goodEao.findByParamsInPage("good.allInBrandInCreateTimeAscInPage", ParamMapper.instance("brandId", brandId), Pageable.inPage(pageNumber, pageSize));
			return goodList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Good> findGoodsByGoodclass1InPage(String goodclass1,
			int pageNumber, int pageSize) {
		try {
			List<Good> goodList = goodEao.findByParamsInPage("good.allInGoodClassInPage", ParamMapper.instance("goodClass1", goodclass1), Pageable.inPage(pageNumber, pageSize));
			return goodList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Good> findGoodsByGoodclass1InCreateTimeDescInPage(
			String goodclass1, int pageNumber, int pageSize) {
		try {
			List<Good> goodList = goodEao.findByParamsInPage("good.allInGoodClassInCreateTimeDescInPage", ParamMapper.instance("goodClass1", goodclass1), Pageable.inPage(pageNumber, pageSize));
			return goodList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Good> findGoodsByGoodclass1InCreateTimeAscInPage(
			String goodclass1, int pageNumber, int pageSize) {
		try {
			List<Good> goodList = goodEao.findByParamsInPage("good.allInGoodClassInCreateTimeAscInPage", ParamMapper.instance("goodClass1", goodclass1), Pageable.inPage(pageNumber, pageSize));
			return goodList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Good> findGoodsByGoodclass2InPage(String goodclass2,
			int pageNumber, int pageSize) {
		try {
			List<Good> goodList = goodEao.findByParamsInPage("good.allInGoodClass2InPage", ParamMapper.instance("goodClass1", goodclass2), Pageable.inPage(pageNumber, pageSize));
			return goodList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Good> findGoodsByGoodclass2InCreateTimeDescInPage(
			String goodclass2, int pageNumber, int pageSize) {
		try {
			List<Good> goodList = goodEao.findByParamsInPage("good.allInGoodClass2InCreateTimeDescInPage", ParamMapper.instance("goodClass1", goodclass2), Pageable.inPage(pageNumber, pageSize));
			return goodList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Good> findGoodsByGoodclass2InCreateTimeAscInPage(
			String goodclass2, int pageNumber, int pageSize) {
		try {
			List<Good> goodList = goodEao.findByParamsInPage("good.allInGoodClass2InCreateTimeAscInPage", ParamMapper.instance("goodClass1", goodclass2), Pageable.inPage(pageNumber, pageSize));
			return goodList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Good findByGoodName(String goodName) {
		try {
			Good good = goodEao.findOneByParams("good.findByGoodName", ParamMapper.instance("goodName", goodName));
			return good;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Good findByGoodCode(String goodCode) {
		try {
			Good good = goodEao.findOneByParams("good.findByGoodCode", ParamMapper.instance("goodCode", goodCode));
			return good;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getCount() {
		try {
			return (int)goodEao.getCount();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public List<Good> findGoodByFilter(Class cls, ParamMapper mapper,
			ParamFilter filter, Pageable pageable) {
		Query query = filterQuery.getFilterQuery(cls, mapper, filter, pageable);
		List<Good> goodList = query.getResultList();
		return goodList;
	}

	@Override
	public List<Good> findAllIdAndName() {
		try {
			return goodEao.findByNamedQuery("good.finAllIdAndName");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
