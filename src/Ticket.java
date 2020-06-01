import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ticket {
	
	private Date date;
	private SimpleDateFormat dateFormat;
	
	
	public Ticket() {
		date = new Date();
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
	}


	public String toString() {
		return dateFormat.format(date);
	}

		
	
	
	
	
	
	
}
