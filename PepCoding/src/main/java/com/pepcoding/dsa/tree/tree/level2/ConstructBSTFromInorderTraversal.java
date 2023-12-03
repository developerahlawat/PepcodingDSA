package com.pepcoding.dsa.tree.tree.level2;

import java.util.Scanner;

public class ConstructBSTFromInorderTraversal {
	 public static Scanner scn = new Scanner(System.in);

	    public static class TreeNode {
	        int val = 0;
	        TreeNode left = null;
	        TreeNode right = null;

	        TreeNode(int val) {
	            this.val = val;
	        }
	    }
	    
	     // leetcode 108, https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
	    private static TreeNode constructBST_In(int[] in, int lo, int hi) {
	        if(lo > hi) return null;
	        int mid = (lo + hi) / 2;
	        TreeNode root = new TreeNode(in[mid]);
	        root.left = constructBST_In(in, lo, mid - 1);
	        root.right = constructBST_In(in, mid + 1, hi);
	        return root;
	    }

	    public static TreeNode constructFromInOrder(int[] in) {
	        return constructBST_In(in, 0, in.length - 1);
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
	        int[] in = new int[n];
	        for (int i = 0; i < n; i++)
	            in[i] = scn.nextInt();

	        TreeNode root = constructFromInOrder(in);
	        display(root);
	    }

	    public static void main(String[] args) {
	        solve();
	    }
	}