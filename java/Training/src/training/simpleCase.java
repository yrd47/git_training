package training;

public class simpleCase {
	
	final long l = System.currentTimeMillis();

	public static void main(String[] args) {
		simpleCase sCase = new simpleCase();
		sCase.case4();
	}
	
	//string与整型相互转换
	public void case1() {
		String a = String.valueOf(2);
		System.out.println(a);	
		int i = Integer.parseInt(a);
	}
	
	public void case2(){
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Math.pow(2, 31));
	}
	
	public void case3(){
		System.out.println(Long.MAX_VALUE);
		long value = Long.valueOf("1209235876731175036");
		System.out.println(value);
		System.out.println(Long.toBinaryString(value));
		System.out.println((value - (value >> 23 << 23)) >> 18);
	}
	
	public void case4() {
		for(int b=0 ; b<10 ; b++){
			double d = Math.random();
			System.out.println(d);
			int i = (int) (d*1000000000); 
			System.out.println(i);
		}
	}
}
