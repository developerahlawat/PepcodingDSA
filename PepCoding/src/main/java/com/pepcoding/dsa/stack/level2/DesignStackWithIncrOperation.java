package com.pepcoding.dsa.stack.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DesignStackWithIncrOperation {
	 // leetcode 1381, https://leetcode.com/problems/design-a-stack-with-increment-operation/
    public static class CustomStack {

        int[] val;
        int[] inc;
        int top;
        public CustomStack(int maxSize) {
            val = new int[maxSize];
            inc = new int[maxSize];
            top = -1;
        }
        
        public void push(int x) {
            if(top + 1 == val.length) {
                return;
            }

            val[top + 1] = x;
            top++;
        }
        
        public int pop() {
            if(top == -1) {
                return -1;
            }

            int value = val[top] + inc[top];
            if(top != 0) {
                inc[top - 1] += inc[top];
            }
            // reset old increment
            inc[top] = 0;
            top--;
            return value;
        }
        
        public void increment(int k, int val) {
            if(top == -1) return;
            if(k > top + 1) {
                inc[top] += val;
            } else {
                inc[k - 1] += val;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int maxsize = Integer.parseInt(read.readLine());

        CustomStack cs = new CustomStack(maxsize);
        
        while(true){
            String task[] = read.readLine().split(" ");
            if(task[0].equals("push")){
                cs.push(Integer.parseInt(task[1]));
            }else if(task[0].equals("pop")){
                System.out.println(cs.pop());
            }else if(task[0].equals("increment")){
                cs.increment(Integer.parseInt(task[1]), Integer.parseInt(task[2]));
            }else{
                break;
            }
        }
        System.out.println("exit");
    }
}
