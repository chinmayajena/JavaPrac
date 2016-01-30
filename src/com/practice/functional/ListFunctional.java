package com.practice.functional;

import java.util.List;

public class ListFunctional {

  public static void main(String[] args) {
    MathOperation addition = (int a, int b) -> a + b;
    
  }
  
  interface MathOperation {
    int operation(int a, int b);
 }
  
  
  public static void functionOperation(String param){
 //   (param) -> System.out.println(param);
  }
  

}
