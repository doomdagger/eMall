package com.codeholic.pojos.jpa;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;


/**
 * The persistent class for the goodsclass1 database table.
 * 
 */
@NamedQueries
(
	@NamedQuery(name="goodsClass1.findAllIdAndName",query="select g.gclass1Id,g.gclass1Name from Goodsclass1 g")
)
@Entity
@Table(name="GOODSCLASS1")
public class Goodsclass1 extends EntityObject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="GCLASS1_ID")
	private String gclass1Id;

	private byte delflag;

	@Column(name="GCLASS1_CLASS")
	private int gclass1Class;

	@Column(name="GCLASS1_CODE")
	private String gclass1Code;

	@Column(name="GCLASS1_DESC")
	private String gclass1Desc;

	@Column(name="GCLASS1_NAME")
	private String gclass1Name;

	/*
	 * 映射所需新加字段
	 */
	@OneToMany(mappedBy="gclass1",fetch=FetchType.LAZY)
	private Collection<Goodsclass2> gclass2s;
	
	@OneToMany(mappedBy="class1")
	private Collection<Good> goods;
	
	//-----------------------end-----------------------
	
	
	
	public Goodsclass1() {
	}

	public Collection<Goodsclass2> getGclass2s() {
		return gclass2s;
	}

	public void setGclass2s(Collection<Goodsclass2> gclass2s) {
		this.gclass2s = gclass2s;
	}

	public String getGclass1Id() {
		return this.gclass1Id;
	}

	public void setGclass1Id(String gclass1Id) {
		this.gclass1Id = gclass1Id;
	}

	public byte getDelflag() {
		return this.delflag;
	}

	public void setDelflag(byte delflag) {
		this.delflag = delflag;
	}

	public int getGclass1Class() {
		return this.gclass1Class;
	}

	public void setGclass1Class(int gclass1Class) {
		this.gclass1Class = gclass1Class;
	}

	public String getGclass1Code() {
		return this.gclass1Code;
	}

	public void setGclass1Code(String gclass1Code) {
		this.gclass1Code = gclass1Code;
	}

	public String getGclass1Desc() {
		return this.gclass1Desc;
	}

	public void setGclass1Desc(String gclass1Desc) {
		this.gclass1Desc = gclass1Desc;
	}

	public String getGclass1Name() {
		return this.gclass1Name;
	}

	public void setGclass1Name(String gclass1Name) {
		this.gclass1Name = gclass1Name;
	}

}