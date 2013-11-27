package com.codeholic.eao.support;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Helper class
 * 辅助类，当获得投影对象的结果集时，数组对象使用不便，封装为
 * DomainModel后，可以非常便捷的使用,支持Iterable
 * 
 * for(Object obj : domainModel){
 * 	   .....
 * }
 * 
 */
public class DomainModel implements Iterable<Object>{
	private List<Object> fields;
	
	public DomainModel(){
		fields = new ArrayList<Object>();
	}
	
	public static DomainModel instance(Object[] objects){
		DomainModel model = new DomainModel();
		model.fillDomainModel(objects);
		return model;
	}
	
	public void fillDomainModel(Object[] objects){
		for(Object object : objects){
			fields.add(object);
		}
	}
	
	public Object get(int i){
		return fields.get(i);
	}
	
	public int size(){
		return fields.size();
	}

	@Override
	public Iterator<Object> iterator() {
		return fields.iterator();
	}
	
}
