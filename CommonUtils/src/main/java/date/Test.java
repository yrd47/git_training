package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test {

	public static void main(String[] args) throws ParseException {
		System.out.println(new Date().getTime());
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date = simpleDateFormat.parse("1993-1-1 1:1:1");
//		System.out.println(date.toString());
//		String[] liStrings = {"as","sc"};
//		System.out.println(liStrings[0]);
//		List<String> list = Arrays.asList("ss","aa","dd");
//		System.out.println(list.toString());
		
		System.out.println(System.currentTimeMillis());
		long start = System.currentTimeMillis();
		while((System.currentTimeMillis() - start)/1000 < 1) {
			System.out.println(System.currentTimeMillis()/1000);
		}
	}
}
