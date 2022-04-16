package com.pepcoding.dsa.stack.level2;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class DesignHitCount {

	 // design hit counter,
	    static class HitCounter {
	        Queue<Integer> qu;
	        /** Initialize your data structure here. */
	        public HitCounter() {
	            qu = new ArrayDeque<>();
	        }
	    
	        /** Record a hit.
	            @param timestamp - The current timestamp (in seconds granularity). */
	        public void hit(int timestamp) {
	            qu.add(timestamp);
	            int start = timestamp - 300 + 1;

	            while(qu.peek() < start) {
	                qu.remove();
	            }
	        }
	    
	        /** Return the number of hits in the past 5 minutes.
	            @param timestamp - The current timestamp (in seconds granularity). */
	        public int getHits(int timestamp) {
	            int start = timestamp - 300 + 1;
	            while(qu.peek() < start) {
	                qu.remove();
	            }
	            return qu.size();
	        }
	    }

	  public static void main(String[] args) throws java.lang.Exception {

	    Scanner scn = new Scanner(System.in);

	    HitCounter obj = new HitCounter();
	    while (true) {
	      String in = scn.next();

	      if (in.equals("hit")) {
	        obj.hit(scn.nextInt());
	      } else if (in.equals("getHits")) {
	        System.out.println(obj.getHits(scn.nextInt()));
	      } else {
	        break;
	      }
	    }
	  }
	

}
