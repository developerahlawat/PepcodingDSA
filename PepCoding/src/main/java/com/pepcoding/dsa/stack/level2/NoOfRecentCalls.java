package com.pepcoding.dsa.stack.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class NoOfRecentCalls {
	// number of recent calls, leetcode 933, https://leetcode.com/problems/number-of-recent-calls/
    static class RecentCounter {

        Queue<Integer> qu;

        public RecentCounter() {
            qu = new ArrayDeque<>();
        }
        
        public int ping(int t) {
            qu.add(t);
            int start = t - 3000;
            while(qu.size() > 0 && qu.peek() < start) qu.remove();

            return qu.size();
        }
    }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    RecentCounter obj = new RecentCounter();

    while (read.ready()) {
      int val = Integer.parseInt(read.readLine());
      int ans = obj.ping(val);
      System.out.println(ans);
    }

  }
}