package com.pepcoding.dsa.bitmanipulation.level2;

import java.util.Scanner;

public class BasicsBitmanupulation {
	// basic of bits
    private static void basicBit(int n, int i, int j, int k, int m) {
        // 1. on ith bit
        int bm1 = (1 << i);
        System.out.println(n | bm1);
        // 2. off jth bit
        int bm2 = (1 << j);
        bm2 = (~bm2); // 1's compliment
        System.out.println(n & bm2);
        // 3. toggle kth bit
        int bm3 = (1 << k);
        System.out.println(n ^ bm3);
        // 4. check if mth bit is on or off
        int bm4 = (i << m);
        System.out.println((bm4 & n) == 0?false:true);
    }


  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();
    basicBit(n,i,j,k,m);
    //write your code here
  }
}
