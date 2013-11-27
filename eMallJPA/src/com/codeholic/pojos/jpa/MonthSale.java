package com.codeholic.pojos.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.codeholic.pojos.jpa.embed.GoodDealInfo;

import java.util.Date;

/**
 * The persistent class for the mounth_sales database table.
 * 
 */
@Entity
@Table(name = "MONTH_SALES")
public class MonthSale extends EntityObject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MSALE_ID")
	private String msaleId;

	/*
	 * // @Column(name="BRAND_ID") // private String brandId;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "BRAND_ID") private Brand brand;
	 * 
	 * // @Column(name="GCLASS1_ID") // private String gclass1Id;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "GCLASS1_ID") private Goodsclass1 gclass1;
	 * 
	 * // @Column(name="GCLASS2_ID") // private String gclass2Id;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "GCLASS2_ID") private Goodsclass2 gclass2;
	 * 
	 * // @Column(name="GOODS_ID") // private String goodsId;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "GOODS_ID") private Good good;
	 * 
	 * // @Column(name="STORE_ID") // private String storeId;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "STORE_ID") private StoreInfo store;
	 */
	@Embedded
	private GoodDealInfo goodDealInfo;
	
	
	@Column(name = "MSALE_NUM")
	private int msaleNum;

	@Temporal(TemporalType.DATE)
	@Column(name = "MSALE_TIME")
	private Date msaleTime;

	public MonthSale() {
	}

	public String getMsaleId() {
		return this.msaleId;
	}

	public void setMsaleId(String msaleId) {
		this.msaleId = msaleId;
	}

	public int getMsaleNum() {
		return this.msaleNum;
	}

	public void setMsaleNum(int msaleNum) {
		this.msaleNum = msaleNum;
	}

	public Date getMsaleTime() {
		return this.msaleTime;
	}

	public void setMsaleTime(Date msaleTime) {
		this.msaleTime = msaleTime;
	}

	public GoodDealInfo getGoodDealInfo() {
		return goodDealInfo;
	}

	public void setGoodDealInfo(GoodDealInfo goodDealInfo) {
		this.goodDealInfo = goodDealInfo;
	}

	
}