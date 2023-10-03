package practice.java;

class Phone
{
	public void call() {System.out.println("Phone call");}
	
	public void sms() {System.out.println("Phone sending sms");}
}

interface ICamera{
	void click();
	void record();
}

interface IMusicPlayer{
	void play();
	void stop();
}

class Smartphone extends Phone implements ICamera,IMusicPlayer{
	public void videoCall() {System.out.println("Smartphone video calling");}
	
	public void click() {System.out.println("Smartphone Clicking photo");}
	
	public void record() {System.out.println("Smartphone recording video");}
	
	public void play() {System.out.println("Smartphone playing Music");}
	
	public void stop() {System.out.println("Smart phone stop music");}
}

public class InterfacePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Smartphone s =new Smartphone();
		s.call();
		s.sms();
		s.videoCall();
		s.click();
		s.record();
		s.play();
		s.stop();
		
		System.out.println("\nThis is in ICamera");
		ICamera sp = new Smartphone();
		sp.click();
		sp.record();
		
		System.out.println("\nThis is in IMusicPlayer");
		IMusicPlayer spp = new Smartphone();
		spp.play();
		spp.stop();
	}

}
