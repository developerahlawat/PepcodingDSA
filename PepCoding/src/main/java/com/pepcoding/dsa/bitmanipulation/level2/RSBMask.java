package com.pepcoding.dsa.bitmanipulation.level2;

import java.util.Scanner;

public class RSBMask {

	// print rightmost set bit mask
	private static void printRSBM(int n) {
		int rsbm = (n & (-n));
		System.out.println(Integer.toBinaryString(rsbm));
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		printRSBM(n);
		// write your code here
	}

}