package com.prac.algo;

import java.util.HashSet;
import java.util.Scanner;

public class Pangram {
//We promptly judged antique ivory buckles for the next prize    

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    System.out.println(input);
    System.out.println(isPangram(input));
    sc.close();
    
  }

  private static  String isPangram(String input) {

    HashSet<Character> alphabets = new HashSet<Character>();
    for(char ch ='a'; ch<='z';ch++){
      alphabets.add(ch);
    }
    
    String s = input.toLowerCase();
    
    for(int i = 0; i < s.length();i++){
      System.out.println(s.charAt(i));
      alphabets.remove(s.charAt(i));
    }
    
    if(alphabets.size() == 0){
      return "pangram";
    }
    
    return "not pangram";
  }

}
