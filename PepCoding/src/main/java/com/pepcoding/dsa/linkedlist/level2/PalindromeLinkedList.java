package com.pepcoding.dsa.linkedlist.level2;

import java.util.Scanner;

public class PalindromeLinkedList {
	 public static class ListNode {
	        int val = 0;
	        ListNode next = null;

	        ListNode(int val) {
	            this.val = val;
	        }
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
	    
	     public static ListNode middleNode(ListNode head) {
	        // mid 2
	        ListNode slow = head;
	        ListNode fast = head;

	        while(fast != null && fast.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return slow;
	    }
	    
	    public static boolean isPalindrome(ListNode head) {
	        if(head == null) return false;
	        boolean isPalindrome = true;

	        // step 1 : find middle 1
	        ListNode mid = middleNode(head);
	        // step 2 : make new head
	        ListNode head2 = mid;
	        mid = null;
	        // step 3 : reverse head2
	        head2 = reverseList(head2);
	        // step 4 : Apply logic to check if it is palindrome or not
	        ListNode temp1 = head;
	        ListNode temp2 = head2;

	        while(temp1 != null && temp2 != null) {
	            if(temp1.val != temp2.val) {
	                isPalindrome = false;
	                break;
	            }
	            temp1 = temp1.next;
	            temp2 = temp2.next;
	        }

	        // if we have to preserve original list
	        head2 = reverseList(head2);
	        mid = head2;

	        return isPalindrome;
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

	        System.out.println(isPalindrome(dummy.next));
	    }
	
}
