package com.codeholic.pojos.jpa;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;


/**
 * The persistent class for the goodsclass2 database table.
 * 
 */
@Entity
@Table(name="GOODSCLASS2")
@NamedQueries({ 
	@NamedQuery(name = "goodsclass2.findByGoodsclass2Name", query = "select g2 from Goodsclass2 g2 where g2.gclass2Name=:gclass2Name"),
		
	@NamedQuery(name = "goodsclass2.findByGoodsclass2Code", query = "select g2 from Goodsclass2 g2 where g2.gclass2Code=:gclass2Code"),
	@NamedQuery(name = "goodsclass2.findAllIdAndName", query = "select g.gclass2Id,g.gclass2Name from Goodsclass2 g")
})
public class Goodsclass2 extends EntityObject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="GCLASS2_ID")
	private String gclass2Id;

	private byte delflag;

	//@Column(name="GCLASS1_ID")
	//private String gclass1Id;
	@ManyToOne
	@JoinColumn(name="GCLASS1_ID")
	private Goodsclass1 gclass1;
	
	@Column(name="GCLASS2_CODE")
	private String gclass2Code;

	@Column(name="GCLASS2_DESC")
	private String gclass2Desc;

	@Column(name="GCLASS2_NAME")
	private String gclass2Name;

	/*
	 * 映射所需新加字段
	 */
	
	@OneToMany(mappedBy="class2",fetch=FetchType.LAZY)
	private Collection<Good> goods;
	
	//-----------------------end-----------------------
	
	
	
	public Goodsclass2() {
	}

	public Collection<Good> getGoods() {
		return goods;
	}

	public void setGoods(Collection<Good> goods) {
		this.goods = goods;
	}

	public String getGclass2Id() {
		return this.gclass2Id;
	}

	public void setGclass2Id(String gclass2Id) {
		this.gclass2Id = gclass2Id;
	}

	public byte getDelflag() {
		return this.delflag;
	}

	public void setDelflag(byte delflag) {
		this.delflag = delflag;
	}

	

	public Goodsclass1 getGclass1() {
		return gclass1;
	}

	public void setGclass1(Goodsclass1 gclass1) {
		this.gclass1 = gclass1;
	}

	public String getGclass2Code() {
		return this.gclass2Code;
	}

	public void setGclass2Code(String gclass2Code) {
		this.gclass2Code = gclass2Code;
	}

	public String getGclass2Desc() {
		return this.gclass2Desc;
	}

	public void setGclass2Desc(String gclass2Desc) {
		this.gclass2Desc = gclass2Desc;
	}

	public String getGclass2Name() {
		return this.gclass2Name;
	}

	public void setGclass2Name(String gclass2Name) {
		this.gclass2Name = gclass2Name;
	}

}