package com.pepcoding.dsa.arraysstring.level2;

public class DigitMultiplier {

	// digit multiplier, https://practice.geeksforgeeks.org/problems/digit-multiplier3000/1
    static String getSmallest(Long num) {
        if(num == 1) return "1";
        String res = "";
        for(int i = 9; i >= 2; i--) {
            while(num % i == 0) {
                res = i + res;
                num /= i;
            }
        }
        return num != 1 ? "-1" : res;
    }
}
