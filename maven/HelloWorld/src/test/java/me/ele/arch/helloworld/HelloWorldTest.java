package me.ele.arch.helloworld;

import static org.junit.Assert.*;
import org.junit.Test;

public class HelloWorldTest{
	@Test
	public void testSayHello(){
		HelloWorld helloworld = new HelloWorld();
		String result = helloworld.sayHello();
		assertEquals("Hello maven",result);
	}
}