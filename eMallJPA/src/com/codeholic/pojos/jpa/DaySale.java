package com.codeholic.pojos.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.codeholic.pojos.jpa.embed.GoodDealInfo;

import java.util.Date;

/**
 * The persistent class for the day_sales database table.
 * 
 */
@Entity
@Table(name = "DAY_SALES")
public class DaySale extends EntityObject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DSALE_ID")
	private String dsaleId;

	@Column(name = "DSALE_NUM")
	private int dsaleNum;

	@Temporal(TemporalType.DATE)
	@Column(name = "DSALE_TIME")
	private Date dsaleTime;

	/*
	 * //@Column(name="BRAND_ID") //private String brandId;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="BRAND_ID") private Brand brand;
	 * 
	 * //@Column(name="GCLASS1_ID") //private String gclass1Id;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="GCLASS1_ID") private Goodsclass1 gclass1;
	 * 
	 * //@Column(name="GCLASS2_ID") //private String gclass2Id;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="GCLASS2_ID") private Goodsclass2 gclass2;
	 * 
	 * //@Column(name="GOODS_ID") //private String goodsId;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="GOODS_ID") private Good good;
	 * 
	 * //@Column(name="STORE_ID") //private String storeId;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="STORE_ID") private StoreInfo store;
	 */

	@Embedded
	private GoodDealInfo goodDealInfo;
	
	public DaySale() {
	}

	public String getDsaleId() {
		return this.dsaleId;
	}

	public void setDsaleId(String dsaleId) {
		this.dsaleId = dsaleId;
	}

	public int getDsaleNum() {
		return this.dsaleNum;
	}

	public void setDsaleNum(int dsaleNum) {
		this.dsaleNum = dsaleNum;
	}

	public Date getDsaleTime() {
		return this.dsaleTime;
	}

	public void setDsaleTime(Date dsaleTime) {
		this.dsaleTime = dsaleTime;
	}

	public GoodDealInfo getGoodDealInfo() {
		return goodDealInfo;
	}

	public void setGoodDealInfo(GoodDealInfo goodDealInfo) {
		this.goodDealInfo = goodDealInfo;
	}

	

}