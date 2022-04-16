package com.pepcoding.dsa.timeandspace.level1;

import java.util.Scanner;

public class CountSort {
	public static void countSort(int[] arr, int min, int max) {
		   //write your code here
		int[] farr=new int[max-min+1];
		
		//create freq array
		for(int i=0;i<arr.length;i++)
			farr[arr[i]-min]++;
		
		//convert freq array into prefix sum array
		for(int i=1;i<farr.length;i++)
			farr[i]+=farr[i-1];
		
		//create ans array
		int [] ans=new int[arr.length];	
		for(int i=arr.length;i>=0;i--) {
			int pos=farr[arr[i]-min];
			ans[pos-1]=arr[i];
			farr[arr[i]-min]--;
		}
		
		//fill org array
		for(int i=1;i<arr.length;i++)
			arr[i]=ans[i];
		
		  }

		  public static void print(int[] arr) {
		    for (int i = 0; i < arr.length; i++) {
		      System.out.println(arr[i]);
		    }
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
		    countSort(arr,min,max);
		    print(arr);
		  }

}
