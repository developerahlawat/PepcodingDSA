package com.pepcoding.dsa.tree.tree.level2;

import java.util.Scanner;

public class ConstructBSTFromPostorderTraversal {
	public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    static int index=0;
      // construct BST from postorder, https://practice.geeksforgeeks.org/problems/construct-bst-from-post-order/1/
    private static TreeNode constructBST_Post(int[] post, int leftRange, int rightRange) {
        if(index < 0 || post[index] < leftRange || post[index] > rightRange) {
            return null;
        }

        int val = post[index--];
        TreeNode root = new TreeNode(val);
        root.right = constructBST_Post(post, val, rightRange);
        root.left = constructBST_Post(post, leftRange, val);
        return root;
    }
    
    public static TreeNode bstFromPostorder(int post[]) {
        index = post.length - 1;
        return constructBST_Post(post, Integer.MIN_VALUE, Integer.MAX_VALUE);
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

        TreeNode root = bstFromPostorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}