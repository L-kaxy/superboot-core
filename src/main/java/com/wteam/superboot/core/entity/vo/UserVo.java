/**
 * Copyright (c) 2007-2017 Wteam.  All rights reserved. 网维网络技术创业团队 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.entity.vo;

/**
 * 用户数据值对象类.
 * 
 * @author 罗佳欣
 * @version 1.0.0
 */
public class UserVo extends BaseValueObject {

	/**
	 * 用户编号.
	 */
	private String userid;

	/**
	 * 用户名.
	 */
	private String username;

	/**
	 * @return the userid
	 */
	public final String getUserid() {
		return userid;
	}

	/**
	 * @param userid
	 *            the userid to set
	 */
	public final void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * @return the username
	 */
	public final String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public final void setUsername(String username) {
		this.username = username;
	}

}
