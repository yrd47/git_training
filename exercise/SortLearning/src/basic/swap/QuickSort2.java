package basic.swap;

public class QuickSort2 {
	
	//此代码可以优化，见basic中
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = {1,9,3,2,5};
		for (int i : list) {
			System.out.println(i);
		}
		if (list.length > 0) {
			quickSort(list, 0, (list.length-1));
		}
		for (int i : list) {
			System.out.println(i);
		}
	}
	
	public static int partition(int[] arr, int left, int right) {
		int pivotKey = arr[left];
		int pivotPointer = left;
		
		while (left < right) {
			while (left < right && arr[right] >= pivotKey) {
				right--;
			}
			while (left < right && arr[left] <= pivotKey) {
				left++;
			}
			swap(arr, left, right);
		}
		swap(arr, pivotPointer, right); 	//把pivot交换到中间
		return left;
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		if (left >= right) {
			return ;
		}
		int pivotPos = partition(arr, left, right);
		quickSort(arr, left, pivotPos - 1);
		quickSort(arr, pivotPos + 1, right);
	}

	public static void swap(int[] arr, int left, int right) {
		int temp = left;
		arr[left] = arr[right];
		arr[right] = temp;
	}
}
