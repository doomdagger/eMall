package com.codeholic.eao;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;

import com.codeholic.eao.ParamFilter.order;
import com.codeholic.eao.support.Pageable;
import com.ibm.ws.batch.xJCL.beans.returnCodeExpression;

@Stateless
@LocalBean
public class FilterQuery{
	
	/**
	 * transform the filter and build a native query statement
	 * @return
	 */	
	@PersistenceContext(unitName = "eMallJPA")
	private EntityManager entityManager;
	private String querySql;
	public FilterQuery()
	{
		
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Query getFilterQuery(Class cls,ParamMapper mapper,ParamFilter filter,Pageable pageable)
	{
		if(cls == null)
		{
			return null;
		}
		querySql = "select t from " + cls.getSimpleName() + " t ";
		
		//build sql statement and create the query instance,then return
		if(mapper != null)
		{
			querySql += "where ";
			Map<String, Object> paramsMap = mapper.getParams();
			for(Entry<String, Object> entry : paramsMap.entrySet())
			{
				querySql += " t."+entry.getKey()+"="+entry.getValue()+" ";
				querySql += " and ";
			}
			querySql = (new StringBuffer(querySql)).substring(0, querySql.length()-4);
		}
		if(filter != null)
		{			
			querySql += " order by ";
			HashMap<String, order> paramsMap = (HashMap<String, order>) filter.getMap();
			for (Entry<String, order> entry : paramsMap.entrySet()) 
			{
				querySql += " t."+entry.getKey() + " " + ( entry.getValue() == order.DESC_ORDER ?  " desc " : " asc ");
				querySql += ",";
			}
			querySql = (new StringBuffer(querySql)).substring(0, querySql.length()-1);
		}
		System.out.println(entityManager);
		Query query = entityManager.createQuery(querySql, cls);
		//get result in page
		if(pageable != null)
		{
			query.setFirstResult(pageable.getOffset());
			query.setMaxResults(pageable.getPageSize());
		}
		return query;
	}
	
	public String getQuerySql()
	{
		return querySql;
	}
	
	/*
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Query nativeQueryWrapper(Class cls,ParamFilter filter)
	{
		String querySql = "select t from "+cls.getName();
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
		Query query = entityManager.createQuery(querySql,cls);
		return query;
	}
	
	public List getFilterResult(Class cls,ParamFilter filter)
	{
		@SuppressWarnings("unchecked")
		List result = nativeQueryWrapper(cls,filter).getResultList();
		return result;
	}
	
	*/
}
