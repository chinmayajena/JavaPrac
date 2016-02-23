package com.coursera.dsalgo;

public class QuickUnionUF {
  
  private int[] id;
  
  public QuickUnionUF(int N) {
    id = new int[N];
    for(int i=0; i < id.length;i++){
      id[i]=i;
    }
  }
  
  private int root(int i){
    while(i!=id[i])
      i= id[i];
      
    return i;
  }
  
  public boolean find(int p, int q) {
    return root(p)==root(q);
  }
  
  public void union(int p, int q) {
    int i = root(p);
    int j = root(q);
    id[i] = j;
  }

}
