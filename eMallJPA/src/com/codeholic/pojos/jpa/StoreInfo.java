package com.codeholic.pojos.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the store_info database table.
 * 
 */

@NamedQueries(
		{
			@NamedQuery(name="storeInfo.findById", query="select s from StoreInfo s where s.storeId=:storeId"),
			@NamedQuery(name="storeInfo.findAllStoreAsc",query="select s from StoreInfo s order by s.storeName ASC"),
			@NamedQuery(name="storeInfo.findByStoreName", query="select s from StoreInfo s where s.storeName=:storeName"),
			@NamedQuery(name="storeInfo.findByStoreCountry", query="select s from StoreInfo s where s.storeCountry=:sotreCounry"),
			@NamedQuery(name="storeInfo.findByStorePrvi", query="select s from StoreInfo s where s.storePrvi=:storePrvi"),
			@NamedQuery(name="storeInfo.findByStoreRegion", query="select s from StoreInfo s where s.storeRegion=:storeRegion"),
			@NamedQuery(name="storeInfo.removeStoreById",query="delete from StoreInfo s where s.storeId=:storeId"),
			@NamedQuery(name="storeInfo.findAllIdAndName",query="select s.storeId,s.storeName from StoreInfo s")
		}
)

@Entity
@Table(name="STORE_INFO")
public class StoreInfo extends EntityObject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="STORE_ID")
	private String storeId;

	@Column(name="STORE_CODE")
	private String storeCode;

	@Column(name="STORE_COUNTRY")
	private int storeCountry;

	@Column(name="STORE_NAME")
	private String storeName;

	@Column(name="STORE_PRVI")
	private int storePrvi;

	@Column(name="STORE_REGION")
	private int storeRegion;

	public StoreInfo() {
	}

	public String getStoreId() {
		return this.storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreCode() {
		return this.storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public int getStoreCountry() {
		return this.storeCountry;
	}

	public void setStoreCountry(int storeCountry) {
		this.storeCountry = storeCountry;
	}

	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getStorePrvi() {
		return this.storePrvi;
	}

	public void setStorePrvi(int storePrvi) {
		this.storePrvi = storePrvi;
	}

	public int getStoreRegion() {
		return this.storeRegion;
	}

	public void setStoreRegion(int storeRegion) {
		this.storeRegion = storeRegion;
	}
	
//	@Override
//	public String toString(){
//		return "["+storeId+"\t"+storeCode+"\t"+storeName+"\t"+storeCountry+"\t"+storePrvi+"\t"+storeRegion+"]";
//	}

}