package com.pepcoding.dsa.arraysstring.level2;

import java.util.Scanner;

public class WiggleSort1Array {
	 // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~
	  private static void swap(int[] arr, int i, int j) {
		        int temp = arr[i];
		        arr[i] = arr[j];
		        arr[j] = temp;
		    }

		    public static void wiggleSort(int[] arr) {
		        for(int i = 0; i < arr.length - 1; i++) {
		            if(i % 2 == 0) {
		                // even index
		                if(arr[i] > arr[i + 1]) {
		                    swap(arr, i, i + 1);
		                }
		            } else {
		                // odd index
		                if(arr[i] < arr[i + 1]) {
		                    swap(arr, i, i + 1);
		                }
		            }
		        } 
		    }

	  // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~
	  public static void main(String[] args) {
	    Scanner scn = new Scanner(System.in);

	    int n = scn.nextInt();
	    int[] arr = new int[n];

	    for (int i = 0; i < n; i++) {
	      arr[i] = scn.nextInt();
	    }

	    wiggleSort(arr);

	    for (int val : arr) {
	      System.out.print(val + " ");
	    }
	    System.out.println();
	  }

	}