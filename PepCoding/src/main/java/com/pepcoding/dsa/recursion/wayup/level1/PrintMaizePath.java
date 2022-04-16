package com.pepcoding.dsa.recursion.wayup.level1;

import java.util.Scanner;

public class PrintMaizePath {
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();

		printMazePaths(1, 1, n, m, "");

	}

	// sr - source row
	// sc - source column
	// dr - destination row
	// dc - destination column
	public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
	        
	    if(sr>dr|| sc>dc)
	    		return;
	    if(sr==dr && sc==dc) {
	    	System.out.println(psf);
	    return;
	    }
	    
	    printMazePaths(sc,sc+1,dr,dc,psf+"h");

	    printMazePaths(sc+1,sc,dr,dc,psf+"v");
}
}