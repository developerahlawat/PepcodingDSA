package com.pepcoding.dsa.linkedlist.level2;

import java.util.Scanner;

public class MergeSortLinkedList {
	 public static Scanner scn = new Scanner(System.in);

	    public static class ListNode {
	        int val = 0;
	        ListNode next = null;

	        ListNode(int val) {
	            this.val = val;
	        }
	    }

	       public static ListNode mergeSort(ListNode head) {
	        if(head == null || head.next == null) return head;

	        ListNode mid = middleNode(head);
	        ListNode head2 = mid.next;
	        mid.next = null;

	        head = mergeSort(head);
	        head2 = mergeSort(head2);

	        ListNode res = mergeTwoLists(head, head2);
	        return res;
	    }
	    
	     public static ListNode middleNode(ListNode head) {
	        // mid 2
	         if(head == null) return head;

	        ListNode slow = head;
	        ListNode fast = head.next;

	        while(fast != null && fast.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return slow;
	    }
	    
	        public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	        if(list1 == null || list2 == null) return list1 == null ? list2 : list1;

	        ListNode head = new ListNode(-1);
	        ListNode temp = head;
	        ListNode t1 = list1;
	        ListNode t2 = list2;

	        while(t1 != null && t2 != null) {
	            if(t1.val < t2.val) {
	                temp.next = t1;
	                temp = t1;
	                t1 = t1.next;
	            } else {
	                temp.next = t2;
	                temp = t2;
	                t2 = t2.next;
	            }
	        }
	        temp.next = t1 == null ? t2 : t1;
	        return head.next;
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

	        ListNode head = mergeSort(h1);
	        printList(head);
	    }
}
