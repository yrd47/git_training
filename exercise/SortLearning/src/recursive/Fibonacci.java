package recursive;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = fib(5);
		System.out.println(result);
	}
	
	public static int fib(int index) {
		if (index == 1 || index == 2) {
			return 1;
		}
		return fib(index - 1) + fib(index - 2);
	}

}
