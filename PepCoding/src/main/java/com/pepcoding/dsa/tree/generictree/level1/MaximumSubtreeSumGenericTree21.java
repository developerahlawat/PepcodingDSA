package com.pepcoding.dsa.tree.generictree.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class MaximumSubtreeSumGenericTree21 {
	private static class Node {
	    int data;
	    ArrayList<Node> children = new ArrayList<>();
	  }

	  public static void display(Node node) {
	    String str = node.data + " -> ";
	    for (Node child : node.children) {
	      str += child.data + ", ";
	    }
	    str += ".";
	    System.out.println(str);

	    for (Node child : node.children) {
	      display(child);
	    }
	  }

	  public static Node construct(int[] arr) {
	    Node root = null;

	    Stack<Node> st = new Stack<>();
	    for (int i = 0; i < arr.length; i++) {
	      if (arr[i] == -1) {
	        st.pop();
	      } else {
	        Node t = new Node();
	        t.data = arr[i];

	        if (st.size() > 0) {
	          st.peek().children.add(t);
	        } else {
	          root = t;
	        }

	        st.push(t);
	      }
	    }

	    return root;
	  }
	  
	  static int maxSumNode=0;
	  static int maxSum=Integer.MIN_VALUE;
	  static int retSumAndCalculateMSST(Node node) {
		  int sum=0;
		  
		  for (Node child : node.children) {
			int csum=retSumAndCalculateMSST(child);
			sum+=csum;
		}
		  
		  sum+=node.data;
		  if(sum>maxSum) {
			  maxSumNode=node.data;
			  maxSum=sum;
		  }
		  
		  return sum;
	  }

	  public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int[] arr = new int[n];
	    String[] values = br.readLine().split(" ");
	    for (int i = 0; i < n; i++) {
	      arr[i] = Integer.parseInt(values[i]);
	    }

	    Node root = construct(arr);
	    retSumAndCalculateMSST(root);
	    System.out.println(maxSumNode+"@"+maxSum);
	  }

}
