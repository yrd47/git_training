package training;

import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		List<String> list1 = null;
		list1 = new ArrayList<>();
		list1.add("333");
		list1.add("444");
		list1.add("555");
		List<String> list2 = new ArrayList<>();
		list2.add("11");
		list2.add("22");
		List<String> list3 = (list1 == null) ? list2 : list1;
		System.out.println(list3.size());
	}
}
