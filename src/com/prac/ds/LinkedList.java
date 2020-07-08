package com.prac.ds;

public class LinkedList {

	class Node {
		Node next;
		int data;
	}

	Node head;
	
	//insert(int num);
	public void insert(int num) {
		if (head==null) {
			Node n = new Node();
			n.data = num;
			head = n;
		}
	}

}
