/**
 * Copyright (c) 2007-2017 Wteam.  All rights reserved. 网维网络技术创业团队 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.entity.po;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * 持久层基类.
 * 
 * @author 罗佳欣
 * @version 1.0.0
 */
@MappedSuperclass
public class BasePersistentObject extends SuperPersistentObject {

	/**
	 * 创建时间.
	 */
	@Basic
	@Temporal(value = TemporalType.TIMESTAMP)
	protected Date createtime;

	/**
	 * 创建者编号.
	 */
	@Basic
	@Column(nullable = false)
	protected Long creatorid;

	/**
	 * 修改时间.
	 */
	@Basic
	@Temporal(value = TemporalType.TIMESTAMP)
	protected Date editetime;

	/**
	 * 修改者编号.
	 */
	@Basic
	protected Long editorid;

	/**
	 * 是否删除.
	 */
	@Basic
	@Column(insertable = false)
	protected Boolean isdelete;

	/**
	 * 是否冻结.
	 */
	@Basic
	@Column(insertable = false)
	protected Boolean islockup;

	/**
	 * 版本.
	 */
	@Basic
	@Version
	protected Long version;

	/**
	 * @return 获取的createtime
	 */
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * 设置createtime的方法.
	 * 
	 * @param createtime
	 *            赋值给createtime的值
	 */
	public void setCreatetime(final Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * @return 获取的creatorid
	 */
	public Long getCreatorid() {
		return creatorid;
	}

	/**
	 * 设置creatorid的方法.
	 * 
	 * @param creatorid
	 *            赋值给creatorid的值
	 */
	public void setCreatorid(final Long creatorid) {
		this.creatorid = creatorid;
	}

	/**
	 * @return 获取的editetime
	 */
	public Date getEditetime() {
		return editetime;
	}

	/**
	 * 设置editetime的方法.
	 * 
	 * @param editetime
	 *            赋值给editetime的值
	 */
	public void setEditetime(final Date editetime) {
		this.editetime = editetime;
	}

	/**
	 * @return 获取的editorid
	 */
	public Long getEditorid() {
		return editorid;
	}

	/**
	 * 设置editorid的方法.
	 * 
	 * @param editorid
	 *            赋值给editorid的值
	 */
	public void setEditorid(final Long editorid) {
		this.editorid = editorid;
	}

	/**
	 * @return 获取的isdelete
	 */
	public Boolean getIsdelete() {
		return isdelete;
	}

	/**
	 * 设置isdelete的方法.
	 * 
	 * @param isdelete
	 *            赋值给isdelete的值
	 */
	public void setIsdelete(final Boolean isdelete) {
		this.isdelete = isdelete;
	}

	/**
	 * @return 获取的islockup
	 */
	public Boolean getIslockup() {
		return islockup;
	}

	/**
	 * 设置islockup的方法.
	 * 
	 * @param islockup
	 *            赋值给islockup的值
	 */
	public void setIslockup(final Boolean islockup) {
		this.islockup = islockup;
	}

	/**
	 * @return 获取的version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * 设置version的方法.
	 * 
	 * @param version
	 *            赋值给version的值
	 */
	public void setVersion(final Long version) {
		this.version = version;
	}

}
