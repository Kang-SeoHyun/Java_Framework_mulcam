package polymorphism3;

import java.util.Properties;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionUser {
	public static void main(String[] args) {
		// 1. Spring 컨테이너를 생성한다. 
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. 컨테이너로부터 사용할 객체를 검색(Lookup)한다. 
		CollectionBean bean = (CollectionBean) container.getBean("collection");
		Properties props = bean.getAddressList();
		
		// 3. 검색한 객체를 사용한다. 
		System.out.println("[ 주소 목록 ]");
		for (Object address : props.values()) {
			System.out.println("---> " + address.toString());
		}
		System.out.println("[ 이름 목록 ]");
		for (Object address : props.keySet()) {
			System.out.println("---> " + address.toString());
		}
		
		// 4. 컨테이너 종료
		container.close();
	}
}