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
 * 系统配置持久层类.
 * 
 * @author 罗佳欣
 * @version 1.2.0
 */
@Entity
@Table(name = "t_systemconfig")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class SystemconfigPo extends BasePersistentObject {

	/**
	 * 系统配置编号.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long systemconfigid;

	/**
	 * 配置项.
	 */
	@Column(nullable = false)
	private String configname;

	/**
	 * 配置值.
	 */
	private String configvalue;

	/**
	 * @return 获取 systemconfigid 的值.
	 */
	public Long getSystemconfigid() {
		return systemconfigid;
	}

	/**
	 * 设置 systemconfigid 的值.
	 *
	 * @param systemconfigid
	 *            赋值给 systemconfigid.
	 */
	public void setSystemconfigid(Long systemconfigid) {
		this.systemconfigid = systemconfigid;
	}

	/**
	 * @return 获取 configname 的值.
	 */
	public String getConfigname() {
		return configname;
	}

	/**
	 * 设置 configname 的值.
	 *
	 * @param configname
	 *            赋值给 configname.
	 */
	public void setConfigname(String configname) {
		this.configname = configname;
	}

	/**
	 * @return 获取 configvalue 的值.
	 */
	public String getConfigvalue() {
		return configvalue;
	}

	/**
	 * 设置 configvalue 的值.
	 *
	 * @param configvalue
	 *            赋值给 configvalue.
	 */
	public void setConfigvalue(String configvalue) {
		this.configvalue = configvalue;
	}

}
