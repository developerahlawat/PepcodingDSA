package com.pepcoding.dsa.arraysstring.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MergeInterval {

       // leetcode 56. https://leetcode.com/problems/merge-intervals/
    public static int[][] mergeIntervals(int intervals[][]){
        if(intervals.length==0) 
          return new int[0][0];
          
        Arrays.sort(intervals, (val1, val2) -> Integer.compare(val1[0], val2[0]));
        
        ArrayList<int[]> list = new ArrayList<>();
        int lsp = intervals[0][0]; // last interval starting point
        int lep = intervals[0][1]; // last interval ending point

        for(int i = 1; i < intervals.length; i++) {
            int sp = intervals[i][0];
            int ep = intervals[i][1];
            
            if(lep < sp) {
                // new interval is found
                int[] sublist = {lsp, lep};
                list.add(sublist);
                lsp = sp;
                lep = ep;
            } else if(lep < ep){
                // partially overlapping
                lep = ep;
            } else {
                // fully overlapping -> nothing to do
            }
        }
        
        int[] sublist = {lsp, lep};
        list.add(sublist);
        return list.toArray(new int[list.size()][]);
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
        int [][]output = mergeIntervals(input);

        System.out.print("[");
        for(int arr[] : output){
            System.out.print(Arrays.toString(arr));
        }
        System.out.println("]");
    }
}
