/**
 * Copyright (c) 2017-2018 Tianxin.  All rights reserved. 广州天新网络科技有限公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.entity.vo;

/**
 * 授权列表条目视图数据值对象类.
 * 
 * @author 罗佳欣
 * @version 1.2.0
 */
public class PageinfoVo extends BaseValueObject {
	/**
	 * 查询起始时间.
	 */
	private String starttime;

	/**
	 * 分页单页条目数.
	 */
	private String size;

	/**
	 * 当前页码.
	 */
	private String indexPageNum;

	/**
	 * (json数组)排序字段名.
	 */
	private String sortFieldNme;

	/**
	 * true 为正序 false为倒序.
	 */
	private Boolean order;

	/**
	 * @return 获取 starttime 的值.
	 */
	public String getStarttime() {
		return starttime;
	}

	/**
	 * 设置 starttime 的值.
	 *
	 * @param starttime
	 *            赋值给 starttime.
	 */
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	/**
	 * @return 获取 size 的值.
	 */
	public String getSize() {
		return size;
	}

	/**
	 * 设置 size 的值.
	 *
	 * @param size
	 *            赋值给 size.
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return 获取 indexPageNum 的值.
	 */
	public String getIndexPageNum() {
		return indexPageNum;
	}

	/**
	 * 设置 indexPageNum 的值.
	 *
	 * @param indexPageNum
	 *            赋值给 indexPageNum.
	 */
	public void setIndexPageNum(String indexPageNum) {
		this.indexPageNum = indexPageNum;
	}

	/**
	 * @return 获取 sortFieldNme 的值.
	 */
	public String getSortFieldNme() {
		return sortFieldNme;
	}

	/**
	 * 设置 sortFieldNme 的值.
	 *
	 * @param sortFieldNme
	 *            赋值给 sortFieldNme.
	 */
	public void setSortFieldNme(String sortFieldNme) {
		this.sortFieldNme = sortFieldNme;
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
