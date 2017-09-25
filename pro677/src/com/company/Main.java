package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MapSum map = new MapSum();
        map.insert("apple", 3);
        map.insert("app", 2);

        int test;
        test = map.sum("ap");
    }
}
