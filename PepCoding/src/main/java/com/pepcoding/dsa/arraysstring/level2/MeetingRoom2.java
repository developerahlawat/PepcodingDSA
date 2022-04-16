package com.pepcoding.dsa.arraysstring.level2;

import java.util.Arrays;
import java.util.Scanner;

public class MeetingRoom2 {

	  public static int meetingRooms(int intervals[][]) {
	        int n = intervals.length;
	        int[] start = new int[n];
	        int[] end = new int[n];

	        for(int i = 0; i < n; i++) {
	            start[i] = intervals[i][0];
	            end[i] = intervals[i][1];
	        }

	        Arrays.sort(start);
	        Arrays.sort(end);

	        int i = 0;
	        int j = 0;
	        int cmax = 0, omax = 0;
	        while(i < n) {
	            if(start[i] < end[j]) {
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
	  public static void main(String args[]) {
	    Scanner scn = new Scanner(System.in);

	    // Input Format
	    int n = scn.nextInt();
	    int input[][] = new int[n][2];

	    for (int i = 0 ; i <  n ; i++) {
	      int sp = scn.nextInt();
	      int ep = scn.nextInt();

	      input[i][0] = sp;
	      input[i][1] = ep;
	    }

	    // Output Format
	    System.out.println(meetingRooms(input));
	  }
	}