package com.pepcoding.dsa.graph.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NoOfEnclaves03 {
	
	 // leetcode 1020. https://leetcode.com/problems/number-of-enclaves/
	/*
	 * 
Number of valid one's from where we can't travel to edge of matrix.

	 */
	
	   static int[] xdir = {-1, 0, 1, 0};
	   static int[] ydir = {0, -1, 0, 1};
	    
	    private static void numEnclave_dfs(int[][] graph, int x, int y) {
	        graph[x][y] = 0;
	        for(int d = 0; d < 4; d++) {
	            int r = x + xdir[d];
	            int c = y + ydir[d];
	            if(r >= 0 && r < graph.length && c >= 0 
	                && c < graph[0].length && graph[r][c] != 0) {
	                numEnclave_dfs(graph, r, c);
	            }
	        }
	    }

	    public static int numEnclaves(int[][] grid) {
	    	//Make all one's which are on boundary(zeroth row and zeroth column and last row last column)
	    	 //to zero to remove them as they are invalid for enclave
	        
	    	// for 0th row
	        for(int c = 0; c < grid[0].length; c++) {
	            if(grid[0][c] == 1) {
	                numEnclave_dfs(grid, 0, c);
	            }
	        }
	        // for last row
	        for(int c = 0; c < grid[0].length; c++) {
	            if(grid[grid.length - 1][c] == 1) {
	                numEnclave_dfs(grid, grid.length - 1, c);
	            }
	        }
	        // for 0th col
	        for(int r = 0; r < grid.length; r++) {
	            if(grid[r][0] == 1) {
	                numEnclave_dfs(grid, r, 0);
	            }
	        }
	        // for last col
	        for(int r = 0; r < grid.length; r++) {
	            if(grid[r][grid[0].length - 1] == 1) {
	                numEnclave_dfs(grid, r, grid[0].length - 1);
	            }
	        }
	        // count remaining one
	        int one = 0;
	        for(int r = 0; r < grid.length; r++) {
	            for(int c = 0; c < grid[0].length; c++) {
	                if(grid[r][c] == 1) one++;
	            }
	        }
	        return one;
	    }
	    
	    public static int numEnclave(int[][] arr) {
	    	
	    	for(int i=0;i<arr.length;i++) {
	    		for(int j=0;j<arr[0].length;j++) {
	    			if(i ==0 || j==0 || i==arr.length-1 || j==arr[0].length-1) {
	    				if(arr[i][j] ==1) {
	    					dfs(arr,i,j);
	    				}
	    			}
	    		}
	    	}
	    	
	    	// count remaining one
	        int one = 0;
	        for(int r = 0; r < arr.length; r++) {
	            for(int c = 0; c < arr[0].length; c++) {
	                if(arr[r][c] == 1) one++;
	            }
	        }
	        return one;
	    }
	    
	    public static void dfs(int[][] arr,int i,int j) {
	    	if(i<0 || j<0 || i>=arr.length || j>arr.length || arr[i][j] ==0) {
	    		return;
	    	}
	    		
	    	arr[i][j]=0;
	    	dfs(arr,i+1,j);
	    	dfs(arr,i-1,j);
	    	dfs(arr,i,j+1);
	    	dfs(arr,i,j-1);
	    } 
	  

	
	  public static void main(String[] args) throws NumberFormatException, IOException {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		    String[] st = br.readLine().split(" ");
		    int m = Integer.parseInt(st[0]);
		    int n = Integer.parseInt(st[1]);

		    int[][] arr = new int[m][n];

		    for (int i = 0; i < m; i++) {
		      st = br.readLine().split(" ");
		      for (int j = 0; j < n; j++) {
		        arr[i][j] = Integer.parseInt(st[j]);
		      }
		    }

		    //recursion call is made in a diffrent way
		    System.out.println(numEnclaves(arr));
		    //recursion
		    System.out.println(numEnclaves(arr));

		  }
}