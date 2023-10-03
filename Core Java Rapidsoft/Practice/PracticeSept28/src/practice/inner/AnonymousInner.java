package practice.inner;

abstract class My{
	abstract void display();
}

class Test extends My{
	void display()
	{
		System.out.println("Displayed");
	}
}

public class AnonymousInner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test t = new Test() {
			void display()
			{
				System.out.println("Inside main class");
			}
		};
		t.display();
	}

}
