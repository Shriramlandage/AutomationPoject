package pacticeTestNg;

public class PS2 extends PS3{
	
	int a;
	
	//Default constructor
	public PS2 (int a)
	{
		super(a);
		this.a=a;
	}
// Default costructor
	
	public int increment()
	{
		a=a+1;
		return a;
	}
	
	public int decrement()
	{
		a=a-1;
		return a;
	}
}
