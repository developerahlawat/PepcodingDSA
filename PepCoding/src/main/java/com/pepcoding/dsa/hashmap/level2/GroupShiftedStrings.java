package com.pepcoding.dsa.hashmap.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GroupShiftedStrings {
	  // This is a functional problem. You have to complete this function.
    // It takes as input the a string array. It return a list of list of
    // strings of strings with same shifting sequence grouped together.

    // group shifted strings
   private static String getStringCode(String str) {
       String code = "";
       for(int i = 1; i < str.length(); i++) {
           char ch1 = str.charAt(i - 1);
           char ch2 = str.charAt(i);
           int val = (int)(ch2 - ch1);
           if(val >= 0) {
               code += val;
           } else { 
               code += (val + 26);
           }
           code += "#";
       }
       code += ".";
       return code;
   }

   public static List<List<String>> groupShiftedStrings(String[] strs) {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
       
       for(String str : strs) {
           String code = getStringCode(str);
           if(map.containsKey(code) == true) {
               map.get(code).add(str);
           } else {
               ArrayList<String> list = new ArrayList<>();
               list.add(str);
               map.put(code, list);
           }
       }

       List<List<String>> res = new ArrayList<>();
       for(ArrayList<String> list : map.values()) {
           res.add(list);
       }
       return res;
	}



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Length of the array
        int N = sc.nextInt();

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }

        List<List<String>> stringsGrouped = groupShiftedStrings(arr);

        for (List<String> lst : stringsGrouped) {
            Collections.sort(lst);
        }

        stringsGrouped.sort(new ListComparator());

        display(stringsGrouped);

    }

    // Comparator for sorting the result list.
    static class ListComparator implements Comparator<List<String>> {

        @Override
        public int compare(List<String> l1, List<String> l2) {

            if (l1.size() != l2.size()) {
                return l2.size() - l1.size();
            }

            for (int i = 0; i < l1.size(); i++) {
                String l1str = l1.get(i);
                String l2str = l2.get(i);

                return l1str.compareTo(l2str);

            }

            return 0;

        }
    }

    // Function to display a List of Lists of strings.
    public static void display(List<List<String>> list) {

        for (int i = 0; i < list.size(); i++) {

            List<String> currList = list.get(i);

            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }

            System.out.println();
        }

    }

}