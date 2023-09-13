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
		System.out.println("[���� ó��] " + methodName + " ����Ͻ� �޼ҵ� ���ϰ� : " + returnobj.toString());
		
		// ����Ͻ� �޼ҵ尡 ������ ��ü�� userVO Ÿ���� ��ü���� Ȯ���Ѵ�.
		if (returnobj instanceof UserVO) {
			UserVO user = (UserVO) returnobj;
			
			// UserVO ��ü�� ������ "Admin"���� Ȯ���Ѵ�.
			if (user.getRole().equals("Admin")) {
				System.out.println(user.getName() + "��! ������ ���� �������� �̵��մϴ�.");
			}
		}
	}
}