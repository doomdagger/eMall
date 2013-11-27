package com.codeholic.ui.gwt.shared.dto;

import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

public class CorePagingLoadResult<T> implements PagingLoadResult<T>, IsSerializable{

	private static final long serialVersionUID = 1006969649449977261L;

	private int offset;
	private int totalLength;
	private List<T> data;
	
	@Override
	public List<T> getData() {
		return data;
	}
	
	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public int getOffset() {
		return offset;
	}

	@Override
	public int getTotalLength() {
		return totalLength;
	}

	@Override
	public void setOffset(int offset) {
		this.offset = offset;
	}

	@Override
	public void setTotalLength(int totalLength) {
		this.totalLength = totalLength;
	}

}
