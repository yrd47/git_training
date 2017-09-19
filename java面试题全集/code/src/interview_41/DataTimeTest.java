package interview_41;

import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * Created by yrd on 2017/5/16.
 *
 */
public class DataTimeTest {

    public static void main(String[] args){
        time();
    }

    //获取当前年月日时间
    public static void time(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DATE));
        //Java 8
        LocalDateTime localDateTime = LocalDateTime.now();
    }
}
