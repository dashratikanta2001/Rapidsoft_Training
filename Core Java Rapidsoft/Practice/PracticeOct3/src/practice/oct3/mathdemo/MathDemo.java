package practice.oct3.mathdemo;

public class MathDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Absolute: ");
		System.out.println(Math.abs(-123));
		
		System.out.println("Absolute: ");
		System.out.println(StrictMath.abs(-123));
		
		System.out.println("Cube Root: ");
		System.out.println(Math.cbrt(9));
		
		System.out.println("Exact Decrement: ");
		System.out.println(Math.decrementExact(7));
		
		System.out.println("Exponent value in floating point rep. : ");
		System.out.println(Math.getExponent(1234.46));
		
		System.out.println("Round Division: ");
		System.out.println(Math.floorDiv(50, 9));

		System.out.println("e power x: ");
		System.out.println(Math.exp(1));
		
		System.out.println("e power x: ");
		System.out.println(StrictMath.exp(1));
		
		System.out.println("Log base 10: ");
		System.out.println(Math.log10(100));
		
		System.out.println("Maximum: ");
		System.out.println(Math.max(100, 50));
		
		System.out.println("Tan: ");
		System.out.println(Math.tan(45*Math.PI/180));
		
		System.out.println("Next Float Value: ");
		System.out.println(Math.nextAfter(12, 15));
	}

}
