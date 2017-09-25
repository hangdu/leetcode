package com.company;

import java.util.*;

public class Main {
    // The trick is that you need to able to permute a char array with duplicate elements
    public static void main(String[] args) {
        List<String> test;
        test = generatePalindromes("aaaaaa");
    }


    public static List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 1) {
            return res;
        }
        if (s.length() == 1) {
            res.add(s);
            return res;
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
                    return res;
                }
            }
        }

        //continue
        char c = '0';
        boolean oddExist = false;

        for (char key : map.keySet()) {
            if (map.get(key) % 2 == 1) {
                oddExist = true;
                c = key;
            }
            map.put(key, map.get(key)/2);
        }

        StringBuilder build = new StringBuilder();
        for (char key : map.keySet()) {
            int num = map.get(key);
            if (num == 0) {
                continue;
            }
            for (int i = 0; i< num; i++) {
                build.append(key);
            }
        }

        boolean[] visited = new boolean[build.length()];
        List<Character> list = new ArrayList<>();
        helper(build.toString(), res, visited, list, c, oddExist);
        return res;

    }

    static void helper(String base, List<String> res, boolean[] visited, List<Character> list, char c, boolean oddExist) {
        if (list.size() == base.length()) {
            //get the result string
            StringBuilder build1 = new StringBuilder();

            for (int i = 0; i < list.size(); i++) {
                build1.append(list.get(i));
            }
            int size = build1.length();
            if (oddExist) {
                build1.append(c);
            }
            for(int i = size-1; i >= 0; i--) {
                build1.append(build1.charAt(i));
            }

            res.add(new String(build1));
            return;
        }

        boolean isFirstTime = true;
        char temp = '0';
        for (int i = 0; i < base.length(); i++) {
            if (visited[i]) {
                continue;
            }
            if (!isFirstTime && base.charAt(i) == temp) {
                continue;
            }

            if (isFirstTime) {
                isFirstTime = false;
            }
            temp = base.charAt(i);
            visited[i] = true;
            list.add(base.charAt(i));
            helper(base, res, visited, list, c, oddExist);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }

}
