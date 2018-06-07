/**
 * Copyright (c) 2017-2018 Tianxin.  All rights reserved. 广州天新网络科技有限公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.entity.vo;

/**
 * 用户数据值对象类.
 * 
 * @author 罗佳欣
 * @version 1.2.0
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
	 * @return 获取 userid 的值.
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 设置 userid 的值.
	 *
	 * @param userid
	 *            赋值给 userid.
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * @return 获取 username 的值.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置 username 的值.
	 *
	 * @param username
	 *            赋值给 username.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}
