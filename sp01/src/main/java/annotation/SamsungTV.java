package annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class SamsungTV implements TV {
	@Autowired
	private Speaker speaker;

	public SamsungTV() {
		System.out.println("===> SamsungTV ");
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker()");
		this.speaker = speaker;
	}

	public void powerOn() {
		System.out.println("SamsungTV powerOn");
	}

	public void powerOff() {
		System.out.println("SamsungTV powerOff.");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
}
