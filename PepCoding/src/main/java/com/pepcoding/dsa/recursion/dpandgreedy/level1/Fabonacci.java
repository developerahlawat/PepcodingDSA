package com.pepcoding.dsa.recursion.dpandgreedy.level1;

import java.util.Scanner;

public class Fabonacci {
	
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [] dp=new int[n+1];
		System.out.println(fibTab(n));
		System.out.println(fibDp(n,dp));
		System.out.println(fibRecursion(n));
	}
	
	public static int fibTab(int n) {
		int [] dp=new int[n+1];

		for(int i=0;i<n;i++) {
			if(i==0||i==1)
				dp[i]=i;
			else
				dp[i]=dp[i-1]+dp[i-2];
		}

		return dp[n ];

	}

	public static int fibDp(int n,int [] dp) {
		if (n == 0 || n == 1)
			return n;

		if(dp[n]!=0)
			return dp[n];
		
		int nm1 = fibDp(n - 1,dp);
		int nm2 = fibDp(n - 2,dp);
		int fn = nm1 + nm2;
		dp[n]=fn;

		return fn;

	}
	
/* Basic approach
 * Getting repeated recusion calls,which puts load on memory
 * Take lots of memory for values <50*/	

	public static int fibRecursion(int n) {
		if (n == 0 || n == 1)
			return n;

		int nm1 = fibRecursion(n - 1);
		int nm2 = fibRecursion(n - 2);
		int fn = nm1 + nm2;

		return fn;

	}
}
