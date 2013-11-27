package com.codeholic.business.goods.view;

import java.io.File;
import java.util.List;

import com.codeholic.eao.ParamFilter;
import com.codeholic.eao.ParamMapper;
import com.codeholic.eao.support.Pageable;
import com.codeholic.pojos.jpa.Brand;

public interface IBrandService {
	
	boolean addBatchBrandsByExcel(File file);

	boolean addBrand(Brand brand);

	boolean removeBrand(String brandId);
	
	boolean updateBrand(Brand brand);
	
	List<Brand> findAllBrandsInPage(int pageNumber, int pageSize);
	
	List<Brand> findAllBrandsInLevelDescInPage(int pageNumber, int pageSize);
	List<Brand> findAllBrandsInLevelAscInPage(int pageNumber, int pageSize);
	
	List<Brand> findAllBrandsInPopularityDescInPage(int pageNumber, int pageSize);
	List<Brand> findAllBrandsInPopularityAscInPage(int pageNumber, int pageSize);
	
	List<Brand> findBrandsByCountryInPage(int country, int pageNumber, int pageSize);
	
	List<Brand> findBrandsByCountryInLevelDescInPage(int country,int pageNumber, int pageSize);
	List<Brand> findBrandsByCountryInLevelAscInPage(int country,int pageNumber, int pageSize);
	
	List<Brand> findBrandsByCountryInPopularityDescInPage(int country,int pageNumber, int pageSize);
	List<Brand> findBrandsByCountryInPopularityAscInPage(int country,int pageNumber, int pageSize);
	
	
	List<Brand> findBrandsByLevelInPage(int level, int pageNumber, int pageSize);
	
	List<Brand> findBrandsByPopularityInPage(int popularity, int pageNumber, int pageSize);
	
	Brand findByBrandName(String brandName);
	
	Brand findByBrandCode(String brandCode);
	
	long getAllCount();

	List<Brand> findInParamFilter(Class cls, ParamMapper mapper,ParamFilter filter,Pageable pageable);
	
	List<Brand> findAllIdAndName();
}
