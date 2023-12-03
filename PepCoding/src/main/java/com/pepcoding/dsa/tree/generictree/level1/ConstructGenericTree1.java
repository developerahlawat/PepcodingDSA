package com.pepcoding.dsa.tree.generictree.level1;

import java.util.ArrayList;
import java.util.Stack;

public class ConstructGenericTree1 {

	public static class Node {
		int data;
		ArrayList<Node> children;

		public Node() {
			children = new ArrayList<>();
		}
	}

	public static Node construct(int[] arr) {
		Node rootnode = new Node();
		rootnode.data = arr[0];

		Stack<Node> st = new Stack<>();
		st.push(rootnode);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1)
				st.pop();
			else {
				Node n = new Node();
				n.data = arr[i];
				st.peek().children.add(n);
			}
		}
		return rootnode;
	}

	public static void display(Node node) {
		String s = "";
		s += node.data + " -> ";

		for (Node child : node.children)
			s += child.data + ", ";

		s += ". ";
		System.out.println();

		for (Node child : node.children) {
			display(child);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 20, 50, -1, 30, 70, -1, 80, -1, 90, -1, -1, 40, 100, -1, -1, -1 };
		Node root = construct(arr);
		display(root);
	}

}
