/**
 * Copyright (c) 2007-2017 Wteam.  All rights reserved. 网维网络技术创业团队 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.wteam.superboot.core.entity.po.BasePersistentObject;
import com.wteam.superboot.core.entity.po.PageinfoPo;
import com.wteam.superboot.core.entity.po.UserPo;
import com.wteam.superboot.core.exception.SuperException;

/**
 * 超级Repository接口.
 * 
 * @author 罗佳欣
 * @version 1.2.0
 */
@NoRepositoryBean
public interface SuperRepository<T extends BasePersistentObject, ID extends Serializable>
		extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

	/**
	 * 添加实体.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param entityPo
	 *            实体，不得为null.
	 * @param currentUser
	 *            当前操作用户，数据库记录该用户进行添加，不得为null.
	 * @throws SuperException
	 *             IllegalArgumentSuperException
	 *             entityPo，currentUser为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public void addEntity(final T entityPo, final UserPo currentUser) throws SuperException;

	/**
	 * 删除实体.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param entityPo
	 *            实体，不得为null.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public void deleteEntity(final T entityPo) throws SuperException;

	/**
	 * 逻辑删除实体.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param entityPo
	 *            实体，不得为null.
	 * @param currentUser
	 *            当前操作用户，数据库记录该用户进行逻辑删除，不得为null.
	 * @throws SuperException
	 *             IllegalArgumentSuperException
	 *             entityPo，currentUser为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public void logicDeleteEntity(final T entityPo, final UserPo currentUser) throws SuperException;

	/**
	 * 冻结实体.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param entityPo
	 *            实体，不得为null.
	 * @param currentUser
	 *            当前操作用户，数据库记录该用户进行冻结，不得为null.
	 * @throws SuperException
	 *             IllegalArgumentSuperException
	 *             entityPo，currentUser为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public void lockUpEntity(final T entityPo, final UserPo currentUser) throws SuperException;

	/**
	 * 解冻实体.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param entityPo
	 *            实体，不得为null.
	 * @param currentUser
	 *            当前操作用户，数据库记录该用户进行解冻，不得为null.
	 * @throws SuperException
	 *             IllegalArgumentSuperException
	 *             entityPo，currentUser为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public void unLockUpEntity(final T entityPo, final UserPo currentUser) throws SuperException;

	/**
	 * 编辑实体.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param entityPo
	 *            实体，不得为null.
	 * @param currentUser
	 *            当前操作用户，数据库记录该用户进行编辑，不得为null.
	 * @throws SuperException
	 *             IllegalArgumentSuperException
	 *             entityPo，currentUser为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public void editEntity(final T entityPo, final UserPo currentUser) throws SuperException;

	/**
	 * 根据实体主键编号查询实体，queryEntity(T)也可以实现该方法的功能， 但它们的区别在于该方法执行效率更高.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param cls
	 *            实体类型，不得为null.
	 * @param id
	 *            实体主键编号，不得为null.
	 * @return 与实体主键编号对应的实体.
	 * @throws SuperException
	 *             IllegalArgumentSuperException cls，id为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public T getEntityById(final Class<T> cls, final Long id) throws SuperException;

	/**
	 * 查询实体列表.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @return 以实体类型为node的列表.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public List<T> queryList(final T aimParm, final T likeParm) throws SuperException;

	/**
	 * 查询实体列表.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param entityPo
	 *            实体，不得为null.
	 * @return 以实体类型为node的列表.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public List<T> queryList(final T entityPo) throws SuperException;

	/**
	 * 查询非删除实体列表.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @return 以实体类型为node的列表.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public List<T> queryNonDeleteList(final T aimParm, final T likeParm) throws SuperException;

	/**
	 * 查询非删除实体列表.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param entityPo
	 *            实体，不得为null.
	 * @return 以实体类型为node的列表.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public List<T> queryNonDeleteList(final T entityPo) throws SuperException;

	/**
	 * 查询非删除非冻结实体列表.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @return 以实体类型为node的列表.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public List<T> queryNonDeleteNonLockupList(final T aimParm, final T likeParm) throws SuperException;

	/**
	 * 查询非删除非冻结实体列表.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param entityPo
	 *            实体，不得为null.
	 * @return 以实体类型为node的列表.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public List<T> queryNonDeleteNonLockupList(final T entityPo) throws SuperException;

	/**
	 * 查询单一实体.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param entityPo
	 *            实体，不得为null.
	 * @return 实体结果.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public T queryEntity(final T entityPo) throws SuperException;

	/**
	 * 查询条目数列表.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @return 查询结果条目数.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public Long queryCount(final T aimParm, final T likeParm) throws SuperException;

	/**
	 * 查询条目数列表.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param entityPo
	 *            实体，不得为null.
	 * @return 查询结果条目数.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public Long queryCount(final T entityPo) throws SuperException;

	/**
	 * 查询非删除条目数列表.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @return 查询结果条目数.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public Long queryNonDeleteCount(final T aimParm, final T likeParm) throws SuperException;

	/**
	 * 查询非删除条目数列表.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param entityPo
	 *            实体，不得为null.
	 * @return 查询结果条目数.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public Long queryNonDeleteCount(final T entityPo) throws SuperException;

	/**
	 * 查询非删除条目数列表.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @return 查询结果条目数.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public Long queryNonDeleteNonLockupCount(final T aimParm, final T likeParm) throws SuperException;

	/**
	 * 查询非删除条目数列表.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param entityPo
	 *            实体，不得为null.
	 * @return 查询结果条目数.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public Long queryNonDeleteNonLockupCount(final T entityPo) throws SuperException;

	/**
	 * 查询是否有查询结果.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @return true-有结果 false-无结果.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public Boolean hasEntity(final T aimParm, final T likeParm) throws SuperException;

	/**
	 * 查询是否有查询结果.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param entityPo
	 *            实体，不得为null.
	 * @return true-有结果 false-无结果.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public Boolean hasEntity(final T entityPo) throws SuperException;

	/**
	 * 非删除查询是否有查询结果.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @return true-有结果 false-无结果.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public Boolean hasNonDeleteEntity(final T aimParm, final T likeParm) throws SuperException;

	/**
	 * 非删除查询是否有查询结果.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param entityPo
	 *            实体，不得为null.
	 * @return true-有结果 false-无结果.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public Boolean hasNonDeleteEntity(final T entityPo) throws SuperException;

	/**
	 * 非删除非锁定查询是否有查询结果.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @return true-有结果 false-无结果.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public Boolean hasNonDeleteNonLockupEntity(final T aimParm, final T likeParm) throws SuperException;

	/**
	 * 非删除非锁定查询是否有查询结果.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param entityPo
	 *            实体，不得为null.
	 * @return true-有结果 false-无结果.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public Boolean hasNonDeleteNonLockupEntity(final T entityPo) throws SuperException;

	/**
	 * 查询分页列表， 当sortFieldNme为null时不进行排序.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param startTime
	 *            如未传startTime，在查询完毕后会传回系统当前时间作为startTime.
	 * @param size
	 *            单页条目数.
	 * @param indexPageNum
	 *            当前页码.
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @param sortFieldNme
	 *            (json数组)排序字段名，不得为null.
	 * @param order
	 *            true 为正序 false为倒序，且当sortFieldNme不为null时，该参数不得为null.
	 * @return 分页信息.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public Page<T> pageEntity(final PageinfoPo pageinfo, final T aimParm, final T likeParm) throws SuperException;

	/**
	 * 查询分页列表， 当sortFieldNme为null时不进行排序.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param startTime
	 *            如未传startTime，在查询完毕后会传回系统当前时间作为startTime.
	 * @param size
	 *            单页条目数.
	 * @param indexPageNum
	 *            当前页码.
	 * @param entityPo
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param sortFieldNme
	 *            排序字段名，当该值为null时不进行排序.
	 * @param order
	 *            true 为正序 false为倒序，且当sortFieldNme不为null时，该参数不得为null.
	 * @return 分页信息.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public Page<T> pageEntity(final PageinfoPo pageinfo, final T entityPo) throws SuperException;

	/**
	 * 查询非删除分页列表， 当sortFieldNme为null时不进行排序.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param startTime
	 *            如未传startTime，在查询完毕后会传回系统当前时间作为startTime.
	 * @param size
	 *            单页条目数.
	 * @param indexPageNum
	 *            当前页码.
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @param sortFieldNme
	 *            排序字段名，当该值为null时不进行排序.
	 * @param order
	 *            true 为正序 false为倒序，且当sortFieldNme不为null时，该参数不得为null.
	 * @return 分页信息.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public Page<T> pageNonDeleteEntity(final PageinfoPo pageinfo, final T aimParm, final T likeParm)
			throws SuperException;

	/**
	 * 查询非删除分页列表， 当sortFieldNme为null时不进行排序.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param startTime
	 *            如未传startTime，在查询完毕后会传回系统当前时间作为startTime.
	 * @param size
	 *            单页条目数.
	 * @param indexPageNum
	 *            当前页码.
	 * @param entityPo
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param sortFieldNme
	 *            排序字段名，当该值为null时不进行排序.
	 * @param order
	 *            true 为正序 false为倒序，且当sortFieldNme不为null时，该参数不得为null.
	 * @return 分页信息.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public Page<T> pageNonDeleteEntity(final PageinfoPo pageinfo, final T entityPo) throws SuperException;

	/**
	 * 查询非删除非冻结分页列表， 当sortFieldNme为null时不进行排序.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param startTime
	 *            如未传startTime，在查询完毕后会传回系统当前时间作为startTime.
	 * @param size
	 *            单页条目数.
	 * @param indexPageNum
	 *            当前页码.
	 * @param aimParm
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param likeParm
	 *            实体，作为模糊搜索的查询条件，可为null.
	 * @param sortFieldNme
	 *            排序字段名，当该值为null时不进行排序.
	 * @param order
	 *            true 为正序 false为倒序，且当sortFieldNme不为null时，该参数不得为null.
	 * @return 分页信息.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public Page<T> pageNonDeleteNonLockupEntity(final PageinfoPo pageinfo, final T aimParm, final T likeParm)
			throws SuperException;

	/**
	 * 查询非删除非冻结分页列表， 当sortFieldNme为null时不进行排序.
	 * 
	 * @param <T>
	 *            实体类型.
	 * @param startTime
	 *            如未传startTime，在查询完毕后会传回系统当前时间作为startTime.
	 * @param size
	 *            单页条目数.
	 * @param indexPageNum
	 *            当前页码.
	 * @param entityPo
	 *            实体，作为精确搜索的查询条件，不得为null.
	 * @param sortFieldNme
	 *            排序字段名，当该值为null时不进行排序.
	 * @param order
	 *            true 为正序 false为倒序，且当sortFieldNme不为null时，该参数不得为null.
	 * @return 分页信息.
	 * @throws SuperException
	 *             IllegalArgumentSuperException entityPo为null时抛出此异常.
	 * 
	 * @author 罗佳欣
	 * @since 1.2.0
	 */
	public Page<T> pageNonDeleteNonLockupEntity(final PageinfoPo pageinfo, final T entityPo) throws SuperException;

}
