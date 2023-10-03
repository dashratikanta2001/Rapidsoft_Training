package practice.oct3.threadpractice;

class MyThread extends Thread
{
	public void run()
	{
		int i=1;
		while(true)
		{
			System.out.println(i+" Hello");
			i++;
		}
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyThread t = new MyThread();
		t.start();
		
		int i=1;
		while(true)
		{
			System.out.println(i+" world");
			i++;
		}
	}

}
