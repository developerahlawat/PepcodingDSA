package com.pepcoding.dsa.tree.tree.level2;

import java.util.ArrayList;
import java.util.Scanner;

public class ConstructBSTFromLevelOrderTraversal {
	
	public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
	   public static Scanner scn = new Scanner(System.in);

	    // construct BST from levelOrder, https://practice.geeksforgeeks.org/problems/convert-level-order-traversal-to-bst/1
	    private static Node constructBST_levelOrder(ArrayList<Integer> level) {
	        if(level.size() == 0) {
	            return null;
	        }
	        Node root = new Node(level.get(0));
	        ArrayList<Integer> llvl = new ArrayList<>();
	        ArrayList<Integer> rlvl = new ArrayList<>();
	        for(int i = 1; i < level.size(); i++) {
	            int val = level.get(i);
	            if(val < root.data) {
	                llvl.add(val);
	            } else {
	                rlvl.add(val);
	            }
	        }

	        root.left = constructBST_levelOrder(llvl);
	        root.right = constructBST_levelOrder(rlvl);
	        return root;
	    }
	    
	    public Node constructBST(int[] arr) {
	        ArrayList<Integer> lvl = new ArrayList<>();
	        for(int val : arr) lvl.add(val);
	        return constructBST_levelOrder(lvl);
	    }
	    
	   

	    // input_section=================================================

	    public static void display(Node root) {
	        if (root == null)
	            return;

	        StringBuilder sb = new StringBuilder();
	        sb.append((root.left != null ? root.left.data : "."));
	        sb.append(" -> " + root.data + " <- ");
	        sb.append((root.right != null ? root.right.data : "."));

	        System.out.println(sb.toString());

	        display(root.left);
	        display(root.right);

	    }

	    public static void solve() {
	        int n = scn.nextInt();
	        ArrayList<Integer>levell=new ArrayList<>();
	        
	        for (int i = 0; i < n; i++)
	            levell.add(scn.nextInt());

	        Node root = constructBST_levelOrder(levell);
	        display(root);
	    }

	    public static void main(String[] args) {
	        solve();
	    }
}
