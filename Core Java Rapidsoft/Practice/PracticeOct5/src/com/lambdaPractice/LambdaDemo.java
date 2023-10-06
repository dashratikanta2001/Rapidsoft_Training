package com.lambdaPractice;

interface MyLambda{
	void display(int i);
}

interface MyLambda2{
	int add(int a, int b);
}

interface MyLambda3{
	void display();
}

class UseLambda{
	public void callLambda(MyLambda3 m1)
	{
		m1.display();
	}
}

class Demo{
	int temp=10;
	public void method1()
	{
		int count=0;
		MyLambda3 m =()->{
			int x=0;
			x+=x;
			System.out.println("Hii "+count+" "+ ++temp);
		};
		m.display();
		
//		count++;
		
		UseLambda u = new UseLambda();
		u.callLambda(()->{System.out.println("Hello World");});
	}
}

public class LambdaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyLambda m =(i)->{
			// TODO Auto-generated method stub
			System.out.println("This is inside the MyLambda "+i);
		};
				
		MyLambda m2 = (int i) ->{
			int j=99;
			j = i*j;
			j++;
			System.out.println(j);
		};
		
		MyLambda m3 =(int x)->System.out.println("Hello"+x);
		
		m.display(5);
		m2.display(10);
		m3.display(191);
		
		MyLambda2 m4 =(a,b)->{
			return  a+b;
		};
		
		MyLambda2 m5 =(a,b)->a+b;
		
		System.out.println(m4.add(10, 20));
		System.out.println(m5.add(50, 40));
		
		Demo d = new Demo();
		d.method1();
	}

}
