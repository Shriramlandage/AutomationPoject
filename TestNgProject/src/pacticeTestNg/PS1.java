package pacticeTestNg;

import org.testng.annotations.Test;

public class PS1 {
	
	@Test
	public void testRun() {
		PS2 ps2=new PS2(3);
		
		int a =3;
		dothis();
		System.out.println(ps2.increment());
		System.out.println(ps2.decrement());
	}

}
