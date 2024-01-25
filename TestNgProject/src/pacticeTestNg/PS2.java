package pacticeTestNg;

public class PS2 {
	
	int a;
	public PS2 (int a)
	{
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
