package com.wteam.superboot.core.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wteam.superboot.core.enums.ResultEnum;
import com.wteam.superboot.core.exception.SuperException;
import com.wteam.superboot.core.helper.ResultHelper;
import com.wteam.superboot.core.result.ResultMessage;

@ControllerAdvice
public class ExceptionHandle {

	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResultMessage handle(Exception e) {
		if (e instanceof SuperException) {
			SuperException superException = (SuperException) e;
			
			return ResultHelper.result(superException.getResult());
		} else if (e instanceof HttpMessageNotReadableException) {
			logger.error("【系统异常】{}", e.getMessage());
			
			return ResultHelper.result(ResultEnum.PARAM_ERROR);
		} else if (e instanceof HttpRequestMethodNotSupportedException) {
			return ResultHelper.result(ResultEnum.REQUEST_METHOD_ERROR);
		} else {
			logger.error("【系统异常】{}", e.getMessage());
			logger.error("【异常信息】", e);
			
			return ResultHelper.result(ResultEnum.UNKONW_ERROR);
		}
	}
}