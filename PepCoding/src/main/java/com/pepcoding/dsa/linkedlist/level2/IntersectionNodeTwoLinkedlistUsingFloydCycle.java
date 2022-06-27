package com.pepcoding.dsa.linkedlist.level2;

import java.util.Scanner;

public class IntersectionNodeTwoLinkedlistUsingFloydCycle {
	public static Scanner scn = new Scanner(System.in);

	public static class ListNode {
		int val = 0;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	// leetcode 160, https://leetcode.com/problems/intersection-of-two-linked-lists/

	public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
		// step 1 : find Tail and connect tail.next = headA
		ListNode tail = headA;
		while (tail.next != null)
			tail = tail.next;

		tail.next = headA;
		// step 2 : find starting node of cycle linkedlist (if cycle then result is node
		// otherwise null)
		ListNode res = detectCycle(headB);
		// step 3 : retain original structure, tail.next = null
		tail.next = null;
		// step 4 : return result
		return res;
	}

	public static ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		if (fast == null || fast.next == null)
			return null;

		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
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