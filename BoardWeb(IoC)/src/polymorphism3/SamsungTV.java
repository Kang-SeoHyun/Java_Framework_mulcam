package polymorphism3;

public class SamsungTV implements TV {
	private int price;
	// 디폴트생성자
	public SamsungTV() {
		// 컨테이너는 디폴트생성자를 먼저 호출하여 객체를 만듬.
		System.out.println("===> SamsungTV 생성");
	}
	public void 멤버변수초기화() {
		System.out.println("---> 멤버변수초기화() 호출");
		this.price = 1700000;
	}
	public void 자원해제() {
		System.out.println("---> 자원해제() 호출");
		this.price = 0;
	}
	public void powerOn() {
		System.out.println("SamsungTv---전원 켠다." + price);
	}
	public void powerOff() {
		System.out.println("SamsungTv---전원 끈다.");
	}
	public void volumeUp() {
		System.out.println("SamsungTv---소리 올린다.");
	}
	public void volumeDown() {
		System.out.println("SamsungTv---소리 내린다.");
	}
}
