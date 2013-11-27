package com.codeholic.business.goods;

import java.io.File;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.codeholic.business.goods.view.IBrandService;
import com.codeholic.business.util.ExcelHandler;
import com.codeholic.eao.FilterQuery;
import com.codeholic.eao.ParamFilter;
import com.codeholic.eao.ParamMapper;
import com.codeholic.eao.UUIDGenerator;
import com.codeholic.eao.goods.BrandEao;
import com.codeholic.eao.support.Pageable;
import com.codeholic.pojos.jpa.Brand;

/**
 * Session Bean implementation class BrandServiceImpl
 */
@Stateless
@Local(IBrandService.class)
public class BrandServiceImpl implements IBrandService {

	
	@EJB
	private BrandEao brandEao;
	@EJB
	private FilterQuery filterQuery;
    /**
     * Default constructor. 
     */
    public BrandServiceImpl() {
    	
    }

	@Override
	public boolean addBatchBrandsByExcel(File file) {
		try{
			ExcelHandler<Brand> brandExcelHandler = new ExcelHandler<Brand>(Brand.class);
			List<Brand> brands = brandExcelHandler.readExcel(file);
			for(Brand brand : brands){
				brand.setBrandId(UUIDGenerator.randomUUID());
				brandEao.add(brand);
			}
			return true;
		}catch(Exception exception){
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addBrand(Brand brand) {
		try{
			brand.setBrandId(UUIDGenerator.randomUUID());
			brandEao.add(brand);
			return true;
		}catch(Exception exception){
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeBrand(String brandId) {
		try {
			Brand brand = brandEao.findOneById(brandId);
			if(brand==null){
				return false;
			}else{
				brandEao.delete(brand);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Brand> findAllBrandsInPage(int pageNumber, int pageSize) {
		try{
			return brandEao.findAllInPage(Pageable.inPage(pageNumber, pageSize));
		}catch(Exception exception){
			exception.printStackTrace();
			return null;
		}
	}

	
	@Override
	public Brand findByBrandName(String brandName) {
		try{
			return brandEao.findOneByParams("brand.findByBrandName", ParamMapper.instance("brandName", brandName));
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Brand findByBrandCode(String brandCode) {
		try {
			return brandEao.findOneByParams("brand.findByBrandCode", ParamMapper.instance("brandCode", brandCode));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Brand> findAllBrandsInLevelDescInPage(int pageNumber,
			int pageSize) {
		try {
			return brandEao.findByParamsInPage("brand.findAllInLevelDesc", null, Pageable.inPage(pageNumber, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Brand> findAllBrandsInLevelAscInPage(int pageNumber,
			int pageSize) {
		try {
			return brandEao.findByParamsInPage("brand.findAllInLevelAsc", null, Pageable.inPage(pageNumber, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Brand> findAllBrandsInPopularityDescInPage(int pageNumber,
			int pageSize) {
		try {
			return brandEao.findByParamsInPage("brand.findAllInPopularityDesc", null, Pageable.inPage(pageNumber, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Brand> findAllBrandsInPopularityAscInPage(int pageNumber,
			int pageSize) {
		try {
			return brandEao.findByParamsInPage("brand.findAllInPopularityAsc", null, Pageable.inPage(pageNumber, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Brand> findBrandsByCountryInPage(int country, int pageNumber,
			int pageSize) {
		try {
			return brandEao.findByParamsInPage("brand.findByCountry", ParamMapper.instance("brandCountry", country), Pageable.inPage(pageNumber, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Brand> findBrandsByCountryInLevelDescInPage(int country, int pageNumber,
			int pageSize) {
		try {
			return brandEao.findByParamsInPage("brand.findByCountryInLevelDesc", ParamMapper.instance("brandCountry", country), Pageable.inPage(pageNumber, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Brand> findBrandsByCountryInLevelAscInPage(int country, int pageNumber,
			int pageSize) {
		try {
			return brandEao.findByParamsInPage("brand.findByCountryInLevelAsc", ParamMapper.instance("brandCountry", country), Pageable.inPage(pageNumber, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Brand> findBrandsByCountryInPopularityDescInPage(int country,
			int pageNumber, int pageSize) {
		try {
			return brandEao.findByParamsInPage("brand.findByCountryInPopularityDesc", ParamMapper.instance("brandCountry", country), Pageable.inPage(pageNumber, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Brand> findBrandsByCountryInPopularityAscInPage(int country, int pageNumber,
			int pageSize) {
		try {
			return brandEao.findByParamsInPage("brand.findByCountryInPopularityAsc", ParamMapper.instance("brandCountry", country), Pageable.inPage(pageNumber, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Brand> findBrandsByLevelInPage(int level, int pageNumber,
			int pageSize) {
		try {
			return brandEao.findByParamsInPage("brand.findByLevel", ParamMapper.instance("brandLevel", level), Pageable.inPage(pageNumber, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Brand> findBrandsByPopularityInPage(int popularity,
			int pageNumber, int pageSize) {
		try {
			return brandEao.findByParamsInPage("brand.findByPopularity", ParamMapper.instance("brandPop", popularity), Pageable.inPage(pageNumber, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public long getAllCount() {
		return brandEao.getCount();
	}
	
	@Override
	public boolean updateBrand(Brand brand) {
		if(brand.getBrandId()==null||brand.getBrandId().equals("")){
			return false;
		}
		try {
			brandEao.update(brand);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Brand> findInParamFilter(Class cls,ParamMapper mapper,ParamFilter filter,Pageable pageable) {
		Query query = filterQuery.getFilterQuery(cls, mapper, filter, pageable);
		List<Brand> brandList = query.getResultList();
		return brandList;
	}

	@Override
	public List<Brand> findAllIdAndName() {
		try {
			return brandEao.findByNamedQuery("brand.findAllIdAndName");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


}
