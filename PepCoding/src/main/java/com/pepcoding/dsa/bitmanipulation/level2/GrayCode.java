package com.pepcoding.dsa.bitmanipulation.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GrayCode {
	// gray code
    public static List<Integer> grayCode(int n) {
        if(n <= 1) {
            List<Integer> bres = new ArrayList<>();
            bres.add(0);
            if(n == 1)
                bres.add(1);
            return bres;
        }

        List<Integer> rres = grayCode(n - 1);
        List<Integer> mres = new ArrayList<>();
        // add normal sequence of rres in mres
        for(int val : rres) 
            mres.add(val);

        // on (n - 1)th bit and add it in mres (make loop iteration in reverse order)
        int bm = (1 << (n - 1));
        for(int i = rres.size() - 1; i >= 0; i--) {
            int val = rres.get(i);
            mres.add(val | bm);
        }
        return mres;
    }
 
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         List<Integer> ans=grayCode(scn.nextInt());
         Collections.sort(ans);
         System.out.println(ans);
     }
 
}
