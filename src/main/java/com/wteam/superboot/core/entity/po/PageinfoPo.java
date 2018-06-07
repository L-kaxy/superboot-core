/**
 * Copyright (c) 2017-2018 Tianxin.  All rights reserved. 广州天新网络科技有限公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.entity.po;

import java.util.Date;
import java.util.List;

/**
 * 封装分页请求参数.
 * 
 * @author 罗佳欣
 * @version 1.2.0
 */
public class PageinfoPo extends BasePersistentObject {
	/**
	 * 查询起始时间, 可为null.
	 */
	private Date starttime;

	/**
	 * 分页单页条目数, 不得为null.
	 */
	private Integer size;

	/**
	 * 当前页码, 不得为null.
	 */
	private Integer indexPageNum;

	/**
	 * 排序字段名列表, 不得为null, 根据排序字段先后顺序作排序优先级.
	 */
	private List<String> sortFieldNames;

	/**
	 * true 为正序 false为倒序, 不得为null.
	 */
	private Boolean order;

	/**
	 * @return 获取 starttime 的值.
	 */
	public Date getStarttime() {
		return starttime;
	}

	/**
	 * 设置 starttime 的值.
	 *
	 * @param starttime
	 *            赋值给 starttime.
	 */
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	/**
	 * @return 获取 size 的值.
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * 设置 size 的值.
	 *
	 * @param size
	 *            赋值给 size.
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * @return 获取 indexPageNum 的值.
	 */
	public Integer getIndexPageNum() {
		return indexPageNum;
	}

	/**
	 * 设置 indexPageNum 的值.
	 *
	 * @param indexPageNum
	 *            赋值给 indexPageNum.
	 */
	public void setIndexPageNum(Integer indexPageNum) {
		this.indexPageNum = indexPageNum;
	}

	/**
	 * @return 获取 sortFieldNames 的值.
	 */
	public List<String> getSortFieldNames() {
		return sortFieldNames;
	}

	/**
	 * 设置 sortFieldNames 的值.
	 *
	 * @param sortFieldNames
	 *            赋值给 sortFieldNames.
	 */
	public void setSortFieldNames(List<String> sortFieldNames) {
		this.sortFieldNames = sortFieldNames;
	}

	/**
	 * @return 获取 order 的值.
	 */
	public Boolean getOrder() {
		return order;
	}

	/**
	 * 设置 order 的值.
	 *
	 * @param order
	 *            赋值给 order.
	 */
	public void setOrder(Boolean order) {
		this.order = order;
	}

}
