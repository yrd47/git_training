import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
	static int i = 0;

	public static void main(String[] args) {
		
		Pattern pattern = Pattern.compile("wg1");
		Matcher matcher = pattern.matcher("xg");
		
		System.out.println(Pattern.matches("xg\\d", "xg1"));
		
		System.out.println(System.currentTimeMillis());
		System.out.println(new Date().getTime());
		
		
		
//		long iLong = 0;
//		System.out.println(0/1024/1024);
//		List<String> list = new ArrayList<>();
//		for(String string : list) {
//			System.out.println(string);
//		}
////		List<String> list1 = new ArrayList<>();
////		list.addAll(null);
////		list.addAll(list1);
//		System.out.println(1);
//		new test().fun();
	}
	
	public void fun() {
		i++;
		System.out.println(i);
	}

}
