import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class MiscClass {
  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner in = new Scanner(System.in);
    String a;
    a = in.next();
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ssa");
    Date date = null;
    try {
      date = sdf.parse(a);
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
    System.out.println(sdf1.format(date));

    
  
  }

}
