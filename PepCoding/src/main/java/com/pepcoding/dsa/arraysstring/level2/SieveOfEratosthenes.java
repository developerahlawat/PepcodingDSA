package com.pepcoding.dsa.arraysstring.level2;

import java.util.Arrays;
import java.util.Scanner;

public class SieveOfEratosthenes {
	  // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static void printPrimeUsingSieve(int n) {
         boolean[] isprime = new boolean[n + 1];

        Arrays.fill(isprime, true); 
        /* this is depend on logic building, 
        i.e. is we consider arr[i] = false, 
        then i is prime so no need to fill is as true
        */

        for(int i = 2; i * i <= n; i++) {
            if(isprime[i] == false) {
                // then 'i' is not prime, and its factors are already solved
                continue;
            }

            for(int j = i + i; j <= n; j += i) {
                isprime[j] = false;
            }
        }

        for(int i = 2; i <= n; i++) {
            if(isprime[i] == true) {
                System.out.print(i + " ");
            }
        }
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {   
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPrimeUsingSieve(n);
    }
}