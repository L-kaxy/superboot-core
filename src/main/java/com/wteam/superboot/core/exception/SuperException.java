/**
 * Copyright (c) 2017-2018 Tianxin.  All rights reserved. 广州天新网络科技有限公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.exception;

import com.wteam.superboot.core.enums.Resultinfo;

/**
 * 框架统一异常.
 * 
 * @author 罗佳欣
 * @version 1.2.0
 */
public class SuperException extends RuntimeException {

	/**
	 * 序列化.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 结果消息.
	 */
	private Resultinfo result;

	/**
	 * 构造器.
	 * 
	 * @param result
	 *            结果消息.
	 */
	public SuperException(Resultinfo result) {
		super(result.getResultInfo());
		this.result = result;
	}

	/**
	 * @return 获取 result 的值.
	 */
	public Resultinfo getResult() {
		return result;
	}

	/**
	 * 设置 result 的值.
	 *
	 * @param result
	 *            赋值给 result.
	 */
	public void setResult(Resultinfo result) {
		this.result = result;
	}

	/**
	 * @return 获取 serialversionuid 的值.
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
