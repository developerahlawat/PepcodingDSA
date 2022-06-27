package com.pepcoding.dsa.tree.tree.level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ConstructBinaryTreefromInorderLevelorderTraversal {
	 // https://practice.geeksforgeeks.org/problems/construct-tree-from-inorder-and-levelorder/1/
	public static Scanner scn = new Scanner(System.in);

	  static class TreeNode {
	    int val;
	    TreeNode left = null, right = null;

	    TreeNode(int val) {
	      this.val = val;
	    }
	  }
	  
	   private static TreeNode constructInLevel(int[] in, int inSt, int inEnd, ArrayList<Integer> level) {
	        if(level.size() == 0) return null;
	        TreeNode root = new TreeNode(level.get(0));
	        int indx = inSt;
	        HashSet<Integer> set = new HashSet<>();
	        while(in[indx] != root.val) {
	            set.add(in[indx]);
	            indx++;
	        }
	        ArrayList<Integer> llvl = new ArrayList<>(); // left level order
	        ArrayList<Integer> rlvl = new ArrayList<>(); // right level order

	        for(int i = 1; i < level.size(); i++) {
	            int val = level.get(i);
	            if(set.contains(val)) {
	                llvl.add(val);
	            } else {
	                rlvl.add(val);
	            }
	        }

	        root.left = constructInLevel(in, inSt, indx - 1, llvl);
	        root.right = constructInLevel(in, indx + 1, inEnd, rlvl);
	        return root;
	    }

	    public static TreeNode buildTree(int[] in, int[] level) {
	        ArrayList<Integer> lvl = new ArrayList<>();
	        for(int val : level) lvl.add(val);

	        return constructInLevel(in, 0, in.length - 1, lvl);
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

	  int[] InOrder = new int[n];
	  for (int i = 0; i < n; i++)
	    InOrder[i] = scn.nextInt();

	  int[] LevelOrder = new int[n];
	  for (int i = 0; i < n; i++)
	    LevelOrder[i] = scn.nextInt();

	  TreeNode root = buildTree(InOrder, LevelOrder);
	  display(root);
	}

	public static void main(String[] args) {
	  solve();
	}

	}