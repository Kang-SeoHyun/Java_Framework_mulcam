package com.multicampus.biz;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.multicampus.biz.user.UserService;
import com.multicampus.biz.user.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		// 1. 스프링 컨테이너를 생성(구동)한다.
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("business-layer.xml");
		
		// 2. 컨테이너로부터 BoardService 타입의 객체를 Lookup한다. 
		UserService userService = (UserService) container.getBean("userService");
		
		// 3. Lookup한 객체를 테스트한다.
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test");
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "님 환영합니다.");
		} else {
			System.out.println("로그인 실패");
		}
		
		// 4. 컨테이너를 종료한다.
		container.close();
	}

}









