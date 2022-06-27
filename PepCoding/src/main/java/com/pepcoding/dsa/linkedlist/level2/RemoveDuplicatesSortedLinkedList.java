package com.pepcoding.dsa.linkedlist.level2;

import java.util.Scanner;

public class RemoveDuplicatesSortedLinkedList {
	 public static Scanner scn = new Scanner(System.in);

	    public static class ListNode {
	        int val = 0;
	        ListNode next = null;

	        ListNode(int val) {
	            this.val = val;
	        }
	    }

	    public static ListNode removeDuplicates(ListNode head) {
	       if(head == null) return head;
	        ListNode i = head;
	        ListNode curr = head.next;

	        while(curr != null) {
	            if(i.val != curr.val) {
	                i.next = curr;
	                i = curr;
	            }
	            curr = curr.next;
	        }
	        i.next = curr;
	        return head;
	    }

	    // InFput_code===================================================

	    public static void printList(ListNode node) {
	        while (node != null) {
	            System.out.print(node.val + " ");
	            node = node.next;
	        }
	    }

	    public static ListNode makeList(int n) {
	        ListNode dummy = new ListNode(-1);
	        ListNode prev = dummy;
	        while (n-- > 0) {
	            prev.next = new ListNode(scn.nextInt());
	            prev = prev.next;
	        }

	        return dummy.next;
	    }

	    public static void main(String[] args) {
	        ListNode head = makeList(scn.nextInt());

	        ListNode ans = removeDuplicates(head);
	        printList(ans);
	    }

	}