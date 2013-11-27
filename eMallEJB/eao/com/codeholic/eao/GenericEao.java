package com.codeholic.eao;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;

import com.codeholic.eao.support.DomainModel;
import com.codeholic.eao.support.Pageable;

public interface GenericEao<T> {
		
	/**
	 * 添加一个entity
	 */
	void add(T paramT);

	/**
	 * 	 update一个entity，使用merge来执行update操作
	 */
	void update(T paramT);

	/**
	 * 根据传递个命名参数来查找符合条件的表记录，然后执行update
	 * 根据JPQL来操作
	 * @param queryName JPQL语句名称   mapper 命名参数对象
	 */
	int updateByParams(String queryName, ParamMapper mapper);
	
	/**
	 * 删除一个entity
	 */
	void delete(T paramT);

	/**
	 * 根据传递个命名参数来查找符合条件的表记录，然后执行delete
	 * 根据JPQL来操作
	 * @param queryName JPQL语句名称   mapper 命名参数对象
	 */
	int deleteByParams(String queryName, ParamMapper mapper);
	
	/**
	 * 根据ID来查一个entity
	 */
	T findOneById(String id);
	
	/**
	 * 根据传递个命名参数来查找符合条件的表记录，只返回第一个符合条件的
	 * 根据JPQL来操作
	 * @param queryName JPQL语句名称   mapper 命名参数对象
	 */
	T findOneByParams(String queryName, ParamMapper mapper);
	
	/**
	 * 根据传递个命名参数来查找符合条件的表记录，返回多个对象
	 * 根据JPQL来操作
	 * @param queryName JPQL语句名称   mapper 命名参数对象
	 */
	List<T> findByParams(String queryName, ParamMapper mapper);
	
	/**
	 * 分页查询
	 */
	List<T> findByParamsInPage(String queryName, ParamMapper mapper, Pageable pageable);

	/**
	 * 投影查询，下同，返回一个DomainModel的集合
	 */
	List<DomainModel> findProjectedByParams(String queryName, ParamMapper mapper);
	
	List<DomainModel> findProjectedByParamsInPage(String queryName, ParamMapper mapper, Pageable pageable);
	
	
	/**
	 * 根据传递多个ID来查找符合条件的表记录，返回多个对象
	 * 根据JPQL来操作
	 * @param ids 不定参数，主键
	 */
	List<T> findMultiByIds(String... ids);
	
	/**
	 * 返回某一个表的全部实体
	 */
	List<T> findAll();
	
	/**
	 * 分页查询
	 */
	List<T> findAllInPage(Pageable pageable);
	
	/**
	 * 采用Criteria API，返回Tuple对象，通过调用tuple.get("field_name", Class<field_type> cls);来获取对应的字段值
	 * String不定参在这里指定需要投射的字段，
	 */
	List<Tuple> findProjectedAll(String... fields);
	
	/**
	 * 同上，添加分页机制
	 */
	List<Tuple> findProjectedAllInPage(Pageable pageable,String... fields);
	
	/**
	 * 根据传递个命名参数来构造TypedQuery对象，这是一个辅助方法，被其他方法调用
	 * @param queryName JPQL语句名称   mapper 命名参数对象
	 */
	TypedQuery<T> executeWithParams(String queryName,ParamMapper mapper);
	
	/**
	 * 获取泛型类，父类调用无效，子类可调
	 */
	Class<T> getParameterizedClass();
	
	/*
	 * 获取数据库中数据个数
	 */
	
	long getCount();
	
	public List<T> findByNamedQuery(String queryName);
	
	public T findOneByNamedQuery(String queryName);
}
