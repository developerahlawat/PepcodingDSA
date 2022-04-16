package com.pepcoding.dsa.trie.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SearchWord {

	// leetcode 211,
	// https://leetcode.com/problems/design-add-and-search-words-data-structure/
	public static class WordDictionary {

		private class Node {
			Node[] children;
			boolean isEnd;

			Node() {
				this.children = new Node[26];
				this.isEnd = false;
			}
		}

		private Node root = null;

		public WordDictionary() {
			root = new Node();
		}

		/** Adds a word into the data structure. */
		public void addWord(String word) {
			Node temp = root;

			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				if (temp.children[ch - 'a'] == null) {
					Node nn = new Node();
					temp.children[ch - 'a'] = nn;
				}
				temp = temp.children[ch - 'a'];
			}
			temp.isEnd = true;
		}

		/**
		 * Returns if the word is in the data structure. A word could contain the dot
		 * character '.' to represent any one letter.
		 */

		private boolean find(Node node, String word, int indx) {
			if (indx == word.length()) {
				return node.isEnd;
			}

			char ch = word.charAt(indx);
			if (ch == '.') {
				for (int i = 0; i < 26; i++) {
					Node child = node.children[i];
					if (child != null && find(child, word, indx + 1) == true) {
						return true;
					}
				}
			} else if (node.children[ch - 'a'] != null) {
				return find(node.children[ch - 'a'], word, indx + 1);
			}
			return false;
		}

		public boolean search(String word) {
			return find(root, word, 0);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		WordDictionary obj = new WordDictionary();

		while (read.ready()) {
			String inp[] = read.readLine().split(" ");

			if (inp[0].equals("addWord")) {
				obj.addWord(inp[1]);
			} else if (inp[0].equals("search")) {
				System.out.println(obj.search(inp[1]));
			}
		}

	}

}
