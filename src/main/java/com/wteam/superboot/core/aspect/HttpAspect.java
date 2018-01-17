package com.wteam.superboot.core.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;
import com.wteam.superboot.core.result.ResultMessage;

@Aspect
@Component
public class HttpAspect {

	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

	@Pointcut("execution(public * com.wteam.*.controller.*.*(..))")
	public void log() {
	}

	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		logger.info("## url \t## {}", request.getRequestURL());
		logger.info("## method \t## {}",
				joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		logger.info("## args \t## {}", new Gson().toJson(joinPoint.getArgs()));
	}

	@AfterReturning(returning = "resultMessage", pointcut = "log()")
	public void doAfterReturning(ResultMessage resultMessage) {
		logger.info("## response ## {}", new Gson().toJson(resultMessage));
	}

}
