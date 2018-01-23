package training;

import java.sql.Timestamp;
import java.util.Date;

public class TimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date=new Date();
		Timestamp timestamp =new Timestamp(date.getTime());
		System.out.println(timestamp);
		System.out.println(System.currentTimeMillis());
	}

}
