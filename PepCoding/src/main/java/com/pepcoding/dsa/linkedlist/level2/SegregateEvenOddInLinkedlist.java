package com.pepcoding.dsa.linkedlist.level2;

import java.util.Scanner;

public class SegregateEvenOddInLinkedlist {
	 public static class ListNode {
	        int val = 0;
	        ListNode next = null;

	        ListNode(int val) {
	            this.val = val;
	        }
	    }

	    public static ListNode segregateEvenOdd(ListNode head) {
	         if(head == null || head.next == null) return head;

	        ListNode ohead = new ListNode(-1);
	        ListNode ehead = new ListNode(-1);
	        ListNode t1 = ehead;
	        ListNode t2 = ohead;

	        for(ListNode temp = head; temp != null; temp = temp.next) {
	            if(temp.val % 2 == 0) {
	                // even 
	                t1.next = temp;
	                t1 = temp;
	            } else {
	                // odd
	                t2.next = temp;
	                t2 = temp;
	            }
	        }
	        t1.next = null;
	        t2.next = null;

	        t1.next = ohead.next;
	        return ehead.next;
	    }

	    public static void main(String[] args) {
	        Scanner scn = new Scanner(System.in);
	        int n = scn.nextInt();
	        ListNode dummy = new ListNode(-1);
	        ListNode prev = dummy;
	        while (n-- > 0) {
	            prev.next = new ListNode(scn.nextInt());
	            prev = prev.next;
	        }

	        ListNode head = segregateEvenOdd(dummy.next);
	        while (head != null) {
	            System.out.print(head.val + " ");
	            head = head.next;
	        }
	    }
}
