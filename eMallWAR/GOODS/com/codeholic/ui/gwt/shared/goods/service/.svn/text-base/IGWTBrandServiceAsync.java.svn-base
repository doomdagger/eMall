package com.codeholic.ui.gwt.shared.goods.service;

import java.util.ArrayList;

import com.codeholic.ui.gwt.shared.goods.dto.BrandDto;
import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

public interface IGWTBrandServiceAsync {

	Request addBatchBrandsByExcel(String fileName, AsyncCallback<Boolean> callback);

	Request addBrand(BrandDto brand, AsyncCallback<Boolean> callback);

	Request findAllBrandsInLevelAscInPage(int pageNumber, int pageSize,
			AsyncCallback<ArrayList<BrandDto>> callback);

	Request findAllBrandsInLevelDescInPage(int pageNumber, int pageSize,
			AsyncCallback<ArrayList<BrandDto>> callback);

	Request findAllBrandsInPage(int pageNumber, int pageSize,
			AsyncCallback<ArrayList<BrandDto>> callback);

	Request findAllBrandsInPopularityAscInPage(int pageNumber, int pageSize,
			AsyncCallback<ArrayList<BrandDto>> callback);

	Request findAllBrandsInPopularityDescInPage(int pageNumber, int pageSize,
			AsyncCallback<ArrayList<BrandDto>> callback);

	Request findBrandsByCountryInLevelAscInPage(int country, int pageNumber,
			int pageSize, AsyncCallback<ArrayList<BrandDto>> callback);

	Request findBrandsByCountryInLevelDescInPage(int country, int pageNumber,
			int pageSize, AsyncCallback<ArrayList<BrandDto>> callback);

	Request findBrandsByCountryInPage(int country, int pageNumber, int pageSize,
			AsyncCallback<ArrayList<BrandDto>> callback);

	Request findBrandsByCountryInPopularityAscInPage(int country, int pageNumber,
			int pageSize, AsyncCallback<ArrayList<BrandDto>> callback);

	Request findBrandsByCountryInPopularityDescInPage(int country, int pageNumber,
			int pageSize, AsyncCallback<ArrayList<BrandDto>> callback);

	Request findBrandsByLevelInPage(int level, int pageNumber, int pageSize,
			AsyncCallback<ArrayList<BrandDto>> callback);

	Request findBrandsByPopularityInPage(int popularity, int pageNumber,
			int pageSize, AsyncCallback<ArrayList<BrandDto>> callback);

	Request findByBrandCode(String brandCode, AsyncCallback<BrandDto> callback);

	Request findByBrandName(String brandName, AsyncCallback<BrandDto> callback);

	Request removeBrand(String brandId, AsyncCallback<Boolean> callback);

	Request getBrands(PagingLoadConfig loadConfig,
			AsyncCallback<PagingLoadResult<BrandDto>> callback);

	Request updateBrand(BrandDto brandDto, AsyncCallback<Boolean> callback);

}
