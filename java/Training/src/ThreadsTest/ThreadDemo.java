package ThreadsTest;

public class ThreadDemo extends Thread{
	
	private Thread thread;
	private String threadName;
	
	public ThreadDemo(String name) {
		// TODO Auto-generated constructor stub
		threadName = name;
		System.out.println("Creating " + threadName);
	}
	
	public void run() {
		System.out.println("Running " + threadName);
		try {
			for (int i = 4; i > 0 ; i--) {
				System.out.println("Thread: " +threadName + "," + i );
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Thread " + threadName + "interrupted.");
		}
		System.out.println("Thread " + threadName + "exiting.");
	}
	
	public void start(){
		System.out.println("Starting " + threadName);
		if (thread==null){
			thread= new Thread(this, threadName);
			thread.start();
		}
	}

}
