package com.pepcoding.dsa.bitmanipulation.level2;

import java.util.Scanner;

public class AllRepeatingExceptOne {
	// non repeating number
    private static int nonRepeatingNum(int[] arr) {
        int res = 0;
        for(int val : arr) {
            res = (res ^ val);
        }
        return res;
    }
    
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    //write your code here
    int res=nonRepeatingNum(arr);
    
    System.out.println(res);
  }


}
