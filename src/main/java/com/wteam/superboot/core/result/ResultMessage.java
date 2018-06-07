/**
 * Copyright (c) 2017-2018 Tianxin.  All rights reserved. 广州天新网络科技有限公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.result;

import java.util.Map;

import com.wteam.superboot.core.helper.JsonHelper;

/**
 * 结果消息实体类.
 * 
 * @author 罗佳欣
 * @version 1.2.0
 */
public class ResultMessage {

	/**
	 * 结果码.
	 */
	private Integer serviceResult;

	/**
	 * 结果信息.
	 */
	private String resultInfo;

	/**
	 * 结果数据.
	 */
	private Map<String, Object> resultParm;

	/**
	 * @return 获取 serviceResult 的值.
	 */
	public Integer getServiceResult() {
		return serviceResult;
	}

	/**
	 * 设置 serviceResult 的值.
	 *
	 * @param serviceResult
	 *            赋值给 serviceResult.
	 */
	public void setServiceResult(Integer serviceResult) {
		this.serviceResult = serviceResult;
	}

	/**
	 * @return 获取 resultInfo 的值.
	 */
	public String getResultInfo() {
		return resultInfo;
	}

	/**
	 * 设置 resultInfo 的值.
	 *
	 * @param resultInfo
	 *            赋值给 resultInfo.
	 */
	public void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	}

	/**
	 * @return 获取 resultParm 的值.
	 */
	public Map<String, Object> getResultParm() {
		return resultParm;
	}

	/**
	 * 设置 resultParm 的值.
	 *
	 * @param resultParm
	 *            赋值给 resultParm.
	 */
	public void setResultParm(Map<String, Object> resultParm) {
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
