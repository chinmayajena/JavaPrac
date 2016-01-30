package com.prac.exception;

public class TestStringNull {
public static void main(String[] args) {
  String x = new String("abc");
  System.out.println(x=="abc");
  System.out.println(x.equals("abc"));
  
  
  String y = "xyz";
  System.out.println(y=="xyz");
  System.out.println(y.equals("xyz"));
  
}
}
