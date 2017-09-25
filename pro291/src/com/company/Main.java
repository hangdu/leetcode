package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        boolean test;
        test = wordPatternMatch("ab", "aa");
    }


    public static boolean wordPatternMatch(String pattern, String str) {
        if (pattern.length() > str.length()) {
            return false;
        }
        if (pattern.length() == 1) {
            return true;
        }

        Set<String> set = new HashSet();
//        int[] array = new int[26];

//        List<Character> charlist = new ArrayList();
        Map<Character, String> map = new HashMap<>();
        Map<Character, Integer> countMap = new HashMap<>();
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            int index = c - 'a';
////            array[index]++;
//            if (countMap.containsKey(c)) {
//                countMap.put(c, 1+countMap.get(c));
//                continue;
//            }
//            countMap.put(c, 1);
//            charlist.add(c);
//        }

        return helper(0, 0,pattern, str,map, set);

    }

    static boolean helper(int patternPointer, int strPointer, String pattern, String str, Map<Character, String> map, Set<String> set) {
        if (strPointer == str.length()) {
            if (patternPointer == pattern.length()) {
                return true;
            } else {
                return false;
            }
        }

        if (patternPointer == pattern.length()) {
            if (strPointer == str.length()) {
                return true;
            } else {
                return false;
            }
        }

        char curPattern = pattern.charAt(patternPointer);
        if (map.containsKey(curPattern)) {
            String s = map.get(curPattern);
            if (str.substring(strPointer).startsWith(s)) {
                return helper(patternPointer+1, strPointer+s.length(), pattern, str, map, set);
            } else {
                return false;
            }
        } else {
            //How many characters should be this curPattern char biject to?
            for (int i = strPointer+1; i <= str.length(); i++) {
                String temp = str.substring(strPointer, i);
                if (set.contains(temp)) {
                    continue;
                }
                map.put(curPattern, temp);
                set.add(temp);
                boolean flag = helper(patternPointer+1, i, pattern, str, map, set);
                if (flag) {
                    return true;
                }

                map.remove(curPattern);
                set.remove(temp);
            }
            return false;
        }
    }

}
