package com.pepcoding.dsa.arraysstring.level2;

import java.util.ArrayList;
import java.util.Scanner;

public class PascalTriangle2 {
	// ~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
	  public static ArrayList<Integer> pascalRow(int n) {
	    // leetcode 119 https://leetcode.com/problems/pascals-triangle-ii
	        ArrayList<Integer> res = new ArrayList<>();
	        long val = 1;
	        for(int r = 0; r <= n; r++) {
	            res.add((int)val);
	            val = val * (n - r) / (r + 1); 
	        }
	        return res;
	    }

	  // ~~~~~~~~~~~Input management~~~~~~~~~~~~~~~~
	  public static void main(String[] args) {
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();

	    ArrayList<Integer> res = pascalRow(n);
	    for (int val : res) {
	      System.out.print(val + " ");
	    }
	    System.out.println();
	  }
	}