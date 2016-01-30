package com.prac.algo;

public class BinaryTree {
  
  Node root;
  
  public void addNode(int key, String name) {
    Node newNode = new Node(key, name);
    if (root == null) {
      root = newNode;
    } else {
      Node focusNode = root;
      Node parent;
      while (true) {
        parent = focusNode; //start root as parent node
        if (key <= focusNode.key) {
          focusNode = focusNode.leftChild;

          if (focusNode == null) {
            parent.leftChild = newNode;
            return;
          }
        } else {
          focusNode = focusNode.rightChild;
          if (focusNode == null) {
            parent.rightChild = newNode;
            return;
          }
        }
      }// while end
    }
  }

  
  private static int count = 0;
  public void inOrderTraverseTree(Node focusNode) {
    if(focusNode!=null){
      System.out.println(++count);
      inOrderTraverseTree(focusNode.leftChild);
      System.out.println(focusNode);
      inOrderTraverseTree(focusNode.rightChild);
    }
  }
  
  

  public static void main(String[] args) {
    
    BinaryTree theTree = new BinaryTree();
    theTree.addNode(33, "Bhubaneswar");
    theTree.addNode(50, "Boss");
    theTree.addNode(25,"Blore");
    theTree.addNode(32,"ret");
    theTree.addNode(31, "Kolkat");
    theTree.inOrderTraverseTree(theTree.root);
  }

}


class Node {

  int key;
  String name;

  Node leftChild;
  Node rightChild;

  public Node(int key, String name) {
    this.key = key;
    this.name = name;

  }


  public String toString() {
    return name + " has a key " + key;

  }

}
