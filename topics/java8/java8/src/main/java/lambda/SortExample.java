package lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yrd on 2017/11/15.
 */
public class SortExample {

    public static void main(String[] args) {
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};

        //使用匿名内部类根据name排序
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        //使用lambda
        Arrays.sort(players, (String s1, String s2) -> s1.compareTo(s2));
    }
}
