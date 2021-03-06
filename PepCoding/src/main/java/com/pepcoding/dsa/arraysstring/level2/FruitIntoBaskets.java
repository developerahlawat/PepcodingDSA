package com.pepcoding.dsa.arraysstring.level2;

public class FruitIntoBaskets {
//https://leetcode.com/problems/fruit-into-baskets/
	
	public int totalFruit(int[] tree) {
	      int max = 0, count = 0, first = 0, second = -1;
	    for (int i = 0; i < tree.length; i++) {
	        count++;
	        if (tree[i] == tree[first]) {
	            first = i;
	        } else if (second == -1 || tree[i] == tree[second]) {
	            second = i;
	        } else {
	            max = Math.max(count - 1, max);
	            count = Math.abs(first - second) + 1;
	            first = i - 1;
	            second = i;
	        }
	    }
	    return Math.max(count, max);   
	    }
}
