package com.pepcoding.dsa.bitmanipulation.level2;

import java.util.Scanner;

public class AllRepeatingExceptTwo {
	 public static void main(String[] args){
		    Scanner scn = new Scanner(System.in);
		    int n = scn.nextInt();
		    int[] arr = new int[n];
		    for(int i = 0 ; i < n; i++){
		      arr[i] = scn.nextInt();
		    }
		    allReeatingExceptTwoNum(arr);
		  }

		  // all repeating except two numbers
		    public static void allReeatingExceptTwoNum(int[] arr){
		        // find rsbm in xor of all numbersa
		        int xor = 0;
		        for(int val : arr) {
		            xor = (xor ^ val);
		        }

		        int rsbm = (xor & (-xor));

		        int x = 0; // rsbm bit is OFF
		        int y = 0; // rsbm bit is ON

		        for(int val : arr) {
		            if((val & rsbm) == 0) {
		                // rsbm bit is OFF
		                x = (x ^ val);
		            } else {
		                // rsbm bit is ON
		                y = (y ^ val);
		            }
		        }
		        if(x < y) {
		            System.out.println(x);
		            System.out.println(y);
		        } else {
		            System.out.println(y);
		            System.out.println(x);
		        }
		    }

		}

