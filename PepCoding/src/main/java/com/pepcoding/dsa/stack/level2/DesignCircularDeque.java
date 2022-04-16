package com.pepcoding.dsa.stack.level2;

class MyCircularDeque {

    // leetcode 641, https://leetcode.com/problems/design-circular-deque/
    

        private class Node {
            int data;
            Node next;
    
            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
    
        private Node head = null;
        private Node tail = null;
        private int size = 0;
        private int limit = 0;
    
        public MyCircularDeque(int k) {
            this.limit = k;
        }
    
        private void handleAddWhenSize0(int val) {
            Node nn = new Node(val);
            head = tail = nn;
            size = 1;
        }
    
        public boolean insertFront(int value) {
            if(this.size == limit) {
                return false;
            } else if(this.size == 0) {
                handleAddWhenSize0(value);
            } else {
                Node nn = new Node(value);
                nn.next = head;
                head = nn;
                this.size++;
            }
            return true;
        }
    
        public boolean insertLast(int value) {
            if(this.size == limit) {
                return false;
            } else if(this.size == 0) {
                handleAddWhenSize0(value);
            } else {
                Node nn = new Node(value);
                tail.next = nn;
                tail = nn;
                this.size++;
            }
            return true;
        }
    
        private void handleRemoveWhenSize1() {
            head = tail = null;
            this.size = 0;
        }
    
        public boolean deleteFront() {
            if(this.size == 0) {
                return false;
            } else if(this.size == 1) {
                handleRemoveWhenSize1();
            } else {
                this.head = this.head.next;
                this.size--;
            }
            return true;
        }
    
        public boolean deleteLast() {
            if(this.size == 0) {
                return false;
            } else if(this.size == 1) {
                handleRemoveWhenSize1();
            } else {
                Node nn = head;
                while(nn.next != tail) {
                    nn = nn.next;
                }
                nn.next = null;
                this.tail = nn;
                this.size--;
            }
            return true;
        }
    
        public int getFront() {
            if(this.size == 0) return -1;
            return head.data;
        }
    
        public int getRear() {
            if(this.size == 0) return -1;
            return tail.data;
        }
    
        public boolean isEmpty() {
            return this.size == 0;
        }
    
        public boolean isFull() {
            return this.size == this.limit;
        }
    }


/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
