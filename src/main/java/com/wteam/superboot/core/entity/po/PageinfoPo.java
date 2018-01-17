package com.wteam.superboot.core.entity.po;

import java.util.Date;
import java.util.List;

/**
 * 授权列表条目视图类.
 * 
 * @author 罗佳欣
 */
public class PageinfoPo extends BasePersistentObject {
	/**
	 * 查询起始时间.
	 */
	private Date starttime;

	/**
	 * 分页单页条目数.
	 */
	private Integer size;

	/**
	 * 当前页码.
	 */
	private Integer indexPageNum;

	/**
	 * 排序字段名列表.
	 */
	private List<String> sortFieldNames;

	/**
	 * true 为正序 false为倒序.
	 */
	private Boolean order;

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getIndexPageNum() {
		return indexPageNum;
	}

	public void setIndexPageNum(Integer indexPageNum) {
		this.indexPageNum = indexPageNum;
	}

	public List<String> getSortFieldNames() {
		return sortFieldNames;
	}

	public void setSortFieldNames(List<String> sortFieldNames) {
		this.sortFieldNames = sortFieldNames;
	}

	public Boolean getOrder() {
		return order;
	}

	public void setOrder(Boolean order) {
		this.order = order;
	}

}
