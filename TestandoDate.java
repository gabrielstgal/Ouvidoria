package Reclamação2;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TestandoDate {
	
	private static Date getData(Date aDate){       
        final Calendar myCalendar = Calendar.getInstance();
        myCalendar.setTime(aDate);
        myCalendar.set(Calendar.HOUR_OF_DAY, 0);
        myCalendar.set(Calendar.MINUTE, 0);
        myCalendar.set(Calendar.SECOND, 0);
        myCalendar.set(Calendar.MILLISECOND, 0);
        return myCalendar.getTime();
    }
	
	public static void main(String[] args) throws ParseException {
		Date data4 = new Date();
		System.out.println(getData(data4));
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date data1 = sdf.parse("18-04-2024");
		System.out.println(getData(data1));
		System.out.println(getData(data1).compareTo(getData(data4)));
	}
	

}
