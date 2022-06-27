package com.pepcoding.dsa.tree.tree.level2;

import java.util.Scanner;

public class ConstructBinaryTreefromPostorderInorderTraversal {
	 // leetcode 106, https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
	   
	public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode constructPostIn(int[] post, int[] in, int poSt, int poEnd, int inSt, int inEnd) {
        if(poSt > poEnd)
            return null;

        TreeNode root = new TreeNode(post[poEnd]);

        int indx = inSt;
        while(in[indx] != root.val) 
            indx++;
        
        int eleCount = indx - inSt;
        root.left = constructPostIn(post, in, poSt, poSt + eleCount - 1, inSt, indx - 1);
        root.right = constructPostIn(post, in, poSt + eleCount, poEnd - 1, indx + 1, inEnd);

        return root;
    }
    
    public static TreeNode buildTree(int[] in, int[] post) {
        return constructPostIn(post, in, 0, post.length - 1, 0, in.length - 1);
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

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(in, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}