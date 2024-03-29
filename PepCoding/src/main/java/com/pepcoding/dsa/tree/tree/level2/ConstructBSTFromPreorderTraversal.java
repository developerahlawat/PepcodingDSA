package com.pepcoding.dsa.tree.tree.level2;

import java.util.Scanner;

public class ConstructBSTFromPreorderTraversal {
	 public static Scanner scn = new Scanner(System.in);

	    public static class TreeNode {
	        int val = 0;
	        TreeNode left = null;
	        TreeNode right = null;

	        TreeNode(int val) {
	            this.val = val;
	        }
	    }
	    
	     // leetcode 1008, https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
	    static int index = 0;
	    
	    private static TreeNode constructBST_Pre(int[] pre, int leftRange, int rightRange) {
	        if(index >= pre.length || pre[index] < leftRange || pre[index] > rightRange) {
	            return null;
	        }

	        int val = pre[index++];
	        TreeNode root = new TreeNode(val);
	        root.left = constructBST_Pre(pre, leftRange, val);
	        root.right = constructBST_Pre(pre, val, rightRange);
	        return root;
	    }

	    public static TreeNode bstFromPreorder(int[] pre) {
	         index = 0;
	        return constructBST_Pre(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
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

	        TreeNode root = bstFromPreorder(pre);
	        display(root);
	    }

	    public static void main(String[] args) {
	        solve();
	    }
	}