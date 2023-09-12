package polymorphism3;

//
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		
		// 1.spring �����̳ʸ� �����Ѵ�.
		GenericXmlApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2.����� ��ü�� �˻��Ѵ�.
		// ������ ����ȯ�� �ؾ���.
		TV tv = (TV) container.getBean("tv");
		
		// 3.�˻��� ��ü�� ����Ѵ�.
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 4.�����̳� ����
		container.close();
	}
}