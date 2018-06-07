/**
 * Copyright (c) 2017-2018 Tianxin.  All rights reserved. 广州天新网络科技有限公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import com.wteam.superboot.core.entity.po.BasePersistentObject;

/**
 * 超级 Repository 工厂实体类.
 * 
 * @author 罗佳欣
 *
 * @param <T>
 *            Repository 类型.
 * @param <S>
 *            实体类型.
 * @param <ID>
 *            实体 ID 类型.
 * 
 * @author 罗佳欣
 * @version 1.2.0
 */
public class SuperRepositoryFactoryBean<T extends Repository<S, ID>, S, ID extends Serializable>
		extends JpaRepositoryFactoryBean<T, S, ID> {

	/**
	 * 构造器.
	 * 
	 * @param repositoryInterface
	 *            Repository接口
	 */
	public SuperRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
		super(repositoryInterface);
	}

	/**
	 * 创建 Repository 工厂.
	 */
	@SuppressWarnings("rawtypes")
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new SuperRepositoryFactory(entityManager);
	}

	/**
	 * 超级 Repository 工厂.
	 * 
	 * @author 罗佳欣
	 *
	 * @param <T>
	 *            实体类型.
	 * @param <ID>
	 *            实体 ID 类型.
	 */
	private static class SuperRepositoryFactory<T extends BasePersistentObject, ID extends Serializable>
			extends JpaRepositoryFactory {

		/**
		 * 持久化实体管理器.
		 */
		private EntityManager entityManager;

		/**
		 * 构造器.
		 * 
		 * @param entityManager
		 *            持久化实体管理器.
		 */
		public SuperRepositoryFactory(EntityManager entityManager) {
			super(entityManager);
			this.entityManager = entityManager;
		}

		/**
		 * 获取目标 Repository.
		 */
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		protected Object getTargetRepository(RepositoryInformation information) {
			return new SuperRepositoryImpl(information.getDomainType(), entityManager);
		}

		/**
		 * 获取 Repository 基类.
		 */
		@Override
		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			return SuperRepository.class;
		}

	}

}
