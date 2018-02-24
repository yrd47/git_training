package sorttrain.swap;

/**
 * Created by yrd on 2018/2/24.
 */
public class BubbleSortTrain1 {

    public static void bubbleSort(int[] a) {
        boolean flag = true;
        for (int i = a.length - 1; i > 0; i--) {
            if (flag) {
                flag = false;
                for (int j = 0; j < i; j++) {
                    if (a[j] > a[j + 1]) {
                        swap(a, j, j + 1);
                        flag = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{9,8,1,3,2,5,6,7,4};
        bubbleSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
