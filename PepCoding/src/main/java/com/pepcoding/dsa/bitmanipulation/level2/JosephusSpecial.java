package com.pepcoding.dsa.bitmanipulation.level2;

import java.util.Scanner;

public class JosephusSpecial {
	 // josephus from bit mathematics
    public static int josephusBit(int n){
        // find 2^x
        int i = 1;
        while(i * 2 <= n) {
            i = i * 2;
        }

        // we know that n = 2^x + l, l = n - 2^x
        int l = n - i; // i is 2^ x
        // result is 2 * l + 1
        return 2 * l + 1;
    }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(josephusBit(n));
  }
  

}
