package training;

public class simpleCase {

	public static void main(String[] args) {
		simpleCase sCase = new simpleCase();
		sCase.case1();
	}
	
	//string与整型相互转换
	public void case1() {
		String a = String.valueOf(2);
		System.out.println(a);	
		int i = Integer.parseInt(a);
	}
}
