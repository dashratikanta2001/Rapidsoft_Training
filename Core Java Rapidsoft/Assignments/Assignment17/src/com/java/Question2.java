//Creat a map with name as weekmap. Basically the key contains the day of the week. After that push
//some speed data on the day basics to the map. 
//i) iterate over the map and find the average speed of that vehicle.

package com.java;

import java.util.*;

public class Question2 {
	
	static double calculateAvgSpeed(HashMap<String, ArrayList<Integer>> vehicle)
	{
		int sum=0;
		int count=0;
		
		for (Map.Entry<String, ArrayList<Integer>> entry : vehicle.entrySet()) {
			for (Integer speed : entry.getValue()) {
				sum+=speed;
				count++;
			}
		}
				
		return sum/count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, ArrayList<Integer>> weekMap = new HashMap<>();

		weekMap.put("Sunday", new ArrayList<>(Arrays.asList(70,60,100,110,50,30)));
		weekMap.put("Monday", new ArrayList<>(Arrays.asList(60,60,80,90,30,70)));
		weekMap.put("Tuesday", new ArrayList<>(Arrays.asList(67,58,112,80,79,99)));
		weekMap.put("Wednesday", new ArrayList<>(Arrays.asList(60,98,46,90,78,34)));
		weekMap.put("Thursday", new ArrayList<>(Arrays.asList(50,90,100,90,40,35)));
		weekMap.put("Friday", new ArrayList<>(Arrays.asList(60,60,80,90,30,70)));
		weekMap.put("Saturday", new ArrayList<>(Arrays.asList(80,88,66,90,38,64)));
		
		System.out.println("Average Speed of the vehicle = "+ calculateAvgSpeed(weekMap));

	}

}
