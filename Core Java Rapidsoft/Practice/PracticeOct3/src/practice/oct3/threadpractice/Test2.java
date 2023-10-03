package practice.oct3.threadpractice;

public class Test2 extends Thread{
	public void run()
	{
		int i=1;
		while(true)
		{
			System.out.println(i+" hello");
			i++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test2 t = new Test2();
		t.start();
		
		int i=1;
		while(true)
		{
			System.out.println(i+"world");
			i++;
			if(i==100)
			{
				break;
			}
		}
		t.stop();

	}

}
