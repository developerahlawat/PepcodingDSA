package com.pepcoding.dsa.recursion.backtracking.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Permutation1 {
	public static void permutations(int[] boxes, int currentItem, int totalItem){
	   if(currentItem>totalItem) {
		   for(int i=0;i<boxes.length;i++)
			   System.out.print(boxes[i]);
		   
		   System.out.println();
		   return;
	   }
		for(int i=0;i<boxes.length;i++) {
			if(boxes[i]==0) {
				boxes[i]=currentItem;
				permutations(boxes,currentItem+1,totalItem);
				boxes[i]=0;
			}
		}
	  }

	  public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int nboxes = Integer.parseInt(br.readLine());
	    int ritems = Integer.parseInt(br.readLine());
	    permutations(new int[nboxes], 1, ritems);
	  }

	}