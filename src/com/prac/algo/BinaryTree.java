package com.prac.algo;

import java.util.ArrayDeque;
import java.util.Queue;

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
				parent = focusNode; // start root as parent node
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
			} // while end
		}
	}


	public void inOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			inOrderTraverseTree(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraverseTree(focusNode.rightChild);
		}
	}

	public void breadthFirstTraverse(Node focusNode) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(focusNode);
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			System.out.print(n.key+"\t");

			if (n.leftChild != null)
				queue.add(n.leftChild);
			if (n.rightChild != null)
				queue.add(n.rightChild);

		}
	}

	public static void main(String[] args) {
		BinaryTree theTree = new BinaryTree();
		
		theTree.addNode(60, "root");
		theTree.addNode(40, "rl");
		theTree.addNode(80, "rr");
		theTree.addNode(30, "rl");
		theTree.addNode(45, "rl");
		theTree.addNode(67, "rl");
		theTree.addNode(95, "rl");
		theTree.addNode(65, "rl");
		System.out.println("Breadth First traversal");
		theTree.breadthFirstTraverse(theTree.root);
		
		System.out.println("\n \n Inorder Traversal");
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
