package basic.select;

public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = {1,9,3,2,5,6,7,4,10,8};
		if (list != null && list.length != 0) {
			selectSort(list);
		}
		for (int i : list) {
			System.out.println(i);
		}
	}
	
	/**
	 * in-place sort;unstable sort
	 * O(n^2)
	 * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换，然后在剩下的数中再找出最小
	 * 的与第二个位置的数交换，如此循环
	 */
	public static void  selectSort(int[] a) {
		int temp = 0;
		//最小值的索引
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			index = i;
			for (int j = i; j < a.length; j++) {
				if (a[j] < a[index]) {
					index = j;
				}
			}
			if (index != i) {
				temp = a[index];
				a[index] = a[i];
				a[i] = temp;
			}
		}
	}
}
