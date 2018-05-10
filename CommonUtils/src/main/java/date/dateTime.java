package date;

import java.util.Date;

import org.joda.time.DateTime;

public class dateTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateTime dateTime = new DateTime(new Date());
		DateTime yesterday = dateTime.minusDays(1);
		System.out.println(dateTime);
		System.out.println(yesterday);
		Date date = new Date();
        int year = date.getYear();
        int month = date.getMonth();
        int day = date.getDay();
        int hour = date.getHours();
        System.out.println(year + 1900);
        System.out.println(month + 1);
        System.out.println(day);
        System.out.println(hour);
       
        Date tomo = new Date(year, month, day + 1, hour, 0 , 0);
        System.out.println(date);
        System.out.println(date.getTime());
        System.out.println(tomo); 
        System.out.println(tomo.getTime());
	}

}
