package lambda;

import java.util.*;

/**
 * Created by yrd on 2017/12/11.
 */
public class Test {

    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> list1 = new Vector<>();
        List<String> list2 = new Vector<>();
        List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3"));

        list.parallelStream().forEach( s -> {
            list1.add(s);
            list2.add(s);
        });

        list1.forEach(s -> System.out.println(s));
        list2.forEach(s -> System.out.println(s));
    }
}
