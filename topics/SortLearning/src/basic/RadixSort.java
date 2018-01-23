package basic;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {
	
	/**
	 * 将所有待比较值统一为同样的数位长度，数位较短的前面补零。然后，从最低位开始，依次进行依次排序，这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//% 与 / 优先级一样，从左往右执行
		int y = 1 % (int) Math.pow(10, 2);
		int x = 1 % (int) Math.pow(10, 2) / (int) Math.pow(10, 1);
		System.out.println(y);
		System.out.println(y/ 10);
		System.out.println("----------------------");
		int[] list = {1,9,3,2,5,6,7,4,10,8,100};
		if (list.length > 0) {
			radixSort(list);
		}
		for (int i : list) {
			System.out.println(i);
		}
	}
	
	public static void radixSort(int[] array) {
		//确定排序的趟数
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		
		int time = 0;
		//判断位数
		while (max > 0) {
			max /= 10;
			time++;
		}
		
		//建立10个队列
		List<ArrayList> queue = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ArrayList<Integer> queue1 = new ArrayList<>();
			queue.add(queue1);
		}
		
		//进行time次分配和收集
		for (int i = 0; i < time; i++) {
			//分配数组元素
			for (int j = 0; j < array.length; j++) {
				//得到数字的第time+1位数
				//返回第一个参数的值提高到第二个参数的幂
				int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
				ArrayList<Integer> queue2 = queue.get(x);
				queue2.add(array[j]);
				queue.set(x, queue2);
			}
			//元素计数器
			int count = 0;
			//收集队列元素
			for (int k = 0; k < 10; k++) {
				while (queue.get(k).size() > 0) {
					ArrayList<Integer> queue3 = queue.get(k);
					array[count] = queue3.get(0);
					queue3.remove(0);
					count++;
				}
			}
		}
	}
}
