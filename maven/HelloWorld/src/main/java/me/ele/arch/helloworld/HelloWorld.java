package me.ele.arch.helloworld;

public class HelloWorld{
	public String sayHello(){
		return "Hello maven";
	}

	public static void main(String[] args){
		System.out.println(new HelloWorld().sayHello());
	}
}