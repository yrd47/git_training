package sort.insert;

public class ShellSort {
	
	/**
	 * 基本思想：将要排序的一组数按某个增量d(n/2，n为要排序的数的个数)分成若干小组，每组中记录的下标相差d。
	 * 对每组中全部元素进行直接插入排序，然后再用一个较小的增量(d/2)对它进行分组，在每组中再进行直接插入排序，当增量减到
	 * 1时，进行直接插入排序后，排序完成
	 * @param args
	 */
	
	public static void main(String[] args) {
		int[] list = {1,9,3,2,5,6,7,4,10,8};
		for (int i : list) {
			System.out.println(i);
		}
		shellSort(list);
		for (int i : list) {
			System.out.println(i);
		}
	}
	
	public static void shellSort(int[] a) {
		double d1 = a.length;
		int temp = 0;
		while (true) {
			//进一除法
			d1 = Math.ceil(d1 / 2);
			int d = (int) d1;
			for (int x = 0; x < d; x++) {
				for (int i = x + d; i < a.length; i += d) {
					int j = i - d ;
					temp = a[i];
					for (; j >= 0 && temp < a[j]; j -= d) {
						a[j + d] = a[j];
					}
					a[j + d] = temp;
				}
			}
			if (d == 1) {
				break;
			}
		}
	}

}
