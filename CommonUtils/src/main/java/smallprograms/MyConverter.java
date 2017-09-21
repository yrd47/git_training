package smallprograms;

import java.util.Scanner;

/**
 * Created by yrd on 2017/5/10.
 */
public class MyConverter {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入：");
        double value = scanner.nextDouble();
        String unit = scanner.next();
        if(unit.equals("厘米")){
            System.out.print(value + " 厘米 = " + value/2.54 + " 英寸");
        }else if(unit.equals("英寸")){
            System.out.println(value + " 英寸 = " + value*2.54 + " 厘米");
        }else{
            System.out.println("输入不符合");
        }
    }
}
