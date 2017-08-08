package basic;

import com.sun.accessibility.internal.resources.accessibility;

public class InsertSort {
	
	/**
	 * 基本思想：在要排序的一组书中，假设前面(n-1)[n>=2]个数已经是排好序的，现在要把第n个数插到前面的有序数中
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = {1,3,2,5,6,7};
		for (int i : list) {
			System.out.println(i);
		}
		insertSort(list);
		for (int i : list) {
			System.out.println(i);
		}
	}
	
	public static void insertSort(int[] list) {
		int temp = 0;
		for (int i = 1; i < list.length; i++) {
			int j = i - 1;
			temp = list[i];
			for (; j >= 0 && temp < list[j]; j--) {
				//将大于temp的值整体后移一个单位
				list[j + 1] = list [j];
			}
			list[j + 1] = temp;
		}
	}

}
