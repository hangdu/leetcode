package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MagicDictionary magicDictionary = new MagicDictionary();
        String[] words = {"hello", "leetcode"};
        magicDictionary.buildDict(words);

        boolean flag;
        flag = magicDictionary.search("hello");
        flag = magicDictionary.search("hhllo");
    }
}
