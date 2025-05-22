package factory;

public class SamsungTV implements TV {

	public SamsungTV() {
		System.out.println("===> SamsungTV");
	}


	public void powerOn() {
		System.out.println("SamsungTV powerOn");
	}

	public void powerOff() {
		System.out.println("SamsungTV powerOff");
	}

	public void volumeUp() {
		System.out.println("SamsungTV volumeUp");
	}

	public void volumeDown() {
		System.out.println("SamsungTV volumeDown");
	}
}
