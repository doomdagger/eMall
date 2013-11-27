package com.codeholic.pojos.jpa;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;


/**
 * The persistent class for the brand database table.
 * 
 */
@Entity
@Table(name="BRAND")
@NamedQueries({
		
	@NamedQuery(name = "brand.findByBrandName", query = "select b from Brand b where b.brandName=:brandName"),
		
	@NamedQuery(name = "brand.findByBrandCode", query = "select b from Brand b where b.brandCode=:brandCode"),
	@NamedQuery(name = "brand.findAllInLevelDesc", query = "select b from Brand b order by b.brandLevel desc"),
	@NamedQuery(name = "brand.findAllInLevelAsc", query = "select b from Brand b order by b.brandLevel asc"),
	@NamedQuery(name = "brand.findAllInPopularityDesc", query = "select b from Brand b order by b.brandPop desc"),
	@NamedQuery(name = "brand.findAllInPopularityAsc", query = "select b from Brand b order by b.brandPop asc"),
	@NamedQuery(name = "brand.findByCountry", query = "select b from Brand b where b.brandCountry=:brandCountry"),
	@NamedQuery(name = "brand.findByCountryInLevelDesc", query = "select b from Brand b where b.brandCountry=:brandCountry order by b.brandLevel desc"),
	@NamedQuery(name = "brand.findByCountryInLevelAsc", query = "select b from Brand b where b.brandCountry=:brandCountry order by b.brandLevel asc"),
	@NamedQuery(name = "brand.findByCountryInPopularityDesc", query = "select b from Brand b where b.brandCountry=:brandCountry order by b.brandPop desc"),
	@NamedQuery(name = "brand.findByCountryInPopularityAsc", query = "select b from Brand b where b.brandCountry=:brandCountry order by b.brandPop asc"),
	@NamedQuery(name = "brand.findByLevel", query = "select b from Brand b where b.brandLevel=:brandLevel"),
	@NamedQuery(name = "brand.findByPopularity", query = "select b from Brand b where b.brandPop=:brandPop"),
	@NamedQuery(name = "brand.findAllIdAndName",query = "select b.brandId,b.brandName from Brand b")
})
public class Brand extends EntityObject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BRAND_ID")
	private String brandId;

	@Column(name="BRAND_CMMENT")
	private String brandCmment;

	@Column(name="BRAND_CODE")
	private String brandCode;

	@Column(name="BRAND_COUNTRY")
	private int brandCountry;

	@Column(name="BRAND_DESC")
	private String brandDesc;

	@Column(name="BRAND_LEVEL")
	private int brandLevel;

	@Column(name="BRAND_NAME")
	private String brandName;

	@Column(name="BRAND_POP")
	private int brandPop;

	private byte delflag;

	
	/*
	 * 映射所需新加字段
	 */
	
	@OneToMany(mappedBy="brand",fetch=FetchType.LAZY)
	private Collection<Good> goods;
	
	//-----------------------end-----------------------
	
	public Brand() {
	}

	public Collection<Good> getGoods(){
		return this.goods;
	}
	public void setGoods(Collection<Good> goods){
		this.goods = goods;
	}
	
	public String getBrandId() {
		return this.brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	
	
	
	public String getBrandCmment() {
		return this.brandCmment;
	}

	public void setBrandCmment(String brandCmment) {
		this.brandCmment = brandCmment;
	}

	public String getBrandCode() {
		return this.brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public int getBrandCountry() {
		return this.brandCountry;
	}

	public void setBrandCountry(int brandCountry) {
		this.brandCountry = brandCountry;
	}

	public String getBrandDesc() {
		return this.brandDesc;
	}

	public void setBrandDesc(String brandDesc) {
		this.brandDesc = brandDesc;
	}

	public int getBrandLevel() {
		return this.brandLevel;
	}

	public void setBrandLevel(int brandLevel) {
		this.brandLevel = brandLevel;
	}

	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getBrandPop() {
		return this.brandPop;
	}

	public void setBrandPop(int brandPop) {
		this.brandPop = brandPop;
	}

	public byte getDelflag() {
		return this.delflag;
	}

	public void setDelflag(byte delflag) {
		this.delflag = delflag;
	}
//
//	@Override
//	public String toString(){
//		return "["+brandId+"\t"+brandName+"\t"+brandCode+"\t"+brandCountry+"\t"+brandDesc+"\t"+brandCmment+"\t"+brandLevel+"\t"+brandPop+"]";
//	}
}