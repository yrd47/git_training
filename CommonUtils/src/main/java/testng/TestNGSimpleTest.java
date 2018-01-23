package testng;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class TestNGSimpleTest {

	@BeforeSuite
	public void beforeSuite(){
		log("beforeSuite");
	}

	@Test
	public void test_001(){
		String str = "TestNG is working fine";
		System.out.println(str);
		assertEquals("TestNG is working fine", str);
	}

	@AfterSuite
	public void afterSuite(){
		log("afterSuite");
	}

	private void log(String string){
		System.out.println(string);
	}
}
