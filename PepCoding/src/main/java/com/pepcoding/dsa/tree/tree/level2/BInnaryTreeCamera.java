package com.pepcoding.dsa.tree.tree.level2;

import java.util.Scanner;

public class BInnaryTreeCamera {
	 public static Scanner scn = new Scanner(System.in);

	    public static class TreeNode {
	        int val = 0;
	        TreeNode left = null;
	        TreeNode right = null;

	        TreeNode(int val) {
	            this.val = val;
	        }
	    }
	    
	     // leetcode 968, https://leetcode.com/problems/binary-tree-cameras/
	    static int camera = 0;
	    // state 0 -> camera is present
	    // state 1 -> I am covered
	    // state 2 -> I am unsafe

	    private static int minCameraCover_rec(TreeNode root) {
	        if(root == null) {
	            return 1; // null is safe, parent try to save yourself
	        }
	        int leftState = minCameraCover_rec(root.left);
	        int rightState = minCameraCover_rec(root.right);

	        // post area
	        if(leftState == 1 && rightState == 1) {
	            // root is unsafe
	            return 2;
	        } else if(leftState == 2 || rightState == 2) {
	            // camera is required
	            camera++;
	            return 0;
	        } else {
	            return 1;
	        }
	    }

	    public static int MinCamerasInBT(TreeNode root) {
	        camera = 0;
	        int finalState = minCameraCover_rec(root);
	        if(finalState == 2) camera++;

	        return camera;
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
	        System.out.println(MinCamerasInBT(root));

	    }

	    public static void main(String[] args) {
	        solve();
	    }
	}