package programme_1;

import java.util.Scanner;

/**
 * Created by yrd on 2017/5/10.
 */
public class MyConverter {

    //static方法表示main方法在内存中是唯一的，程序只有一个入口
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入英寸：");
        double inch = scanner.nextDouble();
        System.out.println(inch+"英寸 = " + inch*2.54 + "厘米");
        scanner.close();
    }

}
