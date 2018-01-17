/**
 * Copyright (c) 2014 Wteamfly.  All rights reserved. 网飞公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.entity.vo;

/**
 * 系统配置数据值对象类.
 * 
 */
public class SystemconfigVo extends BaseValueObject {
    /**
     * 系统配置编号.
     */
    private String systemconfigid;

    /**
     * 配置项.
     */
    private String configname;

    /**
     * 配置值.
     */
    private String configvalue;

    /**
     * @return 获取的systemconfigid
     */
    public final String getSystemconfigid() {
        return systemconfigid;
    }

    /**
     * 设置systemconfigid的方法.
     * @param systemconfigid 赋值给systemconfigid的值
     */
    public final void setSystemconfigid(final String systemconfigid) {
        this.systemconfigid = systemconfigid;
    }

    /**
     * @return 获取的configname
     */
    public final String getConfigname() {
        return configname;
    }

    /**
     * 设置configname的方法.
     * @param configname 赋值给configname的值
     */
    public final void setConfigname(final String configname) {
        this.configname = configname;
    }

    /**
     * @return 获取的configvalue
     */
    public final String getConfigvalue() {
        return configvalue;
    }

    /**
     * 设置configvalue的方法.
     * @param configvalue 赋值给configvalue的值
     */
    public final void setConfigvalue(final String configvalue) {
        this.configvalue = configvalue;
    }

}
