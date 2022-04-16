package com.pepcoding.dsa.bitmanipulation.level2;

import java.util.Scanner;

public class KernighanAlgorithm {
	 // kernighan's algorithm
    private static int countSetBit(int n) {
        int count = 0;
        while(n != 0) {
            int rsbm = (n & (-n));
            n = n - rsbm;
            count++;
        }
        return count;
    }

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //write your code here
    
    System.out.println(countSetBit(n));
  }

}