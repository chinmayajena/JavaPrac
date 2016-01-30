package com.prac.recursion;

import java.util.ArrayList;
import java.util.List;

public class ListSum {


  static List<Integer> intlist = new ArrayList<Integer>();
  static int count = 0;
  

  public static void main(String[] args) {

    intlist.add(5);
    intlist.add(8);
    intlist.add(3);
    intlist.add(6);
    
    int sum = sumList(intlist);    
    System.out.println(sum);    
  }



  private static int sumList(List<Integer> nums) {
    
    if(nums.size() == 0){
      return 0;
    }else {
      
      int sum =  nums.get(0)+sumList(nums.subList(1, nums.size()));
      System.out.println(sum);
      return sum;
    }
    
  }

}
