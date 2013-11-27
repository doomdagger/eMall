package com.codeholic.eao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.codeholic.eao.ParamFilter.order;

@Stateless
@LocalBean
public class NativeQuery<T> {
	
	/**
	 * transform the filter and build a native query statement
	 * @return
	 */	
	private Class<T> cls;
	@PersistenceContext(unitName = "eMallJPA")
	private EntityManager entityManager;
	
	
	public NativeQuery()
	{
		
	}
	
	public Query nativeQueryWrapper(String tableName,ParamFilter filter)
	{
		String querySql = "select t.* from "+tableName+" t ";
		HashMap<String, order> paramsMap = (HashMap<String, order>) filter.getMap();
		if(filter != null)
		{
			querySql += " order by ";
			for (Entry<String, order> entry : paramsMap.entrySet()) 
			{
				querySql += entry.getKey() + ( entry.getValue() == order.DESC_ORDER ?  "desc" : "asc");
				querySql += ",";
			}
		}
		querySql = (new StringBuffer(querySql)).substring(0, querySql.length()-1);
		Query query = entityManager.createNativeQuery(querySql,cls);
		return query;
	}
	
	public List<T> getFilterResult(String tableName,ParamFilter filter)
	{
		initialClassType();
		@SuppressWarnings("unchecked")
		List<T> result = nativeQueryWrapper(tableName,filter).getResultList();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	private void initialClassType()
	{
		@SuppressWarnings("rawtypes")
		Class clazz = getClass();
		while (clazz != Object.class) {
			Type t = clazz.getGenericSuperclass();
			if (t instanceof ParameterizedType) {
				Type[] args = ((ParameterizedType) t).getActualTypeArguments();
				if (args[0] instanceof Class) {					
					this.cls = (Class<T>) args[0];
					break;
				}
			}
			clazz = clazz.getSuperclass();
		}
	}

}
