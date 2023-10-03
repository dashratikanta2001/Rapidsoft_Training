// 3.Write a program program that demonstrates autoboxing and auto-unboxing .

package com.assignment9.wrapperClass;

public class Question3 {
	
	static void autoBoxing() {
		System.out.println("AutoBoxing");
		int a = 45;
		Integer b = Integer.valueOf(a);
		Integer c = a;
		System.out.println("Integer: " + a);
		System.out.println("Integer: " + b);
		System.out.println("Integer: " + c);
		
		System.out.println();
		
		float d = 98.65f;
		Float e = Float.valueOf(d);
		Float f = d;
		System.out.println("Float: " + d);
		System.out.println("Float: " + e);
		System.out.println("Float: " + f);
		
		System.out.println();
		
		char g = 'R';
		Character h = Character.valueOf(g);
		Character i = g;
		System.out.println("Character: " + g);
		System.out.println("Character: " + h);
		System.out.println("Character: " + i);
		System.out.println();
	}
	
	public static void autoUnBoxing() {
		System.out.println("Unboxing.");
		Integer j = new Integer(45);
		Integer k = j.intValue();
		Integer l = j;
		System.out.println("Integer: " + j);
		System.out.println("Integer: " + k);
		System.out.println("Integer" + l);
		
		System.out.println();
		
		Float m = new Float(98.50);
		Float n = m.floatValue();
		Float o = m;
		System.out.println("Float: " + m);
		System.out.println("Float: "  + n);
		System.out.println("Float: " + o);
		
		System.out.println();
		
		Character p = new Character('R');
		Character q = p.charValue();
		Character r = p;
		System.out.println("Character: " + p);
		System.out.println("Character: " + q);
		System.out.println("Character: " + r);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		autoBoxing();
		autoUnBoxing();
	}

}
