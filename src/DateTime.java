import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;



public class DateTime {
  
  
  static String localTimeZone = "Asia/Singapore";
  static TimeZone tz = TimeZone.getTimeZone(localTimeZone);
  public static void main(String[] args) throws ParseException {
    TimeZone tz = TimeZone.getTimeZone(localTimeZone);
    SimpleDateFormat sdf = new SimpleDateFormat();
    sdf.setTimeZone(tz);
    
    System.out.println(getWaveEndTimeDiffFromCurrent("22:30","07:00") );
    //System.out.println(getTimeStringFromTimeStamp(new Timestamp(1451998080000L)));
    
    //System.out.println(getRefreshInterval(1453878063954L));
  }
  
  
  
  public static String getWaveEndTimeWithRdsBlockingRule(String waveStartTime,
      String blockTimeLength) {

    Calendar waveStartTimeStamp = getTimeFromString(waveStartTime);
    SimpleDateFormat sdf = new SimpleDateFormat("HH");
    if (blockTimeLength.contains(".")){
      sdf = new SimpleDateFormat("HH.mm");
    }
    
    Date y = null;
    try {
      y = sdf.parse(blockTimeLength);
      Calendar newCal = Calendar.getInstance();
      newCal.setTimeInMillis(y.getTime());
      waveStartTimeStamp.add(Calendar.HOUR_OF_DAY, -newCal.get(Calendar.HOUR_OF_DAY));
      waveStartTimeStamp.add(Calendar.MINUTE, -newCal.get(Calendar.MINUTE));

    } catch (ParseException e) {
        e.printStackTrace();
    }

    int hour = waveStartTimeStamp.get(Calendar.HOUR_OF_DAY);
    int minutes = waveStartTimeStamp.get(Calendar.MINUTE); 
    
    SimpleDateFormat outPutSdf = new SimpleDateFormat("HH:mm");
    outPutSdf.setTimeZone(TimeZone.getTimeZone("Singapore"));
    String minutesDiplay = minutes<10?"0"+minutes :String.valueOf(minutes);
    
    System.out.println(hour + ":" + minutes);
    System.out.println(outPutSdf.format(waveStartTimeStamp.getTime()));
    
    return outPutSdf.format(waveStartTimeStamp.getTime());

  }
 
 
 public static String  getTimeString (String waveStartTime, String blockTimeLength) {
   Calendar waveStartTimeStamp = getTimeFromString(waveStartTime);
   SimpleDateFormat sdf = new SimpleDateFormat("HH.mm");
   Date y = null;
   try {
     y = sdf.parse(blockTimeLength);
     Calendar newCal = Calendar.getInstance();
     newCal.setTimeInMillis(y.getTime());     
     waveStartTimeStamp.add(Calendar.HOUR_OF_DAY, -newCal.get(Calendar.HOUR_OF_DAY));
     waveStartTimeStamp.add(Calendar.MINUTE, -newCal.get(Calendar.MINUTE));
  } catch (ParseException e) {

}
   
   return  waveStartTimeStamp.get(Calendar.HOUR_OF_DAY)+":"+waveStartTimeStamp.get(Calendar.MINUTE);
 }
 
  
  
/*  public static double getWaveEndTimeDiffFromCurrent(String startHour, String endHour) {
    Calendar calendarWaveStartTime = getTimeFromString(startHour);
    Calendar calendarWaveEndTime = getTimeFromString(endHour);
    Calendar calendarCurrentTime = getTimeFromString("23:30");//Calendar.getInstance(TimeZone.getTimeZone("Singapore"));
    System.out.println(calendarCurrentTime.get(Calendar.HOUR_OF_DAY) +":"+calendarCurrentTime.get(Calendar.MINUTE));
    double timeDiff = Math.toIntExact((calendarWaveEndTime.getTimeInMillis()-calendarCurrentTime.getTimeInMillis()));
    if(calendarWaveStartTime.get(Calendar.HOUR_OF_DAY) > calendarWaveEndTime.get(Calendar.HOUR_OF_DAY) && timeDiff < 0 ){
      System.out.println("Time diff less than zero");
      timeDiff+=86400000;
    }
  
    return timeDiff/60000;
  }
  */
  
  
  public static double getWaveEndTimeDiffFromCurrent(String startHour, String endHour) {
    Calendar calendarWaveStartTime =  getTimeFromString("22:30"); // 22:30
    Calendar calendarWaveEndTime = getTimeFromString("04:00"); // 7:00
    Calendar calendarCurrentTime = getTimeFromString("5:00"); //10:28, 23:00
    if (calendarWaveStartTime.get(Calendar.HOUR_OF_DAY) > calendarWaveEndTime
        .get(Calendar.HOUR_OF_DAY)) {
      calendarWaveEndTime.add(Calendar.DAY_OF_YEAR, 1);
    }
    
    if (calendarWaveStartTime.get(Calendar.HOUR_OF_DAY) > calendarCurrentTime
        .get(Calendar.HOUR_OF_DAY)) {
      calendarCurrentTime.add(Calendar.DAY_OF_YEAR, 1);
    }
    double timeDiff = Math.toIntExact((calendarWaveEndTime.getTimeInMillis()-calendarCurrentTime.getTimeInMillis()));
  /*  if(calendarWaveStartTime.get(Calendar.HOUR_OF_DAY) > calendarWaveEndTime.get(Calendar.HOUR_OF_DAY) && timeDiff < 0 ){
      System.out.println("Time diff less than zero. Adding 24 hrs as it is special case");
      if (calendarWaveStartTime.get(Calendar.HOUR_OF_DAY) < calendarCurrentTime.get(Calendar.HOUR_OF_DAY)) {
        timeDiff+=86400000;
      }
    }
  */
    return timeDiff/60000;
  }
  
  
  public static String getDeliverySlotRange(Long time, int length){
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy");
    sdf.setTimeZone(TimeZone.getTimeZone("Singapore"));
    String dateFormatted =  sdf.format(new Date(time));    
    SimpleDateFormat sdfTime = new SimpleDateFormat("hh a");
    sdfTime.setTimeZone(TimeZone.getTimeZone("Singapore"));
    String FromTimeFormatted =  sdfTime.format(new Date(time));  
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date(time));
    cal.add(Calendar.MINUTE, length); 
    String toTimeFromatted = sdfTime.format(cal.getTime());   
    return dateFormatted+", between "+FromTimeFormatted + " to " + toTimeFromatted ;

  }
  
  
  public static String getETA(String previousTime, int minutes){
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm a");
    Date convertedTime = null;
    try {
      convertedTime = sdf.parse(previousTime);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    
    Calendar cal = Calendar.getInstance();
    cal.setTime(convertedTime);
    cal.add(Calendar.MINUTE, minutes);
    return cal.getTime().toString();
    
    
  }
  
  
  public static String getCurrentSingaporeTime() {
    TimeZone tz = TimeZone.getTimeZone(localTimeZone);
    SimpleDateFormat dateString = new SimpleDateFormat();
    dateString.setTimeZone(tz);
    return dateString.format(new Date());
  }

  public static String getTimeWithDelayAdded(String previousTime, int minutes) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm a");
    Date convertedTime = null;
    try {
      convertedTime = sdf.parse(previousTime);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    Calendar cal = Calendar.getInstance();
    cal.setTime(convertedTime);
    cal.add(Calendar.MINUTE, minutes);
    return cal.getTime().toString();

  }
  
  
  public static String getCurrentSingporeDayOfWeek(){
    SimpleDateFormat sdf = new SimpleDateFormat("EEE");
    try {
      return sdf.format(new SimpleDateFormat().parse(getCurrentSingaporeTime()));
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }
    
  
  public static Calendar getTimeFromString (String time) {
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Singapore"));
    calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time.split(":")[0]));
    calendar.set(Calendar.MINUTE, Integer.parseInt(time.split(":")[1]));
    return calendar;
  }
  

  public static Calendar getCurrentSingaporeCalendarTime () {
    return Calendar.getInstance(TimeZone.getTimeZone("Singapore"));
  }
  
  
  public static void getDifferenceCalendar(){
    System.out.println((getTimeFromString("23:40").getTimeInMillis() - getCurrentSingaporeCalendarTime().getTimeInMillis())/60000);
  }
 
  
  public static String getTimeStringFromTimeStamp(Timestamp ts) {
    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(ts.getTime());    
    return cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE);
  }

  public static String getFormattedTime(String time) {
    Date date = null;
    SimpleDateFormat outPutSdf = new SimpleDateFormat("HH:mm");
    outPutSdf.setTimeZone(TimeZone.getTimeZone("Singapore"));
    try {
      date =  outPutSdf.parse(time);
    } catch (ParseException e) {
      
    }
    return outPutSdf.format(date);

  }
  
  public static double getRefreshInterval(long lastRefreshedAt) {

    if (lastRefreshedAt == 0) {
      return 0;
    } else {

      long currentTime = new Date().getTime();
      long diff = currentTime - lastRefreshedAt;

      double diffInMinutes = diff/60000;

      return diffInMinutes;
    }

  }
  
}


