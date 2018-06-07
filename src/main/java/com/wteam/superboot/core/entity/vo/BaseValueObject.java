/**
 * Copyright (c) 2017-2018 Tianxin.  All rights reserved. 广州天新网络科技有限公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.entity.vo;

/**
 * 数据值对象基类.
 * 
 * @author 罗佳欣
 * @version 1.2.0
 */
public class BaseValueObject extends SuperValueObject {

	/**
	 * 创建时间.
	 */
	private String createtime;

	/**
	 * 创建者编号.
	 */
	private String creatorid;

	/**
	 * 修改时间.
	 */
	private String editetime;

	/**
	 * 修改者编号.
	 */
	private String editorid;

	/**
	 * 是否删除.
	 */
	private String isdelete;

	/**
	 * 是否冻结.
	 */
	private String islockup;

	/**
	 * 版本.
	 */
	private String version;

	/**
	 * @return 获取 createtime 的值.
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * 设置 createtime 的值.
	 *
	 * @param createtime
	 *            赋值给 createtime.
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	/**
	 * @return 获取 creatorid 的值.
	 */
	public String getCreatorid() {
		return creatorid;
	}

	/**
	 * 设置 creatorid 的值.
	 *
	 * @param creatorid
	 *            赋值给 creatorid.
	 */
	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	/**
	 * @return 获取 editetime 的值.
	 */
	public String getEditetime() {
		return editetime;
	}

	/**
	 * 设置 editetime 的值.
	 *
	 * @param editetime
	 *            赋值给 editetime.
	 */
	public void setEditetime(String editetime) {
		this.editetime = editetime;
	}

	/**
	 * @return 获取 editorid 的值.
	 */
	public String getEditorid() {
		return editorid;
	}

	/**
	 * 设置 editorid 的值.
	 *
	 * @param editorid
	 *            赋值给 editorid.
	 */
	public void setEditorid(String editorid) {
		this.editorid = editorid;
	}

	/**
	 * @return 获取 isdelete 的值.
	 */
	public String getIsdelete() {
		return isdelete;
	}

	/**
	 * 设置 isdelete 的值.
	 *
	 * @param isdelete
	 *            赋值给 isdelete.
	 */
	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	/**
	 * @return 获取 islockup 的值.
	 */
	public String getIslockup() {
		return islockup;
	}

	/**
	 * 设置 islockup 的值.
	 *
	 * @param islockup
	 *            赋值给 islockup.
	 */
	public void setIslockup(String islockup) {
		this.islockup = islockup;
	}

	/**
	 * @return 获取 version 的值.
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * 设置 version 的值.
	 *
	 * @param version
	 *            赋值给 version.
	 */
	public void setVersion(String version) {
		this.version = version;
	}

}
