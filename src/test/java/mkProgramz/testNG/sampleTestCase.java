package mkProgramz.testNG;

import org.testng.annotations.Test;

public class sampleTestCase {
	
	@Test(priority=0,enabled=false)
	public void sampleFirstTestCase() {
		System.out.println("Printing Sample Test Cases");
	}
	
	@Test(priority=-2)
	public void sampleSecondTestCase() {
		System.out.println("Printing Sample Second Test Cases");
	}
	
	@Test
	public void backgroundTestCase() {
		System.out.println("Printing Background Test Cases");
	}
	
	@Test(priority=2)
	public void sampleThirdTestCase() {
		System.out.println("Printing Sample Third Test Cases");
	}
	
	@Test(priority=3)
	public void sampleFourthTestCase() {
		System.out.println("Printing Sample Fourth Test Cases");
	}
	

}
