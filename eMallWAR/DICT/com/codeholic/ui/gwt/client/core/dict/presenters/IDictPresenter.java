package com.codeholic.ui.gwt.client.core.dict.presenters;

import com.codeholic.ui.gwt.client.core.presenters.ICorePresenter;
import com.codeholic.ui.gwt.shared.dict.dto.DictDto;

public interface IDictPresenter extends ICorePresenter {
	//view调用的事件

	public void getDictList();
	
	public void getDictChildList(String field_name);
	
	public void updateField_name(String field_code, String newField_name);
	
	public void deleteLabel(String dictId);
	
	public void updateLabel(DictDto model);
}
