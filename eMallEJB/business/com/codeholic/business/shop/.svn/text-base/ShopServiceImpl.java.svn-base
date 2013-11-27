package com.codeholic.business.shop;

import java.io.File;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;


import com.codeholic.business.shop.view.IShopService;
import com.codeholic.business.util.ExcelHandler;
import com.codeholic.eao.ParamMapper;
import com.codeholic.eao.UUIDGenerator;
import com.codeholic.eao.shop.StoreInfoEao;
import com.codeholic.eao.support.Pageable;
import com.codeholic.pojos.jpa.StoreInfo;


@Stateless
@Local(IShopService.class)
public class ShopServiceImpl implements IShopService{

	//ejb inject
	@EJB
	private StoreInfoEao storeInfoEao;
	
	@Override
	public List<StoreInfo> getStoreList() {
		
		List<StoreInfo> infos = null;
		try {
			infos = storeInfoEao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return infos;
		
	}

	@Override
	public List<StoreInfo> getStoreListInPage(int pageNumber, int pageSize) {
		try {
			return storeInfoEao.findAllInPage(Pageable.inPage(pageNumber, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public StoreInfo getStoreById(String id) {
		try {
			return storeInfoEao.findOneById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public StoreInfo getStoreByName(String storename) {
		try {
			return storeInfoEao.findOneByParams("storeInfo.findByStoreName", ParamMapper.instance("storeName", storename));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public StoreInfo getStoreByCountry(String country) {
		try {
			return storeInfoEao.findOneByParams("storeInfo.findByStoreName", ParamMapper.instance("storeCountry", country));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public StoreInfo getStoreByPrvi(String prvi) {
		try {
			return storeInfoEao.findOneByParams("storeInfo.findByStorePrvi", ParamMapper.instance("storePrvi", prvi));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public StoreInfo getStoreByRegion(String region) {
		try {
			return storeInfoEao.findOneByParams("storeInfo.findByStoreRegion", ParamMapper.instance("storeRegion", region));
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return null;
	}

	@Override
	public boolean addStore(StoreInfo store) {
		
		if (store == null) 
		{
			return false;
		}
		try {
			store.setStoreId(UUIDGenerator.randomUUID());
			storeInfoEao.add(store);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeStore(String id) {
		
		if(id == null)
		{
			return false;
		}
		try {
			storeInfoEao.deleteByParams("storeInfo.removeStoreById", ParamMapper.instance("storeId", id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean AddBatchShopStoreByExcel(File file) {
		try {
			ExcelHandler<StoreInfo> shopExcelHandler = new ExcelHandler<StoreInfo>(StoreInfo.class);
			List<StoreInfo> shopsList = shopExcelHandler.readExcel(file);
			for(StoreInfo shopInfo : shopsList)
			{
				shopInfo.setStoreId(UUIDGenerator.randomUUID());
				storeInfoEao.add(shopInfo);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean CreateStoreInfoBasicExcel(String fileName) {
		try {
			ExcelHandler<StoreInfo> shopExcelHandler = new ExcelHandler<StoreInfo>(StoreInfo.class);
			shopExcelHandler.writeExcel(fileName);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<StoreInfo> findAllIdAndName() {
		try {
			return storeInfoEao.findByNamedQuery("storeInfo.findAllIdAndName");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
