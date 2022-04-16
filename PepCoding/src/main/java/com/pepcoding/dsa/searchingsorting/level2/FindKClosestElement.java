package com.pepcoding.dsa.searchingsorting.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindKClosestElement {
	
	//Best Approach
	 public List<Integer> findClosestElements(int[] arr, int k, int x) {
	        LinkedList<Integer> res = new LinkedList<>();
	        int lo = 0;
	        int hi = arr.length - 1;
	        int indx = 0;

	        while(lo <= hi) {
	            int mid = lo + (hi - lo) / 2;
	            indx = Math.abs(arr[indx] - x) > Math.abs(arr[mid] - x) ? mid: indx;
	            if(arr[mid] == x) {
	                break;
	            } else if(arr[mid] > x) {
	                hi = mid - 1;
	            } else {
	                lo = mid + 1;
	            }
	        }

	        lo = indx - 1;
	        hi = indx;
	        while(res.size() < k && lo >= 0 && hi < arr.length) {
	            if(Math.abs(x - arr[lo]) <= Math.abs(arr[hi] - x)) {
	                res.addFirst(arr[lo]);
	                lo--;
	            } else {
	                res.addLast(arr[hi]);
	                hi++;
	            }
	        }

	        while(res.size() < k && lo >= 0) {
	            res.addFirst(arr[lo]);
	            lo--;
	        }
	        
	        while(res.size() < k && hi < arr.length) {
	            res.addLast(arr[hi]);
	            hi++;
	        }
	        return res;
	    }
	 /*find 'k' closest element to 'x' and return answer list*/
    /*elements in answer list should be in ascending order*/
     public static class Pair implements Comparable<Pair> {
        int val;
        int dist;

        public Pair(int val, int dist) {
            this.val = val;
            this.dist = dist;
        }

        public int compareTo(Pair o) {
            if(this.dist == o.dist) {
                return this.val - o.val;
            } else {
                return this.dist - o.dist;
            }
        }
    }

    public static ArrayList<Integer> findClosest(int[]arr,int k,int x) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < arr.length; i++) {
            if(i < k) {
                pq.add(new Pair(arr[i], Math.abs(arr[i] - x)));
            } else {
                if(pq.peek().dist > Math.abs(arr[i] - x)) {
                    pq.remove();
                    pq.add(new Pair(arr[i], Math.abs(x - arr[i])));
                }
            }
        }

        while(pq.size() > 0) {
            res.add(pq.remove().val);
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[]args) {

        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();
        int x = scn.nextInt();

        ArrayList<Integer>ans = findClosest(arr,k,x);

        for(int val : ans) {
            System.out.print(val + " ");
        }

    }
    
    

}
