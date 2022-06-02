package com.pepcoding.dsa.linkedlist.level2;

import java.util.Scanner;

public class MidLinkedList {
	 public static class ListNode {
	        int val = 0;
	        ListNode next = null;

	        ListNode(int val) {
	            this.val = val;
	        }
	    }

	 // leetcode 876, https://leetcode.com/problems/middle-of-the-linked-list/
	    public ListNode middleNode(ListNode head) {
	        // mid 2
	        ListNode slow = head;
	        ListNode fast = head;

	        while(fast != null && fast.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return slow;
	    }

	    // middle 1, i.e. last node of first half
	    public static ListNode midNode1(ListNode head) {
	        if(head == null) return head;

	        ListNode slow = head;
	        ListNode fast = head.next;

	        while(fast != null && fast.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return slow;
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

	        ListNode head = midNode1(dummy.next);
	        while (head != null) {
	            System.out.print(head.val + " ");
	            head = head.next;
	        }
	    }
	}

