package com.codeholic.ui.gwt.shared.dict.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.codeholic.ui.gwt.shared.dict.dto.DictDto;
import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IDictServiceAsync {
	Request deleteUnique(String key, AsyncCallback<Boolean> callback);
	
	Request getDicFieldtList(AsyncCallback<HashMap<String, String> > callback);
	
	Request getDictChildList(String field_name, AsyncCallback<ArrayList<DictDto> > callback);
	
	Request deleteLabel(String dictId, AsyncCallback<Boolean> callback);
	
	Request updateField(String field_code, String newField_name, AsyncCallback<Boolean> callback);
	
	Request updateLabel(DictDto model, AsyncCallback<Boolean> callback);
}
