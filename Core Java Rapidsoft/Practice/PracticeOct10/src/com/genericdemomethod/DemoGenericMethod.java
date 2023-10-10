package com.genericdemomethod;


//interface A{}
//class B implements A{}
//class C implements A{}

//class A{}
//class B extends A{}
//class C extends B{}

///*
class A{}
interface B{}
interface C{}

@SuppressWarnings("unchecked")
class MyArray0<T extends A & B & C>
{
	T A[] =(T[]) new Object[10];
	int length=0;
	public void append(T v)
	{
		A[length++] =v;
	}
	public void display()
	{
		for (int i = 0; i < length; i++) {
			System.out.println(A[i]);	
		}
	}
}
//*/

@SuppressWarnings("unchecked")
class MyArray<T>
{
	T A[] =(T[]) new Object[10];
	int length=0;
	public void append(T v)
	{
		A[length++] =v;
	}
	public void display()
	{
		for (int i = 0; i < length; i++) {
			System.out.println(A[i]);	
		}
	}
}

public class DemoGenericMethod {

	//Generic Method/Bound
	@SafeVarargs
	static <E extends Number> void show(E... list)
	{
		for(E x:list)
		{
			System.out.println(x);
		}
	}

	//UnBounded WildCard
	static void fun(MyArray <?> obj)
	{
		obj.display();
	}

	//UnBounded WildCard with upper bound with extends which accept number only
	static void fun2(MyArray <? extends Number> obj)
	{
		obj.display();
	}

	//UnBounded WildCard with lower bound with super which accept number only
	static void fun3(MyArray <? super Number> obj)
	{
		obj.display();
	}

	//	static void fun4(MyArray <? extends A> obj)
	//	static void fun4(MyArray <? super B> obj)
	static void fun4(MyArray <? super C> obj)

	{
		obj.display();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//		//		//		//		show(new String[] {"Hi","Go","Bye"});
		//		//		//		//		show(new Integer[] {10,20,30,40});
		//		//		//		//		show(10,20,30,40,50,60,70,80,90);
		//		//		//
		//		//		//		//UnBounded WildCard with upper bound with extends which accept number only
		//		//		//		MyArray<String> ma3 = new MyArray<>();
		//		//		//		ma3.append("Hi");
		//		//		//		ma3.append("Bye");
		//		//		//
		//		//		//		MyArray<Integer> ma4 = new MyArray<>();
		//		//		//		ma4.append(10);
		//		//		//		ma4.append(20);
		//		//		//
		//		//		//		fun2(ma3);
		//		//		//		fun2(ma4);
		//		//
		//		//		//UnBounded WildCard with upper bound with extends which accept number only
		//		//		MyArray<String> ma5 = new MyArray<>();
		//		//		ma5.append("Hi");
		//		//		ma5.append("Bye");
		//		//
		//		//		MyArray<Integer> ma6 = new MyArray<>();
		//		//		ma6.append(10);
		//		//		ma6.append(20);
		//		//
		//		//		fun3(ma5);
		//		//		fun3(ma6);
		//
		//
		//		//UnBounded WildCard with upper bound with extends which accept number only
		//		MyArray<B> ma5 = new MyArray<>();
		//
		//
		//		MyArray<C> ma6 = new MyArray<>();
		//
		//
		//		fun4(ma5);
		//		fun4(ma6);
	}

}
