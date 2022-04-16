package com.pepcoding.dsa.bitmanipulation.level2;

import java.util.Scanner;

public class ReduceNTo1 {
	// reduce from N to 1
	public static int reduceNto1(long n) {
		int count = 0;
		while (n != 1) {
			if ((n & 1) == 0) {
				// n % 2 == 0
				// even
				n = n / 2;
			} else if (n == 3) {
				// special case
				n = n - 1;
			} else if ((n & 3) == 1) {
				// n % 4 == 1
				// odd 1 type
				n = n - 1;
			} else if ((n & 3) == 3) {
				// n % 4 == 3
				// odd 2 type
				n = n + 1;
			}
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(reduceNto1(n));
	}

}
