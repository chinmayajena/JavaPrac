import java.io.*;

import java.util.*;
public class Solution {
public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    
    Set<Integer> set2 = new HashSet<Integer>();
    Set<Integer> set3 = new HashSet<Integer>();
    Set<Integer> set4 = new HashSet<Integer>();
    Set<Integer> set5 = new HashSet<Integer>();
    Set<Integer> set6 = new HashSet<Integer>();
    Set<Integer> set7 = new HashSet<Integer>();
    Set<Integer> set8 = new HashSet<Integer>();
    Set<Integer> set9 = new HashSet<Integer>();
    

    List<Integer> list = new ArrayList<Integer>();
    
    try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input=br.readLine())!=null){
          if(input.equals("done")){
            break;
          }
            list.add(Integer.parseInt(input));
        }
        
    }catch(IOException e){
       e.printStackTrace(); 
    }
    Math.pow(2, 2);
    
   /* for(int i : list){
        System.out.println(i);
    }*/
    
    for(int i = 1; i < list.size();i++){
        int id = list.get(i);
        for(int j = 2;j<10;j++){
            switch (j) {
                case 2: set2.add(id%2);
                        break;
                 case 3: set3.add(id%3);
                        break;
                 case 4: set4.add(id%4);
                        break;
                 case 5: set5.add(id%5);
                        break;
                 case 6: set6.add(id%6);
                        break;
                 case 7: set7.add(id%7);
                        break;
                 case 8: set8.add(id%8);
                        break;
                 case 9: set9.add(id%9);
                         break;
            }
        }
    }
    
    
    List<Integer> listOfModuloSets = new ArrayList<Integer>();
    
    if(set2.size() == list.size()-1 ){
        System.out.println("it is 2");
        listOfModuloSets.add(2);
    }
    
     if(set3.size() == list.size()-1 ){
        System.out.println("it is 3");
        listOfModuloSets.add(3);
    }
     if(set4.size() == list.size()-1 ){
        listOfModuloSets.add(4);
    }
     if(set5.size() ==list.size()-1 ){
        listOfModuloSets.add(5);
    }
     if(set6.size() ==list.size()-1 ){
        listOfModuloSets.add(6);
    }
     if(set7.size() ==list.size()-1 ){
        listOfModuloSets.add(7);
    }
     if(set8.size() ==list.size()-1 ){
        listOfModuloSets.add(8);
    }
     if(set9.size() ==list.size()-1 ){
        listOfModuloSets.add(9);
    }

    if(listOfModuloSets.size() > 0){
    Collections.sort(listOfModuloSets);
    System.out.println(listOfModuloSets.get(0));
    }else{
        System.out.println("No module found");
    }
}
}

