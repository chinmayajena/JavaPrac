package com.prac.exception;

public class TestFinally {
  
  public static void aMethod() throws Exception {
    
    try{
     throw newException();
    }finally {
      System.out.println("Finally of a method");
    }
   
  }
  

  private static Exception newException() {
    return null;
  }

  public static void main(String[] args) {

    try{
      TestFinally.aMethod();
    }catch(Exception e){
      System.out.println("Catch of main method");
    }
  }

}
