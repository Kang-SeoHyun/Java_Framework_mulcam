package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.multicampus.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
	
	@AfterReturning(pointcut = "BoardPointcut.getPointcut()", returning = "returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String methodName = jp.getSignature().getName();
		System.out.println("[���� ó��] " + methodName + "() �޼ҵ� ���ϰ� : " + returnObj.toString());
		
		// ����Ͻ� �޼ҵ尡 ������ ��ü�� UserVO Ÿ���� ��ü���� Ȯ���Ѵ�. 
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			
			// UserVO ��ü�� ������ "Admin"���� Ȯ���Ѵ�. 
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName() + "��! ������ ���� �������� �̵��մϴ�.");
			}
		}
	}
}











