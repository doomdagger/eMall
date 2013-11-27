package com.codeholic.ui.gwt.shared.dto;

import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.sencha.gxt.data.shared.SortInfo;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;

public class CorePagingLoadConfig implements PagingLoadConfig,IsSerializable{

	private static final long serialVersionUID = 1743855756515264468L;
	
	private List<? extends SortInfo> sortInfo;
	private int limit;
	private int offset;

	@Override
	public List<? extends SortInfo> getSortInfo() {
		return this.sortInfo;
	}

	@Override
	public void setSortInfo(List<? extends SortInfo> info) {
		this.sortInfo = info;
	}

	@Override
	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public void setOffset(int offset) {
		this.offset = offset;
	}

	@Override
	public int getLimit() {
		return limit;
	}

	@Override
	public int getOffset() {
		return offset;
	}

}
