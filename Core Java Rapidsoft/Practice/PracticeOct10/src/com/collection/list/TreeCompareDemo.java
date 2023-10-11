package com.collection.list;

import java.util.*;

class Point implements Comparable
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
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Point p = (Point)o;
		if(this.x<p.x) return -1;
		else if(this.y>p.y) return 1;
		else 
			
		{
			if(this.y<p.y) return -1;
			else if (this.y>p.y) return 1;
			else return 0;
		}
	}

//	public int compareTo(Point p)
//	{
//		if(this.x<p.x) return -1;
//		if(this.y>p.y) return 1;
//		return 0;
//	}
}

public class TreeCompareDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeSet<Point> ts = new TreeSet<>();
		ts.add(new Point(1,1));
		ts.add(new Point(5,5));
		ts.add(new Point(5,2));
		
		System.out.println(ts);
				
	}
}
