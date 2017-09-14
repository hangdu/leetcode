package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        boolean test;
        test = canPermutePalindrome("carerac");
    }

    public static boolean canPermutePalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, 1+map.get(c));
            } else {
                map.put(c, 1);
            }
        }

        int count = 0;
        for (char key : map.keySet()) {
            int val = map.get(key);
            if (val % 2 == 1) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
