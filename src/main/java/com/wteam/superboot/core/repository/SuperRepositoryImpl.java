/**
 * Copyright (c) 2017-2018 Tianxin.  All rights reserved. 广州天新网络科技有限公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.repository;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import org.apache.commons.beanutils.BeanMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.wteam.superboot.core.entity.po.BasePersistentObject;
import com.wteam.superboot.core.entity.po.PageinfoPo;
import com.wteam.superboot.core.entity.po.UserPo;
import com.wteam.superboot.core.enums.ResultEnum;
import com.wteam.superboot.core.exception.SuperException;
import com.wteam.superboot.core.helper.NullHelper;

/**
 * 超级 Repository 实现类.
 * 
 * 参考 SuperW 框架的 BaseDao 重构而来.
 * 
 * @author 罗佳欣
 * @version 1.2.0
 */
public final class SuperRepositoryImpl<T extends BasePersistentObject, ID extends Serializable>
		extends SimpleJpaRepository<T, ID> implements SuperRepository<T, ID> {
	/**
	 * log4j实例对象.
	 */
	private static Logger logger = LoggerFactory.getLogger(SuperRepositoryImpl.class);

	/**
	 * 注入entityManager.
	 */
	private EntityManager entityManager;

	/**
	 * 超级Repository实现类构造方法.
	 */
	public SuperRepositoryImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		this.entityManager = em;
	}

	/**
	 * 添加实体.
	 * 
	 * @param entityPo
	 *            实体，不得为null.
	 * @param currentUser
	 *            当前操作用户，数据库记录该用户进行添加，不得为null.
	 * @throws SuperException
	 *             统一异常.
	 */
	public void addEntity(final T entityPo, final UserPo currentUser) throws SuperException {
		logger.debug("进入addEntity方法");
		if (entityPo == null) {
			logger.error("参数entityPo不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}
		if (currentUser == null) {
			logger.error("参数currentUser不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}
		entityPo.setCreatorid(currentUser.getUserid());
		entityManager.persist(entityPo);

		logger.debug("退出addEntity方法");
	}

	/**
	 * 删除实体.
	 * 
	 * @param entityPo
	 *            实体，不得为null.
	 * @throws SuperException
	 *             统一异常.
	 */
	public void deleteEntity(final T entityPo) throws SuperException {
		logger.debug("进入deleteEntity方法");
		if (entityPo == null) {
			logger.error("参数entityPo不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}

		// 根据参数查询待删除条目
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<? extends BasePersistentObject> query = criteriaBuilder.createQuery(entityPo.getClass());
		EntityType<? extends BasePersistentObject> model = entityManager.getMetamodel().entity(entityPo.getClass());
		Root<? extends BasePersistentObject> from = query.from(model);
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		// 找非空参数
		BeanMap beanMap = new BeanMap(entityPo);
		String propertyName = null;
		for (Entry<Object, Object> parm : beanMap.entrySet()) {
			propertyName = (String) parm.getKey();
			if (!propertyName.equals("class") && parm.getValue() != null) {
				predicatesList.add(criteriaBuilder.equal(from.get(propertyName), parm.getValue()));
			}
		}
		query.where(predicatesList.toArray(new Predicate[predicatesList.size()]));

		for (BasePersistentObject temp : entityManager.createQuery(query).getResultList()) {
			entityManager.remove(temp);
		}
		logger.debug("退出deleteEntity方法");
	}

	/**
	 * 逻辑删除实体.
	 * 
	 * @param entityPo
	 *            实体，不得为null.
	 * @param currentUser
	 *            当前操作用户，数据库记录该用户进行逻辑删除，不得为null.
	 * @throws SuperException
	 *             统一异常.
	 */
	public void logicDeleteEntity(final T entityPo, final UserPo currentUser) throws SuperException {
		logger.debug("进入logicDeleteEntity方法");
		if (entityPo == null) {
			logger.error("参数entityPo不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}
		if (currentUser == null) {
			logger.error("参数currentUser不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}

		// 根据参数查询待逻辑删除条目
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<? extends BasePersistentObject> query = criteriaBuilder.createQuery(entityPo.getClass());
		EntityType<? extends BasePersistentObject> model = entityManager.getMetamodel().entity(entityPo.getClass());
		Root<? extends BasePersistentObject> from = query.from(model);
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		// 找非空参数
		BeanMap beanMap = new BeanMap(entityPo);
		String propertyName = null;
		for (Entry<Object, Object> parm : beanMap.entrySet()) {
			propertyName = (String) parm.getKey();
			if (!propertyName.equals("class") && parm.getValue() != null) {
				predicatesList.add(criteriaBuilder.equal(from.get(propertyName), parm.getValue()));
			}
		}
		query.where(predicatesList.toArray(new Predicate[predicatesList.size()]));

		for (BasePersistentObject temp : entityManager.createQuery(query).getResultList()) {
			temp.setIsdelete(true);
			temp.setEditorid(currentUser.getUserid());
			entityManager.merge(temp);
		}

		logger.debug("退出logicDeleteEntity方法");
	}

	/**
	 * 冻结实体.
	 * 
	 * @param entityPo
	 *            实体，不得为null.
	 * @param currentUser
	 *            当前操作用户，数据库记录该用户进行冻结，不得为null.
	 * @throws SuperException
	 *             统一异常.
	 */
	public void lockUpEntity(final T entityPo, final UserPo currentUser) throws SuperException {
		logger.debug("进入lockUpEntity方法");
		if (entityPo == null) {
			logger.error("参数entityPo不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}
		if (currentUser == null) {
			logger.error("参数currentUser不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}

		// 根据参数查询待冻结条目
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<? extends BasePersistentObject> query = criteriaBuilder.createQuery(entityPo.getClass());
		EntityType<? extends BasePersistentObject> model = entityManager.getMetamodel().entity(entityPo.getClass());
		Root<? extends BasePersistentObject> from = query.from(model);
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		// 找非空参数
		BeanMap beanMap = new BeanMap(entityPo);
		String propertyName = null;
		for (Entry<Object, Object> parm : beanMap.entrySet()) {
			propertyName = (String) parm.getKey();
			if (!propertyName.equals("class") && parm.getValue() != null) {
				predicatesList.add(criteriaBuilder.equal(from.get(propertyName), parm.getValue()));
			}
		}
		query.where(predicatesList.toArray(new Predicate[predicatesList.size()]));

		for (BasePersistentObject temp : entityManager.createQuery(query).getResultList()) {
			temp.setIslockup(true);
			temp.setEditorid(currentUser.getUserid());
			entityManager.merge(temp);
		}

		logger.debug("退出lockUpEntity方法");
	}

	/**
	 * 解冻实体.
	 * 
	 * @param entityPo
	 *            实体，不得为null.
	 * @param currentUser
	 *            当前操作用户，数据库记录该用户进行解冻，不得为null.
	 * @throws SuperException
	 *             统一异常.
	 */
	public void unLockUpEntity(final T entityPo, final UserPo currentUser) throws SuperException {
		logger.debug("进入unLockUpEntity方法");
		if (entityPo == null) {
			logger.error("参数entityPo不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}
		if (currentUser == null) {
			logger.error("参数currentUser不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}

		// 根据参数查询待解冻条目
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<? extends BasePersistentObject> query = criteriaBuilder.createQuery(entityPo.getClass());
		EntityType<? extends BasePersistentObject> model = entityManager.getMetamodel().entity(entityPo.getClass());
		Root<? extends BasePersistentObject> from = query.from(model);
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		// 找非空参数
		BeanMap beanMap = new BeanMap(entityPo);
		String propertyName = null;
		for (Entry<Object, Object> parm : beanMap.entrySet()) {
			propertyName = (String) parm.getKey();
			if (!propertyName.equals("class") && parm.getValue() != null) {
				predicatesList.add(criteriaBuilder.equal(from.get(propertyName), parm.getValue()));
			}
		}
		query.where(predicatesList.toArray(new Predicate[predicatesList.size()]));

		for (BasePersistentObject temp : entityManager.createQuery(query).getResultList()) {
			temp.setIslockup(false);
			temp.setEditorid(currentUser.getUserid());
			entityManager.merge(temp);
		}

		logger.debug("退出unLockUpEntity方法");
	}

	/**
	 * 编辑实体.
	 * 
	 * @param entityPo
	 *            实体，不得为null.
	 * @param currentUser
	 *            当前操作用户，数据库记录该用户进行编辑，不得为null.
	 * @throws SuperException
	 *             统一异常.
	 */
	public void editEntity(final T entityPo, final UserPo currentUser) throws SuperException {
		logger.debug("进入editEntity方法");
		if (entityPo == null) {
			logger.error("参数entityPo不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}
		if (currentUser == null) {
			logger.error("参数currentUser不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}

		Class<? extends BasePersistentObject> entityClass = entityPo.getClass();

		Long entityId = null;
		for (Field f : entityClass.getDeclaredFields()) {
			String methodname = "get" + (f.getName().charAt(0) + "").toUpperCase() + f.getName().substring(1);
			if (f.isAnnotationPresent(Id.class)) {
				try {
					Method m = entityClass.getMethod(methodname);
					entityId = (Long) m.invoke(entityPo);
				} catch (Exception e) {
					e.printStackTrace();
					throw new SuperException(ResultEnum.PARAM_ERROR);
				}
				break;
			}
		}

		BasePersistentObject rEntityPo = entityManager.find(entityClass, entityId);

		// 找非空参数
		BeanMap beanMap = new BeanMap(entityPo);
		String propertyName = null;
		BeanMap rBeanMap = new BeanMap(rEntityPo);
		for (Entry<Object, Object> parm : beanMap.entrySet()) {
			propertyName = (String) parm.getKey();
			if (!propertyName.equals("class") && parm.getValue() != null) {
				if (NullHelper.isNull(parm.getValue())) {
					rBeanMap.put(propertyName, null);
				} else {
					rBeanMap.put(propertyName, parm.getValue());
				}
			}
		}
		rEntityPo.setEditetime(null);
		rEntityPo.setEditorid(currentUser.getUserid());
		entityManager.merge(rEntityPo);

		logger.debug("退出editEntity方法");
	}

	/**
	 * 根据实体主键编号查询实体，queryEntity(T)也可以实现该方法的功能， 但它们的区别在于该方法执行效率更高.
	 * 
	 * @param cls
	 *            实体类型，不得为null.
	 * @param id
	 *            实体主键编号，不得为null.
	 * @return 与实体主键编号对应的实体.
	 * @throws SuperException
	 *             统一异常.
	 */
	public T getEntityById(final Class<T> cls, final Long id) throws SuperException {
		logger.debug("进入getEntityById方法");
		if (cls == null) {
			logger.error("参数cls不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}
		if (id == null) {
			logger.error("参数id不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}

		T result = null;
		result = (T) entityManager.find(cls, id);
		logger.debug("退出getEntityById方法");
		return result;
	}

	/**
	 * 查询实体列表.
	 * 
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @return 以实体类型为 T 的列表.
	 * @throws SuperException
	 *             统一异常.
	 */
	@SuppressWarnings("unchecked")
	public List<T> queryList(final T aimParm, final T likeParm) throws SuperException {
		logger.debug("进入queryList方法");
		if (aimParm == null) {
			logger.error("参数aimParm不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}

		List<T> result = null;

		// 根据参数查询条目
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<? extends BasePersistentObject> query = criteriaBuilder.createQuery(aimParm.getClass());
		EntityType<? extends BasePersistentObject> model = entityManager.getMetamodel().entity(aimParm.getClass());
		Root<? extends BasePersistentObject> from = query.from(model);
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		// 找模糊搜索非空参数
		if (likeParm != null) {
			BeanMap likeBeanMap = new BeanMap(likeParm);
			String likePropertyName = null;
			for (Entry<Object, Object> likeEntityParm : likeBeanMap.entrySet()) {
				likePropertyName = (String) likeEntityParm.getKey();
				if (likeEntityParm.getValue() != null
						&& likeEntityParm.getValue().getClass().isAssignableFrom(String.class)) {
					predicatesList.add(criteriaBuilder.like(from.<String>get(likePropertyName),
							likeEntityParm.getValue().toString()));
				}
			}
		}

		// 找非空参数
		BeanMap beanMap = new BeanMap(aimParm);
		String propertyName = null;
		for (Entry<Object, Object> parm : beanMap.entrySet()) {
			propertyName = (String) parm.getKey();
			if (!propertyName.equals("class") && parm.getValue() != null) {
				predicatesList.add(criteriaBuilder.equal(from.get(propertyName), parm.getValue()));
			}
		}
		query.where(predicatesList.toArray(new Predicate[predicatesList.size()]));

		result = (List<T>) entityManager.createQuery(query).setHint("org.hibernate.cacheable", true).getResultList();

		logger.debug("退出queryList方法");
		return result;
	}

	/**
	 * 查询实体列表.
	 * 
	 * @param entityPo
	 *            实体，不得为null.
	 * @return 以实体类型为 T 的列表.
	 * @throws SuperException
	 *             统一异常.
	 */
	public List<T> queryList(final T entityPo) throws SuperException {
		logger.debug("进入queryList方法");

		List<T> result = null;
		result = queryList(entityPo, null);

		logger.debug("退出queryList方法");
		return result;
	}

	/**
	 * 查询非删除实体列表.
	 * 
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @return 以实体类型为 T 的列表.
	 * @throws SuperException
	 *             统一异常.
	 */
	public List<T> queryNonDeleteList(final T aimParm, final T likeParm) throws SuperException {
		logger.debug("进入queryNonDeleteList方法");

		List<T> result = null;

		if (aimParm != null) {
			aimParm.setIsdelete(false);
		}

		result = queryList(aimParm, likeParm);
		logger.debug("退出queryNonDeleteList方法");
		return result;
	}

	/**
	 * 查询非删除实体列表.
	 * 
	 * @param entityPo
	 *            实体，不得为null.
	 * @return 以实体类型为 T 的列表.
	 * @throws SuperException
	 *             统一异常.
	 */
	public List<T> queryNonDeleteList(final T entityPo) throws SuperException {
		logger.debug("进入queryNonDeleteList方法");

		List<T> result = null;

		if (entityPo != null) {
			entityPo.setIsdelete(false);
		}

		result = queryList(entityPo, null);
		logger.debug("退出queryNonDeleteList方法");
		return result;
	}

	/**
	 * 查询非删除非冻结实体列表.
	 * 
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @return 以实体类型为 T 的列表.
	 * @throws SuperException
	 *             统一异常.
	 */
	public List<T> queryNonDeleteNonLockupList(final T aimParm, final T likeParm) throws SuperException {
		logger.debug("进入queryNonDeleteNonLockupList方法");

		List<T> result = null;

		if (aimParm != null) {
			aimParm.setIsdelete(false);
			aimParm.setIslockup(false);
		}

		result = queryList(aimParm, likeParm);
		logger.debug("退出queryNonDeleteNonLockupList方法");
		return result;
	}

	/**
	 * 查询非删除非冻结实体列表.
	 * 
	 * @param entityPo
	 *            实体，不得为null.
	 * @return 以实体类型为 T 的列表.
	 * @throws SuperException
	 *             统一异常.
	 */
	public List<T> queryNonDeleteNonLockupList(final T entityPo) throws SuperException {
		logger.debug("进入queryNonDeleteNonLockupList方法");

		List<T> result = null;

		if (entityPo != null) {
			entityPo.setIsdelete(false);
			entityPo.setIslockup(false);
		}

		result = queryList(entityPo, null);
		logger.debug("退出queryNonDeleteNonLockupList方法");
		return result;
	}

	/**
	 * 查询单一实体.
	 * 
	 * @param entityPo
	 *            实体，不得为null.
	 * @return 实体结果.
	 * @throws SuperException
	 *             统一异常.
	 */
	public T queryEntity(final T entityPo) throws SuperException {
		logger.debug("进入queryEntity方法");
		if (entityPo == null) {
			logger.error("参数entityPo不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}

		List<T> result = queryList(entityPo);
		logger.debug("退出queryEntity方法");
		return result.size() > 0 ? result.get(0) : null;
	}

	/**
	 * 查询条目数列表.
	 * 
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @return 查询结果条目数.
	 * @throws SuperException
	 *             统一异常.
	 */
	public Long queryCount(final T aimParm, final T likeParm) throws SuperException {
		logger.debug("进入queryCount方法");
		if (aimParm == null) {
			logger.error("参数aimParm不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}

		Long result = null;

		// 根据参数查询条目
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
		EntityType<? extends BasePersistentObject> model = entityManager.getMetamodel().entity(aimParm.getClass());
		Root<? extends BasePersistentObject> from = query.from(model);
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		// 找模糊搜索非空参数
		if (likeParm != null) {
			BeanMap likeBeanMap = new BeanMap(likeParm);
			String likePropertyName = null;
			for (Entry<Object, Object> likeEntityParm : likeBeanMap.entrySet()) {
				likePropertyName = (String) likeEntityParm.getKey();
				if (likeEntityParm.getValue() != null
						&& likeEntityParm.getValue().getClass().isAssignableFrom(String.class)) {
					predicatesList.add(criteriaBuilder.like(from.<String>get(likePropertyName),
							likeEntityParm.getValue().toString()));
				}
			}
		}

		// 找非空参数
		BeanMap beanMap = new BeanMap(aimParm);
		String propertyName = null;
		for (Entry<Object, Object> parm : beanMap.entrySet()) {
			propertyName = (String) parm.getKey();
			if (!propertyName.equals("class") && parm.getValue() != null) {
				predicatesList.add(criteriaBuilder.equal(from.get(propertyName), parm.getValue()));
			}
		}
		query.where(predicatesList.toArray(new Predicate[predicatesList.size()]));

		query.select(criteriaBuilder.countDistinct(from));
		result = entityManager.createQuery(query).setHint("org.hibernate.cacheable", true).getSingleResult();

		logger.debug("退出queryCount方法");
		return result;
	}

	/**
	 * 查询条目数列表.
	 * 
	 * @param entityPo
	 *            实体，不得为null.
	 * @return 查询结果条目数.
	 * @throws SuperException
	 *             统一异常.
	 */
	public Long queryCount(final T entityPo) throws SuperException {
		logger.debug("进入queryCount方法");

		Long result = null;
		result = queryCount(entityPo, null);

		logger.debug("退出queryCount方法");
		return result;
	}

	/**
	 * 查询非删除条目数列表.
	 * 
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @return 查询结果条目数.
	 * @throws SuperException
	 *             统一异常.
	 */
	public Long queryNonDeleteCount(final T aimParm, final T likeParm) throws SuperException {
		logger.debug("进入queryNonDeleteCount方法");

		Long result = null;

		if (aimParm != null) {
			aimParm.setIsdelete(false);
		}

		result = queryCount(aimParm, likeParm);

		logger.debug("退出queryNonDeleteCount方法");
		return result;
	}

	/**
	 * 查询非删除条目数列表.
	 * 
	 * @param entityPo
	 *            实体，不得为null.
	 * @return 查询结果条目数.
	 * @throws SuperException
	 *             统一异常.
	 */
	public Long queryNonDeleteCount(final T entityPo) throws SuperException {
		logger.debug("进入queryNonDeleteCount方法");

		Long result = null;

		if (entityPo != null) {
			entityPo.setIsdelete(false);
		}

		result = queryCount(entityPo, null);

		logger.debug("退出queryNonDeleteCount方法");
		return result;
	}

	/**
	 * 查询非删除条目数列表.
	 * 
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @return 查询结果条目数.
	 * @throws SuperException
	 *             统一异常.
	 */
	public Long queryNonDeleteNonLockupCount(final T aimParm, final T likeParm) throws SuperException {
		logger.debug("进入queryNonDeleteNonLockupCount方法");

		Long result = null;

		if (aimParm != null) {
			aimParm.setIsdelete(false);
			aimParm.setIslockup(false);
		}
		result = queryCount(aimParm, likeParm);

		logger.debug("退出queryNonDeleteNonLockupCount方法");
		return result;
	}

	/**
	 * 查询非删除条目数列表.
	 * 
	 * @param entityPo
	 *            实体，不得为null.
	 * @return 查询结果条目数.
	 * @throws SuperException
	 *             统一异常.
	 */
	public Long queryNonDeleteNonLockupCount(final T entityPo) throws SuperException {
		logger.debug("进入queryNonDeleteNonLockupCount方法");

		Long result = null;

		if (entityPo != null) {
			entityPo.setIsdelete(false);
			entityPo.setIslockup(false);
		}
		result = queryCount(entityPo, null);

		logger.debug("退出queryNonDeleteNonLockupCount方法");
		return result;
	}

	/**
	 * 查询是否有查询结果.
	 * 
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @return true-有结果 false-无结果.
	 * @throws SuperException
	 *             统一异常.
	 */
	public Boolean hasEntity(final T aimParm, final T likeParm) throws SuperException {
		logger.debug("进入hasEntity方法");
		if (aimParm == null) {
			logger.error("参数aimParm不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}

		Boolean result = false;
		Long count = null;

		// 根据参数查询条目
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
		EntityType<? extends BasePersistentObject> model = entityManager.getMetamodel().entity(aimParm.getClass());
		Root<? extends BasePersistentObject> from = query.from(model);
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		// 找模糊搜索非空参数
		if (likeParm != null) {
			BeanMap likeBeanMap = new BeanMap(likeParm);
			String likePropertyName = null;
			for (Entry<Object, Object> likeEntityParm : likeBeanMap.entrySet()) {
				likePropertyName = (String) likeEntityParm.getKey();
				if (likeEntityParm.getValue() != null
						&& likeEntityParm.getValue().getClass().isAssignableFrom(String.class)) {
					predicatesList.add(criteriaBuilder.like(from.<String>get(likePropertyName),
							likeEntityParm.getValue().toString()));
				}
			}
		}

		// 找非空参数
		BeanMap beanMap = new BeanMap(aimParm);
		String propertyName = null;
		for (Entry<Object, Object> parm : beanMap.entrySet()) {
			propertyName = (String) parm.getKey();
			if (!propertyName.equals("class") && parm.getValue() != null) {
				predicatesList.add(criteriaBuilder.equal(from.get(propertyName), parm.getValue()));
			}
		}
		query.where(predicatesList.toArray(new Predicate[predicatesList.size()]));

		query.select(criteriaBuilder.countDistinct(from));
		count = entityManager.createQuery(query).setMaxResults(1).setHint("org.hibernate.cacheable", true)
				.getSingleResult();
		if (count > 0) {
			result = true;
		}

		logger.debug("退出hasEntity方法");
		return result;
	}

	/**
	 * 查询是否有查询结果.
	 * 
	 * @param entityPo
	 *            实体，不得为null.
	 * @return true-有结果 false-无结果.
	 * @throws SuperException
	 *             统一异常.
	 */
	public Boolean hasEntity(final T entityPo) throws SuperException {
		logger.debug("进入hasEntity方法");
		Boolean result = false;

		result = hasEntity(entityPo, null);

		logger.debug("退出hasEntity方法");
		return result;
	}

	/**
	 * 非删除查询是否有查询结果.
	 * 
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @return true-有结果 false-无结果.
	 * @throws SuperException
	 *             统一异常.
	 */
	public Boolean hasNonDeleteEntity(final T aimParm, final T likeParm) throws SuperException {
		logger.debug("进入hasNonDeleteEntity方法");

		Boolean result = false;

		if (aimParm != null) {
			aimParm.setIsdelete(false);
		}
		result = hasEntity(aimParm, likeParm);

		logger.debug("退出hasNonDeleteEntity方法");
		return result;
	}

	/**
	 * 非删除查询是否有查询结果.
	 * 
	 * @param entityPo
	 *            实体，不得为null.
	 * @return true-有结果 false-无结果.
	 * @throws SuperException
	 *             统一异常.
	 */
	public Boolean hasNonDeleteEntity(final T entityPo) throws SuperException {
		logger.debug("进入hasNonDeleteEntity方法");

		Boolean result = false;

		if (entityPo != null) {
			entityPo.setIsdelete(false);
		}
		result = hasEntity(entityPo, null);

		logger.debug("退出hasNonDeleteEntity方法");
		return result;
	}

	/**
	 * 非删除非锁定查询是否有查询结果.
	 * 
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @return true-有结果 false-无结果.
	 * @throws SuperException
	 *             统一异常.
	 */
	public Boolean hasNonDeleteNonLockupEntity(final T aimParm, final T likeParm) throws SuperException {
		logger.debug("进入hasNonDeleteNonLockupEntity方法");

		Boolean result = false;

		if (aimParm != null) {
			aimParm.setIsdelete(false);
			aimParm.setIslockup(false);
		}
		result = hasEntity(aimParm, likeParm);

		logger.debug("退出hasNonDeleteNonLockupEntity方法");
		return result;
	}

	/**
	 * 非删除非锁定查询是否有查询结果.
	 * 
	 * @param entityPo
	 *            实体，不得为null.
	 * @return true-有结果 false-无结果.
	 * @throws SuperException
	 *             统一异常.
	 */
	public Boolean hasNonDeleteNonLockupEntity(final T entityPo) throws SuperException {
		logger.debug("进入hasNonDeleteNonLockupEntity方法");

		Boolean result = false;

		if (entityPo != null) {
			entityPo.setIsdelete(false);
			entityPo.setIslockup(false);
		}
		result = hasEntity(entityPo, null);

		logger.debug("退出hasNonDeleteNonLockupEntity方法");
		return result;
	}

	/**
	 * 查询分页列表，
	 * 
	 * @param pageinfo
	 *            分页对象, size, indexPageNum, sortFieldNme, order 不得为 null.
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @return 分页信息.
	 * @throws SuperException
	 *             统一异常.
	 */
	@Override
	public Page<T> pageEntity(final PageinfoPo pageinfo, final T aimParm, final T likeParm) throws SuperException {
		logger.debug("进入pageEntity方法");
		if (pageinfo.getSize() == null) {
			logger.error("参数size不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}
		if (pageinfo.getIndexPageNum() == null) {
			logger.error("参数indexPageNum不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}
		if (aimParm == null) {
			logger.error("参数aimParm不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}
		if (pageinfo.getSortFieldNames() == null || pageinfo.getSortFieldNames().isEmpty()) {
			logger.error("参数sortFieldNme不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}
		if (pageinfo.getOrder() == null) {
			logger.error("参数order不得为null.");
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}

		Specification<T> spec = new Specification<T>() {

			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				List<Predicate> predicatesList = new ArrayList<Predicate>();

				// 找模糊搜索非空参数
				if (likeParm != null) {
					BeanMap likeBeanMap = new BeanMap(likeParm);
					String likePropertyName = null;
					for (Entry<Object, Object> likeEntityParm : likeBeanMap.entrySet()) {
						likePropertyName = (String) likeEntityParm.getKey();
						if (likeEntityParm.getValue() != null
								&& likeEntityParm.getValue().getClass().isAssignableFrom(String.class)) {
							predicatesList.add(
									cb.like(root.<String>get(likePropertyName), likeEntityParm.getValue().toString()));
						}
					}
				}

				// 找非空参数
				BeanMap beanMap = new BeanMap(aimParm);
				String propertyName = null;
				for (Entry<Object, Object> parm : beanMap.entrySet()) {
					propertyName = (String) parm.getKey();
					if (!propertyName.equals("class") && parm.getValue() != null) {
						predicatesList.add(cb.equal(root.get(propertyName), parm.getValue()));
					}
				}

				Date startTime2 = pageinfo.getStarttime();
				if (startTime2 == null) {
					startTime2 = new Date(0);
				}
				predicatesList.add(cb.greaterThanOrEqualTo(root.<Date>get("createtime"), startTime2));

				return cb.and(predicatesList.toArray(new Predicate[predicatesList.size()]));
			}
		};

		String[] properties = pageinfo.getSortFieldNames().toArray(new String[0]);
		Pageable pageable = new PageRequest(pageinfo.getIndexPageNum() - 1, pageinfo.getSize(),
				pageinfo.getOrder() ? Direction.ASC : Direction.DESC, properties);
		Page<T> page = findAll(spec, pageable);

		return page;
	}

	/**
	 * 查询分页列表，
	 * 
	 * @param pageinfo
	 *            分页对象, size, indexPageNum, sortFieldNme, order 不得为 null.
	 * @param entityPo
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @return 分页信息.
	 * @throws SuperException
	 *             统一异常.
	 */
	public Page<T> pageEntity(final PageinfoPo pageinfo, final T entityPo) throws SuperException {
		logger.debug("进入pageEntity方法");

		Page<T> result = null;
		result = pageEntity(pageinfo, entityPo, null);

		logger.debug("退出pageEntity方法");
		return result;
	}

	/**
	 * 查询非删除分页列表，
	 * 
	 * @param pageinfo
	 *            分页对象, size, indexPageNum, sortFieldNme, order 不得为 null.
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @return 分页信息.
	 * @throws SuperException
	 *             统一异常.
	 */
	public Page<T> pageNonDeleteEntity(final PageinfoPo pageinfo, final T aimParm, final T likeParm)
			throws SuperException {
		logger.debug("进入pageNonDeleteEntity方法");

		Page<T> result = null;

		if (aimParm != null) {
			aimParm.setIsdelete(false);
		}
		result = pageEntity(pageinfo, aimParm, likeParm);

		logger.debug("退出pageNonDeleteEntity方法");
		return result;
	}

	/**
	 * 查询非删除分页列表，
	 * 
	 * @param pageinfo
	 *            分页对象, size, indexPageNum, sortFieldNme, order 不得为 null.
	 * @param entityPo
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @return 分页信息.
	 * @throws SuperException
	 *             统一异常.
	 */
	public Page<T> pageNonDeleteEntity(final PageinfoPo pageinfo, final T entityPo) throws SuperException {
		logger.debug("进入pageNonDeleteEntity方法");

		Page<T> result = null;

		if (entityPo != null) {
			entityPo.setIsdelete(false);
		}
		result = pageEntity(pageinfo, entityPo);

		logger.debug("退出pageNonDeleteEntity方法");
		return result;
	}

	/**
	 * 查询非删除非冻结分页列表，
	 * 
	 * @param pageinfo
	 *            分页对象, size, indexPageNum, sortFieldNme, order 不得为 null.
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @return 分页信息.
	 * @throws SuperException
	 *             统一异常.
	 */
	public Page<T> pageNonDeleteNonLockupEntity(final PageinfoPo pageinfo, final T aimParm, final T likeParm)
			throws SuperException {
		logger.debug("进入pageNonDeleteNonLockupEntity方法");

		Page<T> result = null;

		if (aimParm != null) {
			aimParm.setIsdelete(false);
			aimParm.setIslockup(false);
		}
		result = pageEntity(pageinfo, aimParm, likeParm);

		logger.debug("退出pageNonDeleteNonLockupEntity方法");
		return result;
	}

	/**
	 * 查询非删除非冻结分页列表，
	 * 
	 * @param pageinfo
	 *            分页对象, size, indexPageNum, sortFieldNme, order 不得为 null.
	 * @param entityPo
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @return 分页信息.
	 * @throws SuperException
	 *             统一异常.
	 */
	public Page<T> pageNonDeleteNonLockupEntity(final PageinfoPo pageinfo, final T entityPo) throws SuperException {
		logger.debug("进入pageNonDeleteNonLockupEntity方法");

		Page<T> result = null;
		if (entityPo != null) {
			entityPo.setIsdelete(false);
			entityPo.setIslockup(false);
		}
		result = pageEntity(pageinfo, entityPo);

		logger.debug("退出pageNonDeleteNonLockupEntity方法");
		return result;
	}

}
