package com.pepcoding.dsa.recursion.array.level1;

import java.util.Scanner;

public class MaxOfArray3 {
	 public static void main(String[] args) throws Exception {
	       Scanner scn= new Scanner(System.in);
	        int n=scn.nextInt();
	        int []arr=new int[n];
	        for(int i=0;i<n;i++)
	          arr[i]=scn.nextInt();
	          
	        int max=maxOfArray(arr,0);
	        System.out.print(max);
	    }

	    public static int maxOfArray(int[] arr, int idx){
	        if(idx==arr.length-1)
	           return arr[idx];
	        
	        int misa=maxOfArray(arr,idx+1);
	        if(misa<arr[idx])
	          return arr[idx];
	        else  
	        return misa;
	    }

}
