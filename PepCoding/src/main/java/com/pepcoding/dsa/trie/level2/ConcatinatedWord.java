package com.pepcoding.dsa.trie.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcatinatedWord {
	private static class Node {
		Node[] children;
		String s;
		boolean isAdded;

		Node() {
			this.children = new Node[26];
		}
	}

	private static void insert(Node node, String word) {
		if (word.length() == 0)
			return;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);

			if (node.children[ch - 'a'] == null) {
				node.children[ch - 'a'] = new Node();
			}
			node = node.children[ch - 'a'];
		}
		node.s = word;
	}

	private static ArrayList<String> res;

	private static void matchCharacter(Node p1, Node p2, Node root) {
		if (p1.s != null && p2.s != null) {
			// p1 id ptr from dfsOnTRIE
			if (p1.isAdded == false)
				res.add(p1.s);
			p1.isAdded = true;
		} else if (p2.s != null) {
			matchCharacter(p1, root, root);
		}
		for (int i = 0; i < 26; i++) {
			if (p1.children[i] != null && p2.children[i] != null) {
				matchCharacter(p1.children[i], p2.children[i], root);
			}
		}
	}

	private static void dfsOnTRIE(Node ptr, Node root) {
		if (ptr.s != null) {
			matchCharacter(ptr, root, root);
		}
		for (Node child : ptr.children) {
			if (child != null) {
				dfsOnTRIE(child, root);
			}
		}
	}

	public static List<String> findAllConcatenatedWordsInADict(String[] words) {
		Node root = new Node();
		for (String word : words) {
			insert(root, word);
		}
		res = new ArrayList<>();
		dfsOnTRIE(root, root);
		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(read.readLine());

		String[] words = new String[n];

		for (int i = 0; i < n; i++) {
			words[i] = read.readLine();
		}

		List<String> result = findAllConcatenatedWordsInADict(words);
		Collections.sort(result);
		PrintWriter out = new PrintWriter(System.out);
		for (String s : result) {
			out.println(s);
		}
		out.close();
	}

}
