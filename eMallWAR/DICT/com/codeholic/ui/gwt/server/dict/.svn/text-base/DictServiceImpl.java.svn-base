package com.codeholic.ui.gwt.server.dict;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;

import com.codeholic.pojos.jpa.Dict;
import com.codeholic.ui.gwt.server.util.ClassMapper;
import com.codeholic.ui.gwt.shared.dict.dto.DictDto;
import com.codeholic.ui.gwt.shared.dict.service.IDictService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class DictServiceImpl extends RemoteServiceServlet implements IDictService {

	private static final long serialVersionUID = -2003733041189200431L;

	@EJB
	private com.codeholic.business.dict.view.IDictService dictEao;
	
	@Override
	public Boolean deleteUnique(String key) {
		return false;
	}

	@Override
	public HashMap<String, String> getDicFieldtList() {
		
		//return dictEao.readAllField();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("11", "bbbbb");
		map.put("22", "mappp");
		return map;
	}

	@Override
	public ArrayList<DictDto> getDictChildList(String field_name) {
		
		//List<Dict> dicts = dictEao.readLabelsByFieldName(field_name);
		
		ArrayList<DictDto> dictList = new ArrayList<DictDto>();
		
		//for(Dict d : dicts){
		//	DictDto dict = new DictDto();
		//	ClassMapper.map(d, dict);
		//	dictList.add(dict);
		//}
		
		DictDto d = new DictDto();
		d.setLabel("asd");
		dictList.add(d);
		return dictList;
	}

	@Override
	public Boolean deleteLabel(String dictId) {
		//return dictEao.deleteDict(dictId);
		return null;
	}

	@Override
	public Boolean updateField(String field_code, String newField_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateLabel(DictDto model) {
		
		return null;
	}
}
