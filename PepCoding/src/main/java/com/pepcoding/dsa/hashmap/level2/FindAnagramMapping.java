package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class FindAnagramMapping {
	 // find mapping of anagrams
    public static int[] anagramMappings(int[] arr1, int[] arr2) {
		HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr2.length; i++) {
            int val = arr2[i];
            if(map.containsKey(val) == true) {
                map.get(val).addLast(i);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(val, list);
            }
        }
        int[] res = new int[arr1.length];
        for(int i = 0; i < arr1.length; i++) {
            int val = arr1[i];
            int indx = map.get(val).removeFirst();
            res[i] = indx;
        }
		return res;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
		}
		for (int j = 0; j < b.length; j++) {
			b[j] = s.nextInt();
		}
		int[] res = anagramMappings(a, b);
		for (int j = 0; j < res.length; j++) {
			System.out.print(res[j] + " ");
		}
	}

}
