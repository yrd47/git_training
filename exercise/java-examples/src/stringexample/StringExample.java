package stringexample;

public class StringExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringCompare();
		SearchlastString();
	}
	
	public static void StringCompare() {
		String string = "Hello World";
		String anotherString  = "hello world";
		Object object = string;
		
		//返回字符串中第一个字母ASCII的差值
		System.out.println(string.compareTo(anotherString));
		System.out.println(string.compareToIgnoreCase(anotherString));
		System.out.println(string.compareTo(object.toString()));
	}
	
	public static void SearchlastString() {
		String string = "Hello world ,Hello Runoob";
		int lastIndex = string.lastIndexOf("Runoob");
		//调用链路	lastIndexOf(str, value.length);		lastIndexOf(value, 0, value.length,str.value, 0, str.value.length, fromIndex);
		if (lastIndex == -1) {
			System.out.println("no Runoob");
		} else {
			System.out.println("Runoob 字符串最后出现的位置：" + lastIndex);
		}
	}

}
