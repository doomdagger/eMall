package com.codeholic.eao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import com.codeholic.eao.support.DomainModel;
import com.codeholic.eao.support.Pageable;

/**
 * Session Bean implementation class GenericEaoImpl
 */
@Stateless
@Local(GenericEao.class)
public class GenericEaoImpl<T> implements GenericEao<T> {
	@PersistenceContext(unitName = "eMallJPA")
	private EntityManager entityManager;

	private Class<T> cls;

	/**
	 * Default constructor. 构造函数不传参，但是很重要，为继承的子类抽出泛型的Class对象，以便于 传给DAO方法
	 */
	@SuppressWarnings("unchecked")
	public GenericEaoImpl() {
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

	/**
	 * @see com.codeholic.eao.GenericEao#getParameterizedClass()
	 */
	@Override
	public Class<T> getParameterizedClass() {
		return this.cls;
	}

	/**
	 * @see com.codeholic.eao.GenericEao#add(java.lang.Object)
	 */
	@Override
	public void add(T paramT) {
		entityManager.persist(paramT);
	}

	/**
	 * 
	 * @see com.codeholic.eao.GenericEao#update(java.lang.Object)
	 */
	@Override
	public void update(T paramT) {
		entityManager.merge(paramT);
	}

	/**
	 * 
	 * @see com.codeholic.eao.GenericEao#updateByParams(java.lang.String,
	 * com.codeholic.eao.ParamMapper)
	 */
	@Override
	public int updateByParams(String queryName, ParamMapper mapper) {
		return executeWithParams(queryName, mapper).executeUpdate();
	}

	@Override
	public void delete(T paramT) {
		entityManager.remove(paramT);
	}

	/**
	 * 
	 * @see com.codeholic.eao.GenericEao#deleteByParams(java.lang.String,
	 * com.codeholic.eao.ParamMapper)
	 */
	@Override
	public int deleteByParams(String queryName, ParamMapper mapper) {
		return executeWithParams(queryName, mapper).executeUpdate();
	}

	@Override
	public T findOneById(String paramString) {
		return entityManager.find(cls, paramString);
	}

	@Override
	public T findOneByParams(String queryName, ParamMapper mapper) {
		return executeWithParams(queryName, mapper).getSingleResult();
	}

	@Override
	public List<T> findByParams(String queryName, ParamMapper mapper) {
		return executeWithParams(queryName, mapper).getResultList();
	}

	@Override
	public List<T> findMultiByIds(String... ids) {
		ArrayList<T> list = new ArrayList<T>();
		for (String id : ids) {
			list.add(findOneById(id));
		}
		return list;
	}

	@Override
	public List<T> findAll() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(cls);
		Root<T> root = cq.from(cls);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	@Override
	public List<T> findAllInPage(Pageable pageable) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(cls);
		Root<T> root = cq.from(cls);
		cq.select(root);
		TypedQuery<T> query = entityManager.createQuery(cq);

		applyPageable(query, pageable);

		return query.getResultList();
	}

	@Override
	public List<T> findByParamsInPage(String queryName, ParamMapper mapper,
			Pageable pageable) {
		TypedQuery<T> query = this.executeWithParams(queryName, mapper);

		applyPageable(query, pageable);

		return query.getResultList();
	}

	@Override
	public TypedQuery<T> executeWithParams(String queryName, ParamMapper mapper) {
		return QueryWrapper.wrap(entityManager, queryName, mapper, cls);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<DomainModel> findProjectedByParams(String queryName,
			ParamMapper mapper) {
		List list = QueryWrapper.wrap(entityManager, queryName, mapper)
				.getResultList();

		ArrayList<DomainModel> models = new ArrayList<DomainModel>();

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			models.add(DomainModel.instance((Object[]) iterator.next()));
		}

		return models;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<DomainModel> findProjectedByParamsInPage(String queryName,
			ParamMapper mapper, Pageable pageable) {
		Query query = QueryWrapper.wrap(entityManager, queryName, mapper);

		applyPageable(query, pageable);

		List list = query.getResultList();

		ArrayList<DomainModel> models = new ArrayList<DomainModel>();

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			models.add(DomainModel.instance((Object[]) iterator.next()));
		}

		return models;
	}

	@Override
	public List<Tuple> findProjectedAll(String... fields) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> cQuery = builder.createTupleQuery();
		Root<T> root = cQuery.from(cls);
		@SuppressWarnings("unchecked")
		Selection<Object>[] selections = new Selection[fields.length];
		for (int i = 0; i < fields.length; i++) {
			selections[i] = root.get(fields[i]);
		}
		cQuery.multiselect(selections);

		TypedQuery<Tuple> typedQuery = entityManager.createQuery(cQuery);

		return typedQuery.getResultList();
	}

	@Override
	public List<Tuple> findProjectedAllInPage(Pageable pageable,
			String... fields) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> cQuery = builder.createTupleQuery();
		Root<T> root = cQuery.from(cls);
		@SuppressWarnings("unchecked")
		Selection<Object>[] selections = new Selection[fields.length];
		for (int i = 0; i < fields.length; i++) {
			selections[i] = root.get(fields[i]);
		}
		cQuery.multiselect(selections);

		TypedQuery<Tuple> typedQuery = entityManager.createQuery(cQuery);

		applyPageable(typedQuery, pageable);

		return typedQuery.getResultList();
	}

	private <V> void applyPageable(TypedQuery<V> typedQuery, Pageable pageable) {
		typedQuery.setFirstResult(pageable.getOffset());
		typedQuery.setMaxResults(pageable.getPageSize());
	}

	private void applyPageable(Query typedQuery, Pageable pageable) {
		typedQuery.setFirstResult(pageable.getOffset());
		typedQuery.setMaxResults(pageable.getPageSize());
	}

	@Override
	public long getCount() {
		String jpql = "select count(c) from "+cls.getSimpleName()+" c";
		return (Long)entityManager.createQuery(jpql).getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedQuery(String queryName)
	{	
		List<T> list = entityManager.createNamedQuery(queryName).getResultList();
		return list;
	}

	@Override
	public T findOneByNamedQuery(String queryName) {
		T entity = entityManager.createNamedQuery(queryName,cls).getSingleResult();
		return entity;
	}

}
