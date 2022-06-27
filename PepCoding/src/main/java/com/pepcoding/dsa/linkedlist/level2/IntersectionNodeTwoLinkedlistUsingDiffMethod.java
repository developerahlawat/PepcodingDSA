package com.pepcoding.dsa.linkedlist.level2;

import java.util.Scanner;

public class IntersectionNodeTwoLinkedlistUsingDiffMethod {
	 // leetcode 160, https://leetcode.com/problems/intersection-of-two-linked-lists/
	   
	public static Scanner scn = new Scanner(System.in);

	public static class ListNode {
		int val = 0;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
		int sizeA = size(headA);
		int sizeB = size(headB);
		ListNode tempA = headA, tempB = headB;
		if (sizeA > sizeB) {
			// move tempA
			for (int i = 0; i < sizeA - sizeB; i++)
				tempA = tempA.next;
		} else {
			// move tempB
			for (int i = 0; i < sizeB - sizeA; i++)
				tempB = tempB.next;
		}

		// move tempA and tempB simultaneously
		while (tempA != null) {
			if (tempA == tempB) {
				return tempA;
			}
			tempA = tempA.next;
			tempB = tempB.next;
		}
		return null;
	}

	public static int size(ListNode head) {
		int count = 0;
		for (; head != null; head = head.next) {
			count++;
		}
		return count;
	}

	// Input_code===================================================

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

		int idx = scn.nextInt();

		ListNode head2 = makeList(scn.nextInt());

		if (idx >= 0) {
			ListNode curr = head1;
			while (idx-- > 0)
				curr = curr.next;

			ListNode prev = head2;
			while (prev.next != null)
				prev = prev.next;

			prev.next = curr;
		}

		ListNode ans = IntersectionNodeInTwoLL(head1, head2);
		System.out.println(ans != null ? ans.val : -1);
	}
}