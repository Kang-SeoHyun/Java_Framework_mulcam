package polymorphism3;

//
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		
		// 1.spring 컨테이너를 생성한다.
		GenericXmlApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2.사용할 객체를 검색한다.
		// 명시적 형변환을 해야함.
		TV tv = (TV) container.getBean("tv");
		
		// 3.검색한 객체를 사용한다.
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 4.컨테이너 종료
		container.close();
	}
}
