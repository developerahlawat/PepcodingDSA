package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.Scanner;

public class FractionToRecurringDecimal {
	public static String fractionToDecimal(int nn, int dd) {
        if(nn == 0) return "0";
        long num = nn;
        long den = dd;
        boolean n1 = num < 0;
        boolean n2 = den < 0;
        num = Math.abs(num);
        den = Math.abs(den);
        StringBuilder ans = new StringBuilder();
        long q = num / den;
        long r = num % den;
        ans.append(q);
        if(r == 0) {
            if((n1 == true && n2 == false) || (n1 == false && n2 == true)) {
            ans.insert(0, '-');
        }
            return ans.toString();
        }
        ans.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        while(r != 0) {
            map.put(r, ans.length());
            r *= 10;
            q = r / den;
            r = r % den;
            ans.append(q);
            if(map.containsKey(r) == true) {
                // insert bracket
                int si = map.get(r);
                ans.insert(si, '(');
                ans.append(")");
                break;
            }
        }
        if((n1 == true && n2 == false) || (n1 == false && n2 == true)) {
            ans.insert(0, '-');
        }
        return ans.toString();
    }

    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int den = scn.nextInt();
		System.out.println(fractionToDecimal(num , den));
	}

}
