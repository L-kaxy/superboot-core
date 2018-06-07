/**
 * Copyright (c) 2017-2018 Tianxin.  All rights reserved. 广州天新网络科技有限公司 版权所有.
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
 * @version 1.2.0
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
	 * @return 获取 createtime 的值.
	 */
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * 设置 createtime 的值.
	 *
	 * @param createtime
	 *            赋值给 createtime.
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * @return 获取 creatorid 的值.
	 */
	public Long getCreatorid() {
		return creatorid;
	}

	/**
	 * 设置 creatorid 的值.
	 *
	 * @param creatorid
	 *            赋值给 creatorid.
	 */
	public void setCreatorid(Long creatorid) {
		this.creatorid = creatorid;
	}

	/**
	 * @return 获取 editetime 的值.
	 */
	public Date getEditetime() {
		return editetime;
	}

	/**
	 * 设置 editetime 的值.
	 *
	 * @param editetime
	 *            赋值给 editetime.
	 */
	public void setEditetime(Date editetime) {
		this.editetime = editetime;
	}

	/**
	 * @return 获取 editorid 的值.
	 */
	public Long getEditorid() {
		return editorid;
	}

	/**
	 * 设置 editorid 的值.
	 *
	 * @param editorid
	 *            赋值给 editorid.
	 */
	public void setEditorid(Long editorid) {
		this.editorid = editorid;
	}

	/**
	 * @return 获取 isdelete 的值.
	 */
	public Boolean getIsdelete() {
		return isdelete;
	}

	/**
	 * 设置 isdelete 的值.
	 *
	 * @param isdelete
	 *            赋值给 isdelete.
	 */
	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}

	/**
	 * @return 获取 islockup 的值.
	 */
	public Boolean getIslockup() {
		return islockup;
	}

	/**
	 * 设置 islockup 的值.
	 *
	 * @param islockup
	 *            赋值给 islockup.
	 */
	public void setIslockup(Boolean islockup) {
		this.islockup = islockup;
	}

	/**
	 * @return 获取 version 的值.
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * 设置 version 的值.
	 *
	 * @param version
	 *            赋值给 version.
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

}
