package lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yrd on 2017/11/15.
 */
public class SimpleExample {

    public static void main(String[] args) {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> list = Arrays.asList(atp);

        //旧的遍历方式
        for (String string : list) {
            System.out.print(string + "; ");
        }

        System.out.println();

        //使用Lambda以及函数式操作
        list.forEach(string -> System.out.print(string + "; "));

        System.out.println();

        //在java8中使用双冒号
        list.forEach(System.out::println);
    }
}
