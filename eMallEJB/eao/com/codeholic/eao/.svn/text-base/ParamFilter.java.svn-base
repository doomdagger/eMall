package com.codeholic.eao;

import java.util.HashMap;
import java.util.Map;


public class ParamFilter {
	
	public enum order{DESC_ORDER,ASC_ORDER,NON_ORDER}
	private Map<String, order> filter = new HashMap<String, order>();
	
	private ParamFilter()
	{
		
	}
	
	private ParamFilter(String key,order value)
	{
		this.filter.put(key, value);
	}
	
	/*
	 * order is an enum variable
	 */
	public static ParamFilter Instance(String key,order value)
	{
		ParamFilter paramFilter = new ParamFilter(key,value);
		return paramFilter;
	}
	
	public ParamFilter add(String key, order value)
	{
		this.filter.put(key, value);
		return this;
	}
	
	public Map<String, order> getMap()
	{
		return filter;
	}
}
