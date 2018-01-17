package com.wteam.superboot.core.enums;

/**
 * 结果消息枚举类型.
 * 
 * @author 罗佳欣
 *
 */
public enum ResultEnum implements Resultinfo {
	REQUEST_METHOD_ERROR(-1, "请求方法错误"),
	UNKONW_ERROR(0, "操作失败"), 
	ADD_SUCCESS(1, "添加成功"),
	EDIT_SUCCESS(1, "修改成功"),
	DEL_SUCCESS(1, "删除成功"),
	GET_SUCCESS(1, "获取成功"),
	PARAM_ERROR(2, "参数错误"),
	
	LOGIN_SUCCESS(1, "登录成功"),
	LOGOUT_SUCCESS(1, "登出成功"),
	NO_ACCESS_AUTH(100, "没有访问权限"),
	REQUEST_INTERFACE_ERROR(101, "接口名拼写错误"),
	USERNAME_NOT_EXIST(102, "用户名不存在"),
	PASSWORD_ERROR(103, "验证信息错误"),
	UPLOAD_SUCCESS(1, "文件上传成功"),
	
	MULTIPLE_NAME(104, "命名重复"),
	
	EMPTY_USERNAME(1000001, "用户名为空"),
	EXIST_USERNAME(1000002, "用户名已存在"), 
	EMPTY_USERID(1000003, "用户编号为空")
	;

	private Integer serviceResult;

	private String resultInfo;

	ResultEnum(Integer serviceResult, String resultInfo) {
		this.serviceResult = serviceResult;
		this.resultInfo = resultInfo;
	}

	@Override
	public Integer getServiceResult() {
		return serviceResult;
	}

	@Override
	public String getResultInfo() {
		return resultInfo;
	}

}
