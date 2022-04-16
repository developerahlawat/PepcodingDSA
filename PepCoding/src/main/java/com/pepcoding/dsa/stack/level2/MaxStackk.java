package com.pepcoding.dsa.stack.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class MaxStackk {
	// max stack, portal
    public static class MaxStack {
        Stack<Integer> vstack; // value stack
        Stack<Integer> mstack; // max stack

        public MaxStack() {
            vstack = new Stack<>();
            mstack = new Stack<>();
        }
    
        public void push(int x) {
            vstack.push(x);
            if(mstack.size() == 0) {
                mstack.push(x);
            } else {
                mstack.push(Math.max(mstack.peek(), x));
            }
        }
    
        public int pop() {
            mstack.pop();
            return vstack.pop();
        }
    
        public int top() {
            return vstack.peek();
        }
    
        public int peekMax() {
            return mstack.peek();
        }
    
        public int popMax() {
            int max = mstack.peek();
            Stack<Integer> helper = new Stack<>();
            while(vstack.peek() != max) {
                mstack.pop();
                helper.push(vstack.pop());
            }
            vstack.pop();
            mstack.pop();
            while(helper.size() > 0) {
                push(helper.pop());
            }
            return max;
        }
    
    }


  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    MaxStack maxst = new MaxStack();

    while (read.ready()) {
      String []inp = read.readLine().split(" ");

      switch (inp[0]) {
        case "pop":
          System.out.println(maxst.pop());
          break;
        case "top":
          System.out.println(maxst.top());
          break;
        case "popMax":
          System.out.println(maxst.popMax());
          break;
        case "peekMax":
          System.out.println(maxst.peekMax());
          break;
        case "push":
          maxst.push(Integer.parseInt(inp[1]));
          break;
      }

    }

  }
}
