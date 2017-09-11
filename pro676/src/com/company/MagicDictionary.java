package com.company;

public class MagicDictionary {
    /** Initialize your data structure here. */
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isLeaf;
        public TrieNode(boolean isLeaf) {
            this.isLeaf = isLeaf;
        }
    }

    TrieNode root = null;
    public MagicDictionary() {
        root = new TrieNode(false);
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        if (dict.length == 0) {
            return;
        }

        for (int i = 0; i < dict.length;i++) {
            String word = dict[i];
            TrieNode temp = root;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                int index = c - 'a';
                if (temp.children[index] == null) {
                    temp.children[index] = new TrieNode(false);
                }

                temp = temp.children[index];
                if (j == word.length()-1) {
                    temp.isLeaf = true;
                }
            }

        }
        return;
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if (root == null) {
            return false;
        }
        return helper(word, 0, 1, root);
    }

    boolean helper(String word, int start, int chance, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (start == word.length()) {
            if (node.isLeaf && chance == 0) {
                return true;
            } else {
                return false;
            }
        }
        char c = word.charAt(start);
        int index = c - 'a';
        TrieNode[] array = node.children;
        if (chance == 0) {
            if (array[index] == null) {
                return false;
            } else {
                return helper(word, start+1, 0, array[index]);
            }
        }

        //Situation of chance == 1
        for (int j = 0; j < 26; j++) {
            if (array[j] == null) {
                continue;
            }
            if (j == index) {
                boolean flag = helper(word, start+1, 1, array[j]);
                if (flag) {
                    return true;
                }
            } else {
                boolean flag = helper(word, start+1, 0, array[j]);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
}
