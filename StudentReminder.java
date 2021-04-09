package studentReminder;

import java.time.LocalDateTime;

//this is where to run the app
public class StudentReminder {

	public static void main (String args[]) {
		LocalDateTime st = LocalDateTime.of(2010, 1, 15, 0, 30);
		LocalDateTime due = LocalDateTime.of(2020, 4, 8, 20, 18);
		
		Assignment testA = new Assignment (
			0, "test", "made for testing", 
			st, due, false);
		
	}
	
}
