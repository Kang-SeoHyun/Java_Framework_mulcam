package polymorphism3;

public class GoogleTV implements TV {
	// 스피커는 구글티비에 의존적인 객체다.
	// 소니스피커 애플스피커 둘 다 쓰고 싶으면 스피커를 인터페이스로 만들어줘서 사용! -> 다형성
	private Speaker speaker;
	private int price;
	
	public GoogleTV() {
		System.out.println("===> GoogleTV(1) 생성");
	}
	
	public GoogleTV(Speaker speaker) {
		System.out.println("===> GoogleTV(2) 생성");
		this.speaker = speaker;
	}

	public GoogleTV(Speaker speaker, int price) {
		System.out.println("===> GoogleTV(3) 생성");
		this.speaker = speaker;
		this.price = price;
	}
	
	// alt + shift + s 로 generate getter setter 해서 setter 만듬
	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("===> setPrice() 호출");
		this.price = price;
	}

	public void powerOn() {
		System.out.println("GoogleTV---전원 켠다." + price);
	}
	public void powerOff() {
		System.out.println("GoogleTV---전원 끈다.");
	}
	public void volumeUp() {
		// 디펜던스라고 함
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
}
