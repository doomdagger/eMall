package com.codeholic.ui.gwt.server.goods;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import com.codeholic.business.goods.view.IBrandService;
import com.codeholic.pojos.jpa.Brand;
import com.codeholic.ui.gwt.server.util.ClassMapper;
import com.codeholic.ui.gwt.shared.goods.dto.BrandDto;
import com.codeholic.ui.gwt.shared.goods.dto.BrandPagingLoadResult;
import com.codeholic.ui.gwt.shared.goods.service.IGWTBrandService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

public class GWTBrandServiceImpl extends RemoteServiceServlet implements
		IGWTBrandService {

	private static final long serialVersionUID = 2709214832755133502L;

	@EJB
	private IBrandService brandService;

	@Override
	public boolean addBatchBrandsByExcel(String fileName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addBrand(BrandDto brand) {
		Brand jpaBrand = new Brand();
		ClassMapper.map(brand, jpaBrand);
		return brandService.addBrand(jpaBrand);
	}

	@Override
	public boolean removeBrand(String brandId) {
		return brandService.removeBrand(brandId);
	}

	@Override
	public ArrayList<BrandDto> findAllBrandsInPage(int pageNumber, int pageSize) {
		List<Brand> list = brandService.findAllBrandsInPage(pageNumber,
				pageSize);

		ArrayList<BrandDto> dtoList = new ArrayList<BrandDto>();

		for (Brand brand : list) {
			BrandDto dto = new BrandDto();
			ClassMapper.map(brand, dto);
			dtoList.add(dto);
		}

		return dtoList;
	}

	@Override
	public ArrayList<BrandDto> findAllBrandsInLevelDescInPage(int pageNumber,
			int pageSize) {
		List<Brand> list = brandService.findAllBrandsInLevelDescInPage(
				pageNumber, pageSize);

		ArrayList<BrandDto> dtoList = new ArrayList<BrandDto>();

		for (Brand brand : list) {
			BrandDto dto = new BrandDto();
			ClassMapper.map(brand, dto);
			dtoList.add(dto);
		}

		return dtoList;
	}

	@Override
	public ArrayList<BrandDto> findAllBrandsInLevelAscInPage(int pageNumber,
			int pageSize) {
		List<Brand> list = brandService.findAllBrandsInLevelAscInPage(
				pageNumber, pageSize);

		ArrayList<BrandDto> dtoList = new ArrayList<BrandDto>();

		for (Brand brand : list) {
			BrandDto dto = new BrandDto();
			ClassMapper.map(brand, dto);
			dtoList.add(dto);
		}

		return dtoList;
	}

	@Override
	public ArrayList<BrandDto> findAllBrandsInPopularityDescInPage(
			int pageNumber, int pageSize) {
		List<Brand> list = brandService.findAllBrandsInPopularityDescInPage(
				pageNumber, pageSize);

		ArrayList<BrandDto> dtoList = new ArrayList<BrandDto>();

		for (Brand brand : list) {
			BrandDto dto = new BrandDto();
			ClassMapper.map(brand, dto);
			dtoList.add(dto);
		}

		return dtoList;
	}

	@Override
	public ArrayList<BrandDto> findAllBrandsInPopularityAscInPage(
			int pageNumber, int pageSize) {
		List<Brand> list = brandService.findAllBrandsInPopularityAscInPage(
				pageNumber, pageSize);

		ArrayList<BrandDto> dtoList = new ArrayList<BrandDto>();

		for (Brand brand : list) {
			BrandDto dto = new BrandDto();
			ClassMapper.map(brand, dto);
			dtoList.add(dto);
		}

		return dtoList;
	}

	@Override
	public ArrayList<BrandDto> findBrandsByCountryInPage(int country,
			int pageNumber, int pageSize) {
		List<Brand> list = brandService.findBrandsByCountryInPage(country,
				pageNumber, pageSize);

		ArrayList<BrandDto> dtoList = new ArrayList<BrandDto>();

		for (Brand brand : list) {
			BrandDto dto = new BrandDto();
			ClassMapper.map(brand, dto);
			dtoList.add(dto);
		}

		return dtoList;
	}

	@Override
	public ArrayList<BrandDto> findBrandsByCountryInLevelDescInPage(
			int country, int pageNumber, int pageSize) {
		List<Brand> list = brandService.findBrandsByCountryInLevelDescInPage(
				country, pageNumber, pageSize);

		ArrayList<BrandDto> dtoList = new ArrayList<BrandDto>();

		for (Brand brand : list) {
			BrandDto dto = new BrandDto();
			ClassMapper.map(brand, dto);
			dtoList.add(dto);
		}

		return dtoList;
	}

	@Override
	public ArrayList<BrandDto> findBrandsByCountryInLevelAscInPage(int country,
			int pageNumber, int pageSize) {
		List<Brand> list = brandService.findBrandsByCountryInLevelAscInPage(
				country, pageNumber, pageSize);

		ArrayList<BrandDto> dtoList = new ArrayList<BrandDto>();

		for (Brand brand : list) {
			BrandDto dto = new BrandDto();
			ClassMapper.map(brand, dto);
			dtoList.add(dto);
		}

		return dtoList;
	}

	@Override
	public ArrayList<BrandDto> findBrandsByCountryInPopularityDescInPage(
			int country, int pageNumber, int pageSize) {
		List<Brand> list = brandService
				.findBrandsByCountryInPopularityDescInPage(country, pageNumber,
						pageSize);

		ArrayList<BrandDto> dtoList = new ArrayList<BrandDto>();

		for (Brand brand : list) {
			BrandDto dto = new BrandDto();
			ClassMapper.map(brand, dto);
			dtoList.add(dto);
		}

		return dtoList;
	}

	@Override
	public ArrayList<BrandDto> findBrandsByCountryInPopularityAscInPage(
			int country, int pageNumber, int pageSize) {
		List<Brand> list = brandService
				.findBrandsByCountryInPopularityAscInPage(country, pageNumber,
						pageSize);

		ArrayList<BrandDto> dtoList = new ArrayList<BrandDto>();

		for (Brand brand : list) {
			BrandDto dto = new BrandDto();
			ClassMapper.map(brand, dto);
			dtoList.add(dto);
		}

		return dtoList;
	}

	@Override
	public ArrayList<BrandDto> findBrandsByLevelInPage(int level,
			int pageNumber, int pageSize) {
		List<Brand> list = brandService.findBrandsByLevelInPage(level,
				pageNumber, pageSize);

		ArrayList<BrandDto> dtoList = new ArrayList<BrandDto>();

		for (Brand brand : list) {
			BrandDto dto = new BrandDto();
			ClassMapper.map(brand, dto);
			dtoList.add(dto);
		}

		return dtoList;
	}

	@Override
	public ArrayList<BrandDto> findBrandsByPopularityInPage(int popularity,
			int pageNumber, int pageSize) {
		List<Brand> list = brandService.findBrandsByPopularityInPage(
				popularity, pageNumber, pageSize);

		ArrayList<BrandDto> dtoList = new ArrayList<BrandDto>();

		for (Brand brand : list) {
			BrandDto dto = new BrandDto();
			ClassMapper.map(brand, dto);
			dtoList.add(dto);
		}

		return dtoList;
	}

	@Override
	public BrandDto findByBrandName(String brandName) {
		Brand brand = brandService.findByBrandName(brandName);
		BrandDto dto = new BrandDto();
		ClassMapper.map(brand, dto);
		return dto;
	}

	@Override
	public BrandDto findByBrandCode(String brandCode) {
		Brand brand = brandService.findByBrandCode(brandCode);
		BrandDto dto = new BrandDto();
		ClassMapper.map(brand, dto);
		return dto;
	}

	@Override
	public PagingLoadResult<BrandDto> getBrands(PagingLoadConfig loadConfig) {

		int limit = loadConfig.getLimit();
		int offset = loadConfig.getOffset();
				
		List<BrandDto> brands = this.findAllBrandsInPage(offset/limit, limit);
		
		BrandPagingLoadResult result = new BrandPagingLoadResult();
		result.setData(brands);
		result.setOffset(offset);
		result.setTotalLength((int)brandService.getAllCount());
		
		return result;
	}

	@Override
	public boolean updateBrand(BrandDto brandDto) {
		Brand brand = new Brand();
		
		ClassMapper.map(brandDto, brand);
		
		return brandService.updateBrand(brand);

	}

}
