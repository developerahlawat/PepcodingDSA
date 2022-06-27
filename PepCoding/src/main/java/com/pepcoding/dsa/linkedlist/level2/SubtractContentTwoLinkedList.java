package com.pepcoding.dsa.linkedlist.level2;

import java.util.Scanner;

public class SubtractContentTwoLinkedList {
	public static Scanner scn = new Scanner(System.in);

	public static class ListNode {
		int val = 0;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
		l1 = reverseList(l1);
		l2 = reverseList(l2);
		ListNode i = l1;
		ListNode j = l2;
		ListNode head = new ListNode(-1);
		ListNode temp = head;
		int borrow = 0;
		while (i != null) {
			int ival = i == null ? 0 : i.val;
			i = i == null ? null : i.next;
			int jval = j == null ? 0 : j.val;
			j = j == null ? null : j.next;
			int diff = ival - jval + borrow;
			if(diff<0)
			{
				borrow=-1;
				diff+=10;
			}else {
				borrow=0;
			}
			ListNode nn = new ListNode(diff);
			temp.next = nn;
			temp = nn;
			
			i=i.next;
			if(j!=null)
				j=j.next;
		}
		head = reverseList(head.next);
		l1 = reverseList(l1);
		l2 = reverseList(l2);
		return head;
	}

	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
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
		ListNode head1 = makeList(scn.nextInt());
		ListNode head2 = makeList(scn.nextInt());

		ListNode ans = subtractTwoNumbers(head1, head2);
		printList(ans);
	}

}