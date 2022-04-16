package com.pepcoding.dsa.recursion.dpandgreedy.level1;

import java.util.Scanner;

public class ClimbStairs {
	public static void main(String[] args) throws Exception {
        Scanner scn =new Scanner(System.in);
        int n =scn.nextInt();
        int[] dp=new int[n+1];

        System.out.println(csTab(n));
        System.out.println(csDp(n,dp));
        System.out.println(csRec(n));
    } 
	
   public static int csDp(int n,int[] dp) {
	   if(n<0)
		   return 0;
	   
	   if(n==0)
		   return 1;
	   
	   if(dp[n]!=0)
		   return dp[n];
	   
	   int x=csDp(n-1,dp);
	   int y=csDp(n-2,dp);
	   int z=csDp(n-3,dp);
	   
	   int ans =x+y+z;
	   dp[n]=ans;
	   return ans;  
   } 
   
   public static int csRec(int n) {
	   if(n<0)
		   return 0;
	   
	   if(n==0)
		   return 1;
	   
	   int x=csRec(n-1);
	   int y=csRec(n-2);
	   int z=csRec(n-3);
	   
	   int ans =x+y+z;
	   return ans;
   }
   
   public static int csTab(int n) {
	   int [] dp=new int[n+1];
	   dp[0]=1;
	   
	   for(int i=1;i<=n;i++) {
		   dp[i]=dp[i-1];
		   if(i-2>=0)
			   dp[i]+=dp[i-2];
		   if(i-3>=0)
			   dp[i]+=dp[i-3];
	   }
	   return dp[n];
   }
	
}
 
