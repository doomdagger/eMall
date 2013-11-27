package com.codeholic.pojos.jpa;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Collection;
import java.util.Date;


/**
 * The persistent class for the receipt database table.
 * 
 */
@Entity
@Table(name="RECEIPT")
public class Receipt extends EntityObject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RECEIPT_ID")
	private String receiptId;

	@Column(name="RECEIPT_CODE")
	private String receiptCode;

	@Column(name="RECEIPT_COMMENT")
	private String receiptComment;

	@Column(name="RECEIPT_COST")
	private double receiptCost;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="RECEIPT_TIME")
	private Date receiptTime;

	@Column(name="RECEIPT_TOTAL")
	private int receiptTotal;

	@Column(name="RECEIPT_TYPE")
	private int receiptType;

	
	//@Column(name="STORE_ID")
	//private String storeId;
	@ManyToOne
	@JoinColumn(name="STORE_ID")
	private StoreInfo store;
	
	/*
	 * No VIP table now!!
	 */
	@Column(name="VIP_ID")
	private String vipId;

	
	/*
	 * 映射所需新加字段
	 */
	
	@OneToMany(mappedBy="receipt",fetch=FetchType.LAZY)
	private Collection<ReceiptDetail> receiptDetails;
	
	//-----------------------end-----------------------
	
	
	
	public Receipt() {
	}

	public String getReceiptId() {
		return this.receiptId;
	}

	public void setReceiptId(String receiptId) {
		this.receiptId = receiptId;
	}

	public String getReceiptCode() {
		return this.receiptCode;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}

	public String getReceiptComment() {
		return this.receiptComment;
	}

	public void setReceiptComment(String receiptComment) {
		this.receiptComment = receiptComment;
	}

	public double getReceiptCost() {
		return this.receiptCost;
	}

	public void setReceiptCost(double receiptCost) {
		this.receiptCost = receiptCost;
	}

	public Date getReceiptTime() {
		return this.receiptTime;
	}

	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}

	public int getReceiptTotal() {
		return this.receiptTotal;
	}

	public void setReceiptTotal(int receiptTotal) {
		this.receiptTotal = receiptTotal;
	}

	public int getReceiptType() {
		return this.receiptType;
	}

	public void setReceiptType(int receiptType) {
		this.receiptType = receiptType;
	}

	public StoreInfo getStore() {
		return store;
	}

	public void setStore(StoreInfo store) {
		this.store = store;
	}

	public Collection<ReceiptDetail> getReceiptDetails() {
		return receiptDetails;
	}

	public void setReceiptDetails(Collection<ReceiptDetail> receiptDetails) {
		this.receiptDetails = receiptDetails;
	}

	public String getVipId() {
		return this.vipId;
	}

	public void setVipId(String vipId) {
		this.vipId = vipId;
	}

}