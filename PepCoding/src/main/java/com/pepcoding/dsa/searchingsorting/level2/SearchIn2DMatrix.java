package com.pepcoding.dsa.searchingsorting.level2;

import java.util.Scanner;

public class SearchIn2DMatrix {
	  private static int findRowIndx(int[][] matrix, int target) {
	        int indx = -1;
	        int lo = 0;
	        int hi = matrix.length - 1;

	        while(lo <= hi) {
	            int midRow = lo + (hi - lo) / 2;

	            if(matrix[midRow][0] <= target && target <= matrix[midRow][matrix[0].length - 1]) {
	                indx = midRow;
	                break;
	            } else if(target < matrix[midRow][0]) {
	                hi = midRow - 1;
	            } else {
	                lo = midRow + 1;
	            }
	        }
	        return indx;
	    }

	    private static int findInIthRow(int[][] matrix, int target, int row) {
	        int indx = -1;
	        int lo = 0;
	        int hi = matrix[0].length - 1;

	        while(lo <= hi) {
	            int mid = lo + (hi - lo) / 2;
	            if(matrix[row][mid] == target) {
	                indx = mid;
	                break;
	            } else if(matrix[row][mid] < target) {
	                lo = mid + 1;
	            } else {
	                hi = mid - 1;
	            }
	        }
	        return indx;
	    }

	    public static boolean search(int[][]matrix, int target) {
	        int rowIndx = findRowIndx(matrix, target);
	        if(rowIndx == -1) return false;
	        int colIndx = findInIthRow(matrix, target, rowIndx);
	        return colIndx != -1;
	    }

	    public static void main(String[]args) {
	        //input work
	        Scanner scn = new Scanner(System.in);
	        int m = scn.nextInt();
	        int n = scn.nextInt();

	        int[][]matrix = new int[m][n];

	        for(int i=0; i < m;i++) {
	            for(int j=0; j < n;j++) {
	                matrix[i][j] = scn.nextInt();
	            }
	        }

	        int target = scn.nextInt();

	        boolean isFound = search(matrix,target);
	        System.out.println(isFound);

	    }
	
}
