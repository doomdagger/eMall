package com.codeholic.eao;

import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * 快速生成TypedQuery对象，调用静态wrap方法
 * queryName为JPQL语句名
 * ParamWrapper为命名参数集合
 * EntityManager为JPA实体管理器
 */
public class QueryWrapper {
	public static <T> TypedQuery<T> wrap(EntityManager em, String queryName,
			ParamMapper mapper, Class<T> cls) {
		TypedQuery<T> query = em.createNamedQuery(queryName, cls);

		if (mapper != null) {
			for (Entry<String, Object> entry : mapper.getParams().entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}

		return query;
	}

	public static Query wrap(EntityManager em, String queryName,
			ParamMapper mapper) {
		Query query = em.createNamedQuery(queryName);

		if (mapper != null) {
			for (Entry<String, Object> entry : mapper.getParams().entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}

		return query;
	}
}
