package polymorphism3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		// 1. Spring �����̳ʸ� �����Ѵ�. 
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. �����̳ʷκ��� ����� ��ü�� �˻�(Lookup)�Ѵ�. 
		TV tv = (TV) container.getBean("tv");
		
		// 3. �˻��� ��ü�� ����Ѵ�. 
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();
		tv.powerOff();
		
		// 4. �����̳� ����
		container.close();
	}
}







