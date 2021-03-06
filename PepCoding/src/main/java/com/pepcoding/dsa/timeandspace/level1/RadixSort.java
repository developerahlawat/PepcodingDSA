package com.pepcoding.dsa.timeandspace.level1;

import java.util.Scanner;

public class RadixSort {
	public static void radixSort(int[] arr,int min,int max) {
	     
		int exp=1;
		while(max!=0) {
			max=max/10;
			countSort(arr, exp);
			exp*=10;			
		}
	  }

	  public static void countSort(int[] arr, int exp) {
	    int [] farr=new int[10];
	    
	    for(int i=0;i<arr.length;i++)
	    	farr[(arr[i]/exp)%10]++;  
		  
	    for(int i=1;i<farr.length;i++)
	    	farr[i]+=farr[i-1];
	    
	    int[] ans=new int[arr.length];
	    for(int i=arr.length-1;i>=0;i--) {
	    	int pos=farr[(arr[i]/exp)%10];
	    	ans[pos-1]=arr[i];
	    	farr[(arr[i]/exp)%10]--;
	    }
	    
	    for(int i=0;i<arr.length;i++)
	    	arr[i]=ans[i];  
	    	
	    System.out.print("After sorting on " + exp + " place -> ");
	    print(arr);
	  }

	  public static void print(int[] arr) {
	    for (int i = 0; i < arr.length; i++) {
	      System.out.print(arr[i] + " ");
	    }
	    System.out.println();
	  }

	  public static void main(String[] args) throws Exception {
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    int[] arr = new int[n];
	    int max = Integer.MIN_VALUE;
	    int min = Integer.MAX_VALUE;
	    for (int i = 0; i < n; i++) {
	      arr[i] = scn.nextInt();
	      max = Math.max(max, arr[i]);
	      min = Math.min(min, arr[i]);
	    }
	    radixSort(arr,min,max);
	    print(arr);
	  }

}
