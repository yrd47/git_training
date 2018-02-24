package sorttrain.swap;

/**
 * Created by yrd on 2018/2/24.
 */
public class QuickSortTrain1 {

    public static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int pivot = a[left];
            int lo = left;
            int hi = right;
            while (lo < hi ) {
                while (lo < hi && a[hi] >= pivot) {
                    hi--;
                }
                a[lo] = a[hi];
                while (lo < hi && a[lo] <= pivot) {
                    lo++;
                }
                a[hi] = a[lo];
            }
            a[lo] = pivot;
            quickSort(a, left, lo - 1);
            quickSort(a, lo + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{9,8,1,3,2,5,6,7,4};
        quickSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }
    }

}
