package com.multicampus.biz;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.multicampus.biz.user.UserService;
import com.multicampus.biz.user.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		// 1. ������ �����̳ʸ� ����(����)�Ѵ�.
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("business-layer.xml");
		
		// 2. �����̳ʷκ��� BoardService Ÿ���� ��ü�� Lookup�Ѵ�. 
		UserService userService = (UserService) container.getBean("userService");
		
		// 3. Lookup�� ��ü�� �׽�Ʈ�Ѵ�.
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test");
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "�� ȯ���մϴ�.");
		} else {
			System.out.println("�α��� ����");
		}
		
		// 4. �����̳ʸ� �����Ѵ�.
		container.close();
	}

}









