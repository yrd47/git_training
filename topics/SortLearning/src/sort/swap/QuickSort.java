package sort.swap;

public class QuickSort {

	/**
	 * unstable sort;in-place sort
	 * 最坏：数组已排好序，O(n^2)
	 * 最好：O(nlgn)
	 * 基本思想：分治法	选择一个基准元素(通常选择第一个或最后一个元素)，通过一趟扫描，将带排序序列分为两部分，
	 * 一部分比基准小，一部分大于等于基准元素，此时基准元素在起排好序后的正确位置，然后再用同样的方法递归的排序划分的两部分
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = {1,9,3,2,5,6,7,4,10,8};
		//查看数组是否为空
		if (list.length > 0) {
			quickSort(list, 0, (list.length-1));
		}
		for (int i : list) {
			System.out.println(i);
		}
	}
	
	public static void quickSort(int[] a, int low, int high) {
		if (low < high) {
			//将数组一分为二
			int middle = getMiddle(a, low, high);
			//对低字表进行递归排序
			quickSort(a, low, middle - 1);
			//对高字表进行递归排序
			quickSort(a, middle + 1, high);
		}
	}
	
	public static int getMiddle(int[] list, int low, int high) {
		int tmp = list[low];	//数组第一个作为中轴
		while (low < high) {
			while (low < high && list[high] >= tmp) {
				high--;
			}
			list[low] = list[high];		//比中轴小的移到低端
			while (low < high && list[low] <= tmp) {
				low++;
			}
			list[high] = list[low];		//比中轴大的移到高端
		}
		list[low] = tmp;		//中轴记录到尾
		return low;				//返回中轴位置	
	}

}
