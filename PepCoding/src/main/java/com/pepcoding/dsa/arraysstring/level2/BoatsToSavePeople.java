package com.pepcoding.dsa.arraysstring.level2;

import java.util.Arrays;
import java.util.Scanner;

public class BoatsToSavePeople {
	// leetcode 881. https://leetcode.com/problems/boats-to-save-people/
	  // ~~~~~~~~~~~User's Section~~~~~~~~~~~~
	  public static int numRescueBoats(int[] people, int limit) {
	   int boats = 0;
	        Arrays.sort(people);
	        int left = 0;
	        int right = people.length - 1;
	        while(left <= right) {
	            int sum = people[left] + people[right];
	            if(sum <= limit) {
	                left++;
	                right--;
	            } else {
	                right--;
	            }
	            boats++;
	        }
	        return boats;
	  }

	  // ~~~~~~~~~~Input Management~~~~~~~~~~~
	  public static void main(String[] args) {
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    int[] people = new int[n];

	    for (int i = 0; i < n; i++)
	      people[i] = scn.nextInt();

	    int limit = scn.nextInt();
	    int boats = numRescueBoats(people, limit);
	    System.out.println(boats);
	  }
	}