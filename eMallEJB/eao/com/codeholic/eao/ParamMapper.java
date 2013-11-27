package com.codeholic.eao;

import java.util.HashMap;
import java.util.Map;

/**
 *  ParamMapper封装了多个命名参数，他的存在主要是为了快速构造命名参数串，
 *  通过调用
 *   ParamMapper.instance(key,value).add(key,value)
 *   来生成键值对，通常传递给QueryWrapper
 */
public class ParamMapper {
	private Map<String, Object> params = new HashMap<String,Object>();
	
	public ParamMapper() {
	}
	
	private ParamMapper(String key, Object value){
		params.put(key, value);
	}
	
	/**
	 * 返回单个实体的ParamMapper
	 * @param key
	 * @param value
	 * @return
	 */
	public static ParamMapper instance(String key, Object value){
		ParamMapper mapper = new ParamMapper(key, value);
		return mapper;
	}
	
	/**
	 * 向ParamMapper添加一个实体
	 * @param key
	 * @param value
	 * @return
	 */
	public ParamMapper add(String key, Object value){
		this.params.put(key, value);
		return this;
	}
	
	public Map<String, Object> getParams(){
		return this.params;
	}
}
