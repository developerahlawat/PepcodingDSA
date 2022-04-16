package com.pepcoding.dsa.arraysstring.level2;

import java.util.Arrays;
import java.util.Scanner;

public class MinNoPlatform {
	public static int findPlatform(int[] arr, int[] dep,int n) {
	    Arrays.sort(arr);
	        Arrays.sort(dep);
	        int i = 0;
	        int j = 0;
	        int cmax = 0, omax = 0;
	        while(i < n) {
	            if(arr[i] <= dep[j]) {
	                cmax++;
	                i++;
	            } else {
	                cmax--;
	                j++;
	            }
	            omax = Math.max(omax, cmax);
	        }
	        return omax;
	  }

	  public static void main(String[] args) {
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    int[] arr = new int[n];
	    int[] dep = new int[n];

	    for (int i = 0; i < n; i++) {
	      arr[i] = scn.nextInt();
	    }

	    for (int i = 0; i < n; i++) {
	      dep[i] = scn.nextInt();
	    }

	    int plateforms = findPlatform(arr, dep,n);
	    System.out.println(plateforms);
	  }
	}

