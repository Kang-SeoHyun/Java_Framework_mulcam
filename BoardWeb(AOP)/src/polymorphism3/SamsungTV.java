package polymorphism3;

public class SamsungTV implements TV {
	private int price;
	// ����Ʈ������
	public SamsungTV() {
		// �����̳ʴ� ����Ʈ�����ڸ� ���� ȣ���Ͽ� ��ü�� ����.
		System.out.println("===> SamsungTV ����");
	}
	public void ��������ʱ�ȭ() {
		System.out.println("---> ��������ʱ�ȭ() ȣ��");
		this.price = 1700000;
	}
	public void �ڿ�����() {
		System.out.println("---> �ڿ�����() ȣ��");
		this.price = 0;
	}
	public void powerOn() {
		System.out.println("SamsungTv---���� �Ҵ�." + price);
	}
	public void powerOff() {
		System.out.println("SamsungTv---���� ����.");
	}
	public void volumeUp() {
		System.out.println("SamsungTv---�Ҹ� �ø���.");
	}
	public void volumeDown() {
		System.out.println("SamsungTv---�Ҹ� ������.");
	}
}
