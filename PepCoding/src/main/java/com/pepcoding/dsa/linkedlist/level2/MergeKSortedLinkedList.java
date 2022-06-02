package com.pepcoding.dsa.linkedlist.level2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeKSortedLinkedList {
	public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    
     private static class pair implements Comparable<pair>{
        ListNode node;
        
        pair(ListNode node) {
            this.node = node;
        }

        public int compareTo(pair o) {
            return this.node.val - o.node.val;
        }
    }

    public static  ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<pair> pq = new PriorityQueue<>(); // min priority queue

        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                pq.add(new pair(lists[i]));
            }
        }

        ListNode head = new ListNode(-1);
        ListNode temp = head;

        while(pq.size() > 0) {
            pair rem = pq.remove();
            temp.next = rem.node;
            temp = temp.next;

            if(rem.node.next != null) {
                pq.add(new pair(rem.node.next));
            }
        }
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
        ListNode[] list = new ListNode[n];
        for (int i = 0; i < n; i++) {
            int m = scn.nextInt();
            list[i] = createList(m);
        }

        ListNode head = mergeKLists(list);
        printList(head);
    }
}
