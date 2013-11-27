package com.codeholic.business.dict.view;

import java.util.HashMap;
import java.util.List;

import com.codeholic.pojos.jpa.Dict;

public interface IDictService {

	/**
	 * 增加一条记录
	 * @param item
	 * @return true增加成功
	 */
	public boolean addDict(Dict item);
	
	/**
	 * 删除一条记录
	 * @param key主键
	 * @return 删除成功
	 */
	public boolean deleteDict(String key);
	
	/**
	 * 修改一条记录
	 * @param item
	 * @return true修改成功
	 */
	public boolean updateDict(Dict item);
	
	/**
	 * 通过field_code列出数据字典
	 * @param field_code
	 * @return 返回的是所有该field_code的数据(用于列表显示)
	 */
	public List<Dict> readLabelsByFieldCode(String field_code);
	
	/**
	 * 通过field_name列出数据字典
	 * @param field_name
	 * @return 返回的是所有该field_name的数据(用于列表显示)
	 */
	public List<Dict> readLabelsByFieldName(String field_name);

	/**
	 *  读取所有数据字典的类别(field_code)
	 * @return HashMap key:field_code value:field_name
	 */
	public HashMap<String, String> readAllField();
	
	/**
	 * 通过field_code和DECODE查出对应的值
	 * @param field_code
	 * @param decode
	 * @return 该DECODE对应的值（用于从数据库读取值，来显示）
	 */
	public String readLabel(String field_code, int decode);

}
