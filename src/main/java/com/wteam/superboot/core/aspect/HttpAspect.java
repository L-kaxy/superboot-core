/**
 * Copyright (c) 2017-2018 Tianxin.  All rights reserved. 广州天新网络科技有限公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.wteam.superboot.core.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;
import com.wteam.superboot.core.result.ResultMessage;

/**
 * http请求切面日志打印.
 * 
 * 仅作为参考, 如需使用务必将这两个注解写到类注解上: {@Aspect,@Component}
 * 
 * @author 罗佳欣
 * @version 1.2.0
 */
public class HttpAspect {

	/**
	 * 初始化 logger.
	 */
	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

	/**
	 * 声明切面位置.
	 */
	@Pointcut("execution(public * com.wteam.*.controller.*.*(..))")
	public void log() {
	}

	/**
	 * 方法执行前.
	 * 
	 * @param joinPoint
	 *            切入点.
	 */
	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		logger.info("## url \t## {}", request.getRequestURL());
		logger.info("## method \t## {}",
				joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		logger.info("## args \t## {}", new Gson().toJson(joinPoint.getArgs()));
	}

	/**
	 * 方法执行之后.
	 * 
	 * @param resultMessage
	 *            返回结果.
	 */
	@AfterReturning(returning = "resultMessage", pointcut = "log()")
	public void doAfterReturning(ResultMessage resultMessage) {
		logger.info("## response ## {}", resultMessage.toJson());
	}

}
