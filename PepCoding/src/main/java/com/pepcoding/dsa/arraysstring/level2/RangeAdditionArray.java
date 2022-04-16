package com.pepcoding.dsa.arraysstring.level2;

import java.util.Scanner;

public class RangeAdditionArray {
    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    // lintcode 903. https://www.lintcode.com/problem/903/
    public static int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];

        // make impact of query on res
        for(int i = 0; i < updates.length; i++) {
            int st = updates[i][0];
            int end = updates[i][1];
            int inc = updates[i][2];

            res[st] += inc;

            if(end + 1 < length) {
                res[end + 1] -= inc;
            }
        }

        // apply impact on res using prefix sum
        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int length = scn.nextInt();

        int nq = scn.nextInt();
        
        int[][] queries = new int[nq][3];

        for(int q = 0; q < nq; q++) {
            queries[q][0] = scn.nextInt();
            queries[q][1] = scn.nextInt();
            queries[q][2] = scn.nextInt();
        }


        int[] res = getModifiedArray(length, queries);

        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
