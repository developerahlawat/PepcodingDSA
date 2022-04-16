package com.pepcoding.dsa.hashmap.level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class TaskCompletion {
	// complete task
    public static void completeTask(int n, int m, int[] arr) {
        ArrayList<Integer> s1 = new ArrayList<>();
        ArrayList<Integer> s2 = new ArrayList<>();
        boolean flag = true;

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < m; i++) {
            set.add(arr[i]);
        }

        for(int i = 1; i <= n; i++) {
            if(set.contains(i) == true) continue;

            if(flag == true) {
                s1.add(i);
                flag = false;
            } else {
                s2.add(i);
                flag = true;
            }
        }

        for(int val : s1) {
            System.out.print(val + " ");
        }
        System.out.println();
        for(int val : s2) {
            System.out.print(val + " ");
        }
	}


	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[] num = new int[m];
		for (int i = 0; i < m; i++) {
			num[i] = scn.nextInt();
		}
		completeTask(n, m, num);
	}

}
