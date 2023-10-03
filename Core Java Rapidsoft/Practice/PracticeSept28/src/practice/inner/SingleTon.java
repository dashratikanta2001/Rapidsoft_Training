package practice.inner;

class CofeeMachine{
	private float cofeeQty;
	private float milkQty;
	private float waterQty;
	private float sugarQty;
	
	static private CofeeMachine my = null;
	
	private CofeeMachine()
	{
		cofeeQty=1;
		milkQty=1;
		waterQty=1;
		sugarQty=1;
	}
	
	public void fillWater(float qty)
	{
		waterQty=qty;
	}
	
	public void fillSugar(float qty)
	{
		sugarQty=qty;
	}
	
	public float getCofee()
	{
			return 0.23f;
	}
	
	static CofeeMachine getInstance()
	{
		if(my == null)
		{
			my = new CofeeMachine();
		}
		return my;
	}

}
public class SingleTon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CofeeMachine m1 = CofeeMachine.getInstance();
		CofeeMachine m2 = CofeeMachine.getInstance();
		CofeeMachine m3 = CofeeMachine.getInstance();
		
		System.out.println(m1+" "+m2+" "+m3);
		System.out.println( m1.getCofee());
		

	}

}
