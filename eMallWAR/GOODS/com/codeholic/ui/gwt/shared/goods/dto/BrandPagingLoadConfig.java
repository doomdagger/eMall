package com.codeholic.ui.gwt.shared.goods.dto;

import java.util.HashMap;

import com.codeholic.ui.gwt.shared.dto.CorePagingLoadConfig;
import com.google.gwt.user.client.rpc.IsSerializable;

public class BrandPagingLoadConfig extends CorePagingLoadConfig implements IsSerializable{

	private static final long serialVersionUID = 4595472400550083291L;

	private HashMap<String,String> filterFields = new HashMap<String,String>();

	public HashMap<String, String> getFilterFields() {
		return filterFields;
	}

	public void setFilterFields(HashMap<String, String> filterFields) {
		this.filterFields = filterFields;
	}
	
	
	
}
