/**
 * Copyright (c) 2014 Wteamfly.  All rights reserved. 网飞公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.entity.vo;

/**
 * 授权列表条目视图数据值对象类.
 * 
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

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getIndexPageNum() {
		return indexPageNum;
	}

	public void setIndexPageNum(String indexPageNum) {
		this.indexPageNum = indexPageNum;
	}

	public String getSortFieldNme() {
		return sortFieldNme;
	}

	public void setSortFieldNme(String sortFieldNme) {
		this.sortFieldNme = sortFieldNme;
	}

	public Boolean getOrder() {
		return order;
	}

	public void setOrder(Boolean order) {
		this.order = order;
	}

}
