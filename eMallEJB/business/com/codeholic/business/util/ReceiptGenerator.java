package com.codeholic.business.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.codeholic.business.goods.view.IGoodService;
import com.codeholic.business.shop.view.IShopService;
import com.codeholic.eao.UUIDGenerator;
import com.codeholic.pojos.jpa.Good;
import com.codeholic.pojos.jpa.Receipt;
import com.codeholic.pojos.jpa.ReceiptDetail;
import com.codeholic.pojos.jpa.StoreInfo;
import com.codeholic.pojos.jpa.User;


@Stateless
@LocalBean
public class ReceiptGenerator {
	
	
	@EJB
	private IShopService shopServiceImpl;
	
	@EJB 
	private IGoodService goodServiceImpl;
	
	final EntityManagerFactory emf = Persistence.createEntityManagerFactory("eMallJPA");
	EntityManager em = emf.createEntityManager();
	Random indexRandom = new Random();
	
	public ReceiptGenerator() {
		// TODO Auto-generated constructor stub
	}
	
	public Receipt next(int goodNumber)
	{
		
		
		
		Receipt receipt = new Receipt();
		receipt.setReceiptId(UUIDGenerator.randomUUID());
		receipt.setReceiptCode(generateReceiptCode(generateStore().getStoreId().toString(), generateVip()));
		receipt.setVipId(generateVip());
		receipt.setStore(generateStore());
		receipt.setReceiptComment("");
		receipt.setReceiptTime(new Date());
		
		List<Good> goodList = generateGoods(goodNumber);
		List<ReceiptDetail> reList = new ArrayList<ReceiptDetail>();
		
		for(int i=0; i<goodList.size(); i++)
		{			
			ReceiptDetail receiptDetails = new ReceiptDetail();
			receiptDetails.setRdId(UUIDGenerator.randomUUID());
			receiptDetails.setRdNum(1);
			receiptDetails.setRdPrice(goodList.get(i).getGoodsPrice());
			receiptDetails.setReceiptTime(new Date());
			Receipt newReceipt = new Receipt();
			newReceipt.setReceiptId(receipt.getReceiptId());
			receiptDetails.setReceipt(newReceipt);
			reList.add(receiptDetails);
		}
		
		receipt.setReceiptDetails(reList);
		return receipt;
	}
	
	//generate the random store in DB
	protected StoreInfo generateStore()
	{
		List<StoreInfo> shopList = shopServiceImpl.getStoreList();
		
		StoreInfo store = shopList.get(indexRandom.nextInt(shopList.size()));
		return store;
	}
	
	//
	protected List<Good> generateGoods(int number)
	{
		
		List<Good> goodList = new ArrayList<Good>();
		for(int i=0; i<number; i++)
		{
			Good good = (Good)em.createNativeQuery("select g.* from GOODS g order by rand() limit 1",Good.class).getSingleResult();
			goodList.add(good);
		}
		return goodList;
	}
	
	//
	protected String generateVip()
	{
		User user = (User)em.createNativeQuery("select u.* from USER u order by rand() limit 1",User.class).getSingleResult();
		return user.getUserId();
	}
	
	//
	protected String generateReceiptCode(String storeId,String vip)
	{
		String codeString = new Date().toString();
		codeString += storeId;
		codeString += vip;
		for(int i=0; i<5; i++)
		{
			codeString += indexRandom.nextInt(10);
		}
		return codeString;
	}
}
