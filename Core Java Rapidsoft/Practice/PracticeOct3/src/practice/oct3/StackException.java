package practice.oct3;

class StackOverFlowException extends Exception{
	public String  toString()
	{
		return "Stack is full";
	}
}

class StackUnderFlowException extends Exception{
	public String  toString()
	{
		return "Stack is empty";
	}
}

class Stack {

	private int size;
	private int top =-1;
	private int s[];
	
	public Stack(int s2)
	{
		size =s2;
		s=  new int [s2];
	}
	
	public void push(int x) throws StackOverFlowException
	{
		if(top == size-1)
		{
			throw new StackOverFlowException();
		}
		top++;
		s[top]=x;
	}
	
	public int pop() throws StackUnderFlowException
	{
		int x=-1;
		if(top ==-1)
		{
			throw new StackUnderFlowException();
		}
		x = s[top];
		top--;
		return x;
	}
}

class StackException{
	public static void main(String[] args) {
		Stack st = new Stack(5);
		
		try {
			st.pop();
			st.push(10);
			st.push(15);
			st.push(10);
			st.push(15);
			st.push(10);
			st.push(15);
		} catch (StackOverFlowException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (StackUnderFlowException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
}
