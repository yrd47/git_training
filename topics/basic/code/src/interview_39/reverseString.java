package interview_39;

/**
 * Created by yrd on 2017/5/16.
 * 使用递归实现字符串反转
 */
public class reverseString {

    public static String reverse(String originString){
        if(originString == null || originString.length() <= 1){
            return originString;
        }
        System.out.println(originString.substring(1));
        return reverse(originString.substring(1))+originString.charAt(0);

    }

    public static void main(String[] args){
        String string = "12345678";
//        System.out.println(string);
//        System.out.println(string.substring(1));
        String result = reverse(string);
        System.out.print(result);
    }

}
