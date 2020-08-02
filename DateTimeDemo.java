import java.text.*;
import java.util.*;
public class DateTimeDemo {
	public static void main(String args[]) {
		Date date = new Date();
		DateFormat df;
		
		df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.JAPAN);
		System.out.println("Japan: " + df.format(date));
		
		df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.KOREA);
		System.out.println("KOREA: " + df.format(date));

		df = DateFormat.getDateInstance(DateFormat.LONG, Locale.UK);
		System.out.println("UK: " + df.format(date));

		df = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
		System.out.println("US: " + df.format(date));
	}
}
