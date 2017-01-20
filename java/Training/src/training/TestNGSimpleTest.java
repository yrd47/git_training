package training;

import org.testng.annotations.*;

import com.beust.testng.TestNG;

import static org.testng.Assert.*;

public class TestNGSimpleTest {
	
	@Test
	public void testAdd(){
		String str = "TestNG is working fine";
		System.out.println(str);
		assertEquals("TestNG is working fine", str);
	}
	
}
