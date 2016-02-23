package com.prac.algo;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {

     public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String input = sc.next();
    System.out.println(isPangram(input));
    
  }

  private static  String isPangram(String input) {

    HashSet<Character> alphabets = new HashSet<Character>();
    for(char ch ='a'; ch<='z';ch++){
      alphabets.add(ch);
    }
    for(char i : input.toLowerCase().toCharArray()){
      alphabets.remove(i);
    }
    
    if(alphabets.size() == 0){
      return "pangram";
    }
    
    return "not pangram";
  }
}