package com.pepcoding.dsa.hashmap.level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class NoEmployeeEveryManager {
	// number of employee under every manager, portal
	private static int printCountOfEmployee(HashMap<String, HashSet<String>> tree, String root) {
		if (tree.get(root) == null) {
			System.out.println(root + " 0");
			return 1;
		}
		int count = 0;
		for (String child : tree.get(root)) {
			count += printCountOfEmployee(tree, child);
		}
		System.out.println(root + " " + count);
		return count + 1;
	}

	public static void numberOfEmployee() {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashMap<String, HashSet<String>> tree = new HashMap<>();
		String root = "";
		for (int i = 0; i < n; i++) {
			String emp = scn.next();
			String man = scn.next();
			if (emp.equals(man) == true) {
				root = emp;
				continue;
			}
			if (tree.containsKey(man) == true) {
				tree.get(man).add(emp);
			} else {
				HashSet<String> list = new HashSet<>();
				list.add(emp);
				tree.put(man, list);
			}
		}
		printCountOfEmployee(tree, root);
	}

	public static void main(String[] args) {

		numberOfEmployee();
	}

}
