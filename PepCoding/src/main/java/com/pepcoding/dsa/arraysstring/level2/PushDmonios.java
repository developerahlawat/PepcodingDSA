package com.pepcoding.dsa.arraysstring.level2;

import java.util.Scanner;

public class PushDmonios {
	// ~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~
    // leetcode 838. https://leetcode.com/problems/push-dominoes/
private static void solveConfig(char[] arr, int i, int j) {
       if(arr[i] == 'L' && arr[j] == 'L') {
           for(int k = i + 1; k < j; k++)
               arr[k] = 'L';

       } else if(arr[i] == 'R' && arr[j] == 'R') {
           for(int k = i + 1; k < j; k++)
               arr[k] = 'R';
               
       } else if(arr[i] == 'L' && arr[j] == 'R') {
           // nothing to do
       } else {
           // arr[i] == 'R' && arr[j] == 'L'
           while(i < j) {
               arr[i] = 'R';
               arr[j] = 'L';
               i++;
               j--;
           }
       }
   }

   public static String pushDominoes(String dominoes) {
       int l = dominoes.length();
       char[] arr = new char[l + 2];
       arr[0] = 'L';
       arr[l + 1] = 'R';
       for(int i = 1; i <= l; i++) {
           arr[i] = dominoes.charAt(i - 1);
       }

       int i = 0;
       int j = 1;
       while(j < arr.length) {
           while(arr[j] == '.')
               j++;

           if(j - i > 1) {
               solveConfig(arr, i, j);
           }
           i = j;
           j++;
       }

       StringBuilder res = new StringBuilder();
       for(int k = 1; k <= l; k++) {
           res.append( arr[k]);
       }
       return res.toString();
   }     

 // ~~~~~~~~~~~Input Management~~~~~~~~~~~~
 public static void main(String[] args) {
   Scanner scn = new Scanner(System.in);
   String str = scn.nextLine();
   String res = pushDominoes(str);
   System.out.println(res);
 }
}