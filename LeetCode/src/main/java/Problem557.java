/**
 * Created by yrd on 2017/7/6.
 */
public class Problem557 {

    public String reverseWords(String s) {
        String result = "";
        String[] list = s.split(" ");
        for(String string : list){
            reverse(string);
        }
        for (int i = 0; i < list.length - 1; i++){
            result = result + list[i] + " ";
        }
        return result + list[list.length-1];
    }

    public static String reverse(String s) {
        char[] list = s.toCharArray();
        char[] result = new char[list.length];
        for(int i=0 ; i < list.length; i++) {
            result[list.length - i -1 ] = list[i];
        }
        return new String(result);
    }

}
