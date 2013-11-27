package com.codeholic.ui.gwt.shared.user.service;

import java.util.List;

import com.codeholic.ui.gwt.shared.user.dto.User;
import com.google.gwt.user.client.rpc.IsSerializable;

public class UserPagingLoadResult implements com.sencha.gxt.data.shared.loader.PagingLoadResult<User>, IsSerializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int offset;
	private int totalLength;
	private List<User> data;
	
	public UserPagingLoadResult(){
		
	}
	
	public UserPagingLoadResult(List<User> users){
		this.data = users;
	}
	
	@Override
	public List<User> getData() {
		return this.data;
	}

	@Override
	public int getOffset() {
		return this.offset;
	}

	@Override
	public int getTotalLength() {
		return this.totalLength;
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
