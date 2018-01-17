/**
 * Copyright (c) 2014 Wteamfly.  All rights reserved. 网飞公司 版权所有.
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
     * @return 获取的systemconfigid
     */
    public Long getSystemconfigid() {
        return systemconfigid;
    }

    /**
     * 设置systemconfigid的方法.
     * 
     * @param systemconfigid
     *            赋值给systemconfigid的值
     */
    public void setSystemconfigid(final Long systemconfigid) {
        this.systemconfigid = systemconfigid;
    }

    /**
     * @return 获取的configname
     */
    public String getConfigname() {
        return configname;
    }

    /**
     * 设置configname的方法.
     * 
     * @param configname
     *            赋值给configname的值
     */
    public void setConfigname(final String configname) {
        this.configname = configname;
    }

    /**
     * @return 获取的configvalue
     */
    public String getConfigvalue() {
        return configvalue;
    }

    /**
     * 设置configvalue的方法.
     * 
     * @param configvalue
     *            赋值给configvalue的值
     */
    public void setConfigvalue(final String configvalue) {
        this.configvalue = configvalue;
    }

}
