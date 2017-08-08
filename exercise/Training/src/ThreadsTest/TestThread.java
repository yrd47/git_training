package ThreadsTest;

public class TestThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunnableDemo R1 = new RunnableDemo("Thread_1");
		R1.start();
		
		RunnableDemo R2 = new RunnableDemo("Thread_2");
		R2.start();
		
		ThreadDemo T1 = new ThreadDemo("Thread_3");
		T1.start();
		
		ThreadDemo T2 = new ThreadDemo("Thread_4");
		T2.start();
	}

}
