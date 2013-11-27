package com.codeholic.ui.gwt.shared.goods.service;

import java.util.ArrayList;

import com.codeholic.ui.gwt.shared.goods.dto.BrandDto;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

@RemoteServiceRelativePath("goods/brand")
public interface IGWTBrandService extends RemoteService {
	boolean addBatchBrandsByExcel(String fileName);

	boolean addBrand(BrandDto brand);

	boolean removeBrand(String brandId);

	boolean updateBrand(BrandDto brandDto);
	
	ArrayList<BrandDto> findAllBrandsInPage(int pageNumber, int pageSize);

	ArrayList<BrandDto> findAllBrandsInLevelDescInPage(int pageNumber, int pageSize);

	ArrayList<BrandDto> findAllBrandsInLevelAscInPage(int pageNumber, int pageSize);

	ArrayList<BrandDto> findAllBrandsInPopularityDescInPage(int pageNumber, int pageSize);

	ArrayList<BrandDto> findAllBrandsInPopularityAscInPage(int pageNumber, int pageSize);

	ArrayList<BrandDto> findBrandsByCountryInPage(int country, int pageNumber,
			int pageSize);

	ArrayList<BrandDto> findBrandsByCountryInLevelDescInPage(int country,
			int pageNumber, int pageSize);

	ArrayList<BrandDto> findBrandsByCountryInLevelAscInPage(int country,
			int pageNumber, int pageSize);

	ArrayList<BrandDto> findBrandsByCountryInPopularityDescInPage(int country,
			int pageNumber, int pageSize);

	ArrayList<BrandDto> findBrandsByCountryInPopularityAscInPage(int country,
			int pageNumber, int pageSize);

	ArrayList<BrandDto> findBrandsByLevelInPage(int level, int pageNumber, int pageSize);

	ArrayList<BrandDto> findBrandsByPopularityInPage(int popularity, int pageNumber,
			int pageSize);

	BrandDto findByBrandName(String brandName);

	BrandDto findByBrandCode(String brandCode);
	
	PagingLoadResult<BrandDto> getBrands(final PagingLoadConfig loadConfig);
}
