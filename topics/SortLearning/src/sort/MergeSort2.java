package sort;

public class MergeSort2 {
	
	/**
	 * 递归分治
	 * 空间复杂度 O(n)
	 * 时间复杂度 O(nlogn)
	 */
	public static void main(String[] args) {
		int[] list = {1,9,3,2};
		if (list == null || list.length == 0 ) {
			return;
		}
		mergrSort(list, 0, list.length - 1);
		for (int i : list) {
			System.out.println(list[i]);
		}
	
	}

	public static void mergrSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = (left + right) / 2;
		//递归排序左边
		mergrSort(arr, left, mid);
		//递归排序右边
		mergrSort(arr, mid + 1, right);
		//合并
		merge(arr, left, mid, right);
	}
	
	public static void merge(int[] arr, int left, int mid, int right) {
		//[left, mid] [mid+1, right]
		//中间数组
		int[] temp = new int[right - left + 1];
		
		int i = left;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		while (j <= right) {
			temp[k++] = arr[j++];
		}
		
		for (int p = 0; p < temp.length; p++) {
			arr[left + p] = temp[p];
		}
	}
}
