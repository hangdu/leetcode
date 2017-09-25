package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<String> test;
        test = generatePossibleNextMoves("++++");
        String s = "++++";
        String temp = s.substring(5);
    }

    public static List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 2) {
            return res;
        }

        for (int i = -1; i < s.length();) {
            i = s.indexOf("++", i);
            if (i == -1) {
                break;
            }
            res.add(s.substring(0, i) + "--" + s.substring(i+2));
            i = i+1;
        }
        return res;

    }
}
