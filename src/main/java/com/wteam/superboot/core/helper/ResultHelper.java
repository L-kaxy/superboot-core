package com.wteam.superboot.core.helper;

import java.util.Map;

import com.wteam.superboot.core.enums.Resultinfo;
import com.wteam.superboot.core.result.ResultMessage;

/**
 * 结果工具类.
 * 
 * @author 罗佳欣
 */
public class ResultHelper {

	public static ResultMessage result(Resultinfo resultEnum, Map<String, Object> resultParm) {
		ResultMessage result = new ResultMessage();
		result.setServiceResult(resultEnum.getServiceResult());
		result.setResultInfo(resultEnum.getResultInfo());
		result.setResultParm(resultParm);
		return result;
	}

	public static ResultMessage result(Resultinfo resultEnum) {
		return result(resultEnum, null);
	}

}
