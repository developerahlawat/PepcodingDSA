package com.pepcoding.dsa.tree.binnarytree.level1;

import java.util.Stack;

public class ConstructBinnaryTree {
	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static class Pair {
		Node node;
		int state;

		public Pair(Node node, int state) {
			this.node = node;
			this.state = state;
		}

	}

	private static Node construct(Integer[] arr) {
		Node root = new Node(arr[0], null, null);
		Pair rootPair = new Pair(root, 1);

		Stack<Pair> st = new Stack<>();
		st.push(rootPair);

		int idx = 0;
		while (st.size() > 0) {
			Pair top = st.peek();
			if (top.state == 1) {
				idx++;
				if (arr[idx] != null) {
					Node leftNode = new Node(arr[idx], null, null);
					top.node.left = leftNode;

					Pair leftPair = new Pair(leftNode, 1);
					st.push(leftPair);
				} else
					top.node.left = null;

				top.state++;
			} else if (top.state == 2) {
				idx++;
				if (arr[idx] != null) {
					Node rightNode = new Node(arr[idx], null, null);
					top.node.right = rightNode;

					Pair rightPair = new Pair(rightNode, 1);
					st.push(rightPair);
				} else
					top.node.right = null;

				top.state++;

			} else
				st.pop();
		}
		return root;
	}

	public static void display(Node node) {
		if (node == null)
			return;

		String str = "";
		str += node.left == null ? "." : node.left.data + "";
		str += "<-" + node.data + "->";
		str += node.right == null ? "." : node.right.data + "";

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static void main(String[] args) {
		Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
				null };

		Node root = construct(arr);
		display(root);
	}

}
