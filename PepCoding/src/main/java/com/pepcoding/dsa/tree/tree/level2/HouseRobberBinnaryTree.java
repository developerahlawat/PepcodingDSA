package com.pepcoding.dsa.tree.tree.level2;

import java.util.Scanner;

public class HouseRobberBinnaryTree {
	 public static Scanner scn = new Scanner(System.in);

	    public static class TreeNode {
	        int val = 0;
	        TreeNode left = null;
	        TreeNode right = null;

	        TreeNode(int val) {
	            this.val = val;
	        }
	    }

	   // leetcode 337, https://leetcode.com/problems/house-robber-iii/
	    private static class RPair {
	        int withRob;
	        int withoutRob;

	        RPair(int withRob, int withoutRob) {
	            this.withRob = withRob;
	            this.withoutRob = withoutRob;
	        }
	    }

	    private static RPair rob_rec(TreeNode root) {
	        if(root == null) {
	            return new RPair(0, 0);
	        }

	        RPair left = rob_rec(root.left);
	        RPair right = rob_rec(root.right);

	        int a = left.withRob;
	        int b = left.withoutRob;
	        int a_ = right.withRob;
	        int b_ = right.withoutRob;
	        int c = root.val;

	        // robbery on root, c + b + b_
	        int withRobbery = c + b + b_;
	        // no robbery, max(a, b) + max(a_, b_)
	        int withoutRobbery = Math.max(a, b) + Math.max(a_, b_);

	        return new RPair(withRobbery, withoutRobbery);
	    }

	    public static int HouseRobber(TreeNode root) {
	        RPair res = rob_rec(root);
	        return Math.max(res.withRob, res.withoutRob);
	    }

	    // input_Section_====================================================================

	    public static TreeNode createTree(int[] arr, int[] IDX) {
	        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
	            IDX[0]++;
	            return null;
	        }

	        TreeNode node = new TreeNode(arr[IDX[0]++]);
	        node.left = createTree(arr, IDX);
	        node.right = createTree(arr, IDX);

	        return node;
	    }

	    public static void solve() {
	        int n = scn.nextInt();
	        int[] arr = new int[n];
	        for (int i = 0; i < n; i++)
	            arr[i] = scn.nextInt();

	        int[] IDX = new int[1];
	        TreeNode root = createTree(arr, IDX);
	        System.out.println(HouseRobber(root));
	    }

	    public static void main(String[] args) {
	        solve();
	    }
	}