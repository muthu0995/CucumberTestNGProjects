package mkProgramz.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class groupMethods {
	
	@Test(priority=0)
	public void Car1() {
		System.out.println("Car1");
	}
	
	@Test(priority=1)
	public void Car2() {
		System.out.println("Car2");
	}
	
	@Test(priority=3,dependsOnMethods= {"Car2","Car1"})
	public void Car3() {
		System.out.println("Car3");
	}
	
	@Test(priority=3,dependsOnMethods= {"Car1"})
	public void Car4() {
		System.out.println("Car4");
	}
	@Test(priority=0,dependsOnMethods= {"Car1"})
	public void Car5() {
		System.out.println("Car5");
	}
	
	@Test(priority=0,dependsOnMethods= {"Car2"})
	public void Car6() {
		System.out.println("Car6");
	}
	
	//Till here it takes priority as first condition then dependsOnMethods,dependsOnGroup; withIn DependsOnMethod and DependsOnGroup takes priority

	@Test(dependsOnGroups= {"Car2"})
	public void Car7() {
		System.out.println("Car7");
	}
	
	@Test(priority=1,groups= {"Car2"})
	public void Car8() {
		System.out.println("Car8");
	}
	
	@Test(priority=0,groups= {"Car2"})
	public void Car9() {
		System.out.println("Car9");
	}
	
	@Test(priority=1,groups= {"Car3"})
	public void Car10() {
		System.out.println("Car10");
	}
	
	@Test(priority=0,groups= {"Car3"})
	@Parameters("Name")
	public void Car11(@Optional("Muthu Kumar")String name) {
		System.out.println("Car11 owned by "+name);
	}
	
	@Test(dataProvider="dataProviderTestCase",groups= {"Car3"})
	public void Car12(String name) {
		System.out.println("Car 12 is owned by :"+name);
	}
	
	@DataProvider(name="dataProviderTestCase")
	public Object[][] dataProviderMethod() {
		return new Object[][] {{"Muthu"},{"Kumar"}};
		
	}
	
}
