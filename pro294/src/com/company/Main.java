package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        boolean test;
        test = canWin("+++++");
    }


    public static boolean canWin(String s) {
        if (s.length() < 2) {
            return false;
        }

        return helper(s);

    }

    static boolean helper(String s) {
        List<String> list = generatePossibleNextMoves(s);
        if (list.size() == 0) {
            return false;
        }

        for (String temp : list) {
            boolean flag = helper(temp);
            if (!flag) {
                return true;
            }
        }
        return false;
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
