package com.pepcoding.dsa.linkedlist.level2;

import java.util.Scanner;

public class RemoveAllDuplicateSortedLinkedList {
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
	        ListNode head2 = new ListNode(-1);
	        ListNode i = head2;
	        ListNode curr = head;
	        i.next = curr;
	        while(curr != null) {
	            curr = curr.next;
	            boolean flag = false;
	            while(curr != null && i.next.val == curr.val) {
	                flag = true; // help to identify duplicacy
	                curr = curr.next;
	            }

	            if(flag == true) {
	                i.next = curr;
	            } else {
	                i = i.next;
	            }
	        }
	        return head2.next;
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