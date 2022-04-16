package com.pepcoding.dsa.arraysstring.level2;

public class MinLengthStringDeleteSimilarEnds {
	// leetcode 1750. https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right && s.charAt(left) == s.charAt(right)) {
            char ch = s.charAt(left);
            // move left ahead with same character's present
            while(left <= right && s.charAt(left) == ch) {
                left++;
            }
            // move right in backward with same character's present
            while(left < right && s.charAt(right) == ch) {
                right--;
            }
        }
        return right - left + 1;
    }
}