package com.multicampus.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BoardPointcut {

	@Pointcut("execution(* com.multicampus.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* com.multicampus.biz..*Impl.get*(..))")
	public void getPointcut() {}
	
	@Pointcut("execution(* com.multicampus.biz.board.*Impl.*(..))")
	public void boardPointcut() {}
	
	@Pointcut("execution(* com.multicampus.biz.user.*Impl.*(..))")
	public void userPointcut() {}
}

