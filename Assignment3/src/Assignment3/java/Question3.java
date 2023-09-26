package Assignment3.java;

class ArrayOperation{
	int maximum(int [] arr)
	{
		int max=arr[0];
		for (int i=0;i<arr.length;i++)
		{
			if(arr[i]>max)
				max = arr[i];
		}
		return max;
	}
	
	double maximum(double [] arr)
	{
		double max=arr[0];
		for (int i=0;i<arr.length;i++)
		{
			if(arr[i]>max)
				max = arr[i];
		}
		return max;
	}
	
	String maximum(String [] arr)
	{
		String max=arr[0];
		for (int i=0;i<arr.length;i++)
		{
			if(arr[i].length()>max.length())
				max = arr[i];
		}
		return max;
	}
}

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] numbers = { 5, 8, 2, 11, 4 };
        double[] doubles = { 3.5, 9.2, 1.7, 6.8 };
        String[] strings = { "apple", "banana", "cherry", "pear" };      

		ArrayOperation A = new ArrayOperation();
		
		System.out.println("The maximun in the integer array is "+A.maximum(numbers));
		System.out.println("The maximun in the double array is "+A.maximum(doubles));
		System.out.println("The maximun in the String array is "+A.maximum(strings));
		
	}

}
