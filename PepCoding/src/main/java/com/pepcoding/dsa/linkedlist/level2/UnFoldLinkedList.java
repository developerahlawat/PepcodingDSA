package com.pepcoding.dsa.linkedlist.level2;

import java.util.Scanner;

public class UnFoldLinkedList {
	 public static class ListNode {
	        int val = 0;
	        ListNode next = null;

	        ListNode(int val) {
	            this.val = val;
	        }
	    }

	    public static void unfold(ListNode head) {
	 if(head == null || head.next == null || head.next.next == null) return;

	        ListNode oh = new ListNode(-1);
	        ListNode eh = new ListNode(-1);

	        ListNode t1 = eh;
	        ListNode t2 = oh;
	        int indx = 0;
	        for(ListNode temp = head; temp != null; temp = temp.next, indx++) {
	            if(indx % 2 == 0) {
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
	        oh = reverseList(oh.next);
	        t1.next = oh;
	    }
	    
	        public static ListNode reverseList(ListNode head) {
	        ListNode prev = null;
	        ListNode curr = head;

	        while(curr != null) {
	            ListNode next = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = next;
	        }
	        return prev;
	    }

	    static void printList(ListNode node) {
	        while (node != null) {
	            System.out.print(node.val + " ");
	            node = node.next;
	        }
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

	        ListNode head = dummy.next;
	        unfold(head);
	        printList(head);
	    }
}
