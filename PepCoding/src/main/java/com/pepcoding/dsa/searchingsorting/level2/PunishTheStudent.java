package com.pepcoding.dsa.searchingsorting.level2;

import java.util.Scanner;

public class PunishTheStudent {
	public static boolean shouldPunish(int[]roll, int[]marks, double avg) {
	    int swaps=0;
	    int n=roll.length;
	    
	    for(int itr=1;itr<=n-1;itr++) {
	    	for(int i=0;i<n-itr;i++) {
	    		if(roll[i]>roll[i+1]) {
	    				  swaps+=2;
	    				  int temp=roll[i];
	    				  roll[i]=roll[i+1];
	    				  roll[i+1]=temp;
	    			  }
	    		}
	    }
	   int oldMarks=0;
	    	
	   for(int i=0;i<marks.length;i++)
	     	oldMarks+=marks[i];
	    	
	    int newMarks=oldMarks-swaps;
	    
	    double navg=(newMarks*1.0)/n;
	    
	    return navg>=avg;
	    
	  }

	  public static void main(String[]args) {
	    //input work
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();

	    int[]roll = new int[n];

	    for (int i = 0; i < n; i++) {
	      roll[i] = scn.nextInt();
	    }

	    int[]marks = new int[n];

	    for (int i = 0; i < n; i++) {
	      marks[i] = scn.nextInt();
	    }

	    double avg = scn.nextDouble();

	    System.out.println(shouldPunish(roll, marks, avg));
	  }
	}

