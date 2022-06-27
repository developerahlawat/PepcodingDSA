package com.pepcoding.dsa.tree.tree.level2;

import java.util.Scanner;

public class ConstructBinaryTreefromPostorderPreorderTraversal {
    // leetcode 889, https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
    
	public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

      private static TreeNode constructPrePost(int[] pre, int[] post, int preSt, int preEnd, int poSt, int poEnd) {
        // single element
        if(preSt == preEnd) {
            return new TreeNode(pre[preSt]);
        }
        // invalid range
        if(preSt > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preSt]);
        int ele = pre[preSt + 1];
        int indx = poSt;
        while(post[indx] != ele)
            indx++;
        
        int eleCount = indx - poSt + 1;
        root.left = constructPrePost(pre, post, preSt + 1, preSt + eleCount, poSt, indx);
        root.right = constructPrePost(pre, post, preSt + eleCount + 1, preEnd, indx + 1, poEnd - 1);
        return root;
    }
    
    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructPrePost(pre, post, 0, pre.length - 1, 0, post.length - 1);
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
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = constructFromPrePost(pre, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}