package com.pepcoding.dsa.recursion.dpandgreedy.level1;

import java.util.Scanner;

public class ClimbStairMinimumMoves {
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] dp = new int[n + 1];
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=scn.nextInt();

		System.out.println(csMmTab(arr));
		System.out.println(csMmGready(arr));
		// System.out.println(csMmDp(n,dp));
		// System.out.println(csMmRec(n));
	}

	public static int csMmGready(int[] arr) {
	int steps=0;
	
	for(int i=0;i<arr.length;i++) {
		if(arr[i]==0)
			break;
		
		int max=0;
		int maxidx=0;
		for(int jump=1;jump<=arr[i];jump++) {
			int j=i+jump;
			if(j==arr.length-1) {
				steps++;
				return jump;
			}
			if(j+arr[j]>=max) {
				max=j+arr[j];
				maxidx=j;
			}
		}
		i=maxidx;
		steps++;
	}
	return Integer.MAX_VALUE;
	}
	public static int csMmTab(int[] arr) {
		int[] dp=new int[arr.length];
		
		for(int i=dp.length-2;i>=0;i--) {
			int min =Integer.MAX_VALUE-1;
			for(int jump=1;jump<=arr[i];jump++)
				if(i+jump<dp.length)
					min=Math.min(min, dp[i+jump]);
	
		  dp[i]=1+min;
	    }
	  return dp[0];
	}

}
