package com.practice.functional;

import java.util.HashMap;

public class MapGetMaxValue {

  public static void main(String[] args) {
    
    HashMap<String,Integer> zoneRemainingTimeMap = new HashMap<String, Integer>();
    zoneRemainingTimeMap.put("DRY", 4);
    zoneRemainingTimeMap.put("FRESH", 2);
    zoneRemainingTimeMap.put("FPCASE",6);
    zoneRemainingTimeMap.put("TPCASE",7);
   System.out.println( zoneRemainingTimeMap.entrySet().stream().
       max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey());


  }

}
