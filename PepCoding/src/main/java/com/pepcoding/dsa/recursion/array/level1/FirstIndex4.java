package com.pepcoding.dsa.recursion.array.level1;

import java.util.Scanner;

public class FirstIndex4 {
	 public static void main(String[] args) throws Exception {
	       Scanner scn= new Scanner(System.in);
	        int n=scn.nextInt();
	        int []arr=new int[n];
	        for(int i=0;i<n;i++)
	          arr[i]=scn.nextInt();
	          
	          
	        int d=scn.nextInt();  
	        int fi=firstIndex(arr,0,d);
	        System.out.print(fi);
	    }

	    public static int firstIndex(int[] arr, int idx, int x){
	        if(idx==arr.length)
	          return -1;
	          
	        if(arr[idx]==x)
	          return idx;
	        else {
	        
	        int fisa=firstIndex(arr,idx+1,x);
	        return fisa;
	            
	        }
	    }

}
