package com.pepcoding.dsa.stack.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class AsteriodCollision {
	 // leetcode 735, https://leetcode.com/problems/asteroid-collision/
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int val : asteroids) {
            if(val > 0) {
                st.push(val);
                continue;
            }
            // val is -ve
            // peek is positive but smaller in temrs of size then pop untile this condition will not break
            while(st.size() > 0 && st.peek() < -val && st.peek() > 0) {
                st.pop();
            }
            if(st.size() > 0 && st.peek() == -val) {
                st.pop(); // equal in size but opposite in direction
            } else if(st.size() == 0 || st.peek() < 0) {
                st.push(val);
            } else {
                // nothing to do
            }
        }
        int[] res = new int[st.size()];
        for(int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int arr[] = new int[n];
    for (int i = 0; i < n; i++)arr[i] = Integer.parseInt(read.readLine());
    int result[] = asteroidCollision(arr);

    System.out.println(result.length);
    for (int e : result) {
      System.out.println(e);
    }

  }
}