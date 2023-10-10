package com.collection.list;
import java.util.*;

class MyCom implements Comparator<Integer>
{
	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		if(o1<o2) return 1;
		if(o1>o2) return -1;
		return 0;
	}
}


public class PriorityDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PriorityQueue<Integer> p = new PriorityQueue<>();
		p.add(20);
		p.add(10);
		p.add(30);
		p.add(5);
		p.add(15);
		p.add(3);

		//		System.out.println(p.poll());
		//		System.out.println(p.poll());
		//		System.out.println(p.poll());
		//		System.out.println(p.poll());


		System.out.println();
		p.forEach((x)->System.out.println(x));


		System.out.println("Larger value");
		// Compare value and store larger priority value in first
		PriorityQueue<Integer> p1 = new PriorityQueue<>(new MyCom());
		
		p1.add(20);
		p1.add(10);
		p1.add(30);
		p1.add(5);
		p1.add(15);
		p1.add(3);
		
		System.out.println();
		p1.forEach((x)->System.out.println(x));
		p1.poll();
		
		System.out.println("After Deletion");
		p1.forEach((x)->System.out.println(x));

	}

}
