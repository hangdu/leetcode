package com.company;

public class MapSum {
    /** Initialize your data structure here. */
    //use Trie to solve this problem

    class TrieNode {
        TrieNode[] children  = new TrieNode[26];
        boolean isLeaf;
        int val;
        public TrieNode(boolean isLeaf, int val) {
            this.isLeaf = isLeaf;
            this.val = val;
        }
    }

    TrieNode root;

    public MapSum() {
        root = new TrieNode(false, 0);
    }

    public void insert(String key, int val) {
        //if already exist then override
        TrieNode temp = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int index = c - 'a';
            if (temp.children[index] == null) {
                if (i == key.length()-1) {
                    temp.children[index] = new TrieNode(true, val);
                    return;
                }
                temp.children[index] = new TrieNode(false, 0);
            }
            temp = temp.children[index];
        }
        temp.isLeaf = true;
        temp.val = val;
    }

    public int sum(String prefix) {
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (temp.children[index] == null) {
                return 0;
            }
            temp = temp.children[index];
        }

        return getSum(temp);
    }

    int getSum(TrieNode node) {
        int res = 0;
        if (node.isLeaf) {
            res += node.val;
        }

        for (int i = 0; i < 26; i++) {
            TrieNode t = node.children[i];
            if (t == null) {
                continue;
            }
            int d = getSum(node.children[i]);

            res += d;
        }
        return res;
    }
}
