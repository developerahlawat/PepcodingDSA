package com.pepcoding.dsa.recursion.backtracking.level1;

import java.util.Scanner;

public class NQueens3 {
	/*
Place N queens in chess board such that no queen kill other.
ans- 0-1,1-3,2-0,3-2
Sol- only one queen can sit per column or row
	 */
	 public static void main(String[] args) throws Exception {
	        Scanner scn=new Scanner(System.in);
	        int n =scn.nextInt();
	        boolean[][] chess=new boolean[n][n];
	        printNQueens(chess,"",0);
	    }
	 
	 public static boolean isQueenSafe(boolean[][] chess,int row,int col) {
		 //check in col
		 for(int i=row-1;i>=0;i--) {
			 if(chess[i][col]==true) {
				 return false;
			 }
		 }
		 
		 //check in d1
		 for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--) {
			 if(chess[i][j]==true) {
				 return false;
			 }
		 }
		 
		 //check in d2
		 for(int i=row-1,j=col+1;i>=0 && j<chess.length;i--,j++) {
			 if(chess[i][j]==true) {
				 return false;
			 }
		 }
		 return true;  
		 
	 }

	    public static void printNQueens(boolean[][] chess, String asf, int row) {
	         if(row==chess.length) {
	        	 System.out.println(asf+".");
	        	 return;
	         }
	         
	         for(int col=0;col<chess.length;col++) {// as we can only place one in each col
	        	 if(isQueenSafe(chess,row,col)==true) {
	        		 //place the queen
	        		 chess[row][col]=true;
	        		 //make recursive call
	        		 printNQueens(chess, asf+row+"-"+col+",", row+1);
	        		 //unplace the queen
	        		 chess[row][col]=false;
	        	 }
	         }
	    }
}
