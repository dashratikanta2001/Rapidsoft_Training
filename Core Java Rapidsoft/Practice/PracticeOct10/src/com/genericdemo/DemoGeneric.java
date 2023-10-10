package com.genericdemo;

class Data<T>
{
	private T obj;
	public void setData(T v)
	{
		obj=v;
	}
	public T getData()
	{
		return obj;
	}
}

//No Parameter
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


class MyArray2<T> extends MyArray<T>
{
	
}


//2 Parameter
//@SuppressWarnings("unchecked")
//class MyArray3<K,V>
//{
//	T A[] =(T[]) new Object[10];
//	int length=0;
//	public void append(T v)
//	{
//		A[length++] =v;
//	}
//	public void display()
//	{
//		for (int i = 0; i < length; i++) {
//			System.out.println(A[i]);	
//		}
//	}
//}


// Bounded Type
@SuppressWarnings("unchecked")
class MyArray4 <T extends Number>
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

////Bounded type with extends class
//class A{}
//class B extends A{}
//class C extends B{}
//class MyArrayBound <T extends A >{}
////class MyArrayBound <T extends B >{}
////class MyArrayBound <T extends C >{}


//Bounded type with extends interface
interface A{}
class B implements A{}
class C implements A{}
class MyArrayBound <T extends A >{}
//class MyArrayBound <T extends B >{}
//class MyArrayBound <T extends C >{}


public class DemoGeneric {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Data<Integer> d = new Data<>();
//		Data<String> d1 = new Data<>();
//		d.setData(10);
//		d1.setData("Hi");
//		System.ouStringt.println(d.getData());
//		System.out.println(d1.getData());
		
		//Array of Integer
		MyArray<Integer> ma = new MyArray<>();
		ma.append(10);
		ma.append(20);
		ma.append(30);
		ma.display();
		
		//Array of String
		MyArray<String> ma2 = new MyArray<>();
		ma2.append("hi");
		ma2.append("Bye");
		ma2.append("Go");
		ma2.display();
		
		//Array of without parameter ( No Parameter )
		MyArray ma3 = new MyArray();
		ma3.append("This is hi");
		ma3.append(20);
		ma3.append(30);
		ma3.append("This is bye");
		ma3.display();
		
		//2 Parameter
		MyArray2<Integer > ma4 = new MyArray2<>();
//		ma4.append("Hello");
		ma4.append(20);
//		ma4.append("Bye");
		ma4.display();
		
		//Bounded Type
		System.out.println("Bounded Type");
		MyArray<Float> ma5 = new MyArray<>();
		ma5.append(10.1f);
		ma5.append(20.2f);
		ma5.append(30.3f);
		ma5.display();
		
		//Bounded Tyoe with Extends Class
		MyArrayBound<A> ma6 = new MyArrayBound<>();
//		MyArrayBound<B> ma6 = new MyArrayBound<>();
//		MyArrayBound<C> ma6 = new MyArrayBound<>();
//		MyArrayBound<String> ma6 = new MyArrayBound<>(); //It Gives Error
	}

}
