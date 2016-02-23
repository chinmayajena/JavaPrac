
public class DecimalToBinary {

  /*
   * 
MSB Binary Digit    LSB
1   1   1   1   1   1   1   1   1
256 128 64  32  16  8   4   2   1

   * 
   * */
  
  
  public static void main(String[] args) {
    //10011100
    convert(15);
  }

  private static void  convert(int num) {
    
    int[] binary = new int[10];
    int index = 0;
    while(num>0){      
      binary[index++] = num%2;
      num = num/2;
    }
    for(int i = index-1; i >=0 ; i --){
      System.out.print(binary[i]);
    }
        
  }

}
