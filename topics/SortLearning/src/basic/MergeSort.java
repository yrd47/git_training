package basic;

import java.util.Arrays;

public class MergeSort {
	
	/**
	 * 将两个或以上的有序表合并成一个新的有序表，即把待排序的序列分为若干个子序列，每个子序列是有序的，然后再把有序子序列合并为整体有序序列
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = {1,9,3,2,5,6,7,4,10,8,100};
		if (list.length > 0) {
			mergeSort(list, 0, list.length - 1);
		}
		for (int i : list) {
			System.out.println(i);
		}
	}
	
	public static void mergeSort(int[] a, int left, int right) {
		if (left < right) {
			//找出中间索引
			int center = (left + right) / 2;
			//对左边数组进行递归
			mergeSort(a, left, center);
			//对右边数组进行递归
			mergeSort(a, center + 1, right);
			//合并
			merge(a, left, right, center);
		}
	}
	
	public static void merge(int[] data, int left, int right, int center) {
		int[] tmpArr = new int[data.length];
		int mid = center + 1;
        // third记录中间数组的索引
        int third = left;
        int tmp = left;
        while (left <= center && mid <= right) {
  
            // 从两个数组中取出最小的放入中间数组
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }
        // 剩余部分依次放入中间数组
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
        // 将中间数组中的内容复制回原数组
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
        System.out.println(Arrays.toString(data));
    }
}
