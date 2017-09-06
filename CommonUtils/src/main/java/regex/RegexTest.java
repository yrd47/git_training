package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Mac;

public class RegexTest {

	public static void main(String[] args) {
		Pattern pattern = PatternTest.init("\\d+");
		
		String[] liStrings = PatternTest.split(pattern, "我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
		System.out.println("-------split---------");
		for (String string : liStrings) {
			System.out.println(string);
		}
		
		System.out.println("-------match---------");
		System.out.println(PatternTest.match("\\d+", "2223"));
		System.out.println(PatternTest.match("\\d+", "2223aa"));
		System.out.println(PatternTest.match("\\d+", "22aa23"));
		
		Matcher matcher1 = PatternTest.matcher(pattern, "2223");
		Matcher matcher2 = PatternTest.matcher(pattern, "ddf22");
		System.out.println("-------pattern---------");
		System.out.println(matcher1.pattern());
		System.out.println("-------matches---------");
		System.out.println(matcher1.matches());
		System.out.println(matcher2.matches());
		//lookingAt()对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true
		System.out.println("-------lookAt---------");
		System.out.println(matcher1.lookingAt());
		System.out.println(matcher2.lookingAt());
		//find()对字符串进行匹配,匹配到的字符串可以在任何位置. 
		System.out.println("-------find---------");
		System.out.println(matcher1.find());
		System.out.println(matcher2.find());
		
		//当使用matches(),lookingAt(),find()执行匹配操作后,可以使用以下三个方法得到更详细的信息
		//start()返回匹配到的子字符串在字符串中的索引位置
		//end()返回匹配到的子字符串的最后一个字符在字符串中的索引位置
		//group()返回匹配到的子字符串
		//只有当匹配操作成功,才可以使用start(),end(),group()三个方法,否则会抛出java.lang.IllegalStateException,
		//也就是当matches(),lookingAt(),find()其中任意一个方法返回true时,才可以使用.
		System.out.println("-------start---------");
		System.out.println(matcher2.start());
		System.out.println("-------end---------");
		System.out.println(matcher2.end());
		System.out.println("-------group---------");
		System.out.println(matcher2.group());
		
		//start(),end(),group()均有一个重载方法它们是start(int i),end(int i),group(int i)专用于分组操作,
		//Mathcer类还有一个groupCount()用于返回有多少组.
		Pattern pattern2 = Pattern.compile("([a-z]+)(\\d+)");
		Matcher matcher = pattern2.matcher("aaa2223bb");
		System.out.println("-------------------");
		System.out.println(matcher.find());
		System.out.println(matcher.groupCount());
		System.out.println(matcher.start(1));
		System.out.println(matcher.start(2));
		System.out.println(matcher.end(1));
		System.out.println(matcher.end(2));
		System.out.println(matcher.group(0));
		System.out.println(matcher.group(1));
		System.out.println(matcher.group(2));
		
		//将文本中所有数字都取出来
		Matcher matcher3 = pattern.matcher("我的QQ是:456456 我的电话是:0532214 我的邮箱是:aaa123@aaa.com");
		System.out.println("------------------");
		while (matcher3.find()) {
			System.out.println(matcher3.group());
			System.out.println("start:" + matcher3.start());
			System.out.println("end:" + matcher3.end());
		}
	}

}
