package com.pepcoding.dsa.searchingsorting.level2;

import java.util.Scanner;

public class CountZeroInSortedMatrix {

	  public static int countZeros(int[][]mat) {
	     int count = 0;

	        int i = 0;
	        int j = mat[0].length - 1;
	        while(i < mat.length && j >= 0) {
	            if(mat[i][j] == 1) {
	                j--;
	            } else {
	                count += (j + 1);
	                i++;
	            }
	        }
	        return count;
	  }

	  public static void main(String[]args) {
	    //input work
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();

	    int[][]mat = new int[n][n];

	    for (int i = 0; i < n; i++) {
	      for (int j = 0; j < n; j++) {
	        mat[i][j] = scn.nextInt();
	      }
	    }

	    System.out.println(countZeros(mat));
	  }
	}

