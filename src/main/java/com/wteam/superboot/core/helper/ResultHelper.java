/**
 * Copyright (c) 2017-2018 Tianxin.  All rights reserved. 广州天新网络科技有限公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.helper;

import java.util.Map;

import com.wteam.superboot.core.enums.Resultinfo;
import com.wteam.superboot.core.result.ResultMessage;

/**
 * 结果工具类.
 * 
 * @author 罗佳欣
 * @version 1.2.0
 */
public class ResultHelper {

	/**
	 * 封装结果消息, 有返回数据.
	 * 
	 * @param resultEnum
	 *            结果枚举类型.
	 * @param resultParm
	 *            结果数据.
	 * @return 结果消息.
	 */
	public static ResultMessage result(Resultinfo resultEnum, Map<String, Object> resultParm) {
		ResultMessage result = new ResultMessage();
		result.setServiceResult(resultEnum.getServiceResult());
		result.setResultInfo(resultEnum.getResultInfo());
		result.setResultParm(resultParm);
		return result;
	}

	/**
	 * 封装结果消息, 无返回数据.
	 * 
	 * @param resultEnum
	 *            结果枚举类型.
	 * @return 结果消息.
	 */
	public static ResultMessage result(Resultinfo resultEnum) {
		return result(resultEnum, null);
	}

}
