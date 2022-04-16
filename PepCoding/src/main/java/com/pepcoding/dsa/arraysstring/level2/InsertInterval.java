package com.pepcoding.dsa.arraysstring.level2;

import java.util.ArrayList;

public class InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result=new ArrayList<>();
       for(int []in : intervals) {         
           if(in[1]<newInterval[0]) {     
               result.add(in);
           } else if(newInterval[1]<in[0]) {
               result.add(newInterval);
               // smart move
               newInterval=in;
           } else {
               newInterval[0]=Math.min(in[0],newInterval[0]);
               newInterval[1]=Math.max(in[1],newInterval[1]);
           } 
       } 
       result.add(newInterval);
       return result.toArray(new int[result.size()][2]); 
   }
}
