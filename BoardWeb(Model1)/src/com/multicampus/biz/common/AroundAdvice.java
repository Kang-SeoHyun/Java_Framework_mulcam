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
	
	// Around�� ��ϵǴ� �޼ҵ�� ����Ÿ��(Object)�� �Ű�����(ProceedingJoinPoint)�� �����ȴ�.
	@Around("BoardPointcut.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable {
		String methodName = jp.getSignature().getName();
		Object obj = null;
		StopWatch watch = new StopWatch();
		
		watch.start();
		// jp.proceed() �޼ҵ带 ȣ���ؾ� Ŭ���̾�Ʈ�� ȣ���� Biz �޼ҵ尡 ����ȴ�.
		obj = jp.proceed();
		watch.stop();
		
		System.out.println(methodName + " �޼ҵ� ���࿡ �ҿ�� �ð� : " + watch.getTotalTimeSeconds());
		return obj;
	}
}











