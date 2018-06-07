/**
 * Copyright (c) 2017-2018 Tianxin.  All rights reserved. 广州天新网络科技有限公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.entity.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * 用户持久层类.
 * 
 * @author 罗佳欣
 * @version 1.2.0
 */
@Entity
@Table(name = "t_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UserPo extends BasePersistentObject {

	/**
	 * 用户编号.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;

	/**
	 * 用户名.
	 */
	@Column(nullable = false)
	private String username;

	/**
	 * @return 获取 userid 的值.
	 */
	public Long getUserid() {
		return userid;
	}

	/**
	 * 设置 userid 的值.
	 *
	 * @param userid
	 *            赋值给 userid.
	 */
	public void setUserid(Long userid) {
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
