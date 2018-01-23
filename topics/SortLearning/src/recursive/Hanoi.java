package recursive;

public class Hanoi {
	
	public final static String from = "盘子A";
	public final static String to = "盘子C";
	public final static String mid = "盘子B";
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		move(4, from, mid, to);
	}
	
	/**
	 * 当你>=2时，先将上面的n-1个盘由A借助C移到B，然后最底下的一个大盘由A借助B移到C（实际就是直接从A移到C），最后将B上的n-1个盘由B借助A移到C
	 * 
	 * @param num
	 * @param from2
	 * @param mid2
	 * @param to2
	 */
	public static void move(int num, String from2, String mid2, String to2) {
		if (num == 1) {
			System.out.println("移动盘子1 从 " + from2 + "到" + to2);
		} else {
			move(num - 1, from2, to2, mid2);
			System.out.println("移动盘子" + num + " 从 " + from2 + "到" + to2);
			move(num - 1, mid2, from2, to2);
		}
	}

}
