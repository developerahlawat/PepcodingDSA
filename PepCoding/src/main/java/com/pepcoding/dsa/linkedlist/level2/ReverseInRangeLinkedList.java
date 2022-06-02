package com.pepcoding.dsa.linkedlist.level2;

import java.util.Scanner;

public class ReverseInRangeLinkedList {
	public static Scanner scn = new Scanner(System.in);

	  public static class ListNode {
	    int val = 0;
	    ListNode next = null;

	    ListNode(int val) {
	      this.val = val;
	    }
	  }
	  
	    static ListNode thead;
	    static ListNode ttail;

	    public static void addFirst(ListNode node) {
	        if(thead == null) {
	            // first node of list
	            thead = ttail = node;
	        } else {
	            node.next = thead;
	            thead = node;
	        }
	    }
	    // reverse in range, leetcode 92, https://leetcode.com/problems/reverse-linked-list-ii/
		 
	    public static ListNode reverseInRange(ListNode head, int left, int right) {
	        if(left == right) return head;
	        thead = ttail = null;
	        ListNode prev = head;

	        for(int i = 1; i < left - 1; i++) {
	            prev = prev.next;
	        }

	        ListNode next = left != 1 ? prev.next : head;
	        for(int i = left; i <= right; i++) {
	            ListNode curr = next;
	            next = next.next;
	            curr.next = null;
	            addFirst(curr);
	        }
	    
	        if(left > 1) {
	            prev.next = thead;
	        } else {
	            head = thead;
	        }
	        ttail.next = next;
	        return head;  
	    }
	

	  public static void printList(ListNode node) {
	    while (node != null) {
	      System.out.print(node.val + " ");
	      node = node.next;
	    }
	  }
	   
	  public static ListNode createList(int n) {
	    ListNode dummy = new ListNode(-1);
	    ListNode prev = dummy;
	    while (n-- > 0) {
	      prev.next = new ListNode(scn.nextInt());
	      prev = prev.next;
	    }

	    return dummy.next;
	  }

	  public static void main(String[] args) {
	    int sz = scn.nextInt();
	    ListNode h1 = createList(sz);

	    int m = scn.nextInt();
	    int n = scn.nextInt();

	    h1 = reverseInRange(h1, m, n);
	    printList(h1);
	  }
	}
