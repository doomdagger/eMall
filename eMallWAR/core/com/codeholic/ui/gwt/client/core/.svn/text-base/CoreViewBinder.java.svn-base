package com.codeholic.ui.gwt.client.core;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

@SuppressWarnings("rawtypes")
public abstract class CoreViewBinder {
	HashMap<Class, Class> map = new HashMap<Class, Class>();   

	public abstract void bind();
	
	public void bind(Class cls1, Class cls2){
		map.put(cls1, cls2);
	}
	
	public HashMap<Class, Class> getMap(){
		return this.map;
	}
	
	public Set<Entry<Class, Class>> getEntrySet(){
		return map.entrySet();
	}
	
}
