package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] strs = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> test;
        test = groupStrings(strs);

        int d = -25 % 26;
    }

    public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings.length  == 0) {
            return res;
        }

        if (strings.length == 1) {
            List<String> list = new ArrayList<>();
            list.add(strings[0]);
            res.add(list);
            return res;
        }

        int n = strings.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            List<String> list = new ArrayList<>();
            visited[i] = true;
            list.add(strings[i]);
            for (int j = i+1; j < n; j++) {
                //check whether strings[j] is the same group as string[i]
                if (!visited[j] && strings[j].length() == strings[i].length()) {
                    if (strings[j].length() == 1) {
                        list.add(strings[j]);
                        visited[j] = true;
                    } else {
                        int diff = strings[j].charAt(0) - strings[i].charAt(0);
                        if (diff < 0) {
                            diff += 26;
                        }
                        boolean flag = true;
                        for (int k = 1; k < strings[j].length(); k++) {
                            int a = strings[j].charAt(k) - strings[i].charAt(k);
                            if (a < 0) {
                                a += 26;
                            }
                            if (a != diff) {
                                flag = false;
                                break;
                            }
                        }

                        if (flag) {
                            list.add(strings[j]);
                            visited[j] = true;
                        }
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
}
