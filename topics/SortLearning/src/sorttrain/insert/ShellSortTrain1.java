package sorttrain.insert;

/**
 * Created by yrd on 2018/2/11.
 */
public class ShellSortTrain1 {

    public static void shellSort(int[] a) {
        int temp;
        int k;
        int d = a.length;
        while (true) {
            d = d / 2;
            for (int i = 0; i < d; i++) {
                for (int j = i + d; j < a.length; j += d) {
                    k = j - d;
                    temp = a[j];
                    for (; k >= 0 && temp < a[k]; k -= d) {
                        a[k + d] = a[k];
                    }
                    a[k + d] = temp;
                }
            }
            if (d == 1) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{9,8,1,3,2,5,6,7,4};
        shellSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
