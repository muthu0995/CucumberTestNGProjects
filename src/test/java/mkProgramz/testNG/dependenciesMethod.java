package mkProgramz.testNG;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jdk.internal.org.objectweb.asm.commons.Method;
import junit.framework.Assert;

public class dependenciesMethod {
	
	@Test(enabled=true,description="Muthu Kumar M") //description is used to describe the test method
	public void childBorn() {
		System.out.println("Child is Born");
	}
	
//	@Test(enabled=false, dependsOnMethods="childBorn")
//	@Test(priority=1,dependsOnMethods="childBorn")
	@Test(priority=0,dependsOnMethods={"childBorn"})
	public void kinderGarden() {
		System.out.println("Child went to Kinder Garden");
//		Assert.assertTrue(false);
	}

//	@Test(priority=1, dependsOnMethods="childBorn")
//	@Test(priority=0, dependsOnMethods="childBorn")
//	@Test(dependsOnMethods="kinderGarden") // if dependant methods fails its will skip to execute; If dependant method set as enable=false it won't execute and gives error
	@Test(alwaysRun=true,dependsOnMethods="kinderGarden")   // alwaysRun=true try to execute dependantMethods fails
//	@Test // if we didn't give priority it will assumes as priority as '0'
	public void hrSecSchool() {
		System.out.println("Child went to Hr Sec School");
	}
	
	@Test(dependsOnMethods="hrSecSchool") // if we didn't give priority it will assumes as priority as '0'
	public void Engginering() {
		System.out.println("Child went to Engginering");
	}
	
	@BeforeMethod
	public void getBeforeMethod() {
//		System.out.println("Before Method:"+method.getName());		
	}
	
}
