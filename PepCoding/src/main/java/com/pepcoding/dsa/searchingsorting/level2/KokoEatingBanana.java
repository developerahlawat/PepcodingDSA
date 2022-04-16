package com.pepcoding.dsa.searchingsorting.level2;

import java.util.Scanner;

public class KokoEatingBanana {
	
	  // leetcode 875. https://leetcode.com/problems/koko-eating-bananas/
	   
	private static boolean isPossible(int[] piles, int h, int speed) {
        int time = 0;
        for(int i = 0; i < piles.length; i++) {
            time += (int)Math.ceil(piles[i] * 1.0 / speed);
        }
        return time <= h;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int val : piles) 
            max = Math.max(max, val);
            
        int lo = 1;
        int hi = max;
        int k = Integer.MAX_VALUE;

        while(lo <= hi) {
            int speed = lo + (hi - lo) / 2;
            if(isPossible(piles, h, speed) == true) {
                k = speed;
                hi = speed - 1;
            } else {
                lo = speed + 1;
            }
        }
        return k;
    }
    
   

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]piles = new int[n];

        for(int i=0 ; i < n ; i++) {
            piles[i] = scn.nextInt();
        }

        int h = scn.nextInt();

        int speed = minEatingSpeed(piles,h);
        System.out.println(speed);
    }

}
