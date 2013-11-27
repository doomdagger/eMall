package com.codeholic.pojos.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the goods database table.
 * 
 */
@NamedQueries(
		{
			@NamedQuery(name="good.getCount", query="select count(g) from Good g"),
			@NamedQuery(name="good.removeGood", query="delete from Good g where g.goodsId=:goodId"),
			@NamedQuery(name="good.allInCreateTimeDescInPage", query="select g from Good g order by g.goodsCreatetime desc"),
			@NamedQuery(name="good.allInCreateTimeAscInPage", query="select g from Good g order by g.goodsCreatetime asc"),
			@NamedQuery(name="good.allInBrandInPage", query="select g from Good g where g.brand=:brandId"),
			@NamedQuery(name="good.allInBrandInCreateTimeDescInPage", query="select g from Good g where g.brand=:brandId order by g.goodsCreatetime desc"),
			@NamedQuery(name="good.allInBrandInCreateTimeAscInPage", query="select g from Good g where g.brand=:brandId order by g.goodsCreatetime asc"),
			@NamedQuery(name="good.allInGoodClassInPage", query="select g from Good g where g.class1=:goodClass1"),
			@NamedQuery(name="good.allInGoodClassInCreateTimeDescInPage", query="select g from Good g where g.class1=:goodClass1 order by g.goodsCreatetime desc"),
			@NamedQuery(name="good.allInGoodClassInCreateTimeAscInPage", query="select g from Good g where g.class1=:goodClass1 order by g.goodsCreatetime asc"),
			@NamedQuery(name="good.allInGoodClass2InPage", query="select g from Good g where g.class2=:goodClass2"),
			@NamedQuery(name="good.allInGoodClass2InCreateTimeDescInPage", query="select g from Good g where g.class2=:goodClass2 order by g.goodsCreatetime desc"),
			@NamedQuery(name="good.allInGoodClass2InCreateTimeAscInPage", query="select g from Good g where g.class2=:goodClass2 order by g.goodsCreatetime asc"),
			@NamedQuery(name="good.findByGoodName", query="select g from Good g where g.goodsName=:goodName"),
			@NamedQuery(name="good.findByGoodCode", query="select g from Good g where g.goodsCode=:goodCode"),
			@NamedQuery(name="good.finAllIdAndName",query="select g.goodsId,g.goodsName from Good g")
			
		}
		
		)
@Entity
@Table(name="GOODS")
public class Good extends EntityObject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="GOODS_ID")
	private String goodsId;

	//@Column(name="BRAND_ID")
	//private String brandId;
	@ManyToOne
	@JoinColumn(name="BRAND_ID")
	private Brand brand;
	
	//@Column(name="CLASS1_ID")
	//private String class1Id;
	@ManyToOne
	@JoinColumn(name="GCLASS1_ID")
	private Goodsclass1 class1;
	
	//@Column(name="CLASS2_ID")
	//private String class2Id;
	@ManyToOne
	@JoinColumn(name="GCLASS2_ID")
	private Goodsclass2 class2;
	
	private byte delflag;

	@Column(name="GOODS_CODE")
	private String goodsCode;

	@Temporal(TemporalType.DATE)
	@Column(name="GOODS_CREATETIME")
	private Date goodsCreatetime;

	@Column(name="GOODS_MODE")
	private int goodsMode;

	@Column(name="GOODS_NAME")
	private String goodsName;

	@Column(name="GOODS_PRICE")
	private double goodsPrice;

	@Column(name="GOODS_UNIT")
	private String goodsUnit;

	@Column(name="GOODS_VALID")
	private byte goodsValid;

	public Good() {
	}

	public String getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	

	public Goodsclass1 getClass1() {
		return class1;
	}

	public void setClass1(Goodsclass1 class1) {
		this.class1 = class1;
	}

	public Goodsclass2 getClass2() {
		return class2;
	}

	public void setClass2(Goodsclass2 class2) {
		this.class2 = class2;
	}

	public byte getDelflag() {
		return this.delflag;
	}

	public void setDelflag(byte delflag) {
		this.delflag = delflag;
	}

	public String getGoodsCode() {
		return this.goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public Date getGoodsCreatetime() {
		return this.goodsCreatetime;
	}

	public void setGoodsCreatetime(Date goodsCreatetime) {
		this.goodsCreatetime = goodsCreatetime;
	}

	public int getGoodsMode() {
		return this.goodsMode;
	}

	public void setGoodsMode(int goodsMode) {
		this.goodsMode = goodsMode;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public double getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsUnit() {
		return this.goodsUnit;
	}

	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}

	public byte getGoodsValid() {
		return this.goodsValid;
	}

	public void setGoodsValid(byte goodsValid) {
		this.goodsValid = goodsValid;
	}

}