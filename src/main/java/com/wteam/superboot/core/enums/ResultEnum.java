/**
 * Copyright (c) 2017-2018 Tianxin.  All rights reserved. 广州天新网络科技有限公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.enums;

/**
 * 结果消息枚举类型.
 * 
 * @author 罗佳欣
 * @version 1.2.0
 */
public enum ResultEnum implements Resultinfo {
	/**
	 * 框架核心结果类型.
	 */
	REQUEST_METHOD_ERROR(-1, "请求方法错误"),
	UNKONW_ERROR(0, "操作失败"),
	ADD_SUCCESS(1, "添加成功"),
	EDIT_SUCCESS(1, "修改成功"),
	DEL_SUCCESS(1, "删除成功"),
	GET_SUCCESS(1, "获取成功"),
	PARAM_ERROR(2, "参数错误"),

	/**
	 * 框架权限结果类型.
	 */
	LOGIN_SUCCESS(1, "登录成功"),
	LOGOUT_SUCCESS(1, "登出成功"),
	NO_ACCESS_AUTH(100, "没有访问权限"),
	REQUEST_INTERFACE_ERROR(101, "接口名拼写错误"),
	USERNAME_NOT_EXIST(102, "用户名不存在"),
	PASSWORD_ERROR(103, "验证信息错误"),

	/**
	 * 框架上传结果类型.
	 */
	UPLOAD_SUCCESS(1, "文件上传成功"),

	/**
	 * 通用结果类型.
	 */
	MULTIPLE_NAME(104, "命名重复"),

	/**
	 * 自定义结果类型.
	 */
	EMPTY_USERNAME(1000001, "用户名为空"),
	EXIST_USERNAME(1000002, "用户名已存在"),
	EMPTY_USERID(1000003, "用户编号为空");

	/**
	 * 结果码.
	 */
	private Integer serviceResult;

	/**
	 * 结果消息.
	 */
	private String resultInfo;

	/**
	 * 构造器.
	 * 
	 * @param serviceResult
	 *            结果码.
	 * @param resultInfo
	 *            结果消息.
	 */
	ResultEnum(Integer serviceResult, String resultInfo) {
		this.serviceResult = serviceResult;
		this.resultInfo = resultInfo;
	}

	/**
	 * 重写 getServiceResult
	 * 
	 * @see {@link Resultinfo#getServiceResult()}.
	 */
	@Override
	public Integer getServiceResult() {
		return serviceResult;
	}

	/**
	 * 重写 getResultInfo
	 * 
	 * @see {@link Resultinfo#getResultInfo()}.
	 */
	@Override
	public String getResultInfo() {
		return resultInfo;
	}

}
