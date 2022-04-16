package com.pepcoding.dsa.arraysstring.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TargetSumUniquePairThreeSumArray {
	// ~~~~~~~~~~~~User Section~~~~~~~~~~~~
	  private static List<List<Integer>> twoSum(int[] arr, int st, int end, int target) {
	        int left = st;
	        int right = end;
	        List<List<Integer>> res = new ArrayList<>();
	        while(left < right) {
	            if(left != st && arr[left] == arr[left - 1]) {
	                left++;
	                continue;
	            }
	            int sum = arr[left] + arr[right];
	            if(sum == target) {
	                List<Integer> subres = new ArrayList<>();
	                subres.add(arr[left]);
	                subres.add(arr[right]);
	                res.add(subres);

	                left++;
	                right--;
	            } else if(sum > target) {
	                right--;
	            } else {
	                left++;
	            }
	        }
	        return res;
	    }

	    public static List<List<Integer>> threeSum(int[] nums, int target) {
	        Arrays.sort(nums);
	        List<List<Integer>> res = new ArrayList<>();

	        for(int i = 0; i < nums.length - 2; i++) {
	            if(i != 0 && nums[i] == nums[i - 1])
	                continue;

	            int val1 = nums[i];
	            int smallTarget = target - val1;

	            List<List<Integer>> subres = twoSum(nums, i + 1, nums.length - 1, smallTarget);
	            for(List<Integer> list : subres) {
	                list.add(val1);
	                res.add(list);
	            }
	        }
	        return res;
	    }

	  // ~~~~~~~~~~Input Management~~~~~~~~~~
	  public static void main(String[] args) {
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    int[] arr = new int[n];
	    for (int i = 0; i < n; i++) {
	      arr[i] = scn.nextInt();
	    }
	    int target = scn.nextInt();
	    List<List<Integer>> res = threeSum(arr, target);
	    ArrayList<String> finalResult = new ArrayList<>();
	    for (List<Integer> list : res) {
	      Collections.sort(list);
	      String ans = "";
	      for (int val : list) {
	        ans += val + " ";
	      }
	      finalResult.add(ans);
	    }
	    Collections.sort(finalResult);
	    for (String str : finalResult) {
	      System.out.println(str);
	    }
	  }

	}