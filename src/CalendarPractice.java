import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


public class CalendarPractice {

  public static void main(String[] args) {

    //Date date = new Date(1442372400000L);
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Singapore"));
    calendar.setTimeInMillis(1442372400000L);
    System.out.println(calendar.get(Calendar.HOUR));
    
    Calendar calendar1 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    calendar1.set(Calendar.HOUR, calendar.get(Calendar.HOUR));;
    System.out.println(calendar1.getTimeInMillis());
    Date newDAte = new Date(1442228580584L);
    System.out.println(newDAte);
    
    
   /* System.out.println(date);
    Calendar calendar = new GregorianCalendar();
    calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
    String today = calendar.getTime().toString();
    System.out.println(today + ","+ calendar.getTimeInMillis() + "," + calendar.getTime() + "," + calendar.getTimeZone());
    
    */
    
    
  }

}
