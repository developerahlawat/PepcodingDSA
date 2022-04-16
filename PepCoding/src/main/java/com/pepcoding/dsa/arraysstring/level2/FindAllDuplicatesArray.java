package com.pepcoding.dsa.arraysstring.level2;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesArray {

    // leetcode 442. https://leetcode.com/problems/find-all-duplicates-in-an-array/
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int indx = Math.abs(nums[i]) - 1;
            int val = nums[indx];

            if(val < 0) {
                // indx + 1 is repitited
                res.add(indx + 1);
            } else {
                // mark it
                nums[indx] *= -1;
            }
        }
        return res;
    }
}
