package stringstest;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("^.*[0-9]+[0-9]+$");
		Matcher matcher = pattern.matcher("wg1-hg-leap-fe-console-1-1");
		System.out.println(matcher.matches());
	}

}
