package com.pepcoding.dsa.recursion.arraylist.level1;

import java.util.ArrayList;
import java.util.Scanner;

public class MaizePath4 {
	/*
	 * 
Given a 2d array-maize.
Need to travel from src->destination,
can only travel one step at a time horizontal or one step vertical
find all paths of travel
	 */
	public static void main(String[] args) throws Exception {
           
		Scanner scn = new Scanner(System.in);
		int n =scn.nextInt();
		int m=scn.nextInt();
		
		ArrayList<String> paths=getMazePaths(1,1,n,m);
		System.out.println(paths);
}

// sr - source row
// sc - source column
// dr - destination row
// dc - destination column
public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
   if(sr==dr && sc==dc) {
	   ArrayList<String> bres=new ArrayList<>();
	   bres.add("");
	   return bres;
   }
	
	ArrayList<String> hpaths=new ArrayList<>();
    ArrayList<String> vpaths=new ArrayList<>();
    if(sc<dc)
	 hpaths=getMazePaths(sr,sc+1,dr,dc);
    if(sr<dr)		
      vpaths=getMazePaths(sr+1,sc,dr,dc);
    
    ArrayList<String> paths= new ArrayList<>();
    
    for(String hpath:hpaths)
    	paths.add("h"+hpath);

    for(String vpath:vpaths)
      	paths.add("v"+vpath);
    
    return paths;

}

}
