package com.codeholic.pojos.jpa.embed;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;


/*
 * 封装对象，五个字段
 */
@Embeddable
@Access(AccessType.FIELD)
public class GoodDealInfo {
	@Column(name = "BRAND_ID")
	private String brandId;

	@Column(name = "GCLASS1_ID")
	private String gclass1Id;

	@Column(name = "GCLASS2_ID")
	private String gclass2Id;

	@Column(name = "GOODS_ID")
	private String goodsId;

	@Column(name="STORE_ID")
	private String storeId;

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getGclass1Id() {
		return gclass1Id;
	}

	public void setGclass1Id(String gclass1Id) {
		this.gclass1Id = gclass1Id;
	}

	public String getGclass2Id() {
		return gclass2Id;
	}

	public void setGclass2Id(String gclass2Id) {
		this.gclass2Id = gclass2Id;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	
}
