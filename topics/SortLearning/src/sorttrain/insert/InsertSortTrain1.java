package sorttrain.insert;

/**
 * Created by yrd on 2018/2/11.
 */
public class InsertSortTrain1 {

    public static void insertSort(int[] a) {
        int j;
        int tmp = 0;
        for (int i = 1; i < a.length; i++) {
            j = i;
            tmp = a[i];
            for (; j > 0 && tmp < a[j - 1]; j--) {
                //将大于temp的值整体后移一个单位
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    public static void insertSort2(int[] a) {
        int tmp = 0;
        int j = 0;
        for (int i = 1; i < a.length; i++) {
            j = i;
            tmp = a[i];
            for (; j > 0 && a[j - 1] > tmp; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{9,8,1,3,2,5,6,7,4};
        insertSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
