package com.pepcoding.dsa.linkedlist.level2;

import java.util.Scanner;

public class ReverseKGroupLinkedList {
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
	    public static int size(ListNode head) {
	        int count = 0;
	        for(; head != null; head = head.next) {
	            count++;
	        }
	        return count;
	    }

	    // leetcode 25, https://leetcode.com/problems/reverse-nodes-in-k-group/
	    public static ListNode reverseInKGroup(ListNode ohead, int k) {
	        if(ohead == null || ohead.next == null || k == 1 || k==0) return ohead;
	        // ohead -> original head
	        int sz = size(ohead);
	        ListNode head = null;
	        ListNode tail = null;
	        thead = ttail = null;
	        ListNode temp = ohead;
	        while(true) {
	            if(sz >= k) {
	                thead = ttail = null;
	                for(int i = 0; i < k; i++) {
	                    ListNode curr = temp;
	                    temp = temp.next;
	                    curr.next = null;
	                    addFirst(curr);
	                }
	                if(head == null) {
	                    head = thead;
	                    tail = ttail;
	                } else {
	                    tail.next = thead;
	                    tail = ttail;
	                }
	                sz -= k;
	            } else {
	                tail.next = temp;
	                break;
	            }
	        }
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
	        int n = scn.nextInt();
	        ListNode h1 = createList(n);

	        int k = scn.nextInt();
	        h1 = reverseInKGroup(h1, k);
	        printList(h1);
	    }
}
