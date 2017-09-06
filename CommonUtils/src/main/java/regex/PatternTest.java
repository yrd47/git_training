package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
	
	/**
	 * Patter类用于创建一个正则表达式，它的构造方法是私有的，不可以直接创建，
	 *但可以通过Pattern.complie(String regex)简单工厂方法创建一个正则表达式,
	 *pattern() 返回正则表达式的字符串形式,其实就是返回Pattern.complile(String regex)的regex参数
	 */
	public static Pattern init(String string) {
		Pattern pattern = Pattern.compile(string);
		return pattern;
	}
	
	/**
	 * Pattern.split(CharSequence input)
	 * Pattern有一个split(CharSequence input)方法,用于分隔字符串,并返回一个String[]
	 */
	public static String[] split(Pattern pattern, String input) {
		String[] list = pattern.split(input);
		return list;
	}
	
	/**
	 * Pattern.matcher(String regex,CharSequence input)
	 * 一个静态方法,用于快速匹配字符串,该方法适合用于只匹配一次,且匹配全部字符串
	 */
	public static boolean match(String regex, String input) {
		return Pattern.matches(regex, input);
	}
	
	/**
	 * Pattern.matcher(CharSequence input)
	 * Pattern.matcher(CharSequence input)返回一个Matcher对象.
	 * Matcher类的构造方法也是私有的,不能随意创建,只能通过Pattern.matcher(CharSequence input)方法得到该类的实例.
	 */
	public static Matcher matcher(Pattern pattern, String input) {
		return pattern.matcher(input);
	}
}
