package com.pepcoding.dsa.searchingsorting.level2;

import java.util.Scanner;

public class FacingTheSun {
	  public static int countBuildings(int[]ht) {
		    int max = ht[0];
		        int count = 1;
		        
		        for(int i = 1; i < ht.length; i++) {
		            if(ht[i] > max) {
		                count++;
		                max = ht[i];
		            }
		        }
		        return count;
		  }

		  public static void main(String[]args) {
		    //input work
		    Scanner scn = new Scanner(System.in);
		    int n = scn.nextInt();
		    int[]ht = new int[n];

		    for (int i = 0; i < n; i++) {
		      ht[i] = scn.nextInt();
		    }

		    System.out.println(countBuildings(ht));
		  }
		}