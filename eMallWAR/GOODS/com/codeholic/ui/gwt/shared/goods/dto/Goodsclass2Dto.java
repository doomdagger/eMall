package com.codeholic.ui.gwt.shared.goods.dto;

import com.google.gwt.user.client.rpc.IsSerializable;


public class Goodsclass2Dto implements IsSerializable{
	private String gclass2Id;

	private byte delflag;

	private Goodsclass1Dto gclass1;

	private String gclass2Code;

	private String gclass2Desc;

	private String gclass2Name;

	
	public Goodsclass2Dto() {
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

	public Goodsclass1Dto getGclass1() {
		return gclass1;
	}

	public void setGclass1(Goodsclass1Dto gclass1) {
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
