//Create two map with name as todayMap<string,arrayList> and weeklyMap<string, arrayList>. Basically the
//key contains the vehicle number and the arrayList contains the speed with respective vehicles. 
//i) find the vehicle number and speed where the speed is greater than the provided speed (through
//scanner class) and print it.
//ii) find the common speed of the vehicles in both the maps and print the speed with vehicle number.

package com.java;

import java.util.*;

public class Question1 {
	
	//Find the Over Speed Vehicle
	static void overSpeed(HashMap<String, ArrayList<Integer>> todayMap,HashMap<String, ArrayList<Integer>> weeklyMap,int limit)
	{
		HashMap<String, ArrayList<Integer>> vehicle = new HashMap<>();

		vehicle.putAll(findOverSpeed(todayMap, limit));
		vehicle.putAll(findOverSpeed(weeklyMap, limit));

		System.out.println(vehicle);
	}

	//return the list of overspeed vehicle
	static HashMap<String, ArrayList<Integer>> findOverSpeed(HashMap<String, ArrayList<Integer>> map,int limit)
	{
		HashMap<String, ArrayList<Integer>> vehicle = new HashMap<>();

		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			ArrayList<Integer> al = new ArrayList<>();

			for (Integer speed : entry.getValue()) {
				if(speed >= limit)
				{
					al.add(speed);
				}
			}			
			if(!al.isEmpty())
				vehicle.put(entry.getKey(), al);
		}
		return vehicle;
	}

	//Find the Speed report
	static void speedReport(HashMap<String, ArrayList<Integer>> todayMap,HashMap<String, ArrayList<Integer>> weeklyMap)
	{
		TreeMap<Integer, ArrayList<String>> report = new TreeMap<>();
		todayMap.putAll(weeklyMap);
		
		for (Map.Entry<String, ArrayList<Integer>> entry : todayMap.entrySet()) {
			for (Integer it : entry.getValue()) {
				
				if(findCommon(todayMap, it).size()>1)
				
				report.put(it, findCommon(todayMap, it));
			}	
		}
		
		for (Map.Entry<Integer, ArrayList<String>> vehicle : report.entrySet()) {
			System.out.println("Speed: "+vehicle.getKey()+" : "+vehicle.getValue());
			
		}
	}
	
	//return the list of common speed vehicle details 
	static ArrayList<String> findCommon(HashMap<String, ArrayList<Integer>> hs,int speed)
	{
		ArrayList<String> vehicle = new ArrayList<>();
		
		for (Map.Entry<String, ArrayList<Integer>> entry : hs.entrySet()) {
			for (Integer sp : entry.getValue()) {
				if(sp==speed && !vehicle.contains(entry.getKey()))
				{
					vehicle.add(entry.getKey());
				}
			}
		}
		return vehicle;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, ArrayList<Integer>> todayMap = new HashMap<>();
		HashMap<String, ArrayList<Integer>> weeklyMap = new HashMap<>();

		todayMap.put("OD-01-V-1020", new ArrayList<>(Arrays.asList(70,60,100,110,50,30)));

		weeklyMap.put("OD-02-A-5016", new ArrayList<>(Arrays.asList(60,60,80,90,30,70)));
		weeklyMap.put("OD-01-S-2811", new ArrayList<>(Arrays.asList(67,58,112,80,79,99)));
		weeklyMap.put("OD-19-E-6630", new ArrayList<>(Arrays.asList(60,98,46,90,78,34)));
		weeklyMap.put("OD-14-C-7152", new ArrayList<>(Arrays.asList(50,90,100,90,40,35)));
		weeklyMap.put("OD-30-S-3487", new ArrayList<>(Arrays.asList(60,60,80,90,30,70)));

		System.out.println("Enter Limit:");
		Scanner sc = new Scanner(System.in);
		int limit = sc.nextInt();

		System.out.println("Over Speed vehicles: ");
		overSpeed(todayMap,weeklyMap,limit);
		
		System.out.println("\nSpeed Report:");
		speedReport(todayMap,weeklyMap);
		
	}

}
