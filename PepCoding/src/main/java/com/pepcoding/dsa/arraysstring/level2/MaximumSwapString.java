package com.pepcoding.dsa.arraysstring.level2;

import java.util.Scanner;

public class MaximumSwapString {
	private static void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

  // ~~~~~~~~~~User Section~~~~~~~~~~~
   // leetcode 670. https://leetcode.com/problems/maximum-swap/
    public static String maximumSwap(String num) {
       // String num = n + "";
        // convert number into string
        char[] arr = num.toCharArray();

        int[] lastIndxOfDigit = new int[10];
        // travel and fill last index of digits
        for(int i = 0; i < arr.length; i++) {
            lastIndxOfDigit[arr[i] - '0'] = i;
        }

        // travel and find swapping point
        for(int i = 0; i < arr.length; i++) {
            int digit = arr[i] - '0';
            int indx = i;
            for(int j = 9; j > digit; j--) {
                // greater digit have max index then set it in indx and break
                if(lastIndxOfDigit[j] > i) {
                    indx = lastIndxOfDigit[j];
                    break;
                }
            }
            if(indx != i) {
                swap(arr, i, indx);
                break;
            }
        }
        String res = String.valueOf(arr);
        // convert string into number
        //return Integer.parseInt(res);
        return res;
    }

  // ~~~~~~~~Input Management~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    String ans = maximumSwap(str);
    System.out.println(ans);
  }
}
