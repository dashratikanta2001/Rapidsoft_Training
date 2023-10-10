package com.collection.list;

import java.util.*;

class Point
{
	int x;
	int y;
	
	Point(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "x= "+x+" y= "+y;
	}
	public int compareTo(Point p)
	{
		if(this.x<p.x) return -1;
		if(this.y>p.y) return 1;
		return 0;
	}
}

public class TreeCompareDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeSet<Point> ts = new TreeSet<>();
		ts.add(new Point(1,2));
		ts.add(new Point(5,5));
		ts.add(new Point(5,2));
		
		System.out.println(ts);
				
	}
}
