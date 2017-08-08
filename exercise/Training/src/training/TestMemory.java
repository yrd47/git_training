package training;

public class TestMemory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("内存信息：" + toMemoryInfo());
	}
	
	public static String toMemoryInfo(){
		Runtime currRuntime = Runtime.getRuntime();
		System.out.println(currRuntime);
		int nTotalMemory = (int) (currRuntime.totalMemory() / 1024 / 1024);
		System.out.println(nTotalMemory);
		int nFreeMemory = (int) (currRuntime.freeMemory() / 1024 / 1024);
		System.out.println(nFreeMemory);
		return nFreeMemory + "M/" + nTotalMemory + "M(free/total)";
	}
}
