package com.pepcoding.dsa.tree.tree.level2;

import java.util.Scanner;

public class ConstructBinaryTreefromPreorderInorderTraversal {
	public static Scanner scn = new Scanner(System.in);
	// leetcode 105,
	// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int val) {
			this.val = val;
		}
	}

	private static TreeNode constructPreIn(int[] pre, int[] in, int preSt, int preEnd, int inSt, int inEnd) {
		if (preSt > preEnd) {
			return null;
		}

		TreeNode root = new TreeNode(pre[preSt]);
		int indx = inSt;
		while (in[indx] != root.val)
			indx++;

		int eleCount = indx - inSt;
		root.left = constructPreIn(pre, in, preSt + 1, preSt + eleCount, inSt, indx - 1);
		root.right = constructPreIn(pre, in, preSt + eleCount + 1, preEnd, indx + 1, inEnd);
		return root;
	}

	public static TreeNode buildTree(int[] pre, int[] in) {
		return constructPreIn(pre, in, 0, pre.length - 1, 0, in.length - 1);
	}

	// input_section=================================================

	public static void display(TreeNode node) {
		if (node == null)
			return;

		StringBuilder sb = new StringBuilder();
		sb.append((node.left != null ? node.left.val : "."));
		sb.append(" -> " + node.val + " <- ");
		sb.append((node.right != null ? node.right.val : "."));

		System.out.println(sb.toString());

		display(node.left);
		display(node.right);

	}

	public static void solve() {
		int n = scn.nextInt();
		int[] pre = new int[n];
		for (int i = 0; i < n; i++)
			pre[i] = scn.nextInt();

		int[] in = new int[n];
		for (int i = 0; i < n; i++)
			in[i] = scn.nextInt();

		TreeNode root = buildTree(pre, in);
		display(root);
	}

	public static void main(String[] args) {
		solve();
	}
}
