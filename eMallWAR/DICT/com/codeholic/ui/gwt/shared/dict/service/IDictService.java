package com.codeholic.ui.gwt.shared.dict.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.codeholic.pojos.jpa.Dict;
import com.codeholic.ui.gwt.shared.dict.dto.DictDto;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("dict")
public interface IDictService extends RemoteService{
	Boolean deleteUnique(String key);

	HashMap<String, String> getDicFieldtList();
	
	ArrayList<DictDto> getDictChildList(String field_name);
	
	/**
	 * 删除一条记录
	 */
	Boolean deleteLabel(String dictId);
	
	/**
	 * 更新所有field_code对应的field_name
	 * @param field_code
	 * @param newField_name
	 * @return
	 */
	Boolean updateField(String field_code, String newField_name);
	
	/**
	 * 更新id为mode.dictId的对象
	 * @param model
	 * @return
	 */
	Boolean updateLabel(DictDto model);
	
}
