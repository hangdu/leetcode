package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] dict = {"a", "a"};
        ValidWordAbbr validWordAbbr = new ValidWordAbbr(dict);

        boolean test;
        test = validWordAbbr.isUnique("a");
        test = validWordAbbr.isUnique("cart");
        test = validWordAbbr.isUnique("cane");
        test = validWordAbbr.isUnique("make");

    }
}
