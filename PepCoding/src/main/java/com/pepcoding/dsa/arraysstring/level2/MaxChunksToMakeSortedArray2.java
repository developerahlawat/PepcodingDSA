package com.pepcoding.dsa.arraysstring.level2;

import java.util.Scanner;

public class MaxChunksToMakeSortedArray2 {
	// ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static int maxChunksToSorted2(int[] arr) {
//        // this  code is self approach not working as of now
// 
//    	 int chunks = 0;
//         int leftMax = Integer.MIN_VALUE;
//         int rightMin=Integer.MAX_VALUE;
//         int i=0;
//         int j=arr.length-1;
//         while(i<arr.length) {
//          	leftMax=Math.max(leftMax,arr[i]);            
//          	rightMin=Math.min(rightMin,arr[j]);
//             if(i+1==j){
//                 i++;
//                if(leftMax<rightMin)
//                    chunks++;
//             }
//             else if(j>i)
//                 j--;
//             else
//                 j=arr.length-1;
//      }
//         return chunks;
    	
    
        	int n = arr.length;
            int[] rightMin = new int[n + 1];
            rightMin[n] = Integer.MAX_VALUE;
            int chunks = 0;
            // prepare right min
            for(int i = n - 1; i >= 0; i--) {
                rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
            }
            // solve count of using using a leftmax variable
            int leftmax = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                leftmax = Math.max(leftmax, arr[i]);

                if(leftmax <= rightMin[i + 1])
                    chunks++;
            }
            return chunks;
        }
         
     
    
     
     // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         int n = scn.nextInt();
         int[] arr = new int[n];

         for(int i = 0; i < n; i++) {
             arr[i] = scn.nextInt();
         }

         int res = maxChunksToSorted2(arr);
         System.out.println(res);
     }
}
