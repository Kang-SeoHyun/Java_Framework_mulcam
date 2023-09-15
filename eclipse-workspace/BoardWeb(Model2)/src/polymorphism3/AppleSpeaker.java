package polymorphism3;

public class AppleSpeaker implements Speaker {
	public AppleSpeaker() {
		System.out.println("===> AppleSpeaker 积己");
	}
	public void volumeUp() {
		System.out.println("AppleSpeaker---家府 棵赴促.");
	}
	public void volumeDown() {
		System.out.println("AppleSpeaker---家府 郴赴促.");
	}
}
