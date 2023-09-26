package Practice.Sept25;

public class Array2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {3,9,7,8,12,6,15,5,4,10};
//		int key=8;
//		for(int x:A)
//		{
//			if(x==key)
//				System.out.println("The Key found " +key);
//		}
		
		//Print max
		
//		int max=A[0];
//		for (int i=0;i<A.length;i++)
//		{
//			if(A[i]>max)
//				max = A[i];
//		}
//		System.out.println(max);
		
		//Print 2nd max
		
//		int max1=A[0];
//		int max2=A[0];
//		for (int i=0;i<A.length;i++)
//		{
//			if(A[i]>max1)
//			{
//				max2 = max1;
//				max1 = A[i];
//			}
//			else if (A[i]>max2)
//			{
//				max2 = A[i];
//			}
//		}
//		System.out.println(max2);
		
//		// Rotating array to left
//		
//		int temp=A[0];
//		for(int i=1;i<A.length;i++)
//		{
//			A[i-1] = A[i];
//		}
//		A[A.length-1] = temp;
//		
//		for(int x:A)
//		{
//			System.out.print(x+" ");
//		}
		
		
		//Insert element to the array
		
//		int x=20;
//		int index=2;
//		
//		for(int i=A.length-1;i>index;i--)
//		{
//			A[i] = A[i-1];
//		}
//		A[index] = x;
//		
//		for(int i:A)
//		{
//			System.out.print(i+" ");
//		}
		
		// Delete elemenet from the array
		
//		int dindex=1;
//		for(int i=dindex;i<A.length-1;i++)
//		{
//			A[i]=A[i+1];
//		}
//		
//		for(int i=0;i<A.length-1;i++)
//		{
//			System.out.print(A[i]+" ");
//		}
		
		
		//Copying an Array;
		
//		int B[] = new int[10];
//		for(int i=0;i<A.length;i++)
//		{
//			B[i] = A[i];
//			System.out.print(B[i]+" ");
//		}
		
		
		//Copying an Array in reverse order;
		
//		int B[] = new int[10];
//		for(int i=A.length-1,j=0;i>=0;i--,j++)
//		{
//			B[j] = A[i];
//			System.out.print(B[j]+" ");
//		}
		
		
//		Increse the size of array
		System.out.println("Length of A="+A.length);
		int B[]= new int[2*A.length];
		for(int i=A.length-1,j=0;i>=0;i--,j++)
		{
			B[j] = A[i];
		}
		A=B;
		B=null;
		System.out.println("New A Length = "+A.length);
		for(int x:A)
		{
			System.out.print(x+" ");
		}
		
	}

}
