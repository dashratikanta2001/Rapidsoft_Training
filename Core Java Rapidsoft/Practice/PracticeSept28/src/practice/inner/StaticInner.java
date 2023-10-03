package practice.inner;

class StaticOuter {
	static int x = 10;
	int y = 15;

	static class StaticInner {
		void display() {
			System.out.println("X in StaticInner class = " + x);
//			System.out.println("Y in StaticInner class = "+y);
		}
	}
}

public class StaticInner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StaticOuter.StaticInner s = new StaticOuter.StaticInner();
		s.display();

	}

}
