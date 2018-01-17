/**
 * Copyright (c) 2007-2015 WteamFly.  All rights reserved. 网飞网络公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.result;

import java.util.Map;

import com.wteam.superboot.core.helper.JsonHelper;

/**
 * 服务返回信息类.
 * 
 */
public class ResultMessage {

    /**
     * 服务类执行结果.
     */
    private Integer serviceResult;

    /**
     * 返回结果信息.
     */
    private String resultInfo;

    /**
     * 返回参数，又vo的json字符串组成.
     */
    private Map<String, Object> resultParm;

    /**
     * @return 获取的serviceResult
     */
    public final Integer getServiceResult() {
        return serviceResult;
    }

    /**
     * 设置serviceResult的方法.
     * 
     * @param serviceResult
     *            赋值给serviceResult的值
     */
    public final void setServiceResult(final Integer serviceResult) {
        this.serviceResult = serviceResult;
    }

    /**
     * @return 获取的resultInfo
     */
    public final String getResultInfo() {
        return resultInfo;
    }

    /**
     * 设置resultInfo的方法.
     * 
     * @param resultInfo
     *            赋值给resultInfo的值
     */
    public final void setResultInfo(final String resultInfo) {
        this.resultInfo = resultInfo;
    }

    /**
     * @return 获取的resultParm
     */
    public final Map<String, Object> getResultParm() {
        return resultParm;
    }

    /**
     * 设置resultParm的方法.
     * 
     * @param resultParm
     *            赋值给resultParm的值
     */
    public final void setResultParm(final Map<String, Object> resultParm) {
        this.resultParm = resultParm;
    }

    /**
     * 拼接json字符串以返回.
     * 
     * @return 返回信息的json字符串
     */
    public final String toJson() {
        return JsonHelper.toJson(this);
    }
}
