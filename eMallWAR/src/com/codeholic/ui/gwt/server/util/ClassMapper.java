package com.codeholic.ui.gwt.server.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.codeholic.pojos.jpa.StoreInfo;
import com.codeholic.ui.gwt.shared.dto.StoreInfoDto;

public class ClassMapper {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T,V> void map(T t, V v){
		Class tcls = t.getClass();
		Class vcls = v.getClass();
				
		Field[] tFields = tcls.getDeclaredFields();
		Field[] vFields = vcls.getDeclaredFields();
		
		for(Field tField : tFields){
			for(Field vField : vFields){
				if(tField.getName().equals(vField.getName())&&tField.getType().equals(vField.getType())){
					try {
						String name = Character.toUpperCase(tField.getName().charAt(0))+tField.getName().substring(1);
						Method setterMethod = vcls.getMethod("set"+name, vField.getType());
						Method getterMethod = tcls.getMethod("get"+name, null);
						
						setterMethod.invoke(v, getterMethod.invoke(t, null));
						
					} catch(Exception exception){
						exception.printStackTrace();
					}
					break;
				}
			}
		}
		
		
	}
	
	public static void main(String[] args){
		StoreInfoDto dto = new StoreInfoDto();
		dto.setStoreCode("20232123");
		StoreInfo info = new StoreInfo();
		
		map(dto, info);
		
		System.out.println(info.getStoreCode());
	}
}
