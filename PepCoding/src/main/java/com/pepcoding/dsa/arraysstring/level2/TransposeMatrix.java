package com.pepcoding.dsa.arraysstring.level2;

public class TransposeMatrix {
	  // leetcode 867. https://leetcode.com/problems/transpose-matrix/
	//for mxn
	public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
       int col = matrix[0].length;

       int[][] res = new int[col][row];
       
       for(int r = 0; r < row; r++) {
           for(int c = 0; c < col; c++) {
               res[c][r] = matrix[r][c];
           }
       }
       return res;
   }
	
	 // tarnspose matrix of N*N, inplace
    public void transpose1(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            } 
        }
    }
}
