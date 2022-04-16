package com.pepcoding.dsa.arraysstring.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MeetingRoom1 {
	 // lintcode 920. https://www.lintcode.com/problem/920/
	    public static boolean meetingRooms(int intervals[][]){
	        if(intervals.length == 0) return true;
	        
	        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
	        
	        int lsp = intervals[0][0];
	        int lep = intervals[0][1];

	        for(int i = 1; i < intervals.length; i++) {
	            int sp = intervals[i][0];
	            int ep = intervals[i][1];

	            if(lep <= sp) {
	                lsp = sp;
	                lep = ep;
	            } else {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    public static void main(String args[]){
	        Scanner scn = new Scanner(System.in);

	        // Input Format
	        int n = scn.nextInt();
	        int input[][] = new int[n][2];

	        for(int i = 0 ; i <  n ; i++){
	            int sp = scn.nextInt();
	            int ep = scn.nextInt();

	            input[i][0] = sp;
	            input[i][1] = ep;
	        }

	        // Output Format
	        boolean res = meetingRooms(input);
	        System.out.println(res);
	    }
	}