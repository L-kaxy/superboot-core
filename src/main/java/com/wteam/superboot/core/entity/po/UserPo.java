/**
 * Copyright (c) 2007-2017 Wteam.  All rights reserved. 网维网络技术创业团队 版权所有.
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
 * @version 1.0.0
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
	 * @return the userkeyid
	 */
	public final Long getUserid() {
		return userid;
	}

	/**
	 * @param userid
	 *            the userid to set
	 */
	public final void setUserid(Long userid) {
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
