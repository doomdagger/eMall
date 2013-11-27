package com.codeholic.business.dict;

import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.codeholic.business.dict.view.IDictService;
import com.codeholic.eao.ParamMapper;
import com.codeholic.eao.UUIDGenerator;
import com.codeholic.eao.dict.DictEao;
import com.codeholic.eao.support.DomainModel;
import com.codeholic.pojos.jpa.Dict;

/**
 * 数据字典Service
 */
@Stateless
@Local(IDictService.class)
public class DictServiceImpl implements IDictService {
	
	@EJB
	private DictEao dictEao;

	public DictServiceImpl(){
		
	}
	@Override
	public boolean addDict(Dict item) {
		if(item == null)
			return false;
		item.setDictId(UUIDGenerator.randomUUID());
		try{
			this.dictEao.add(item);
		}catch(Exception exception){
			exception.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteDict(String key) {
		Dict dict = new Dict();
		if(key == "")
			return false;
		try{
			dict.setDictId(key);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateDict(Dict item) {
		if(item.getDictId() == "")
			return false;
		try{
			dictEao.update(item);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	@Override
	public List<Dict> readLabelsByFieldCode(String field_code) {
		ParamMapper parmMappers = ParamMapper.instance("field_code", field_code);
		try {
			return dictEao.findByParams("dict.readLabelsByFieldCode", parmMappers);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String readLabel(String field_code, int decode) {
		ParamMapper paramMapper = ParamMapper.instance("field_code", field_code);
		paramMapper.add("decode", decode);
		try {
			return dictEao.findOneByParams("dict.readLabel", paramMapper).getLabel();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public HashMap<String, String> readAllField() {
		List<DomainModel> items = dictEao.findProjectedByParams("dict.readAllField", null);
		HashMap<String, String> map = new HashMap<String, String>();
		if(items != null){
			for (DomainModel model : items) {
				map.put((String)model.get(0), (String)model.get(1));
			}
		}
		else 
			return null;
		return map;
	}
	
	@Override
	public List<Dict> readLabelsByFieldName(String field_name) {
		ParamMapper parmMappers = ParamMapper.instance("field_name", field_name);
		try {
			return dictEao.findByParams("dict.readLabelsByFieldName", parmMappers);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
}
