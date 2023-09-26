package Assignment3.java;
class Calculator2{
	int sumNumber(int ...x)
	{
		int sum=0;
		for(int i:x)
		{
			sum+=i;
		}
		return sum;
	}
}

public class Question6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator2 c = new Calculator2();
		System.out.println("The sum is "+c.sumNumber(5,6));
		System.out.println("The sum is "+c.sumNumber(5,6,7,8));
		System.out.println("The sum is "+c.sumNumber(5,6,9,11,67,78,11,77));

	}

}
