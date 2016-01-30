package com.prac.algo;

import java.util.Stack;

public class QueueWithStack {

  private Stack<Integer> oldStack;
  private Stack<Integer> newStack;
  private int topElement;
  private int size;

  public QueueWithStack() {
    oldStack = new Stack<Integer>();
    newStack = new Stack<Integer>();
    topElement = -1;
    size = -1;
  }

  public boolean enque(int i) {
    boolean ret = true;
    oldStack.push(i);
    return ret;
  }

  public int deque() {
    if (newStack.isEmpty()) {
      while(oldStack.size() > 0) {
        topElement = oldStack.peek();
        newStack.push(topElement);
        oldStack.pop();
      }
    }
    if (!newStack.isEmpty()) {
      topElement = newStack.peek();
      newStack.pop();
    }

    return topElement;
  }

  public int size() {
    size = oldStack.size() + newStack.size();
    return size;
  }


  public static void main(String[] args) {
    QueueWithStack q = new QueueWithStack();
    for (int i = 1; i < 10; i++) {
      System.out.println("Enqueued item is :"+i);
      q.enque(i);
    }
    int length = q.size();
    for (int i = 0; i < length-5; i++) {
      System.out.println("The dequeued item is:"+q.deque());
    }
  }

}
