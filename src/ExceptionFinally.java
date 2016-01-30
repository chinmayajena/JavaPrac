
public class ExceptionFinally {

  

  public static void main(String[] args) {

    try{
      
      int i = 9/0;
      System.out.println(i);
      
    }catch(Exception e){
      System.out.println("hold");
    }finally{
      System.out.println("I m finally");
    }
    
  }

}
