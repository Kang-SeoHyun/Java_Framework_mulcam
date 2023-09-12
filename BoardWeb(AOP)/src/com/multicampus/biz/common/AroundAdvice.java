package com.multicampus.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	
	// Around로 등록되는 메소드는 리턴타입(Object)과 매개변수(ProceedingJoinPoint)가 고정된다.
	@Around("BoardPointcut.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable {
		String methodName = jp.getSignature().getName();
		Object obj = null;
		StopWatch watch = new StopWatch();
		
		watch.start();
		// jp.proceed() 메소드를 호출해야 클라이언트가 호출한 Biz 메소드가 실행된다.
		obj = jp.proceed();
		watch.stop();
		
		System.out.println(methodName + " 메소드 수행에 소요된 시간 : " + watch.getTotalTimeSeconds());
		return obj;
	}
}











