package programme_3;

/**
 * Created by yrd on 2017/5/10.
 */
public class YangHuiTriangle {

    //二维数组实现杨辉三角
    public static void main(String[] args){
        int[][] array = new int[10][];
        for(int i = 0;i<10;i++){
            array[i] = new int[i+1];
            for(int j=0;j<array[i].length;j++) {
                if (j == 0 || j == i) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
                }
            }
            for(int a=0;a<array[i].length;a++){
                System.out.print(array[i][a] + " ");
            }
            System.out.println(" ");
        }
    }

}
