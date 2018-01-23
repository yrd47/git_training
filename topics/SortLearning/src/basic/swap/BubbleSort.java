package basic.swap;

public class BubbleSort {
	
	/**
	 * stable sort;in-place sort
	 * 最坏复杂度：O(n^2)
	 * 基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次比较和调整，
	 * 较大数往下沉，较小的往上冒。即：每当相邻的数比较后发现它们的排序与排序要求相反是，将它们互换
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = {1,9,3,2,5,6,7,4,10,8};
		bubbleSort(list);
		for (int i : list) {
			System.out.println(i);
		}
	}

	public static void bubbleSort(int[] a) {
		int temp = 0;
		boolean flag = true;
		for (int i = a.length - 1; i > 0; i--) {
			if (flag) {
				flag = false;
				for (int j = 0; j < i; j++) {
					if (a[j] > a[j + 1]) {
						temp = a[j];
						a[j] = a[j + 1];
						a[j + 1] = temp;
						flag = true;
					}
				}
			} else {
				return;
			}
		}
	}
}
