package com.codeholic.pojos.jpa;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class EntityObject implements Serializable{
	
	/**
	 * Generated Serial Version ID
	 */
	private static final long serialVersionUID = -2612171703152457078L;

	public String serialize(){
		
		return null;
	}
	
	public void deserialize(String data){
		
	}
	
	
	@Override
	public String toString(){
		Method[] methods = this.getClass().getMethods();
		ArrayList<Method> list = new ArrayList<Method>();
		for(Method method : methods){
			if(method.getName().startsWith("get")){
				list.add(method);
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("{");
		for(Method method : list){
			try {
				stringBuilder.append(" ["+method.invoke(this, (Object[])null).toString()+"] ");
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}
		stringBuilder.append("}");
		return stringBuilder.toString();
	}
}
