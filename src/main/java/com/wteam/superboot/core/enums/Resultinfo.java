/**
 * Copyright (c) 2017-2018 Tianxin.  All rights reserved. 广州天新网络科技有限公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.enums;

/**
 * 结果消息枚举接口.
 * 
 * {@link com.wteam.superboot.core.exception.SuperException}
 * 
 * @author 罗佳欣
 * @version 1.2.0
 */
public interface Resultinfo {

	/**
	 * 获取结果码.
	 * 
	 * @return 结果码.
	 */
	public Integer getServiceResult();

	/**
	 * 获取结果消息.
	 * 
	 * @return 结果消息.
	 */
	public String getResultInfo();
}
