package sorttrain.select;

/**
 * Created by yrd on 2018/2/12.
 */
public class SelectSortTrain1 {

    public static void selectSort(int[] a) {
        int tmp = 0;
        int j = 0;
        for (int i = 0; i < a.length - 1; i++) {
            j = i;
            tmp = j;
            for (; j < a.length; j++) {
                if (a[j] < a[tmp]) {
                    tmp = j;
                }
            }
            swap(a, i, tmp);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{9,8,1,3,2,5,6,7,4};
        selectSort(a);
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
