package study;

import java.sql.Timestamp;
import java.util.Date;

public class Demo {

	public static void main(String[] args) {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		
		System.out.println(timestamp instanceof Date);
	}
}
