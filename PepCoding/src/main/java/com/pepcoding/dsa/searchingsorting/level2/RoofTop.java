package com.pepcoding.dsa.searchingsorting.level2;

import java.util.Scanner;

public class RoofTop {
	public static int findMaxSteps(int[]arr) {
        int count=0;
        int res=0;
        
        for(int i=1;i<arr.length;i++) {
        	if(arr[i-1] < arr[i])
        		count++;
        	else {
        		res=Math.max(res, count);
        		count=0;        				
        	}
        }
        res=Math.max(res, count);
        return res;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findMaxSteps(arr);
        System.out.println(ans);
    }
}
