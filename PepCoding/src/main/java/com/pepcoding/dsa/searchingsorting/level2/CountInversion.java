package com.pepcoding.dsa.searchingsorting.level2;

import java.util.Scanner;

public class CountInversion {
	static int c_inv = 0;

    private static int[] mergeSortedArray(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        int[] res = new int[n1 + n2]; 

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < n1 && j < n2) {
            if(arr1[i] > arr2[j]) {
                res[k] = arr2[j];
                j++;
                c_inv += n1 - i;
            } else {
                res[k] = arr1[i];
                i++;
            }
            k++;
        }

        while(i < n1) {
            res[k] = arr1[i];
            i++;
            k++;
        }

        while(j < n2) {
            res[k] = arr2[j];
            j++;
            k++;
        }

        return res;
    }

    private static int[] mergeSort(int[] arr, int lo, int hi) {
        if(lo == hi) {
            int[] bres = {arr[lo]};
            return bres;
        }

        int mid = lo + (hi - lo) / 2;
        int[] lres = mergeSort(arr, lo, mid);
        int[] rres = mergeSort(arr, mid + 1, hi);
        int[] res = mergeSortedArray(lres, rres);
        return res;
    }

    private static int countInversion(int[] arr) {
        c_inv = 0;
        int[] res = mergeSort(arr, 0, arr.length - 1);
        return c_inv;
    }

	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int[] arr=new int[n];
		
		for(int i=0;i<n;i++)
			arr[i]=scn.nextInt();
		
		mergeSort(arr,0,n-1);
		
	}

}
