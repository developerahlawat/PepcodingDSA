package com.pepcoding.dsa.hashmap.level1;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubsequenceHashMap {
	public static void main(String[] args) throws Exception {
	    Scanner scn=new Scanner(System.in);
	    
	    int n=scn.nextInt();
	    int[] arr=new int[n]; 
	    for(int i=0;i<arr.length;i++)
	    	arr[i]=scn.nextInt();
	    
	
	HashMap<Integer,Boolean> map=new HashMap<>();
	
	for(int val:arr)
		map.put(val, true);
	
	for(int val:arr)
		if(map.containsKey(val-1))
			map.put(val, false);
	
	int maxStart=0;
	int maxlength=0;
	
	for(int val:arr) {
		if(map.get(val)) {
			int tempLength=1;
			int tempStart=val;
			
			while(map.containsKey(tempStart+tempLength))
				tempLength++;
			
			if(tempLength>maxlength) {
				maxStart=tempStart;
				maxlength=tempLength;
			}
		}
	}
	for(int i=0;i<maxlength;i++)
		System.out.println(maxStart+i);
	
	}
}
