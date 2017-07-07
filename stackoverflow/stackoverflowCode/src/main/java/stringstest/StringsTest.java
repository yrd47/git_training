package stringstest;

/**
 * Created by yrd on 2017/7/6.
 *
 */
public class StringsTest {

    public static void EqualsTest() {
        String firstString = "Test123";
        String secondString= "Test" + 123;
        System.out.println(firstString == secondString);
        System.out.println(firstString.equals(secondString));
    }

    public static void InternTest() {
        String strObj = new String("Hello");
        String str = "Hello";
        if (strObj.equals(str))
            System.out.println("The string are equal");
        if (strObj != str)
            System.out.println("The strings are not the same object");
        String internedStr = strObj.intern();
        if (internedStr == str)
            System.out.println("The interned string and the literal are the same object");
    }

    public static void ConvertStrings() {
        String string = "This is a Random String";
        String upper = string.toUpperCase();
        String lower = string.toLowerCase();
        System.out.println(upper);
        System.out.println(lower);
    }

    public static void ContainsTest() {
        String str1 = "Hello World";
        String str2 = "Hello";
        String str3 = "HeLLo";
        System.out.println(str1.contains(str2));
        System.out.println(str1.contains(str3));
        String s = "this is a long sentence";
        int i = s.indexOf('i');    // the first 'i' in String is at index 2
        int j = s.indexOf("long"); // the index of the first occurrence of "long" in s is 10
        int k = s.indexOf('z');    // k is -1 because 'z' was not found in String s
        int h = s.indexOf("LoNg"); // h is -1 because "LoNg" was not found in String s
        String str11 = "Hello World";
        String str12 = "wOr";
        str11.indexOf(str12);                               // -1
        str11.toLowerCase().contains(str12.toLowerCase());  // true
        str11.toLowerCase().indexOf(str12.toLowerCase());   // 6
    }

    public static void SplitTest() {
        String lineFromCsvFile = "Mickey;Bolton;12345;121216";
        String[] dataCells = lineFromCsvFile.split(";");
        for (String string:
             dataCells) {
            System.out.println(string);
        }
        String lineFromInput = "What    do you need    from me?";
        String[] words = lineFromInput.split("\\s+"); // one or more space chars
        // Result is words = {"What", "do", "you", "need", "from", "me?"};
    }

    public static void main(String[] args) {
        EqualsTest();
        InternTest();
        ConvertStrings();
        ContainsTest();
    }
}
