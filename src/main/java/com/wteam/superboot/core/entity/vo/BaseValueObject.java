/**
 * Copyright (c) 2007-2016 Wteam.  All rights reserved. 网维网络技术创业团队 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.entity.vo;

/**
 * 数据值对象基类.
 * 
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
     * @return 获取的createtime
     */
    public final String getCreatetime() {
        return createtime;
    }

    /**
     * 设置createtime的方法.
     * 
     * @param createtime
     *            赋值给createtime的值
     */
    public final void setCreatetime(final String createtime) {
        this.createtime = createtime;
    }

    /**
     * @return 获取的creatorid
     */
    public final String getCreatorid() {
        return creatorid;
    }

    /**
     * 设置creatorid的方法.
     * 
     * @param creatorid
     *            赋值给creatorid的值
     */
    public final void setCreatorid(final String creatorid) {
        this.creatorid = creatorid;
    }

    /**
     * @return 获取的editetime
     */
    public final String getEditetime() {
        return editetime;
    }

    /**
     * 设置editetime的方法.
     * 
     * @param editetime
     *            赋值给editetime的值
     */
    public final void setEditetime(final String editetime) {
        this.editetime = editetime;
    }

    /**
     * @return 获取的editorid
     */
    public final String getEditorid() {
        return editorid;
    }

    /**
     * 设置editorid的方法.
     * 
     * @param editorid
     *            赋值给editorid的值
     */
    public final void setEditorid(final String editorid) {
        this.editorid = editorid;
    }

    /**
     * @return 获取的isdelete
     */
    public final String getIsdelete() {
        return isdelete;
    }

    /**
     * 设置isdelete的方法.
     * 
     * @param isdelete
     *            赋值给isdelete的值
     */
    public final void setIsdelete(final String isdelete) {
        this.isdelete = isdelete;
    }

    /**
     * @return 获取的islockup
     */
    public final String getIslockup() {
        return islockup;
    }

    /**
     * 设置islockup的方法.
     * 
     * @param islockup
     *            赋值给islockup的值
     */
    public final void setIslockup(final String islockup) {
        this.islockup = islockup;
    }

    /**
     * @return 获取的version
     */
    public final String getVersion() {
        return version;
    }

    /**
     * 设置version的方法.
     * 
     * @param version
     *            赋值给version的值
     */
    public final void setVersion(final String version) {
        this.version = version;
    }

}
