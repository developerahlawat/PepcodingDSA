package com.pepcoding.dsa.linkedlist.level2;

import java.util.Scanner;

public class FoldLinkedList {
	public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
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
    
    public static void fold(ListNode head) {
       if(head == null || head.next == null || head.next.next == null) return;
        // step 1. Segregate from middle
        ListNode mid = middleNode(head);
        ListNode head2 = mid.next;
        mid.next = null;
        // step 2 : Reverse second half
        head2 = reverseList(head2);
        // step 3. Merge Them according to logic
        ListNode temp1 = head;
        ListNode temp2 = head2;

        while(temp1 != null && temp2 != null) {
            ListNode next1 = temp1.next;
            ListNode next2 = temp2.next;

            temp1.next = temp2;
            temp2.next = next1;

            temp1 = next1;
            temp2 = next2;
        }  
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
        fold(head);
        printList(head);
    }
}