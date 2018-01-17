/**
 * Copyright (c) 2007-2017 Wteam.  All rights reserved. 网维网络技术创业团队 版权所有.
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
 * 超级Repository工厂实体.
 * 
 * @author 罗佳欣
 * @version 1.2.0
 */
public class SuperRepositoryFactoryBean<T extends Repository<S, ID>, S, ID extends Serializable>
		extends JpaRepositoryFactoryBean<T, S, ID> {

	public SuperRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
		super(repositoryInterface);
	}

	@SuppressWarnings("rawtypes")
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new SuperRepositoryFactory(entityManager);
	}

	private static class SuperRepositoryFactory<T extends BasePersistentObject, ID extends Serializable>
			extends JpaRepositoryFactory {

		private EntityManager entityManager;

		public SuperRepositoryFactory(EntityManager entityManager) {
			super(entityManager);
			this.entityManager = entityManager;
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		protected Object getTargetRepository(RepositoryInformation information) {
			return new SuperRepositoryImpl(information.getDomainType(), entityManager);
		}

		@Override
		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			return SuperRepository.class;
		}

	}

}
