package com.pepcoding.dsa.arraysstring.level2;

public class RotateMatrix {
	 // leetcode 48 https://leetcode.com/problems/rotate-image/
    private void reverseRow(int[][] arr) {
        for(int r = 0; r < arr.length; r++) {
            int left = 0;
            int right = arr[r].length - 1;

            while(left < right) {
                int temp = arr[r][left];
                arr[r][left] = arr[r][right];
                arr[r][right] = temp;

                left++;
                right--;
            }
        }
    }
    public void rotate(int[][] matrix) {
        transpose1(matrix);
        reverseRow(matrix);
    }
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
