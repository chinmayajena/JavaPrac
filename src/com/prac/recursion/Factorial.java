package com.prac.recursion;

public class Factorial {
  public static void main(String[] args) {
    System.out.println(factorial(6));
  }

  private static int factorial(int i) {
    int n = 1;
    if(i==1){
      return 1;
    }else{
      n=i*factorial(i-1);
    }
    return n;
  }
  
 

}
