package com.prac.recursion;

public class SimpleSum {

  public static void main(String[] args) {
        System.out.println(recursionSum(5,0));
  }

  private static int recursionSum(int number,int val) { 
    int value = val;
    value++;
    if(number==0 || val == 2){
      return 0;
    }else{
      System.out.println("value is :"+val);
      number+=recursionSum(--number, value);    
    }
    return number;
  }

}
