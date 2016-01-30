import java.util.regex.Pattern;



/**
 * @author chinmay
 *
 * This class shows how to check if the string is an integer or not.
 */
public class IsInteger {

  public static void main(String[] args) {

    String i = "99999";   
    System.out.println(!i.matches(Pattern.compile(".*[^0-9].*").pattern()));
    
  }

}
