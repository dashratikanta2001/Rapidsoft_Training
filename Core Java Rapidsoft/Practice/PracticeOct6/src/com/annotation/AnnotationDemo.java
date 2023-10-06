package com.annotation;

import java.util.*;

@FunctionalInterface
interface MyInterface
{
	public void display();
//	public void show();
}

abstract class AbstCls{
	abstract public void display();
}

class OverrideAbstcls extends AbstCls{
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
}

class SimpleCls{
	public void simdisplay() {}
}

class OverrideSimpleCls extends SimpleCls
{
	@Override
	public void simdisplay() {
		// TODO Auto-generated method stub
		super.simdisplay();
	}
	
	public void simdisplay1() {
		// TODO Auto-generated method stub
		super.simdisplay();
	}
}

class OldClass{
	public void display() {
		System.out.println("Hello");
	}
	
	@Deprecated
	public void show() {
		System.out.println("hi");
	}
}

class My<T>
{
	@SuppressWarnings("unused")
	@SafeVarargs
	final private void show(T...arg)
	{
		for(T x:arg)
		{
			System.out.println(x);
		}
	}
}

public class AnnotationDemo {

	@SuppressWarnings("rawtypes")
	static List l;
//	@SuppressWarnings("deprecation")
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		l.add(10);
		OldClass o = new OldClass();
		o.show();
	}

}
