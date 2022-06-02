package com.pepcoding.dsa.linkedlist.level1;

public class ReverseUsingAddFirstLinkedList {
	public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
	
	// reverse using add first method
    static ListNode thead;
    static ListNode ttail;

    public static void addFirst(ListNode node) {
        if(thead == null) {
            // first node of list
            thead = ttail = node;
        } else {
            node.next = thead;
            thead = node;
        }
    }

    public static ListNode reverseUsingAddFirst(ListNode head) {
        thead = ttail = null;
        ListNode next = head;
        while(next != null) {
            ListNode curr = next;
            next = next.next;
            curr.next = null;
            addFirst(curr);
        }
        return thead;
    }
}
