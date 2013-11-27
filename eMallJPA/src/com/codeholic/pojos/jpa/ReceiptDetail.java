package com.codeholic.pojos.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.codeholic.pojos.jpa.embed.GoodDealInfo;

import java.util.Date;

/**
 * The persistent class for the receipt_detail database table.
 * 
 */
@Entity
@Table(name = "RECEIPT_DETAIL")
public class ReceiptDetail extends EntityObject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "RD_ID")
	private String rdId;

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
	
	
	@Column(name = "RD_NUM")
	private int rdNum;

	@Column(name = "RD_PRICE")
	private double rdPrice;

	// @Column(name="RECEIPT_ID")
	// private String receiptId;
	@ManyToOne
	@JoinColumn(name = "RECEIPT_ID")
	private Receipt receipt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RECEIPT_TIME")
	private Date receiptTime;

	public ReceiptDetail() {
	}

	public String getRdId() {
		return this.rdId;
	}

	public void setRdId(String rdId) {
		this.rdId = rdId;
	}

	public int getRdNum() {
		return this.rdNum;
	}

	public void setRdNum(int rdNum) {
		this.rdNum = rdNum;
	}

	public double getRdPrice() {
		return this.rdPrice;
	}

	public void setRdPrice(double rdPrice) {
		this.rdPrice = rdPrice;
	}

	public Date getReceiptTime() {
		return this.receiptTime;
	}

	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}

	
	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public GoodDealInfo getGoodDealInfo() {
		return goodDealInfo;
	}

	public void setGoodDealInfo(GoodDealInfo goodDealInfo) {
		this.goodDealInfo = goodDealInfo;
	}
	
//	@Override
//	public String toString(){
//		return "["+rdId+"\t"+rdNum+"\t"+rdPrice+"\t"+goodDealInfo+"\t"+receiptTime+"\t"+"]";
//	}
//	

}