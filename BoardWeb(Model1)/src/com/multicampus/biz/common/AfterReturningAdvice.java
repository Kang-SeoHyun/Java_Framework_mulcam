package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.multicampus.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
	
	@AfterReturning(pointcut = "BoardPointcut.getPointcut()", returning = "returnobj")
	public void afterLog(JoinPoint jp, Object returnobj) {
		String methodName = jp.getSignature().getName();
		System.out.println("[사후 처리] " + methodName + " 비즈니스 메소드 리턴값 : " + returnobj.toString());
		
		// 비즈니스 메소드가 리턴한 객체가 userVO 타입의 객체인지 확인한다.
		if (returnobj instanceof UserVO) {
			UserVO user = (UserVO) returnobj;
			
			// UserVO 객체의 권한이 "Admin"인지 확인한다.
			if (user.getRole().equals("Admin")) {
				System.out.println(user.getName() + "님! 관리자 전용 페이지로 이동합니다.");
			}
		}
	}
}